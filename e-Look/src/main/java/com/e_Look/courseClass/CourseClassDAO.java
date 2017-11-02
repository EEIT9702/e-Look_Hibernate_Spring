package com.e_Look.courseClass;

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

import com.e_Look.eLookEvent.eLookEventDAO;
import com.e_Look.eLookEvent.eLookEventVO;



public class CourseClassDAO implements CourseClass_interface{
	private static DataSource ds = null;
	static {
		try {
			Context ctx = new InitialContext();
			ds = (DataSource) ctx.lookup("java:comp/env/jdbc/eLookDB");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}

	private static final String INSERT_COURSE_CLASS = "INSERT INTO courseClass (ccName) VALUES (?)"; 
	private static final String UPDATE_COURSE_CLASS = "UPDATE courseClass SET ccName=? eventID=? WHERE CourseClassID=?"; 
	private static final String DELETE_COURSE_CLASS = "DELETE FROM courseClass WHERE CourseClassID=?"; 
	private static final String SELECT_COURSE_CLASS = "SELECT CourseClassID,ccName,eventID FROM courseClass WHERE CourseClassID=?";
	private static final String SELECT_EVENT_COURSE_CLASS = "SELECT CourseClassID,ccName,eventID FROM courseClass WHERE eventID=?";
	private static final String SELECT_ALL_COURSE_CLASS = "SELECT CourseClassID,ccName,eventID FROM courseClass";
	@Override
	public void insert(CourseClassVO courseClassVO) {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = ds.getConnection();
			
			pstmt = con.prepareStatement(INSERT_COURSE_CLASS);
			pstmt.setString(1, courseClassVO.getCcName());

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
	public void delete(Integer CourseClassID) {
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			con = ds.getConnection();
			
			pstmt = con.prepareStatement(DELETE_COURSE_CLASS);
			
			pstmt.setInt(1,CourseClassID);
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
	public void update(CourseClassVO courseClassVO) {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = ds.getConnection();
			
			pstmt = con.prepareStatement(UPDATE_COURSE_CLASS);
			
			pstmt.setString(1,courseClassVO.getCcName());
			//pstmt.setInt(2,courseClassVO.getEventID());
			pstmt.setInt(2,courseClassVO.getEventVO().getEventID());
			pstmt.setInt(3,courseClassVO.getCourseClassID());
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
	public CourseClassVO getByCourseClassID(Integer CourseClassID) {
		CourseClassVO courseClassVO = null;
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		eLookEventDAO eedao = new eLookEventDAO(); 
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(SELECT_COURSE_CLASS);
			pstmt.setInt(1, CourseClassID);
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				courseClassVO = new CourseClassVO();
				
				courseClassVO.setCourseClassID(rs.getInt(1));
				courseClassVO.setCcName(rs.getString(2));
				eLookEventVO eventVO=eedao.findByPrimaryKey(rs.getInt(3));				
				courseClassVO.setEventVO(eventVO);
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
		
		return courseClassVO;
	
	}

	public List<CourseClassVO> getByEventID(Integer eventID){
		
		List<CourseClassVO> event_courseClass = new LinkedList<CourseClassVO>();
		eLookEventDAO eedao = new eLookEventDAO(); 
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {		
			con = ds.getConnection();
			pstmt = con.prepareStatement(SELECT_EVENT_COURSE_CLASS);
			pstmt.setInt(1, eventID);
			rs = pstmt.executeQuery();
			
			while(rs.next()){
				CourseClassVO courseClassVO = new CourseClassVO();
			
				courseClassVO.setCourseClassID(rs.getInt(1));	
				courseClassVO.setCcName(rs.getString(2));	
				eLookEventVO eventVO = eedao.findByPrimaryKey(rs.getInt(3));
				courseClassVO.setEventVO(eventVO);
				
				event_courseClass.add(courseClassVO);
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
		return event_courseClass;
	}
			

	@Override
	public List<CourseClassVO> getAll() {
		
		List<CourseClassVO> event_courseClass = new LinkedList<CourseClassVO>();
		eLookEventDAO eedao = new eLookEventDAO(); 
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(SELECT_ALL_COURSE_CLASS);
			rs = pstmt.executeQuery();
			
			while(rs.next()){
				CourseClassVO courseClassVO = new CourseClassVO();
				courseClassVO.setCourseClassID(rs.getInt(1));	
				courseClassVO.setCcName(rs.getString(2));	
				eLookEventVO eventVO = eedao.findByPrimaryKey(rs.getInt(3));
				courseClassVO.setEventVO(eventVO);
				event_courseClass.add(courseClassVO);
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
		return event_courseClass;
	}
}

