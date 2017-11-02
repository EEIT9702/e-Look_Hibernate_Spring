package com.e_Look.member.control;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.e_Look.emailSystem.MemberCheckEmail;
import com.e_Look.emailSystem.ResetPwdEmail;
import com.e_Look.emailSystem.ResetPwdSystem;
import com.e_Look.member.model.MemberService;
import com.e_Look.member.model.MemberVO;

/**
 * Servlet implementation class RegisterController
 */
@WebServlet("/login.html")
public class RegisterController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		synchronized (this) {
			request.setCharacterEncoding("UTF-8");
			HttpSession session = request.getSession();
			MemberService service = new MemberService();
			MemberVO memberVO = null;
			String emailID = request.getParameter("emailID");
			if (emailID.trim() == null || emailID.trim().length() == 0) {
				session.setAttribute("registerOK", "參數錯誤請重新確認");
			} else {
				memberVO = service.getMemberMail(emailID);
				if (memberVO == null) {
					session.setAttribute("registerOK", "查無此會員");
				}
				if (memberVO != null) {
					if (memberVO.getStatus() == 1)
						session.setAttribute("registerOK", "該會員已經驗證過了");
				}
			}
			if (session.getAttribute("registerOK") != null) {
				response.sendRedirect(request.getContextPath() + "/HOME.jsp");
				return;
			} else {
				service.updateMemberStatus(memberVO.getMemberID());
				session.setAttribute("registerOK", "完成認證，您可以登入了");
				response.sendRedirect(request.getContextPath() + "/HOME.jsp");
				return;
			}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected synchronized void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		Map<String, String> errMessage = new HashMap<String, String>();
		MemberService service = new MemberService();
		MemberVO memberVO = null;
		String name = request.getParameter("mName");
		String email = request.getParameter("email");
		String password = request.getParameter("mPassword");
		String password2 = request.getParameter("mPassword2");
		String check = request.getParameter("check");
		String reset = request.getParameter("reset");
		String verify = (String) session.getAttribute("check_code");
			if (reset == null) {
				if (name.trim() == null || name.trim().length() == 0) {
					errMessage.put("errname", "(請輸入名字)");
				} else {
					String enameReg = "^[(\u4e00-\u9fa5)(a-zA-Z0-9)]{2,10}$";
					if (!name.trim().matches(enameReg)) {
						errMessage.put("errname", "(只能是中、英文字母、數字 , 且長度不能超過10)");
					}
				}
				if (password.trim() == null || password.trim().length() == 0) {
					errMessage.put("errpwd", "(請輸入密碼)");
				} else {
					String passwordReg = "^.*(?=.{8,10})(?=.*\\d)(?=.*[a-z])(?=.*[A-Z]).*$";
					if (!password.trim().matches(passwordReg)) {
						errMessage.put("errpwd", "(密碼需有數字及大小寫字母，長度到8~10)");
					} else if ((password2.trim() != null || password2.trim().length() > 0)
							&& !password2.equals(password)) {
						errMessage.put("errpwd2", "(與密碼不符)");
					}
				}
				if (email.trim() == null || email.trim().length() == 0) {
					errMessage.put("erremail", "(請輸入信箱)");
				} else {
					String emaildReg = "^[_a-zA-Z0-9-]+([.][_a-zA-Z0-9-]+)*@[a-zA-Z0-9-]+([.][a-zA-Z0-9-]+)*$";
					if (!email.trim().matches(emaildReg)) {
						errMessage.put("erremail", "(不符合信箱格式)");
					} else {
						memberVO = service.getMemberMail(email);
						if (memberVO != null) {
							errMessage.put("erremail", "(帳號已存在)");
						}
					}
				}
				if (check.trim() == null || check.trim().length() == 0) {
					errMessage.put("errcheck", "(請輸入驗證碼)");
				} else if (!check.equals(verify)) {
					errMessage.put("errcheck", "(與驗證碼不符)");
				}
				if (!errMessage.isEmpty()) {
					session.setAttribute("regerr", errMessage);
					session.setAttribute("Name", name);
					session.setAttribute("mail", email);
					// if (request.getHeader("referer").indexOf("?") != -1) {
					// response.sendRedirect(
					// request.getHeader("referer").substring(0,
					// request.getHeader("referer").indexOf("?"))
					// + "?Name=" + name + "&mail=" + email);
					// // System.out.println("1");
					// return;
					// } else {
					// String url = request.getHeader("referer") + "?";
					// response.sendRedirect(url.substring(0, url.indexOf("?"))
					// + "?Name=" + name + "&mail=" + email);
					// // System.out.println("2");
					// return;
					// }
					response.sendRedirect(request.getHeader("referer"));
					return;

				} else {

					service.insertMember(email, name, password, request.getServletContext().getRealPath(""));
					MemberCheckEmail.sendmail(email, request.getRequestURL().toString());
					session.setAttribute("registerOK", "請去信箱收取認證信");
					response.sendRedirect(request.getHeader("referer"));
					return;

				}
			} else {
				if (email.trim() == null || email.trim().length() == 0) {
					session.setAttribute("registerOK", "請不要空白");
				} else {
					String emaildReg = "^[_a-zA-Z0-9-]+([.][_a-zA-Z0-9-]+)*@[a-zA-Z0-9-]+([.][a-zA-Z0-9-]+)*$";
					if (!email.trim().matches(emaildReg)) {
						session.setAttribute("registerOK", "不符合信箱格式");
					} else {
						memberVO = service.getMemberMail(email);
						if (memberVO != null) {
							if (memberVO.getStatus() == 1 && !memberVO.getmPassword().equals("")) {
								ResetPwdSystem resetpwd = new ResetPwdSystem();
								String newpassword = resetpwd.pwdGenerator();
								memberVO.setmPassword(newpassword);
								service.updateMember(memberVO);
							} else {
								session.setAttribute("registerOK", "1.您尚未驗證無法寄送新密碼<br>2.您目前尚未註冊<br>3.帳號身份錯誤");
							}
						}
					}
				}
				if (session.getAttribute("registerOK") != null) {
					response.sendRedirect(request.getHeader("referer"));
					return;
				} else {
					service.updateMemberStatus(memberVO.getMemberID());
					ResetPwdEmail.sendmail(memberVO.getmName(), email, memberVO.getmPassword());
					session.setAttribute("registerOK", "已發送新密碼到信箱");
					response.sendRedirect(request.getHeader("referer"));
					return;
				}
			}
		}
	
}
