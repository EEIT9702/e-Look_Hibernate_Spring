package com.e_Look.backStage.login.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import com.e_Look.ad.AdVO;

public class LoginDAO implements Login_interface{
	private static DataSource ds = null;
	static {
		try {
			Context ctx = new InitialContext();
			ds = (DataSource) ctx.lookup("java:comp/env/jdbc/eLookDB");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}
	
	
	public static final String SELECT_LOGIN="SELECT managerID,mPassword FROM Manager where managerID=?";



@Override
public LoginVO findByManagerID(String managerID) {
	LoginVO loginVO = null;
	Connection con = null;
	PreparedStatement pstmt = null;
	
	try {
		//"SELECT adID, fileName, adFile, status FROM Ad WHERE adID=?";
		con = ds.getConnection();
		pstmt = con.prepareStatement(SELECT_LOGIN);
		pstmt.setString(1,managerID);
		ResultSet rs = pstmt.executeQuery();

		while (rs.next()) {
			// adVO 也稱為 Domain objects
			loginVO = new LoginVO();
			loginVO.setManagerID(rs.getString("managerID"));
			loginVO.setmPassword(rs.getString("mPassword"));
			
		}

		// Handle any SQL errors
	} catch (SQLException se) {
		throw new RuntimeException("A database error occured. "
				+ se.getMessage());
		// Clean up JDBC resources
	} finally {
		if (pstmt != null) {
			try {
				pstmt.close();
			} catch (SQLException se) {
				se.printStackTrace(System.err);
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
	return loginVO;
}

}
