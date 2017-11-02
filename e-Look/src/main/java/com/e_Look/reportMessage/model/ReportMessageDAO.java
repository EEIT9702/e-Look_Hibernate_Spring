package com.e_Look.reportMessage.model;

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

import com.e_Look.message.model.MessageDAO;
import com.e_Look.message.model.MessageVO;

public class ReportMessageDAO implements ReportMessageDAO_interface {
	private static DataSource ds = null;
	static {
		try {
			Context ctx = new InitialContext();
			ds = (DataSource) ctx.lookup("java:comp/env/jdbc/eLookDB");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}
	
	private static final String INSERT_REPORT_MESSAGE =
			"INSERT INTO ReportMessage (reportMessageID, reportMemberID, reportContent, reportTime, status) VALUES (?,?,?,getDate(),0)";
//	private static final String UPDATE_ReportMessage =
//			"UPDATE ReportMessage SET reportContent=? WHERE reportId=?";
	private static final String UPDATE_STATUS =
		    "UPDATE ReportMessage SET status=? WHERE reportId=?";
	//DELETE_REPORTMESSAGE寫著,但應該用不到
	private static final String DELETE_REPORT_MESSAGE =
		    "DELETE FROM ReportMessage WHERE reportId =?";
	private static final String SELECT_ONE_REPORT_COURSE =
			"SELECT reportId, reportMessageID, reportMemberID, reportContent, reportTime, status FROM ReportMessage WHERE reportId=?";
	private static final String SELECT_NOT_HANDLE_REPORT_MESSAGE =
			"SELECT reportId, reportMessageID, reportMemberID, reportContent, reportTime, status FROM ReportMessage WHERE status=0";
	private static final String SELECT_ALL_REPORT_MESSAGE =
			"SELECT reportId, reportMessageID, reportMemberID, reportContent, reportTime, status FROM ReportMessage";
	
	private static final String GET_JSON = "SELECT m.messageID, m.mContent, rm.reportID, rm.reportMessageID,"
			+ " rm.reportMemberID, rm.reportContent, rm.reportTime, rm.status"
			+ " FROM Message m INNER JOIN ReportMessage rm ON m.messageID = "
			+ "rm.reportMessageID WHERE rm.status=?";
	
	/*
	private static final String SELECT_ONE_REPORT_MESSAGE =
			"SELECT m.messageID, m.mContent, rm.reportID, rm.reportMessageID, rm.reportMemberID, rm.reportContent, rm.reportTime, rm.status FROM Message m INNER JOIN ReportMessage rm ON m.messageID = rm.reportMessageID WHERE rm.reportId=?";
	private static final String SELECT_NOT_HANDLE_REPORT_MESSAGE =
			"SELECT m.messageID, m.mContent, rm.reportID, rm.reportMessageID, rm.reportMemberID, rm.reportContent, rm.reportTime, rm.status FROM Message m INNER JOIN ReportMessage rm ON m.messageID = rm.reportMessageID WHERE rm.status=0";
	private static final String SELECT_ALL_REPORT_MESSAGE =
			"SELECT m.messageID, m.mContent, rm.reportID, rm.reportMessageID, rm.reportMemberID, rm.reportContent, rm.reportTime, rm.status FROM Message m INNER JOIN ReportMessage rm ON m.messageID = rm.reportMessageID ";
	查詢檢舉join留言內容的指令
	SELECT m.messageID, m.mContent, rm.reportID, rm.reportMessageID, 
	rm.reportMemberID, rm.reportContent, rm.reportTime, rm.status
	FROM Message m INNER JOIN ReportMessage rm ON m.messageID = rm.reportMessageID
	*/
	
	@Override
	public void insert(ReportMessageVO reportMessageVO) {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			//"INSERT INTO ReportMessage (reportMessageID, reportMemberID, reportContent, reportTime, status) VALUES (?,?,?,getDate(),0)";
			con = ds.getConnection();
			pstmt = con.prepareStatement(INSERT_REPORT_MESSAGE);
//			pstmt.setInt(1, reportMessageVO.getReportMessageID());
			pstmt.setInt(1, reportMessageVO.getMessageVO().getMessageID());
			pstmt.setInt(2, reportMessageVO.getReportMemberID());
			pstmt.setString(3, reportMessageVO.getReportContent());
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
	public void update(ReportMessageVO reportMessageVO) {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			//"UPDATE ReportMessage SET status=? WHERE reportId=?";
			con = ds.getConnection();
			pstmt = con.prepareStatement(UPDATE_STATUS);
			pstmt.setByte(1, reportMessageVO.getStatus());
			pstmt.setInt(2, reportMessageVO.getReportId());
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
			pstmt=con.prepareStatement(DELETE_REPORT_MESSAGE);
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
	public ReportMessageVO findByReportId(Integer reportId) {
		ReportMessageVO reportMessageVO = null;
		MessageVO messageVO = null;
		
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			//"SELECT reportId, reportMessageID, reportMemberID, reportContent, reportTime,
			//status FROM ReportMessage WHERE reportId=?";
			con = ds.getConnection();
			pstmt = con.prepareStatement(SELECT_ONE_REPORT_COURSE);

			pstmt.setInt(1, reportId);

			ResultSet rs = pstmt.executeQuery();

			if (rs.next()) {
				// reportMessageVO 也稱為 Domain objects
				reportMessageVO = new ReportMessageVO();
				messageVO = new MessageVO();
				
				MessageDAO messageDAO = new MessageDAO();
				Integer messageID = rs.getInt("reportMessageID");
				messageVO = (messageDAO.findByPrimaryKey(messageID));
				
				reportMessageVO.setMessageVO(messageVO);
				
				reportMessageVO.setReportId(rs.getInt("reportId"));
				reportMessageVO.setReportMemberID(rs.getInt("reportMemberID"));
				reportMessageVO.setReportContent(rs.getString("reportContent"));
				reportMessageVO.setReportTime(rs.getDate("reportTime"));
				reportMessageVO.setStatus(rs.getByte("status"));
			}

			// Handle any SQL errors
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. "
					+ se.getMessage());
			// Clean up JDBC resources
		} finally {
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
		return reportMessageVO;
	}

	@Override
	public String getJSON(Integer status) {
		//List<ReportMessageVO> list = new ArrayList<ReportMessageVO>();
		String jsonString;
		//ReportMessageVO reportMessageVO = null;
		//MessageVO messageVO = null;
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			//"SELECT m.messageID, m.mContent, rm.reportID, rm.reportMessageID,
			//rm.reportMemberID, rm.reportContent, rm.reportTime, rm.status
			//FROM Message m INNER JOIN ReportMessage rm ON m.messageID = 
			//rm.reportMessageID WHERE rm.status=?";
			con = ds.getConnection();
			pstmt = con.prepareStatement(GET_JSON);
			pstmt.setInt(1, status);
			rs = pstmt.executeQuery();
			
			 List  l1 = new LinkedList();
			 while (rs.next()) {
				 Map m1 = new HashMap();  
				 m1.put("messageID", rs.getString(1));   
				 m1.put("mContent", rs.getString(2));  
				 m1.put("reportID", rs.getString(3));   
				 m1.put("reportMessageID", rs.getString(4)); 
				 m1.put("reportMemberID", rs.getString(5)); 
				 m1.put("reportContent", rs.getString(6));
				 m1.put("reportTime", rs.getString(7));
				 m1.put("status", rs.getString(8));
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
	public List<ReportMessageVO> getNotHandle() {
		List<ReportMessageVO> list = new ArrayList<ReportMessageVO>();
		ReportMessageVO reportMessageVO = null;
		MessageVO messageVO = null;
		
		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			//"SELECT reportId, reportMessageID, reportMemberID, reportContent, reportTime,
			//status FROM ReportMessage WHERE status=0";
			con = ds.getConnection();
			pstmt = con.prepareStatement(SELECT_NOT_HANDLE_REPORT_MESSAGE);
			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				// reportMessageVO 也稱為 Domain objects
				reportMessageVO = new ReportMessageVO();
				messageVO = new MessageVO();
				
				MessageDAO messageDAO = new MessageDAO();
				Integer messageID = rs.getInt("reportMessageID");
				messageVO = (messageDAO.findByPrimaryKey(messageID));
				
				reportMessageVO.setMessageVO(messageVO);
				
				reportMessageVO.setReportId(rs.getInt("reportId"));
				reportMessageVO.setReportMemberID(rs.getInt("reportMemberID"));
				reportMessageVO.setReportContent(rs.getString("reportContent"));
				reportMessageVO.setReportTime(rs.getDate("reportTime"));
				reportMessageVO.setStatus(rs.getByte("status"));
				list.add(reportMessageVO); // Store the row in the list
			}

			// Handle any SQL errors
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. "
					+ se.getMessage());
			// Clean up JDBC resources
		} finally {
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
	public List<ReportMessageVO> getAll() {
		List<ReportMessageVO> list = new ArrayList<ReportMessageVO>();
		ReportMessageVO reportMessageVO = null;
		MessageVO messageVO = null;

		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			//"SELECT reportId, reportMessageID, reportMemberID, reportContent, reportTime,
			//status FROM ReportMessage";
			con = ds.getConnection();
			pstmt = con.prepareStatement(SELECT_ALL_REPORT_MESSAGE);
			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				// reportMessageVO 也稱為 Domain objects
				reportMessageVO = new ReportMessageVO();
				messageVO = new MessageVO();
				
				MessageDAO messageDAO = new MessageDAO();
				Integer messageID = rs.getInt("reportMessageID");
				messageVO = (messageDAO.findByPrimaryKey(messageID));
				
				reportMessageVO.setMessageVO(messageVO);
				
				reportMessageVO.setReportId(rs.getInt("reportId"));
				reportMessageVO.setReportMemberID(rs.getInt("reportMemberID"));
				reportMessageVO.setReportContent(rs.getString("reportContent"));
				reportMessageVO.setReportTime(rs.getDate("reportTime"));
				reportMessageVO.setStatus(rs.getByte("status"));
				list.add(reportMessageVO); // Store the row in the list
			}

			// Handle any SQL errors
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. "
					+ se.getMessage());
			// Clean up JDBC resources
		} finally {
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
