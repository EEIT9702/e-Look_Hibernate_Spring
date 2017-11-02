package com.e_Look.CourseClassDetails;

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

import com.e_Look.Course.CourseDAO;
import com.e_Look.Course.CourseVO;
import com.e_Look.courseClass.CourseClassDAO;
import com.e_Look.courseClass.CourseClassVO;

public class CourseClassDetailsDAO implements CourseClassDetails_interface {
	private static DataSource ds = null;
	static {
		try {
			Context ctx = new InitialContext();
			ds = (DataSource) ctx.lookup("java:comp/env/jdbc/eLookDB");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}
	
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
			con = ds.getConnection();
			pstmt = con.prepareStatement(INSERT_COURSE_N_CLASS);
			
			pstmt.setInt(1, courseVO.getCourseID());
			pstmt.setString(2, courseVO.getCourseName());
			pstmt.setInt(3, courseClassVO.getCourseClassID());
			pstmt.setString(4, courseClassVO.getCcName());
			
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
	public void update(CourseClassVO courseClassVO, CourseVO courseVO) {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = ds.getConnection();
			
//			pstmt = con.prepareStatement(UPDATE_courseNClass);

//			pstmt.setInt(1, courseClassVO.getCourseClassID());
//			pstmt.setInt(2, courseVO.getCourseID());
//			pstmt.executeUpdate();
			
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
			con = ds.getConnection();
			pstmt = con.prepareStatement(DELETE_COURSE_N_CLASS);
			pstmt.setInt(1,courseID);
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
	public List<CourseClassDetailsVO> getBycourseClassID(Integer CourseClassID) {
		
		List<CourseClassDetailsVO> findBycourseClassID = new LinkedList<CourseClassDetailsVO>();
		Connection con = null;
		PreparedStatement pstmt = null;
		CourseDAO cdao = new CourseDAO();
		CourseClassDAO ccdao = new CourseClassDAO();
		try {
			con = ds.getConnection();
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
		CourseDAO cdao = new CourseDAO();
		CourseClassDAO ccdao = new CourseClassDAO();

		try {
			con = ds.getConnection();
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
		CourseDAO cdao = new CourseDAO();
		CourseClassDAO ccdao = new CourseClassDAO();
		try {
			con = ds.getConnection();
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

}
