package com.e_Look.message.model;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.LinkedList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;



public class MessageDAO implements MessageDAO_interface {
	private static DataSource ds = null;
	static {
		try {
			Context ctx = new InitialContext();
			ds = (DataSource) ctx.lookup("java:comp/env/jdbc/eLookDB");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}
	private static final String INSERT_MESSAGE = "insert into Message ( mContent,mTime,memberID,courseID,bought,status) values ( ?, ?, ?, ?, ?,?)";
	private static final String INSERT_MESSAGE_RESPONSE = "insert into Message ( mContent,mTime,messageID_response,memberID,courseID,bought,status) values (?, ?, ?, ?, ?, ?,?)";
	private static final String UPDATE_MESSAGE = "update Message set mContent=?, mTime=? where messageID= ?";
//	private static final String UPDATE_MESSAGE_RESPONSE = "update Message set mContent=?, mTime=? where messageID= ?";
	private static final String UPDATE_STATUS = "update Message set status=? where messageID= ?";
	private static final String DELETE_MESSAGE = "delete from Message where messageID= ?";
	private static final String SELECT_ONE_MESSAGE_M = "select messageID,mContent,mTime,messageID_response,memberID,courseID,bought,status from Message where messageID= ?";
	private static final String SELECT_ONE_MESSAGE = "select messageID,mContent,mTime,messageID_response,memberID,courseID,bought,status from Message where courseID= ?";
	private static final String SELECT_ALL_MESSAGE = "select messageID,mContent,mTime,messageID_response,memberID,courseID,bought,status from Message";	
		
	@Override
	public void insert(MessageVO messageVO) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet generatedKeys = null;
		try {
			con = ds.getConnection();
			
			pstmt = con.prepareStatement(INSERT_MESSAGE,
					Statement.RETURN_GENERATED_KEYS);
			pstmt.setString(1, messageVO.getmContent());
			Timestamp ts = new Timestamp(System.currentTimeMillis());
			pstmt.setTimestamp(2, ts);
			pstmt.setInt(3, messageVO.getMemberID());
			pstmt.setInt(4, messageVO.getCourseID());
			pstmt.setLong(5, messageVO.getBought());
			pstmt.setByte(6, messageVO.getStatus());
			
			pstmt.executeUpdate();
			
			int id = 0;
			generatedKeys = pstmt.getGeneratedKeys();
			if (generatedKeys.next()) {
				id = generatedKeys.getInt(1);
			} else {
				throw new SQLException(
						"Creating user failed, no generated key obtained.");
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
	}
	
	@Override
	public void insert_re(MessageVO messageVO) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet generatedKeys = null;
		try {
			con = ds.getConnection();
			
			pstmt = con.prepareStatement(INSERT_MESSAGE_RESPONSE,
					Statement.RETURN_GENERATED_KEYS);
			pstmt.setString(1, messageVO.getmContent());
			Timestamp ts = new Timestamp(System.currentTimeMillis());
			pstmt.setTimestamp(2, ts);
			pstmt.setInt(3, messageVO.getMessageID_response());
			pstmt.setInt(4, messageVO.getMemberID());
			pstmt.setInt(5, messageVO.getCourseID());
			pstmt.setLong(6, messageVO.getBought());
			pstmt.setByte(7, messageVO.getStatus());
			
			pstmt.executeUpdate();
			
			int id = 0;
			
			generatedKeys = pstmt.getGeneratedKeys();
			
			if (generatedKeys.next()) {
				id = generatedKeys.getInt(1);
			} else {
				throw new SQLException(
						"Creating user failed, no generated key obtained.");
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
	}

	@Override
	public void update(MessageVO messageVO, String update) {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = ds.getConnection();
			if (update.equalsIgnoreCase("message")) {
				pstmt = con.prepareStatement(UPDATE_MESSAGE);
				pstmt.setString(1, messageVO.getmContent());
				Timestamp ts = new Timestamp(System.currentTimeMillis());
				pstmt.setTimestamp(2, ts);
				pstmt.setInt(3, messageVO.getMessageID());	
				
				pstmt.executeUpdate();
//			} else if (update.equalsIgnoreCase("messageresponse")) {
//				pstmt = con.prepareStatement(UPDATE_MESSAGE_RESPONSE);
//				pstmt.setString(1, messageVO.getmContent());
//				Timestamp ts = new Timestamp(System.currentTimeMillis());
//				pstmt.setTimestamp(2, ts);
//				pstmt.setInt(3, messageVO.getMessageID_response());
//				
//				pstmt.executeUpdate();
			} else if (update.equalsIgnoreCase("status")) {
				pstmt = con.prepareStatement(UPDATE_STATUS);
				pstmt.setByte(1, messageVO.getStatus());
				pstmt.setInt(2, messageVO.getMessageID());
				
				pstmt.executeUpdate();
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
		
	}

	@Override
	public void delete(Integer messageID) {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(DELETE_MESSAGE);
			pstmt.setInt(1, messageID);
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
	public MessageVO findByPrimaryKey(Integer messageID) {
		MessageVO messageVO = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(SELECT_ONE_MESSAGE_M);
			pstmt.setInt(1, messageID);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				messageVO = new MessageVO();		
				messageVO.setMessageID(rs.getInt(1));
				messageVO.setmContent(rs.getString(2));
				messageVO.setmTime(rs.getTimestamp(3));
				messageVO.setMessageID_response(rs.getInt(4));
				messageVO.setMemberID(rs.getInt(5));
				messageVO.setCourseID(rs.getInt(6));
				messageVO.setBought(rs.getLong(7));
				messageVO.setStatus(rs.getByte(8));
				
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
		return messageVO;
		
	}
	@Override
	public List<MessageVO> findByPrimaryKeyM(Integer courseID) {
		List<MessageVO> list = new LinkedList<MessageVO>();
		MessageVO messageVO = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(SELECT_ONE_MESSAGE);
			pstmt.setInt(1, courseID);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				messageVO = new MessageVO();		
				messageVO.setMessageID(rs.getInt(1));
				messageVO.setmContent(rs.getString(2));
				messageVO.setmTime(rs.getTimestamp(3));
				messageVO.setMessageID_response(rs.getInt(4));
				messageVO.setMemberID(rs.getInt(5));
				messageVO.setCourseID(rs.getInt(6));
				messageVO.setBought(rs.getLong(7));
				messageVO.setStatus(rs.getByte(8));
				
				list.add(messageVO);
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
	public List<MessageVO> getAll() {
		List<MessageVO> list = new LinkedList<MessageVO>();

		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(SELECT_ALL_MESSAGE);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				MessageVO messageVO = new MessageVO();		
				messageVO.setMessageID(rs.getInt(1));
				messageVO.setmContent(rs.getString(2));
				messageVO.setmTime(rs.getTimestamp(3));
				messageVO.setMessageID_response(rs.getInt(4));
				messageVO.setMemberID(rs.getInt(5));
				messageVO.setCourseID(rs.getInt(6));
				messageVO.setBought(rs.getLong(7));
				messageVO.setStatus(rs.getByte(8));
				
				list.add(messageVO);
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
