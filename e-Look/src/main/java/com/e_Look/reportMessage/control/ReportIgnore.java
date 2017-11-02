package com.e_Look.reportMessage.control;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ProductsInsert
 */
@WebServlet("/backstage/ReportIgnore")
public class ReportIgnore extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int reportId = Integer.parseInt(request.getParameter("reportId"));
		response.setHeader("content-type", "text/plain;charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String url = "jdbc:sqlserver://localhost:1433;DatabaseName=eLook";
		String query = "UPDATE ReportMessage SET status=1 WHERE reportId=?";
		try {
			DriverManager.registerDriver(new com.microsoft.sqlserver.jdbc.SQLServerDriver());
			con = DriverManager.getConnection(url, "sa", "P@ssw0rd");
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, reportId);
			int i = pstmt.executeUpdate();
			if (i > 0)
				out.println("確認不予處理成功");
			else
				out.println("處理失敗");
		} catch (Exception e) {
			out.println(e);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
