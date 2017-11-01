package com.e_Look.memberSubscription;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class MemberSubscriptionDAO implements MemberSubscriptionDAO_interface {
	private static DataSource ds = null;
	static {
		try {
			Context ctx = new InitialContext();
			ds = (DataSource) ctx.lookup("java:comp/env/jdbc/eLookDB");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}
	
	private static final String INSERT_MEMBERSUBSCRIPTION =
			"INSERT INTO MemberSubscription (memberID, memberTrackID) VALUES (?,?) ";
	//UPDATE寫著,但應該用不到
	private static final String UPDATE_MEMBERSUBSCRIPTION =
			"UPDATE MemberSubscription SET memberTrackID=? WHERE memberID=?";
	private static final String DELETE_MEMBERSUBSCRIPTION =
		    "DELETE FROM MemberSubscription WHERE memberID=? and memberTrackID =?";
	private static final String SELECT_ONE_MEMBERSUBSCRIPTION =
			"SELECT memberTrackID, memberID FROM MemberSubscription WHERE memberID=?";
	private static final String SELECT_ALL_MEMBERSUBSCRIPTION =
			"SELECT memberTrackID, memberID FROM MemberSubscription";
	
	@Override
	public void insert(MemberSubscriptionVO memberSubscriptionVO) {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(INSERT_MEMBERSUBSCRIPTION);
			pstmt.setInt(1, memberSubscriptionVO.getMemberID());
			pstmt.setInt(2, memberSubscriptionVO.getMemberTrackID());
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
	public void update(MemberSubscriptionVO memberSubscriptionVO) {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			//"UPDATE MemberSubscription SET memberTrackID=? WHERE memberID=?";
			con = ds.getConnection();
			pstmt = con.prepareStatement(UPDATE_MEMBERSUBSCRIPTION);
			pstmt.setInt(1, memberSubscriptionVO.getMemberID());
			pstmt.setInt(2, memberSubscriptionVO.getMemberTrackID());
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
	public void delete(Integer memberID, Integer memberTrackID) {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			//"DELETE FROM MemberSubscription WHERE memberID=? and memberTrackID =?";
			con = ds.getConnection();
			pstmt=con.prepareStatement(DELETE_MEMBERSUBSCRIPTION);
			pstmt.setInt(1, memberID);
			pstmt.setInt(2, memberTrackID);
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
	public List<MemberSubscriptionVO> findByMemberID(Integer memberID) {
		List<MemberSubscriptionVO> list = new ArrayList<MemberSubscriptionVO>();
		MemberSubscriptionVO memberSubscriptionVO = null;
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			//"SELECT memberTrackID, memberID FROM MemberSubscription WHERE memberID=?";
			con = ds.getConnection();
			pstmt = con.prepareStatement(SELECT_ONE_MEMBERSUBSCRIPTION);

			pstmt.setInt(1, memberID);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				// memberSubscriptionVO 也稱為 Domain objects
				memberSubscriptionVO = new MemberSubscriptionVO();
				memberSubscriptionVO.setMemberTrackID(rs.getInt("memberTrackID"));
				memberSubscriptionVO.setMemberID(rs.getInt("memberID"));
				list.add(memberSubscriptionVO); // Store the row in the list
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
	public List<MemberSubscriptionVO> getAll() {
		List<MemberSubscriptionVO> list = new ArrayList<MemberSubscriptionVO>();
		MemberSubscriptionVO memberSubscriptionVO = null;

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			//"SELECT memberTrackID, memberID FROM MemberSubscription";
			con = ds.getConnection();
			pstmt = con.prepareStatement(SELECT_ALL_MEMBERSUBSCRIPTION);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				// memberSubscriptionVO 也稱為 Domain objects
				memberSubscriptionVO = new MemberSubscriptionVO();
				memberSubscriptionVO.setMemberTrackID(rs.getInt("memberTrackID"));
				memberSubscriptionVO.setMemberID(rs.getInt("memberID"));
				list.add(memberSubscriptionVO); // Store the row in the list
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


	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
