package com.e_Look.courseClass;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import com.e_Look.eLookEvent.eLookEventDAO;
import com.e_Look.eLookEvent.eLookEventDAO_JDBC;
import com.e_Look.eLookEvent.eLookEventVO;



public class CourseClassDAO_JDBC implements CourseClass_interface{
	String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
	String url = "jdbc:sqlserver://localhost:1433;DatabaseName=eLook";
	String userid = "sa";
	// 第一組密碼
	
	String passwd = "P@ssw0rd";
	// 第二組密碼
	// String passwd = "123456";

	private static final String INSERT_COURSE_CLASS = "INSERT INTO courseClass (ccName) VALUES (?)"; 
	private static final String UPDATE_COURSE_CLASS = "UPDATE courseClass SET ccName=? eventID=? WHERE CourseClassID=?"; 
	private static final String DELETE_COURSE_CLASS = "DELETE FROM courseClass WHERE CourseClassID=?"; 
	private static final String SELECT_COURSE_CLASS = "SELECT CourseClassID,ccName,eventID FROM courseClass WHERE CourseClassID=?";
	private static final String SELECT_EVENT_COURSE_CLASS = "SELECT CourseClassID,ccName,eventID FROM courseClass WHERE eventID=?";
	private static final String SELECT_ALL_COURSE_CLASS = "SELECT CourseClassID,ccName,eventID FROM courseClass";
	@Override
	public void insert(CourseClassVO courseClassVO) {
		Connection conn =null;
		PreparedStatement pstmt=null;
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, userid, passwd);
			
			pstmt=conn.prepareStatement(INSERT_COURSE_CLASS);
			pstmt.setString(1, courseClassVO.getCcName());

			pstmt.executeUpdate();
			
			
		} catch (SQLException e) {
			throw new RuntimeException("A database error occured. " + e.getMessage());
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace(System.err);
				}
			}
			if (conn != null) {
				try {
					conn.close();
				} catch (Exception e) {
					e.printStackTrace(System.err);
				}
			}
		}
	}
	
	
	
	@Override
	public void delete(Integer CourseClassID) {
		Connection conn =null;
		PreparedStatement pstmt=null;
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, userid, passwd);
			
			pstmt=conn.prepareStatement(DELETE_COURSE_CLASS);
			
			pstmt.setInt(1,CourseClassID);
			pstmt.executeUpdate();
			
			
		} catch (SQLException e) {
			throw new RuntimeException("A database error occured. " + e.getMessage());
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
			if (conn != null) {
				try {
					conn.close();
				} catch (Exception e) {
					e.printStackTrace(System.err);
				}
			}
		}
		
	}

	@Override
	public void update(CourseClassVO courseClassVO) {
		Connection conn =null;
		PreparedStatement pstmt=null;
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, userid, passwd);
			
			pstmt=conn.prepareStatement(UPDATE_COURSE_CLASS);
			
			pstmt.setString(1,courseClassVO.getCcName());
			//pstmt.setInt(2,courseClassVO.getEventID());
			pstmt.setInt(2,courseClassVO.getEventVO().getEventID());
			pstmt.setInt(3,courseClassVO.getCourseClassID());
			pstmt.executeUpdate();
			
			
		} catch (SQLException e) {
			throw new RuntimeException("A database error occured. " + e.getMessage());
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
			if (conn != null) {
				try {
					conn.close();
				} catch (Exception e) {
					e.printStackTrace(System.err);
				}
			}
		}
		
	}

	
	@Override
	public CourseClassVO getByCourseClassID(Integer CourseClassID) {
		CourseClassVO courseClassVO = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		eLookEventDAO_JDBC eedao = new eLookEventDAO_JDBC(); 
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, userid, passwd);
			pstmt = conn.prepareStatement(SELECT_COURSE_CLASS);
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
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace(System.err);
				}
			}
			if (conn != null) {
				try {
					conn.close();
				} catch (Exception e) {
					e.printStackTrace(System.err);
				}
			}
		}
		
		return courseClassVO;
	
	}

	public List<CourseClassVO> getByEventID(Integer eventID){
		
		List<CourseClassVO> event_courseClass = new LinkedList<CourseClassVO>();
		eLookEventDAO_JDBC eedao = new eLookEventDAO_JDBC(); 
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {		
			Class.forName(driver);
			conn = DriverManager.getConnection(url, userid, passwd);
			pstmt=conn.prepareStatement(SELECT_EVENT_COURSE_CLASS);
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
			if (conn != null) {
				try {
					conn.close();
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
		eLookEventDAO_JDBC eedao = new eLookEventDAO_JDBC(); 
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, userid, passwd);
			pstmt=conn.prepareStatement(SELECT_ALL_COURSE_CLASS);
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
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace(System.err);
				}
			}
			if (conn != null) {
				try {
					conn.close();
				} catch (Exception e) {
					e.printStackTrace(System.err);
				}
			}
		}
		return event_courseClass;
	}
	
	public static void main(String[] args) {
		CourseClassDAO_JDBC dao = new CourseClassDAO_JDBC();
//		新增類別
//		CourseClassVO courseClassVO1 = new CourseClassVO();	
//		courseClassVO1.setCcName("商業1");
//		dao.insert(courseClassVO1);
		
//		查詢一筆
		CourseClassVO courseClassVO2 = dao.getByCourseClassID(101);
		System.out.print(courseClassVO2.getCourseClassID() + ",");
		System.out.print(courseClassVO2.getCcName() + ",");
		System.out.print(courseClassVO2.getEventVO().getEventID() + "\n");
		System.out.println("-----------");
		
		
//		查詢全部
		List<CourseClassVO> list1 = dao.getAll();
		for(CourseClassVO courseClassVO3:list1){
			System.out.print(courseClassVO3.getCourseClassID() + ",");
			System.out.print(courseClassVO3.getCcName() + ",");
			System.out.print(courseClassVO3.getEventVO().getEventID() + "\n");
		
		}
	}
}

