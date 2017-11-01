package com.e_Look.buyCourse.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class BuyCourseDAO_JDBC implements BuyCourseDAO_interface {
	String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
	String url = "jdbc:sqlserver://localhost:1433;DatabaseName=elook";
	String userid = "sa";
	// 第一組密碼
	String passwd = "P@ssw0rd";
	// 第二組密碼
	// String passwd = "123456";
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
			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(INSERT_BUYCOURSE);
			pstmt.setInt(1, buyCourseVO.getMemberID());
			pstmt.setInt(2, buyCourseVO.getCourseID());
			pstmt.executeUpdate();

		} catch (ClassNotFoundException e) {
			throw new RuntimeException("Couldn't load database driver. " + e.getMessage());
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
			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(UPDATE_BUYCOURSE);
			pstmt.setInt(1, buyCourseVO.getScore());
			pstmt.setInt(2, buyCourseVO.getMemberID());
			pstmt.setInt(3, buyCourseVO.getCourseID());
			pstmt.executeUpdate();

		} catch (ClassNotFoundException e) {
			throw new RuntimeException("Couldn't load database driver. " + e.getMessage());
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
			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(DELETE_BUYCOURSE);
			pstmt.setInt(1, buyCourseVO.getMemberID());
			pstmt.setInt(2, buyCourseVO.getCourseID());
			pstmt.executeUpdate();
		} catch (ClassNotFoundException e) {
			throw new RuntimeException("Couldn't load database driver. " + e.getMessage());
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
			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(SELECT_AVG_SCORE);
			pstmt.setInt(1, courseID);
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				avg = rs.getDouble(1);
			}
		} catch (ClassNotFoundException e) {
			throw new RuntimeException("Couldn't load database driver. " + e.getMessage());
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
			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
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

		} catch (ClassNotFoundException e) {
			throw new RuntimeException("Couldn't load database driver. " + e.getMessage());
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
			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(SELECT_ALL);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				BuyCourseVO buyCourseVO = new BuyCourseVO();
				buyCourseVO.setMemberID(rs.getInt(1));
				buyCourseVO.setCourseID(rs.getInt(2));
				buyCourseVO.setScore(rs.getInt(3));
				list.add(buyCourseVO);
			}

		} catch (ClassNotFoundException e) {
			throw new RuntimeException("Couldn't load database driver. " + e.getMessage());
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
			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt=con.prepareStatement(SELECT_BYCOURSEID);
			pstmt.setInt(1, courseID);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()){
				BuyCourseVO buyCourseVO = new BuyCourseVO();
				buyCourseVO.setMemberID(rs.getInt(1));
				buyCourseVO.setCourseID(rs.getInt(2));
				buyCourseVO.setScore(rs.getInt(3));
				list.add(buyCourseVO);
			}
			
		} catch (ClassNotFoundException e) {
			throw new RuntimeException("Couldn't load database driver. " + e.getMessage());
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

	public static void main(String[] args) {
		BuyCourseDAO_JDBC dao = new BuyCourseDAO_JDBC();
		// 新增一筆購買
		// BuyCourseVO buyCourseVO1 = new BuyCourseVO();
		// buyCourseVO1.setMemberID(100001);
		// buyCourseVO1.setCourseID(200002);
		// dao.insert(buyCourseVO1);
		//
		// //修改(本DAO修改僅修改score欄位)
		BuyCourseVO buyCourseVO2 = new BuyCourseVO();
		buyCourseVO2.setMemberID(100001);
		buyCourseVO2.setCourseID(200001);
		buyCourseVO2.setScore(5);
		dao.update(buyCourseVO2);
		//
		// //刪除(本table不太會用到此方法)
		// BuyCourseVO buyCourseVO3 = new BuyCourseVO();
		// buyCourseVO3.setMemberID(100001);
		// buyCourseVO3.setCourseID(200001);
		// dao.delete(buyCourseVO3);
		//
		// //計算課程平均分數
		// System.out.println(dao.getAvgScore(200001));

		// 查詢該會員購買之課程
		List<BuyCourseVO> list1 = dao.findByMemberID(100001);
		for (BuyCourseVO buyCourseVO : list1) {
			System.out.print(buyCourseVO.getMemberID() + ",");
			System.out.print(buyCourseVO.getCourseID() + ",");
			System.out.println(buyCourseVO.getScore() + ",");
		}
		// 查全部
		List<BuyCourseVO> list2 = dao.getAll();
		for (BuyCourseVO buyCourseVO : list2) {
			System.out.print(buyCourseVO.getMemberID() + ",");
			System.out.print(buyCourseVO.getCourseID() + ",");
			System.out.println(buyCourseVO.getScore() + ",");
		}

	}
}
