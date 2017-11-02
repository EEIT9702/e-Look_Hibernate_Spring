package com.e_Look.reportMessage.control;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONValue;

/**
 * Servlet implementation class ReportMessages
 */
@WebServlet("/backstage/ReportMessages")
public class ReportMessages extends HttpServlet {
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
		PrintWriter out = response.getWriter();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String url = "jdbc:sqlserver://localhost:1433;DatabaseName=eLook";
		
		String query = "SELECT m.messageID, m.mContent, rm.reportID, rm.reportMessageID,"
				+ " rm.reportMemberID, rm.reportContent, rm.reportTime, rm.status"
				+ " FROM Message m INNER JOIN ReportMessage rm ON m.messageID = "
				+ "rm.reportMessageID WHERE rm.status=?";
		String status = request.getParameter("status");
		if(status == null){
			status = "0";
		}
		
		try {
			DriverManager.registerDriver(new com.microsoft.sqlserver.jdbc.SQLServerDriver());
			con = DriverManager.getConnection(url, "sa", "P@ssw0rd");
			
			pstmt = con.prepareStatement(query);
			pstmt.setString(1,status);
			 rs = pstmt.executeQuery();
			
			
			 List  l1 = new LinkedList();
			 while (rs.next()) {
				 Map m1 = new HashMap();  
				 m1.put("messageID", rs.getString(1));   
				 m1.put("mContent", rs.getString(2));  
				 m1.put("reportID", rs.getString(3));   
				 m1.put("reportMessageID", rs.getString(4)); 
				 m1.put("reportMemberID", rs.getString(5)); 
				 m1.put("reportContent", rs.getString(6));
				 m1.put("reportTime", rs.getString(7));
				 m1.put("status", rs.getString(8));
				 l1.add(m1);
			 }
			 
			 String jsonString = JSONValue.toJSONString(l1);  
			 out.println(jsonString);
			
			// Handle any SQL errors
		} catch (SQLException e) {
			out.println("Error:" + e.getMessage());
			// Clean up JDBC resources
		} finally {
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace(System.err);
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (Exception e) {
					e.printStackTrace(System.err);
				}
			}
		}
		
	}

}
