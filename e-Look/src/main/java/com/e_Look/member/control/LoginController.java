package com.e_Look.member.control;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.e_Look.Course.CourseVO;
import com.e_Look.member.model.MemberService;
import com.e_Look.member.model.MemberVO;
import com.e_Look.shoppingCart.model.jdbc.ShoppingCartDAO;

/**
 * Servlet implementation class Logincontroller
 */
@WebServlet("*.login")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String email = request.getParameter("email");
		String password = request.getParameter("mPassword");
		String status = request.getParameter("loginstatus");
		HttpSession session = request.getSession();
//		session.removeAttribute("err");
		MemberService service = new MemberService();
		MemberVO memberVO = null;
		if (status == null) {
			Map<String, String> errMessage = new HashMap<String, String>();
			if (email.trim() == null || email.trim().equals("")) {
				errMessage.put("erremail", "請輸入信箱");
			} else {
				memberVO = service.getMemberMail(email);
				if (memberVO == null) {
					errMessage.put("erremail", "帳號錯誤");
				} else if (memberVO != null && !email.equals(memberVO.getEmail())) {
					errMessage.put("erremail", "帳號錯誤");
				}else if(memberVO.getStatus()==0){
					errMessage.put("erremail", "帳號未驗證，無法登入");
				}
			}
			if (password.trim() == null || password.trim().equals("")) {
				errMessage.put("errepwd", "請輸入密碼");
			} else {
				if (email.trim() == null || email.trim().equals("")) {
				} else {
					if (memberVO != null && !password.equals(memberVO.getmPassword())) {
						errMessage.put("erremail", "帳號或密碼錯誤!!!");
					}
				}
			}
			if (!errMessage.isEmpty()) {
				session.setAttribute("err", errMessage);
				response.sendRedirect(request.getHeader("referer"));
				//System.out.println("4");
				return;
			}
			session.setAttribute("LoginOK", memberVO);
			
			ShoppingCartDAO dao = new ShoppingCartDAO();
			List<CourseVO> shoppingCartList =dao.findByMemberID(memberVO.getMemberID());
			session.setAttribute("shoppingCartList", shoppingCartList);
			
			response.sendRedirect(request.getHeader("referer"));
			//System.out.println("5");
			return;
		}else if(status.equals("fb")){
			String mName=request.getParameter("mName");
			String mPhoto=request.getParameter("mPhoto");
			memberVO = service.getMemberMail(email);
			if(memberVO==null){
				service.insertFBMember(email, mName, mPhoto);
				memberVO = service.getMemberMail(email);
				System.out.println(memberVO);
			}
			
		}else if(status.equals("google")){
			String mName=request.getParameter("mName");
			String mPhoto=request.getParameter("mPhoto");
			memberVO = service.getMemberMail(email);
			if(memberVO==null){
				
				service.insertGoogleMember(email, mName, mPhoto);
				memberVO = service.getMemberMail(email);
				System.out.println(memberVO);
			}
		}
		session.setAttribute("LoginOK", memberVO);
		
		ShoppingCartDAO dao = new ShoppingCartDAO();
		List<CourseVO> shoppingCartList =dao.findByMemberID(memberVO.getMemberID());
		session.setAttribute("shoppingCartList", shoppingCartList);
		

	}

}
