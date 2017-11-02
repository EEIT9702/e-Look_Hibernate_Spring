package com.e_Look.memberBookmarks.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import com.e_Look.Course.CourseVO;
import com.e_Look.member.model.MemberVO;

public class MemberBookmarksDAO implements MemberBookmarksDAO_interface {
	private static DataSource ds = null;
	static {
		try {
			Context ctx = new InitialContext();
			ds = (DataSource) ctx.lookup("java:comp/env/jdbc/eLookDB");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}
	
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
			con = ds.getConnection();
			pstmt = con.prepareStatement(INSERT_MEMBERBOOKMARKS);
			pstmt.setInt(1,memberID);
			pstmt.setInt(2,courseID);
			
			pstmt.executeUpdate();

			// Handle any SQL errors
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. "
					+ se.getMessage());
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

	@Override
	public void update(MemberBookmarksVO MemberBookmarksVO) {

		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			//"UPDATE MemberBookmarks SET courseID=? WHERE memberID=?";
			con = ds.getConnection();
			pstmt = con.prepareStatement(UPDATE_MEMBERBOOKMARKS);
			pstmt.setInt(2, MemberBookmarksVO.getMemberID());
			pstmt.setInt(1,MemberBookmarksVO.getCourseID());
			pstmt.executeUpdate();

			// Handle any SQL errors
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. "
					+ se.getMessage());
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

	@Override
	public void delete(Integer memberID, Integer courseID) {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			//"DELETE FROM MemberBookmarks WHERE memberID =? and courseID =?";
			con = ds.getConnection();
			pstmt=con.prepareStatement(DELETE_MEMBERBOOKMARKS);
			pstmt.setInt(1, memberID);
			pstmt.setInt(2, courseID);
			pstmt.executeUpdate();

			// Handle any SQL errors
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. "
					+ se.getMessage());
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

	@Override
	public List<MemberBookmarksVO> findByMemberID(Integer memberID) {
		List<MemberBookmarksVO> list = new ArrayList<MemberBookmarksVO>();
		MemberBookmarksVO memberBookmarksVO = null;
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			//"SELECT memberID, courseID FROM MemberBookmarks WHERE memberID=?";
			con = ds.getConnection();
			pstmt = con.prepareStatement(SELECT_ONE_MEMBERBOOKMARKS);

			pstmt.setInt(1, memberID);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				// memberSubscriptionVO 也稱為 Domain objects
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
			con = ds.getConnection();
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

}
