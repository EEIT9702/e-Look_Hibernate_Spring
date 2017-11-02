package com.e_Look.reportMessage.control;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.e_Look.reportMessage.model.ReportMessageService;

/**
 * Servlet implementation class InsertReportMessageController
 */
@WebServlet("/InsertReportMessageController")
public class InsertReportMessageController extends HttpServlet {
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
		
		response.setContentType("text/html;charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		Integer messageID = Integer.valueOf(request.getParameter("reportMessageID"));
		Integer reportMemberID = Integer.valueOf(request.getParameter("reportMemberID"));
		String 	reportContent = request.getParameter("reportContent");
		System.out.println("mID:" + messageID + ", rMbID:" + reportMemberID + ", rC:" +reportContent);
		
		ReportMessageService rmServ = new ReportMessageService();
		rmServ.insertReportMessage(messageID, reportMemberID, reportContent);
		
		response.sendRedirect(request.getHeader("referer"));
		return;
	}

}
