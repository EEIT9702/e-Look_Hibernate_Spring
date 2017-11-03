package com.e_Look.message.model;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import com.e_Look.member.model.MemberDAO;



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
	private static final String INSERT_MESSAGE = "insert into Message ( mContent,mTime,memberID,courseID,status) values ( ?, ?, ?, ?,?)";
	private static final String INSERT_MESSAGE_RESPONSE = "insert into Message ( mContent,mTime,messageID_response,memberID,courseID,status) values (?, ?, ?, ?, ?,?)";
	private static final String UPDATE_MESSAGE = "update Message set mContent=?, mTime=? where messageID= ?";
	private static final String UPDATE_MESSAGE_RESPONSE = "update Message set mContent=?, mTime=? where  messageID=?";
	private static final String UPDATE_STATUS = "update Message set status=? where messageID= ?";
	// 刪除用不到
	private static final String DELETE_MESSAGE = "delete from Message where messageID= ?";
	private static final String SELECT_ONE_MESSAGE = "select messageID,mContent,mTime,messageID_response,memberID,courseID,status from Message where messageID= ?";
	private static final String SELECT_MESSAGE_BY_COURSEID = "select messageID,mContent,mTime,messageID_response,memberID,courseID,status from Message where courseID= ?";
	private static final String SELECT_RESPONSE = "select messageID,mContent,mTime,messageID_response,memberID,courseID,status from Message where messageID_response= ?";
	private static final String SELECT_ALL_MESSAGE = "select messageID,mContent,mTime,messageID_response,memberID,courseID,status from Message";	
		
	@Override
	public Integer insert(MessageVO messageVO) {
		Connection con = null;
		int id = 0;
		PreparedStatement pstmt = null;
		ResultSet generatedKeys = null;
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(INSERT_MESSAGE,
					Statement.RETURN_GENERATED_KEYS);
//"insert into Message ( mContent,mTime,memberID,courseID,status) values ( ?, ?, ?, ?,?)";
			pstmt.setString(1, messageVO.getmContent());
			Timestamp ts = new Timestamp(System.currentTimeMillis());
			pstmt.setTimestamp(2, ts);
			pstmt.setInt(3, messageVO.getMemberVO().getMemberID());
			pstmt.setInt(4, messageVO.getCourseID());
			pstmt.setByte(5, messageVO.getStatus());
			pstmt.executeUpdate();
			
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
		return id;
	}
	
	@Override
	public void insert_re(MessageVO messageVO) {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = ds.getConnection();
			
			pstmt = con.prepareStatement(INSERT_MESSAGE_RESPONSE);
			// "insert into Message (mContent,mTime,messageID_response,memberID,courseID,status)values (?, ?, ?, ?, ?, ?)"
						pstmt.setString(1, messageVO.getmContent());
						Timestamp ts = new Timestamp(System.currentTimeMillis());
						pstmt.setTimestamp(2, ts);
						pstmt.setInt(3, messageVO.getMessageID_response());
						pstmt.setInt(4, messageVO.getMemberVO().getMemberID());
						pstmt.setInt(5, messageVO.getCourseID());
						pstmt.setByte(6, messageVO.getStatus());
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
	public void update(MessageVO messageVO, String update) {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = ds.getConnection();
			if (update.equalsIgnoreCase("message")) {
				pstmt = con.prepareStatement(UPDATE_MESSAGE);
//"update Message set mContent=?, mTime=? where messageID= ?";
				pstmt.setString(1, messageVO.getmContent());
				Timestamp ts = new Timestamp(System.currentTimeMillis());
				pstmt.setTimestamp(2, ts);
				pstmt.setInt(3, messageVO.getMessageID());	
				
				pstmt.executeUpdate();
			} else if (update.equalsIgnoreCase("messageresponse")) {
				pstmt = con.prepareStatement(UPDATE_MESSAGE_RESPONSE);
//"update Message set mContent=?, mTime=? where messageID= ?";
				pstmt.setString(1, messageVO.getmContent());
				Timestamp ts = new Timestamp(System.currentTimeMillis());
				pstmt.setTimestamp(2, ts);
				pstmt.setInt(3, messageVO.getMessageID());
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
	public void updateStatus(Integer messageID,Byte status) {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = ds.getConnection();
			
				pstmt = con.prepareStatement(UPDATE_STATUS);
//"update Message set status=? where messageID= ?"
				pstmt.setByte(1, status);
				pstmt.setInt(2, messageID);
				
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
	public void delete(Integer messageID) {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(DELETE_MESSAGE);
// "delete from Message where messageID= ?";
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
		MemberDAO dao = new MemberDAO();
		MessageVO messageVO = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(SELECT_ONE_MESSAGE);
//"select messageID,mContent,mTime,messageID_response,memberID,courseID,status from Message where messageID= ?"
			pstmt.setInt(1, messageID);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				messageVO = new MessageVO();		
				messageVO.setMessageID(rs.getInt(1));
				messageVO.setmContent(rs.getString(2));
				messageVO.setmTime(rs.getTimestamp(3));
				messageVO.setMessageID_response(rs.getInt(4));
				messageVO.setMemberVO(dao.findByPrimaryKey(rs.getInt(5)));
				messageVO.setCourseID(rs.getInt(6));
				messageVO.setStatus(rs.getByte(7));
				
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
	public List<MessageVO> findMessageByCourseID(Integer courseID) {
		List<MessageVO> list = new ArrayList<MessageVO>();
		MessageVO messageVO = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		MemberDAO dao = new MemberDAO();
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(SELECT_MESSAGE_BY_COURSEID);
//"select messageID,mContent,mTime,messageID_response,memberID,courseID,status from Message where courseID= ?";
			pstmt.setInt(1, courseID);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				messageVO = new MessageVO();		
				messageVO.setMessageID(rs.getInt(1));
				messageVO.setmContent(rs.getString(2));
				messageVO.setmTime(rs.getTimestamp(3));
				messageVO.setMessageID_response(rs.getInt(4));
				messageVO.setMemberVO(dao.findByPrimaryKey(rs.getInt(5)));
				messageVO.setCourseID(rs.getInt(6));
				messageVO.setStatus(rs.getByte(7));
				
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
	public List<MessageVO> findAllResponse(Integer messageID_response) {
		MemberDAO dao = new MemberDAO();
		List<MessageVO> list = new ArrayList<MessageVO>();
		MessageVO messageVO = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(SELECT_RESPONSE);
//"select messageID,mContent,mTime,messageID_response,memberID,courseID,status from Message where courseID= ?";
			pstmt.setInt(1, messageID_response);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				messageVO = new MessageVO();		
				messageVO.setMessageID(rs.getInt(1));
				messageVO.setmContent(rs.getString(2));
				messageVO.setmTime(rs.getTimestamp(3));
				messageVO.setMessageID_response(rs.getInt(4));
				messageVO.setMemberVO(dao.findByPrimaryKey(rs.getInt(5)));
				messageVO.setCourseID(rs.getInt(6));
				messageVO.setStatus(rs.getByte(7));
				
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
		MemberDAO dao = new MemberDAO();
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(SELECT_ALL_MESSAGE);
//"select messageID,mContent,mTime,messageID_response,memberID,courseID,status from Message";	
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				MessageVO messageVO = new MessageVO();		
				messageVO.setMessageID(rs.getInt(1));
				messageVO.setmContent(rs.getString(2));
				messageVO.setmTime(rs.getTimestamp(3));
				messageVO.setMessageID_response(rs.getInt(4));
				messageVO.setMemberVO(dao.findByPrimaryKey(rs.getInt(5)));
				messageVO.setCourseID(rs.getInt(6));
				messageVO.setStatus(rs.getByte(7));
				
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
