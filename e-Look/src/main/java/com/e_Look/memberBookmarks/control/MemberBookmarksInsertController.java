package com.e_Look.memberBookmarks.control;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.e_Look.memberBookmarks.model.MemberBookmarksService;

@WebServlet("/MemberBookmarksInsertController")
public class MemberBookmarksInsertController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Integer memberID= Integer.valueOf(request.getParameter("memberID"));
		Integer courseID= Integer.valueOf(request.getParameter("courseID"));
		//System.out.println(memberID);
		//System.out.println(courseID);
		MemberBookmarksService memberBookmarksService =new MemberBookmarksService();
		memberBookmarksService.deleteMemberBookmarks(memberID, courseID);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Integer memberID= Integer.valueOf(request.getParameter("memberID"));
		Integer courseID= Integer.valueOf(request.getParameter("courseID"));
		MemberBookmarksService memberBookmarksService =new MemberBookmarksService();
		memberBookmarksService.insertMemberBookmarks(memberID, courseID);
	}

}
