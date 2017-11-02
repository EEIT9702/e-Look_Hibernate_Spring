package com.e_Look.Course.control;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.http.client.RequestDirector;

import com.e_Look.Course.CourseService;
import com.e_Look.Course.CourseVO;
import com.e_Look.member.model.MemberVO;

/**
 * Servlet implementation class CreateCourseCotroller
 */
@WebServlet("/CreateCourseCotroller")
public class CreateCourseCotroller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		request.setCharacterEncoding("UTF-8");
		
		HttpSession session = request.getSession();
		MemberVO memberVO = (MemberVO) session.getAttribute("LoginOK");
		if (memberVO == null) {
			session.setAttribute("loginerr", "123");
			response.sendRedirect(request.getHeader("referer"));
		} else {
			CourseService courseService = new CourseService();
			Integer CourseID = courseService.CreateNewCourse(memberVO.getMemberID());
			
			request.setAttribute("CourseID", CourseID);
			RequestDispatcher rd = request.getRequestDispatcher("/CreateCourse.jsp");
			
			rd.forward(request, response);
			return;//表示中斷點
		}
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
	}

}
