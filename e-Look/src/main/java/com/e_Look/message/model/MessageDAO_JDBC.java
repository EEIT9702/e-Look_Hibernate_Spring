package com.e_Look.message.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.LinkedList;
import java.util.List;

import net.minidev.json.JSONValue;

public class MessageDAO_JDBC implements MessageDAO_interface {
	String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
	String url = "jdbc:sqlserver://localhost:1433;DatabaseName=elook";
	String userid = "sa";
	//第一組密碼
	String passwd = "P@ssw0rd";
	//第二組密碼
	//String passwd = "123456";
	private static final String INSERT_MESSAGE = "insert into Message ( mContent,mTime,memberID,courseID,bought,status) values ( ?, ?, ?, ?, ?,?)";
	private static final String INSERT_MESSAGE_RESPONSE = "insert into Message ( mContent,mTime,messageID_response,memberID,courseID,bought,status) values (?, ?, ?, ?, ?, ?,?)";
	private static final String UPDATE_MESSAGE = "update Message set mContent=?, mTime=? where messageID= ?";
	private static final String UPDATE_MESSAGE_RESPONSE = "update Message set mContent=?, mTime=? where messageID_response= ?";
	private static final String UPDATE_STATUS = "update Message set status=? where messageID= ?";
	private static final String DELETE_MESSAGE = "delete from Message where messageID= ?";
	private static final String SELECT_ONE_MESSAGE = "select messageID,mContent,mTime,messageID_response,memberID,courseID,bought,status from Message where courseID= ?";
	private static final String SELECT_ALL_MESSAGE = "select messageID,mContent,mTime,messageID_response,memberID,courseID,bought,status from Message";
	private static final String SELECT_ONE_MESSAGE_M = "select messageID,mContent,mTime,messageID_response,memberID,courseID,bought,status from Message where messageID= ?";	
	
