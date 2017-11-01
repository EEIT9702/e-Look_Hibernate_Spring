package com.e_Look.image;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

/**
 * Servlet implementation class CourseImage
 */
@WebServlet("/CourseImage")
public class CourseImage extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String CourseID=request.getParameter("CourseID");
		InputStream is = null;
		ServletOutputStream os=null;
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
			pstmt = con.prepareStatement("select cPhoto from Course where CourseID=? ");
			pstmt.setInt(1, Integer.valueOf(CourseID));
			ResultSet  rs=pstmt.executeQuery();
			if(rs.next()){
				 is= rs.getBinaryStream(1);
				 if(is==null){
					 is=new FileInputStream(new File(request.getServletContext().getRealPath("")+"/img/請上傳課程封面.png"));
				 }
				 response.setContentType("image/jpeg");
				 os = response.getOutputStream();
				 int count = 0;
					byte[] bytes = new byte[8192];
					while ((count = is.read(bytes)) != -1) {
						os.write(bytes, 0, count);
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
