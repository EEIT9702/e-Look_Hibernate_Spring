package com.e_Look.buyCourse.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class BuyCourseDAO implements BuyCourseDAO_interface {
	private static DataSource ds = null;
	static {
		try {
			Context ctx = new InitialContext();
			ds = (DataSource) ctx.lookup("java:comp/env/jdbc/eLookDB");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}

	private static final String INSERT_BUYCOURSE = "insert into BuyCourse (memberID,courseID) values (?,?)";
	private static final String UPDATE_BUYCOURSE = "update BuyCourse set score=? where memberID=? and courseID=?";
	private static final String DELETE_BUYCOURSE = "delete from BuyCourse where memberID=? and courseID=?";
	private static final String SELECT_AVG_SCORE = "select avg(score) from BuyCourse where courseID=?";
	private static final String SELECT_MEMBER_BUYCOURSE = "select memberID,courseID,score from BuyCourse where memberID=?";
	private static final String SELECT_ALL = "select memberID,courseID,score from BuyCourse";
	private static final String SELECT_BYCOURSEID = "select memberID,courseID,score from BuyCourse where courseID=?";

	@Override
	public void insert(BuyCourseVO buyCourseVO) {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(INSERT_BUYCOURSE);
			pstmt.setInt(1, buyCourseVO.getMemberID());
			pstmt.setInt(2, buyCourseVO.getCourseID());
			pstmt.executeUpdate();

		} catch (SQLException e) {
			throw new RuntimeException("A database error occured. " + e.getMessage());
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
	public void update(BuyCourseVO buyCourseVO) {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(UPDATE_BUYCOURSE);
			pstmt.setInt(1, buyCourseVO.getScore());
			pstmt.setInt(2, buyCourseVO.getMemberID());
			pstmt.setInt(3, buyCourseVO.getCourseID());
			pstmt.executeUpdate();

		} catch (SQLException e) {
			throw new RuntimeException("A database error occured. " + e.getMessage());
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
	public void delete(BuyCourseVO buyCourseVO) {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(DELETE_BUYCOURSE);
			pstmt.setInt(1, buyCourseVO.getMemberID());
			pstmt.setInt(2, buyCourseVO.getCourseID());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			throw new RuntimeException("A database error occured. " + e.getMessage());
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
	public Double getAvgScore(Integer courseID) {
		Double avg = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(SELECT_AVG_SCORE);
			pstmt.setInt(1, courseID);
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				avg = rs.getDouble(1);
			}
		} catch (SQLException e) {
			throw new RuntimeException("A database error occured. " + e.getMessage());
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
		return avg;
	}

	@Override
	public List<BuyCourseVO> findByMemberID(Integer memberID) {
		List<BuyCourseVO> list = new LinkedList<BuyCourseVO>();

		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(SELECT_MEMBER_BUYCOURSE);
			pstmt.setInt(1, memberID);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				BuyCourseVO buyCourseVO = new BuyCourseVO();
				buyCourseVO.setMemberID(rs.getInt(1));
				buyCourseVO.setCourseID(rs.getInt(2));
				buyCourseVO.setScore(rs.getInt(3));
				list.add(buyCourseVO);
			}

		} catch (SQLException e) {
			throw new RuntimeException("A database error occured. " + e.getMessage());
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
		return list;
	}

	@Override
	public List<BuyCourseVO> getAll() {
		List<BuyCourseVO> list = new LinkedList<BuyCourseVO>();
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(SELECT_ALL);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				BuyCourseVO buyCourseVO = new BuyCourseVO();
				buyCourseVO.setMemberID(rs.getInt(1));
				buyCourseVO.setCourseID(rs.getInt(2));
				buyCourseVO.setScore(rs.getInt(3));
				list.add(buyCourseVO);
			}

		} catch (SQLException e) {
			throw new RuntimeException("A database error occured. " + e.getMessage());
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
		return list;
	}

	@Override
	public List<BuyCourseVO> getByCourseID(Integer courseID) {
		List<BuyCourseVO> list = new LinkedList<BuyCourseVO>();
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = ds.getConnection();
			pstmt=con.prepareStatement(SELECT_BYCOURSEID);
			pstmt.setInt(1, courseID);
			ResultSet rs=pstmt.executeQuery();
			while(rs.next()){
				BuyCourseVO buyCourseVO = new BuyCourseVO();
				buyCourseVO.setMemberID(rs.getInt(1));
				buyCourseVO.setCourseID(rs.getInt(2));
				buyCourseVO.setScore(rs.getInt(3));
				list.add(buyCourseVO);
			}
		} catch (SQLException e) {
			throw new RuntimeException("A database error occured. " + e.getMessage());
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
		return list;
	}
}
