package com.e_Look.ReportCourse.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.json.simple.JSONValue;

import com.e_Look.Course.CourseDAO;
import com.e_Look.Course.CourseDAO_JDBC;
import com.e_Look.Course.CourseVO;


public class ReportCourseDAO_JDBC implements ReportCourseDAO_interface {
	String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
	String url = "jdbc:sqlserver://localhost:1433;DatabaseName=elook";
	String userid = "sa";
	//第一組密碼
	String passwd = "P@ssw0rd";
	//第二組密碼
	//String passwd = "123456";
	
	private static final String INSERT_REPORTCOURSE =
			"INSERT INTO ReportCourse (reportCourseID, reportMemberID, reportContent, reportTime,status ) VALUES (?,?,?,getDate(),0)";
	private static final String UPDATE_STATUS =
		    "UPDATE ReportCourse SET status=? WHERE reportId=?";	
	private static final String DELETE_REPORTCOURSE =
		    "DELETE FROM ReportCourse WHERE reportId =?";
	private static final String SELECT_ONE_REPORT_COURSE =
			"SELECT reportId,reportCourseID,reportMemberID,reportContent,reportTime,status FROM ReportCourse WHERE reportId=?";
	private static final String SELECT_NOT_HANDLE_REPORT_COURSE =
			"SELECT reportId,reportCourseID,reportMemberID,reportContent,reportTime,status FROM ReportCourse WHERE status=?";
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
			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
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
			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(UPDATE_STATUS);
			pstmt.setByte(1, reportCourseVO.getStatus());
			pstmt.setInt(2, reportCourseVO.getReportId());
			pstmt.executeUpdate();
		
			// Handle any SQL errors
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. "
					+ se.getMessage());
			// Clean up JDBC resources
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
			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt=con.prepareStatement(DELETE_REPORTCOURSE);
			pstmt.setInt(1, reportID);
			pstmt.executeUpdate();

			// Handle any SQL errors
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. "
					+ se.getMessage());
			// Clean up JDBC resources
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
			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(SELECT_ONE_REPORT_COURSE);

			pstmt.setInt(1, reportId);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				reportCourseVO = new ReportCourseVO();
				courseVO = new CourseVO();
				
				CourseDAO_JDBC courseDAO = new CourseDAO_JDBC();
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
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
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
			
		// Handle any driver errors
		} catch (ClassNotFoundException e) {
			throw new RuntimeException("Couldn't load database driver. "
					+ e.getMessage());
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
			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(SELECT_NOT_HANDLE_REPORT_COURSE);
			pstmt.setByte(1, status);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				reportCourseVO = new ReportCourseVO();
				courseVO = new CourseVO();
				
				CourseDAO_JDBC courseDAO = new CourseDAO_JDBC();
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
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(SELECT_ALL_REPORT_COURSE);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				reportCourseVO = new ReportCourseVO();
				courseVO = new CourseVO();
				
				CourseDAO_JDBC courseDAO = new CourseDAO_JDBC();
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
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
		
		ReportCourseDAO_JDBC dao = new ReportCourseDAO_JDBC();
		
		
		ReportCourseVO reportCourseVO = new ReportCourseVO();
		
		// 新增	
//		reportCourseVO.setReportCourseID(200006);
//		reportCourseVO.setReportMemberID(100005);
//		reportCourseVO.setReportContent("太長了");
//		dao.insert(reportCourseVO);
		
		//修改
//		reportCourseVO.setReportId(1001);
//		reportCourseVO.setStatus((byte) 1);
//		dao.update(reportCourseVO);
		
		//查詢單一
		//"SELECT reportId,reportCourseID,reportMemberID,reportContent,reportTime,status FROM ReportCourse WHERE reportId=?";
		ReportCourseVO reportCourseVO2 = dao.findByReportId(1001);
		System.out.println(reportCourseVO2.getReportId());
		System.out.println(reportCourseVO2.getCourseVO().getCourseID());
		System.out.println(reportCourseVO2.getReportMemberID());
		System.out.println(reportCourseVO2.getReportContent());
		System.out.println(reportCourseVO2.getReportTime());
		System.out.println(reportCourseVO2.getStatus());
		System.out.println("---------------------------");
		
		//查詢全部
		List<ReportCourseVO> list = dao.getAll();
		for(ReportCourseVO reportCourseVO1 : list) {
			System.out.print(reportCourseVO1.getReportId() + "  ");
			System.out.print(reportCourseVO1.getCourseVO().getCourseID() + "  ");
			System.out.print(reportCourseVO1.getReportMemberID() + "  ");
			System.out.print(reportCourseVO1.getReportContent() + "  ");
			System.out.print(reportCourseVO1.getReportTime() + "  ");
			System.out.print(reportCourseVO1.getStatus() + "\n");
		}
		
	}

}
