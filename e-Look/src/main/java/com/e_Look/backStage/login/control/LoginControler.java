package com.e_Look.backStage.login.control;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.e_Look.backStage.login.model.*;

@WebServlet("/backstage/login")
public class LoginControler extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
        req.setCharacterEncoding("UTF-8");
        String action = req.getParameter("action");
		String managerID = req.getParameter("managerID");
		String password = req.getParameter("mPassword");
		//String login = req.getParameter("action");
		ManagerService service = new ManagerService();
		ManagerVO loginVO = null;
		Map<String, String> errorMsgs = new HashMap<String, String>();
		req.setAttribute("ErrMsg", errorMsgs);

		if (action.equals("login")){
		loginVO = service.findByManagerID(managerID);
		if (managerID.trim() == null || managerID.trim().equals("")) {
			errorMsgs.put("errID", "請輸入帳號及密碼");
		} else {
			loginVO = service.findByManagerID(managerID);
			if (loginVO == null) {System.out.println("123");
				errorMsgs.put("erreID", "帳號錯誤");
			} else if (loginVO != null && !managerID.equals(loginVO.getManagerID())) {System.out.println("122");
				errorMsgs.put("errID", "帳號錯誤");
			}
		
		
			if (password.trim() == null || password.trim().equals("")) {System.out.println("111");
				errorMsgs.put("errpw", "請輸入密碼");
			} else {
				if (loginVO != null && !password.equals(loginVO.getmPassword())) {
					errorMsgs.put("errpw", "帳號或密碼錯誤!!!");
				}
			}
		}
		if (!errorMsgs.isEmpty()) {System.out.println("****");
			req.setAttribute("LoginVO", loginVO); // 含有輸入格式錯誤的empVO物件,也存入req
			RequestDispatcher failureView = req
					.getRequestDispatcher("backLogin.jsp");
			failureView.forward(req, res);
			return;}
		
		RequestDispatcher successView = req.getRequestDispatcher("backHome1.jsp"); // 新增成功後轉交listAllEmp.jsp
		successView.forward(req, res);
		}
	}
}

