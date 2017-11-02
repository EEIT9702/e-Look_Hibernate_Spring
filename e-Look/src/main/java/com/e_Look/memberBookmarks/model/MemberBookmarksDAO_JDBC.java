package com.e_Look.memberBookmarks.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.e_Look.Course.CourseVO;
import com.e_Look.member.model.MemberVO;

public class MemberBookmarksDAO_JDBC implements MemberBookmarksDAO_interface {
	String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
	String url = "jdbc:sqlserver://localhost:1433;DatabaseName=elook";
	String userid = "sa";
	
	//第一組密碼
	String passwd = "P@ssw0rd";
	//第二組密碼
	//String passwd = "123456";
	
	private static final String INSERT_MEMBERBOOKMARKS =
			"INSERT INTO MemberBookmarks (memberID, courseID) VALUES (?,?) ";
	//UPDATE寫著,但應該用不到
	private static final String UPDATE_MEMBERBOOKMARKS =
			"UPDATE MemberBookmarks SET courseID=? WHERE memberID=?";
	private static final String DELETE_MEMBERBOOKMARKS =
		    "DELETE FROM MemberBookmarks WHERE memberID =? and courseID =?";
	private static final String SELECT_ONE_MEMBERBOOKMARKS =
			"SELECT memberID, courseID FROM MemberBookmarks WHERE memberID=?";
	private static final String SELECT_ALL_MEMBERBOOKMARKS =
			"SELECT memberID, courseID FROM MemberBookmarks";
	
	
	@Override
	public void insert(Integer memberID,Integer courseID) {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(INSERT_MEMBERBOOKMARKS);
			pstmt.setInt(1,memberID);
			pstmt.setInt(2,courseID);
			
			pstmt.executeUpdate();

			// Handle any SQL errors
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. "
					+ se.getMessage());
			// Clean up JDBC resources
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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

	@Override
	public void update(MemberBookmarksVO MemberBookmarksVO) {

		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			//"UPDATE MemberBookmarks SET courseID=? WHERE memberID=?";
			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(UPDATE_MEMBERBOOKMARKS);
			pstmt.setInt(2, MemberBookmarksVO.getMemberID());
			pstmt.setInt(1,MemberBookmarksVO.getCourseID());
			pstmt.executeUpdate();

			// Handle any SQL errors
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. "
					+ se.getMessage());
			// Clean up JDBC resources
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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

	@Override
	public void delete(Integer memberID, Integer courseID) {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			//"DELETE FROM MemberBookmarks WHERE memberID =? and courseID =?";
			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt=con.prepareStatement(DELETE_MEMBERBOOKMARKS);
			pstmt.setInt(1, memberID);
			pstmt.setInt(2, courseID);
			pstmt.executeUpdate();

			// Handle any SQL errors
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. "
					+ se.getMessage());
			// Clean up JDBC resources
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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

	@Override
	public List<MemberBookmarksVO> findByMemberID(Integer memberID) {
		List<MemberBookmarksVO> list = new ArrayList<MemberBookmarksVO>();
		MemberBookmarksVO memberBookmarksVO = null;
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			//"SELECT memberID, courseID FROM MemberBookmarks WHERE memberID=?";
			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(SELECT_ONE_MEMBERBOOKMARKS);

			pstmt.setInt(1, memberID);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				// memberSubscriptionVO 也稱為 Domain objects
				memberBookmarksVO = new MemberBookmarksVO();
				memberBookmarksVO.setMemberID(rs.getInt("memberID"));
				memberBookmarksVO.setCourseID(rs.getInt("CourseID"));
				list.add(memberBookmarksVO); // Store the row in the list
			}

			// Handle any SQL errors
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. "
					+ se.getMessage());
			// Clean up JDBC resources
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
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
		return list;
	}

	@Override
	public List<MemberBookmarksVO> getAll() {
		List<MemberBookmarksVO> list = new ArrayList<MemberBookmarksVO>();
		MemberBookmarksVO memberBookmarksVO = null;

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			//"SELECT memberID, courseID FROM MemberBookmarks";
			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(SELECT_ALL_MEMBERBOOKMARKS);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				// memberBookmarksVO 也稱為 Domain objects
				memberBookmarksVO = new MemberBookmarksVO();
				memberBookmarksVO.setMemberID(rs.getInt("memberID"));
				memberBookmarksVO.setCourseID(rs.getInt("courseID"));
				list.add(memberBookmarksVO); // Store the row in the list
			}

			// Handle any SQL errors
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. "
					+ se.getMessage());
			// Clean up JDBC resources
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
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
		return list;
	}
	public static void main(String[] args) {
		MemberBookmarksDAO_JDBC dao=new MemberBookmarksDAO_JDBC();
		MemberBookmarksVO MemberBookmarksVO=new MemberBookmarksVO();
		
		//"INSERT INTO MemberBookmarks (memberID, courseID) VALUES (?,?) ";
		//新增

		dao.insert(100002,200002);
		
		//"UPDATE MemberBookmarks SET courseID=? WHERE memberID=?";
		//修改沒意義不寫了
		
		//"DELETE FROM MemberBookmarks WHERE memberID =? and courseID =?";
		//刪除
//		dao.delete(100002, 200002);
		
		
		//"SELECT memberID, courseID FROM MemberBookmarks WHERE memberID=?";
		//一筆資料
//		List<MemberBookmarksVO> MemberBookmarks=dao.findByMemberID(100002);
//		for(MemberBookmarksVO list:MemberBookmarks){
//			System.out.print(list.getMemberID()+"  ");
//			System.out.println(list.getCourseID());
//		}
		//"SELECT memberID, courseID FROM MemberBookmarks"
		//多筆資料
//		List<MemberBookmarksVO> MemberBookmarks=dao.getAll();
//		for(MemberBookmarksVO list:MemberBookmarks){
//			System.out.print(list.getMemberID()+"  ");
//			System.out.println(list.getCourseID());
//		}		
	}

}
