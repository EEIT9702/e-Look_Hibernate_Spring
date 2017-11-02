package com.e_Look.memberBookmarks.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.e_Look.member.model.MemberVO;
import com.e_Look.memberBookmarks.model.MemberBookmarksService;

@WebServlet("/MemberBookmarksOfMe")
public class MemberBookmarksOfMe extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		MemberBookmarksService memberBookmarksService = null;
		HttpSession session = request.getSession(false);
		Integer courseID=Integer.valueOf(request.getParameter("courseID"));
		
		if (session != null) {
			MemberVO memberVO = (MemberVO) session.getAttribute("LoginOK");
			memberBookmarksService = new MemberBookmarksService();
			Integer memberID = memberVO.getMemberID();
			
			 memberBookmarksService.deleteMemberBookmarks(memberID, courseID);
		}else{
			
			
		}
	}

}
