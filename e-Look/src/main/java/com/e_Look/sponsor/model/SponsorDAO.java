package com.e_Look.sponsor.model;

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

public class SponsorDAO implements SponsorDAO_interface {
	private static DataSource ds = null;
	static {
		try {
			Context ctx = new InitialContext();
			ds = (DataSource) ctx.lookup("java:comp/env/jdbc/eLookDB");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}

	private static final String INSERT_SPONSOR = "INSERT INTO Sponsor (courseID, SponsorName, money,dateSponsor) VALUES (?,?,?,?) ";
	// 寫著,但應該用不到
	private static final String UPDATE_SPONSOR = "UPDATE Sponsor SET SponsorName=?, money=? WHERE courseID=?";
	// 寫著,但應該用不到
	private static final String DELETE_SPONSOR = "DELETE FROM Sponsor WHERE courseID =?";
	
	private static final String SELECT_ONE_SPONSOR = "SELECT courseID, SponsorName, money,dateSponsor FROM Sponsor WHERE courseID=?";

	private static final String SELECT_ALL_SPONSOR = "SELECT courseID, SponsorName, money,dateSponsor FROM Sponsor";

	@Override
	public void insert(SponsorVO sponsorVO) {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(INSERT_SPONSOR);
			pstmt.setInt(1, sponsorVO.getCourseID());
			pstmt.setString(2, sponsorVO.getSponsorName());
			pstmt.setInt(3, sponsorVO.getMoney());
			pstmt.setDate(4, sponsorVO.getDateSponsor());
			pstmt.executeUpdate();

			// Handle any SQL errors
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. " + se.getMessage());
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
	public void update(SponsorVO sponsorVO) {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			// "UPDATE Sponsor SET SponsorName=?, money=? WHERE courseID=?";
			con = ds.getConnection();
			pstmt = con.prepareStatement(UPDATE_SPONSOR);
			pstmt.setInt(3, sponsorVO.getCourseID());
			pstmt.setString(1, sponsorVO.getSponsorName());
			pstmt.setInt(2, sponsorVO.getMoney());
			pstmt.executeUpdate();

			// Handle any SQL errors
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. " + se.getMessage());
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
	public void delete(Integer courseID) {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			// "DELETE FROM Sponsor WHERE courseID =?";
			con = ds.getConnection();
			pstmt = con.prepareStatement(DELETE_SPONSOR);
			pstmt.setInt(1, courseID);
			pstmt.executeUpdate();

			// Handle any SQL errors
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. " + se.getMessage());
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
	public SponsorVO findByCourseID(Integer courseID) {

		SponsorVO sponsorVO = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			// "SELECT courseID, SponsorName, money FROM Sponsor WHERE
			// courseID=?";
			con = ds.getConnection();
			pstmt = con.prepareStatement(SELECT_ONE_SPONSOR);

			pstmt.setInt(1, courseID);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				// sponsorVO 也稱為 Domain objects
				sponsorVO = new SponsorVO();
				sponsorVO.setCourseID(rs.getInt("courseID"));
				sponsorVO.setSponsorName(rs.getString("sponsorName"));
				sponsorVO.setMoney(rs.getInt("money"));
			}

			// Handle any SQL errors
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. " + se.getMessage());
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
		return sponsorVO;
	}

	@Override
	public List<SponsorVO> getCountMoney(Integer courseID) {
		// "SELECT courseID, SponsorName, money FROM Sponsor WHERE courseID=?";
		List<SponsorVO> CountMoney = new ArrayList<SponsorVO>();
		SponsorVO SponsorVO = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(SELECT_ONE_SPONSOR);
			pstmt.setInt(1, courseID);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				SponsorVO = new SponsorVO();
				SponsorVO.setCourseID(rs.getInt("courseID"));
				SponsorVO.setSponsorName(rs.getString("SponsorName"));
				SponsorVO.setMoney(rs.getInt("money"));
				SponsorVO.setDateSponsor(rs.getDate("dateSponsor"));
				CountMoney.add(SponsorVO);
			}
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. " + se.getMessage());
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
		return CountMoney;

	}

	public List<SponsorVO> getAll() {
		List<SponsorVO> list = new ArrayList<SponsorVO>();
		SponsorVO sponsorVO = null;

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			// "SELECT courseID, SponsorName, money FROM Sponsor";
			con = ds.getConnection();
			pstmt = con.prepareStatement(SELECT_ALL_SPONSOR);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				// sponsorVO 也稱為 Domain objects
				sponsorVO = new SponsorVO();
				sponsorVO.setCourseID(rs.getInt("courseID"));
				sponsorVO.setSponsorName(rs.getString("sponsorName"));
				sponsorVO.setMoney(rs.getInt("money"));
				sponsorVO.setDateSponsor(rs.getDate("dateSponsor"));
				list.add(sponsorVO); // Store the row in the list
			}

			// Handle any SQL errors
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. " + se.getMessage());
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
