package com.e_Look.member.control;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.e_Look.member.model.MemberService;
import com.e_Look.member.model.MemberVO;

/**
 * Servlet implementation class MemberDataContrlloer
 */
@MultipartConfig(location = "", fileSizeThreshold = 1024 * 1024, maxFileSize = 1024 * 1024 * 1024, maxRequestSize = 1024
		* 1024 * 1024)
@WebServlet("/member/MemberDataContrlloer")
public class MemberDataContrlloer extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession(false);
		MemberService service = null;
		MemberVO memberVO = null;
		String change = request.getParameter("change");
		if (change == null) {
			Integer memberID = new Integer(request.getParameter("memberID"));
			String email = request.getParameter("email");
			service = new MemberService();
			if(request.getPart("memberphoto").getSize()==0){
			
			String mName = request.getParameter("mName");
			
			String mPassword = request.getParameter("mPassword");
			String aboutme = request.getParameter("aboutme");
			String skill = request.getParameter("skill");
			String hobby = request.getParameter("hobby");
			// String city=request.getParameter("city");
			// String district=request.getParameter("district");
			String address = request.getParameter("address");
			service = new MemberService();
			memberVO = new MemberVO(memberID, email, mPassword, mName, aboutme, skill, hobby, address);
			service.updateMember(memberVO);
			memberVO = service.getMemberMail(email);
			session.setAttribute("LoginOK", memberVO);
			}else{
				service.updateMemberImage(memberID, request.getPart("memberphoto"));
			}
			
		}else{
			String mPassword = request.getParameter("mPassword");
			memberVO=(MemberVO)session.getAttribute("LoginOK");
			service = new MemberService();		
			memberVO.setmPassword(mPassword);
			service.updateMember(memberVO);
			session.setAttribute("LoginOK", memberVO);
			
			
		}
	}

}
