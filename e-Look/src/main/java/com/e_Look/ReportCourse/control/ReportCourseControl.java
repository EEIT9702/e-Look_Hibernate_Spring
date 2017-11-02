package com.e_Look.ReportCourse.control;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.e_Look.ReportCourse.model.ReportCourseService;

/**
 * Servlet implementation class ReportCourseControl
 */
@WebServlet("/backstage/ReportCourseControl")
public class ReportCourseControl extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.setHeader("content-type", "text/html;charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		//用來到時使用out.println()把JSON格式輸出到網頁上
		PrintWriter out = response.getWriter();
		
		/***************************1.接收請求參數****************************************/
		int status = new Integer(request.getParameter("status"));
		System.out.println("status = " + status);
		Integer reportID = null;
		/***************************2.開始查詢資料*****************************************/
		//獲得點擊"下架影片"或"不處理"所傳來的對應reportID
		String reportIDSTR = request.getParameter("reportIDx");
		if(status == 6){
			System.out.println("status == 6");
			if(reportIDSTR != null){
				System.out.println("reportIDSTR = " + reportIDSTR);
				reportID = Integer.parseInt(reportIDSTR);
				//使用Service並傳入對應的reportID以及對 Course欄位所做出的判斷status
				ReportCourseService rcServ = new ReportCourseService();
				System.out.println(reportID+"*****"+status);
				rcServ.discontinuedCourse(reportID, status);
			}
		}else if(status == 2){
			if(reportIDSTR != null){
				reportID = Integer.parseInt(reportIDSTR);
				//使用Service並傳入對應的reportID以及對 Course欄位所做出的判斷status
				ReportCourseService rcServ = new ReportCourseService();
				rcServ.jugeCourse(reportID, status);
			}
		}
		
		ReportCourseService rcService = new ReportCourseService();
		String jsonObj = rcService.getJSON(status);
		out.println(jsonObj);
	}

}