	@Override
	public void insert(MessageVO messageVO) {
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			Class.forName(driver);			
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(INSERT_MESSAGE);
			pstmt.setString(1, messageVO.getmContent());
			pstmt.setTimestamp(2, messageVO.getmTime());
			pstmt.setInt(3, messageVO.getMemberID());
			pstmt.setInt(4, messageVO.getCourseID());
			pstmt.setLong(5, messageVO.getBought());
			pstmt.setByte(6, messageVO.getStatus());
			pstmt.executeUpdate();
		} catch (ClassNotFoundException e) {
					throw new RuntimeException("Couldn't load database driver. "+ e.getMessage());
				} catch (SQLException e) {
					throw new RuntimeException("A database error occured. "
							+ e.getMessage());
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
		
		try {
			Class.forName(driver);			
			con = DriverManager.getConnection(url, userid, passwd);
			
			pstmt = con.prepareStatement(INSERT_MESSAGE_RESPONSE
					);
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
			
			
			
		} catch (ClassNotFoundException e) {
			throw new RuntimeException("Couldn't load database driver. "+ e.getMessage());
		} catch (SQLException e) {
			throw new RuntimeException("A database error occured. "
					+ e.getMessage());
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
			}}
		}
	
	@Override
	public void update(MessageVO messageVO, String update) {
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			Class.forName(driver);			
			con = DriverManager.getConnection(url, userid, passwd);
			if (update.equalsIgnoreCase("message")) {
				pstmt = con.prepareStatement(UPDATE_MESSAGE);
				pstmt.setString(1, messageVO.getmContent());
				pstmt.setTimestamp(2, messageVO.getmTime());
				pstmt.setInt(3, messageVO.getMessageID());			
				pstmt.executeUpdate();
			} else if (update.equalsIgnoreCase("messageresponse")) {
				pstmt = con.prepareStatement(UPDATE_MESSAGE_RESPONSE);
				pstmt.setString(1, messageVO.getmContent());
				pstmt.setTimestamp(2, messageVO.getmTime());
				pstmt.setInt(3, messageVO.getMessageID_response());		
				pstmt.executeUpdate();
			} else if (update.equalsIgnoreCase("status")) {
				pstmt = con.prepareStatement(UPDATE_STATUS);
				pstmt.setByte(1, messageVO.getStatus());
				pstmt.setInt(2, messageVO.getMessageID());
				pstmt.executeUpdate();
			} 
		} catch (ClassNotFoundException e) {
					throw new RuntimeException("Couldn't load database driver. "+ e.getMessage());
				} catch (SQLException e) {
					throw new RuntimeException("A database error occured. "
							+ e.getMessage());
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
			Class.forName(driver);			
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(DELETE_MESSAGE);
			pstmt.setInt(1, messageID);
			pstmt.executeUpdate();
		} catch (ClassNotFoundException e) {
					throw new RuntimeException("Couldn't load database driver. "+ e.getMessage());
				} catch (SQLException e) {
					throw new RuntimeException("A database error occured. "
							+ e.getMessage());
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
			Class.forName(driver);			
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(SELECT_ONE_MESSAGE);
			pstmt.setInt(1, messageID);
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
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
		} catch (ClassNotFoundException e) {
					throw new RuntimeException("Couldn't load database driver. "+ e.getMessage());
				} catch (SQLException e) {
					throw new RuntimeException("A database error occured. "
							+ e.getMessage());
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
	public List<MessageVO> getAll() {
		List<MessageVO> list = new LinkedList<MessageVO>();

		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			Class.forName(driver);			
			con = DriverManager.getConnection(url, userid, passwd);
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
		} catch (ClassNotFoundException e) {
					throw new RuntimeException("Couldn't load database driver. "+ e.getMessage());
				} catch (SQLException e) {
					throw new RuntimeException("A database error occured. "
							+ e.getMessage());
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
		MessageDAO_JDBC dao = new MessageDAO_JDBC();
//		//新增
//		MessageVO messageVO1= new MessageVO();
//		
//		messageVO1.setmContent("goodnews");
//		messageVO1.setmTime(new Timestamp(System.currentTimeMillis()));
//		messageVO1.setMemberID(100001);
//		messageVO1.setCourseID(200001);
//		messageVO1.setBought((long) 123);
//		messageVO1.setStatus((byte) 0);
//				
//		dao.insert(messageVO1);
//		
		//修改資料
//		MessageVO messageVO2= new MessageVO();
//		messageVO2.setmContent("good-good");
//		messageVO2.setmTime(new Date(System.currentTimeMillis()));
//		messageVO2.setMessageID(1006);
//		dao.update(messageVO2, "message");
		//修改資料response
//		MessageVO messageVO2= new MessageVO();
//		messageVO2.setmContent("good-good12");
//		messageVO2.setmTime(new Date(System.currentTimeMillis()));
//		messageVO2.setMessageID_response(1005);
//		dao.update(messageVO2, "messageresponse");
		//修改狀態
		//MessageVO messageVO2= new MessageVO();
//		messageVO2.setStatus((byte) 1);
//		messageVO2.setMessageID(1007);
//		dao.update(messageVO2, "status");
	
//		MessageVO messageVO4=dao.findByPrimaryKey(200002);
//		String json= JSONValue.toJSONString(messageVO4);
//		System.out.println(json);
		//刪除
//		dao.delete(1007);
		//查詢單一
//		MessageVO messageVO3=dao.findByPrimaryKey(200001);
//		System.out.println(messageVO3.getMessageID());
//		System.out.println(messageVO3.getmContent());
//		System.out.println(messageVO3.getmTime());
//		System.out.println(messageVO3.getMessageID_response());
//		System.out.println(messageVO3.getMemberID());
//		System.out.println(messageVO3.getCourseID());
//		System.out.println(messageVO3.getBought());
//		System.out.println(messageVO3.getStatus());

		//查詢全部會員
//		List<MessageVO> list=dao.getAll();
//		for(MessageVO messageVO :list){
//			System.out.println(messageVO.getMessageID()+"  ");
//			System.out.println(messageVO.getmContent()+"  ");
//			System.out.println(messageVO.getmTime()+"  ");
//			System.out.println(messageVO.getMessageID_response()+"  ");
//			System.out.println(messageVO.getMemberID()+"  ");
//			System.out.println(messageVO.getCourseID()+"  ");
//			System.out.println(messageVO.getBought()+"  ");
//			System.out.println(messageVO.getStatus()+"  ");
//			
//		}
//	


	}

	@Override
	public List<MessageVO> findByPrimaryKeyM(Integer courseID) {
		List<MessageVO> list = new LinkedList<MessageVO>();
		MessageVO messageVO = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			Class.forName(driver);			
			con = DriverManager.getConnection(url, userid, passwd);
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
				
				list.add(messageVO);}
		} catch (ClassNotFoundException e) {
					throw new RuntimeException("Couldn't load database driver. "+ e.getMessage());
				} catch (SQLException e) {
					throw new RuntimeException("A database error occured. "
							+ e.getMessage());
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
