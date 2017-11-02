package com.e_Look.ReportCourse.control;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.e_Look.ReportCourse.model.ReportCourseService;

@WebServlet("/ReportCourseInsertController")
public class ReportCourseInsertController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public ReportCourseInsertController() {

    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		Integer memberID= Integer.valueOf(request.getParameter("reportMemberID"));
		Integer courseID= Integer.valueOf(request.getParameter("reportCourseID"));
		String 	reportContent=request.getParameter("radioReporterCon");
		System.out.println(reportContent);
		
		ReportCourseService reportCourseService=new ReportCourseService(); 
		reportCourseService.insertReportCourse(courseID, memberID, reportContent);
		response.sendRedirect(request.getHeader("referer"));
		return;
	}

}
