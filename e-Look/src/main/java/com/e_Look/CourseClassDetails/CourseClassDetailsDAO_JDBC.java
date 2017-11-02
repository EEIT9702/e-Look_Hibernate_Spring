package com.e_Look.CourseClassDetails;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import com.e_Look.Course.CourseDAO;
import com.e_Look.Course.CourseDAO_JDBC;
import com.e_Look.Course.CourseVO;
import com.e_Look.courseClass.CourseClassDAO;
import com.e_Look.courseClass.CourseClassDAO_JDBC;
import com.e_Look.courseClass.CourseClassVO;

public class CourseClassDetailsDAO_JDBC implements CourseClassDetails_interface {
	String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
	String url = "jdbc:sqlserver://localhost:1433;DatabaseName=eLook";
	String userid = "sa";
	// 第一組密碼
	
	String passwd = "P@ssw0rd";
	// 第二組密碼
	// String passwd = "123456";
	
	private static final String INSERT_COURSE_N_CLASS = 
			"INSERT INTO CourseClassDetails (courseID,courseName,CourseClassID,ccName) VALUES (?,?,?,?)";
	
//	private static final String UPDATE_courseNClass = 
//			"update CourseClassDetails set CourseClassID=? where courseID=?";
	
	private static final String DELETE_COURSE_N_CLASS = 
			"DELETE FROM CourseClassDetails WHERE courseID=?";
	
	private static final String SELECT_BY_COURSE_CLASSID = 
			"SELECT CourseClassID,ccName,courseID,courseName FROM CourseClassDetails WHERE CourseClassID=?";
	
	private static final String SELECT_BY_COURSEID = 
			"SELECT courseID,courseName,CourseClassID,ccName FROM CourseClassDetails WHERE courseID=?";
	
	private static final String SELECT_ALL = 
			"SELECT CourseClassID,ccName,courseID,courseName FROM CourseClassDetails";

	@Override
	public void insert(CourseVO courseVO, CourseClassVO courseClassVO) {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(INSERT_COURSE_N_CLASS);
			
			pstmt.setInt(1, courseVO.getCourseID());
			pstmt.setString(2, courseVO.getCourseName());
			pstmt.setInt(3, courseClassVO.getCourseClassID());
			pstmt.setString(4, courseClassVO.getCcName());
			
//			CourseVO courseVO = new CourseVO();
//			courseVO.setCourseID(courseID);
//			String courseName = courseVO.getCourseName();
//			
//			CourseClassVO courseClassVO = new CourseClassVO();
//			courseClassVO.setCourseClassID(CourseClassID);
//			String CcName = courseClassVO.getCcName();
//			
//			pstmt.setInt(1, courseID);
//			pstmt.setString(2, courseName);
//			pstmt.setInt(3, CourseClassID);
//			pstmt.setString(4, CcName);

			pstmt.executeUpdate();
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();	
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
	public void update(CourseClassVO courseClassVO, CourseVO courseVO) {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
//			pstmt = con.prepareStatement(UPDATE_courseNClass);

//			pstmt.setInt(1, courseClassVO.getCourseClassID());
//			pstmt.setInt(2, courseVO.getCourseID());
//			pstmt.executeUpdate();
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
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
	public void delete(Integer courseID) {
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(DELETE_COURSE_N_CLASS);
			pstmt.setInt(1,courseID);
			pstmt.executeUpdate();
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
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
	public List<CourseClassDetailsVO> getBycourseClassID(Integer CourseClassID) {
		
		List<CourseClassDetailsVO> findBycourseClassID = new LinkedList<CourseClassDetailsVO>();
		Connection con = null;
		PreparedStatement pstmt = null;
		CourseDAO_JDBC cdao = new CourseDAO_JDBC();
		CourseClassDAO_JDBC ccdao = new CourseClassDAO_JDBC();

		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(SELECT_BY_COURSE_CLASSID);
		
			pstmt.setInt(1, CourseClassID);
			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				CourseClassDetailsVO CourseClassDetailsVO = new CourseClassDetailsVO();
				CourseClassDetailsVO.setCourseClassVO(ccdao.getByCourseClassID(rs.getInt(1)));
				CourseClassDetailsVO.setCcName(rs.getString(2));
				CourseClassDetailsVO.setCourseVO(cdao.findByPrimaryKey(rs.getInt(3)));
				CourseClassDetailsVO.setCourseName(rs.getString(4));
				findBycourseClassID.add(CourseClassDetailsVO);
			}
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
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
		return findBycourseClassID;
	}

	@Override
	public List<CourseClassDetailsVO> findBycourseID(Integer CourseID) {
		List<CourseClassDetailsVO> findBycourseID = new LinkedList<CourseClassDetailsVO>();

		Connection con = null;
		PreparedStatement pstmt = null;
		CourseDAO_JDBC cdao = new CourseDAO_JDBC();
		CourseClassDAO_JDBC ccdao = new CourseClassDAO_JDBC();

		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(SELECT_BY_COURSEID);
			pstmt.setInt(1, CourseID);
			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				CourseClassDetailsVO CourseClassDetailsVO = new CourseClassDetailsVO();
				
				CourseClassDetailsVO.setCourseVO(cdao.findByPrimaryKey(rs.getInt(1)));
				CourseClassDetailsVO.setCourseName(rs.getString(2));
				CourseClassDetailsVO.setCourseClassVO(ccdao.getByCourseClassID(rs.getInt(3)));
				CourseClassDetailsVO.setCcName(rs.getString(4));
				findBycourseID.add(CourseClassDetailsVO);
			}
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
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
		return findBycourseID;
	}

	@Override
	public List<CourseClassDetailsVO> getAll() {
		List<CourseClassDetailsVO> getAll = new LinkedList<CourseClassDetailsVO>();

		Connection con = null;
		PreparedStatement pstmt = null;
		CourseDAO_JDBC cdao = new CourseDAO_JDBC();
		CourseClassDAO_JDBC ccdao = new CourseClassDAO_JDBC();
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(SELECT_ALL);

			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				
				
				CourseClassDetailsVO CourseClassDetailsVO = new CourseClassDetailsVO();
				CourseClassDetailsVO.setCourseClassVO(ccdao.getByCourseClassID(rs.getInt(1)));
				CourseClassDetailsVO.setCcName(rs.getString(2));
				CourseClassDetailsVO.setCourseVO(cdao.findByPrimaryKey(rs.getInt(3)));
				CourseClassDetailsVO.setCourseName(rs.getString(4));
				
				getAll.add(CourseClassDetailsVO);
			}
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
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
		return getAll;
	}
	
	public static void main(String[] args) {
		
		CourseClassDetailsDAO_JDBC dao = new CourseClassDetailsDAO_JDBC();
		
		//新增
//		CourseDAO_JDBC cdao = new CourseDAO_JDBC();
//		CourseVO courseVO = cdao.findByPrimaryKey(200002);
//	
//		CourseClassDAO_JDBC ccdao = new CourseClassDAO_JDBC();
//		CourseClassVO courseClassVO = ccdao.getByCourseClassID(109);
//		dao.insert(courseVO, courseClassVO);
		
		//查詢全部
		List<CourseClassDetailsVO> list = dao.getAll();
		for(CourseClassDetailsVO ccDetailsVO3 : list) {
			System.out.print(ccDetailsVO3.getCourseVO().getCourseID() + ", ");
			System.out.print(ccDetailsVO3.getCourseName() + ", ");
			System.out.print(ccDetailsVO3.getCourseClassVO().getCourseClassID() + ", ");
			System.out.print(ccDetailsVO3.getCcName() + "\n");
		}
	}
	
}
