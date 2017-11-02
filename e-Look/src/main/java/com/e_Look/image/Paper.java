package com.e_Look.image;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

/**
 * Servlet implementation class Paper
 */
@WebServlet("/Paper")
public class Paper extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String CourseID=request.getParameter("CourseID");
		InputStream is = null;
		OutputStream os=null;
		DataSource ds = null;
		try {
			Context ctx = new InitialContext();
			ds = (DataSource) ctx.lookup("java:comp/env/jdbc/eLookDB");
		} catch (NamingException e) {
			e.printStackTrace();
		}
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement("select paper from Course where CourseID=? ");
			pstmt.setInt(1, Integer.valueOf(CourseID));
			ResultSet  rs=pstmt.executeQuery();
			if(rs.next()){
				 is= rs.getBinaryStream(1);
				 if(is!=null){
					 response.setContentType("application/x-compressed");
					 os = response.getOutputStream();
					 int count = 0;
					byte[] bytes = new byte[16384];
					while ((count = is.read(bytes)) != -1) {
						os.write(bytes, 0, count);
					}
			}
			}
		} catch (SQLException e) {
		
			e.printStackTrace();
		}finally {
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
