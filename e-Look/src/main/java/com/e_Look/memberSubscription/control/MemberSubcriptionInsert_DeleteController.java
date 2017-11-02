package com.e_Look.memberSubscription.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.e_Look.memberSubscription.MemberSubscriptionService;

import com.e_Look.memberSubscription.MemberSubscriptionService;

@WebServlet("/MemberSubcriptionInsert_DeleteController")
public class MemberSubcriptionInsert_DeleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Integer memberID= Integer.valueOf(request.getParameter("memberID"));
		Integer memberTrackID= Integer.valueOf(request.getParameter("memberTrackID"));
		//System.out.println(memberID);
		//System.out.println(memberTrackID);
		MemberSubscriptionService memberSubscriptionService=new MemberSubscriptionService();
		memberSubscriptionService.deleteMemberSubscription(memberID, memberTrackID);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			request.setCharacterEncoding("utf-8");
			Integer memberID=Integer.parseInt(request.getParameter("memberID"));
			Integer memberTrackID=Integer.parseInt(request.getParameter("memberTrackID"));
			MemberSubscriptionService memberSubscriptionService=new MemberSubscriptionService();
			memberSubscriptionService.insertMemberSubscription(memberID, memberTrackID);
			
	}

}
