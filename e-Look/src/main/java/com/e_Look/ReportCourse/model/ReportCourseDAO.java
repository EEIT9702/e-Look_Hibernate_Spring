package com.e_Look.ReportCourse.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import org.json.simple.JSONValue;

import com.e_Look.Course.CourseDAO;
import com.e_Look.Course.CourseVO;


public class ReportCourseDAO implements ReportCourseDAO_interface {
	private static DataSource ds = null;
	static {
		try {
			Context ctx = new InitialContext();
			ds = (DataSource) ctx.lookup("java:comp/env/jdbc/eLookDB");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}
	
	private static final String INSERT_REPORTCOURSE =
			"INSERT INTO ReportCourse (reportCourseID, reportMemberID, reportContent, reportTime,status ) VALUES (?,?,?,getDate(),0)";
	private static final String UPDATE_STATUS =
		    "UPDATE ReportCourse SET status=? WHERE reportId=?";	
	private static final String DELETE_REPORTCOURSE =
		    "DELETE FROM ReportCourse WHERE reportId =?";
	private static final String SELECT_ONE_REPORT_MESSAGE =
			"SELECT reportId,reportCourseID,reportMemberID,reportContent,reportTime,status FROM ReportCourse WHERE reportId=?";
	private static final String SELECT_NOT_HANDLE_REPORT_COURSE =
			"SELECT reportId,reportCourseID,reportMemberID,reportContent,reportTime,status FROM ReportCourse WHERE status=0";
	private static final String SELECT_ALL_REPORT_COURSE =
			"SELECT reportId,reportCourseID,reportMemberID,reportContent,reportTime,status FROM ReportCourse";	
	
	private static final String GET_JSON = "SELECT rc.reportID, rc.reportCourseID, rc.reportContent, rc.reportTime, rc.status,"
			+ "rc.reportMemberID, c.courseID, c.soldPrice FROM Course c INNER JOIN ReportCourse rc "
			+ "ON c.courseID = rc.reportCourseID WHERE rc.status=?";
	
	@Override
	public void insert(ReportCourseVO ReportCourseVO) {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(INSERT_REPORTCOURSE);

			//pstmt.setInt(1, ReportCourseVO.getReportCourseID());
			pstmt.setInt(1, ReportCourseVO.getCourseVO().getCourseID());
			pstmt.setInt(2,	ReportCourseVO.getReportMemberID());
			pstmt.setString(3, ReportCourseVO.getReportContent());
			
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
	public void update(ReportCourseVO reportCourseVO) {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			//"UPDATE ReportMessage SET status=? WHERE reportId=?";
			con = ds.getConnection();
			pstmt = con.prepareStatement(UPDATE_STATUS);
			pstmt.setByte(1, reportCourseVO.getStatus());
			pstmt.setInt(2, reportCourseVO.getReportId());
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
	public void delete(Integer reportID) {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			//"DELETE FROM ReportMessage WHERE reportId =?";
			con = ds.getConnection();
			pstmt=con.prepareStatement(DELETE_REPORTCOURSE);
			pstmt.setInt(1, reportID);
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
	public ReportCourseVO findByReportId(Integer reportId) {
		ReportCourseVO reportCourseVO = null;
		CourseVO courseVO = null;
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			//"SELECT reportId,reportCourseID,reportMemberID,reportContent,reportTime,status FROM ReportCourse WHERE reportId=?";
			con = ds.getConnection();
			pstmt = con.prepareStatement(SELECT_ONE_REPORT_MESSAGE);

			pstmt.setInt(1, reportId);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				reportCourseVO = new ReportCourseVO();
				courseVO = new CourseVO();
				
				CourseDAO courseDAO = new CourseDAO();
				Integer courseID = rs.getInt("reportCourseID");
				courseVO = courseDAO.findByPrimaryKey(courseID);
				
				reportCourseVO.setCourseVO(courseVO);
				
				reportCourseVO.setReportId(rs.getInt("reportId"));
				reportCourseVO.setReportMemberID(rs.getInt("reportMemberID"));
				reportCourseVO.setReportContent(rs.getString("reportContent"));
				reportCourseVO.setReportTime(rs.getDate("reportTime"));
				reportCourseVO.setReportTime(rs.getDate("reportTime"));
				reportCourseVO.setStatus(rs.getByte("status"));
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
		return reportCourseVO;
	}

	@Override
	public String getJSON(Integer status) {
		String jsonString;
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			//SELECT rc.reportID, rc.reportCourseID, rc.reportContent, rc.reportTime, rc.status, 
			//rc.reportMemberID, c.courseID, c.soldPrice
			//FROM Course c INNER JOIN ReportCourse rc ON c.courseID = rc.reportCourseID
			con = ds.getConnection();
			pstmt = con.prepareStatement(GET_JSON);
			pstmt.setInt(1, status);
			rs = pstmt.executeQuery();
			
			 List l1 = new LinkedList();
			 while (rs.next()) {
				 Map m1 = new HashMap();  
				 m1.put("reportID", rs.getString(1));   
				 m1.put("reportCourseID", rs.getString(2));  
				 m1.put("reportContent", rs.getString(3));   
				 m1.put("reportTime", rs.getString(4)); 
				 m1.put("status", rs.getString(5)); 
				 m1.put("reportMemberID", rs.getString(6));
				 m1.put("courseID", rs.getString(7));
				 m1.put("soldPrice", rs.getString(8));
				 l1.add(m1);
			 }
			 jsonString = JSONValue.toJSONString(l1);  
			
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
		return jsonString;
	}
	
	@Override
	public List<ReportCourseVO> getNotHandle(byte status) {
		List<ReportCourseVO> list = new ArrayList<ReportCourseVO>();
		ReportCourseVO reportCourseVO = null;
		CourseVO courseVO = null;
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(SELECT_NOT_HANDLE_REPORT_COURSE);
			pstmt.setByte(1, status);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				reportCourseVO = new ReportCourseVO();
				courseVO = new CourseVO();
				
				CourseDAO courseDAO = new CourseDAO();
				Integer courseID = rs.getInt("reportCourseID");
				courseVO = courseDAO.findByPrimaryKey(courseID);
				
				reportCourseVO.setCourseVO(courseVO);
				
				reportCourseVO.setReportId(rs.getInt("reportId"));
				reportCourseVO.setReportMemberID(rs.getInt("reportMemberID"));
				reportCourseVO.setReportContent(rs.getString("reportContent"));
				reportCourseVO.setReportTime(rs.getDate("reportTime"));
				reportCourseVO.setReportTime(rs.getDate("reportTime"));
				reportCourseVO.setStatus(rs.getByte("status"));
				list.add(reportCourseVO); // Store the row in the list
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
	public List<ReportCourseVO> getAll() {
		List<ReportCourseVO> list = new ArrayList<ReportCourseVO>();
		ReportCourseVO reportCourseVO = null;
		CourseVO courseVO = null;
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(SELECT_ALL_REPORT_COURSE);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				reportCourseVO = new ReportCourseVO();
				courseVO = new CourseVO();
				
				CourseDAO courseDAO = new CourseDAO();
				Integer courseID = rs.getInt("reportCourseID");
				courseVO = courseDAO.findByPrimaryKey(courseID);
				
				reportCourseVO.setCourseVO(courseVO);
				
				reportCourseVO.setReportId(rs.getInt("reportId"));
				reportCourseVO.setReportMemberID(rs.getInt("reportMemberID"));
				reportCourseVO.setReportContent(rs.getString("reportContent"));
				reportCourseVO.setReportTime(rs.getDate("reportTime"));
				reportCourseVO.setReportTime(rs.getDate("reportTime"));
				reportCourseVO.setStatus(rs.getByte("status"));
				list.add(reportCourseVO); // Store the row in the list
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
