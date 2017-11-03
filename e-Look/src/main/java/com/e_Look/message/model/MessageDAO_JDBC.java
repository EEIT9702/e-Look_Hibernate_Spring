package com.e_Look.message.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.e_Look.member.model.MemberDAO;

public class MessageDAO_JDBC implements MessageDAO_interface {
	String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
	String url = "jdbc:sqlserver://localhost:1433;DatabaseName=elook";
	String userid = "sa";
	// 第一組密碼
	String passwd = "P@ssw0rd";
	// 第二組密碼
	// String passwd = "123456";
	private static final String INSERT_MESSAGE = "insert into Message ( mContent,mTime,memberID,courseID,status) values ( ?, ?, ?, ?,?)";
	private static final String INSERT_MESSAGE_RESPONSE = "insert into Message ( mContent,mTime,messageID_response,memberID,courseID,status) values (?, ?, ?, ?, ?,?)";
	private static final String UPDATE_MESSAGE = "update Message set mContent=?, mTime=? where messageID= ?";
	private static final String UPDATE_MESSAGE_RESPONSE = "update Message set mContent=?, mTime=? where  messageID=?";
	private static final String UPDATE_STATUS = "update Message set status=? where messageID= ?";
	// 刪除用不到
	private static final String DELETE_MESSAGE = "delete from Message where messageID= ?";
	private static final String SELECT_MESSAGE_BY_COURSEID = "select messageID,mContent,mTime,messageID_response,memberID,courseID,status from Message where courseID= ?";
	private static final String SELECT_ONE_MESSAGE = "select messageID,mContent,mTime,messageID_response,memberID,courseID,status from Message where messageID= ?";
	private static final String SELECT_RESPONSE = "select messageID,mContent,mTime,messageID_response,memberID,courseID,status from Message where messageID_response= ?";
	private static final String SELECT_ALL_MESSAGE = "select messageID,mContent,mTime,messageID_response,memberID,courseID,status from Message";	
	

	@Override
	public Integer insert(MessageVO messageVO) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet generatedKeys = null;
		int id = 0;
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(INSERT_MESSAGE,Statement.RETURN_GENERATED_KEYS);
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
		return id;
	}

	@Override
	public void insert_re(MessageVO messageVO) {
		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);

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
		} catch (ClassNotFoundException e) {
			throw new RuntimeException("Couldn't load database driver. " + e.getMessage());
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
			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			if (update.equalsIgnoreCase("message")) {
				pstmt = con.prepareStatement(UPDATE_MESSAGE);
				// "update Message set mContent=?, mTime=? where messageID= ?"
				pstmt.setString(1, messageVO.getmContent());
				Timestamp ts = new Timestamp(System.currentTimeMillis());
				pstmt.setTimestamp(2, ts);
				pstmt.setInt(3, messageVO.getMessageID());
				pstmt.executeUpdate();
			} else if (update.equalsIgnoreCase("messageresponse")) {
				pstmt = con.prepareStatement(UPDATE_MESSAGE_RESPONSE);
				// "update Message set mContent=?, mTime=? where messageID=?"
				pstmt.setString(1, messageVO.getmContent());
				Timestamp ts = new Timestamp(System.currentTimeMillis());
				pstmt.setTimestamp(2, ts);
				pstmt.setInt(3, messageVO.getMessageID());
				pstmt.executeUpdate();
			} else if (update.equalsIgnoreCase("status")) {
				pstmt = con.prepareStatement(UPDATE_STATUS);
				// "update Message set status=? where messageID= ?"
				pstmt.setByte(1, messageVO.getStatus());
				pstmt.setInt(2, messageVO.getMessageID());
				pstmt.executeUpdate();
			}
		} catch (ClassNotFoundException e) {
			throw new RuntimeException("Couldn't load database driver. " + e.getMessage());
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
			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(DELETE_MESSAGE);
			pstmt.setInt(1, messageID);
			pstmt.executeUpdate();
		} catch (ClassNotFoundException e) {
			throw new RuntimeException("Couldn't load database driver. " + e.getMessage());
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
			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(SELECT_ONE_MESSAGE);
//select messageID,mContent,mTime,messageID_response,memberID,courseID,status from Message where messageID= ?""
			pstmt.setInt(1, messageID);
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				messageVO = new MessageVO();
				messageVO.setMessageID(rs.getInt(1));
				messageVO.setmContent(rs.getString(2));
				messageVO.setmTime(rs.getTimestamp(3));
				messageVO.setMessageID_response(rs.getInt(4));
				messageVO.setMemberVO(dao.findByPrimaryKey(rs.getInt(5)));
				messageVO.setCourseID(rs.getInt(6));
				messageVO.setStatus(rs.getByte(7));

			}
		} catch (ClassNotFoundException e) {
			throw new RuntimeException("Couldn't load database driver. " + e.getMessage());
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
	public List<MessageVO> findAllResponse(Integer messageID_response) {
		List<MessageVO> list = new ArrayList<MessageVO>();
		MessageVO messageVO = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		MemberDAO dao = new MemberDAO();

		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(SELECT_RESPONSE);
// "select messageID,mContent,mTime,messageID_response,memberID,courseID,status from Message where messageID_response= ?";;
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
		} catch (ClassNotFoundException e) {
			throw new RuntimeException("Couldn't load database driver. " + e.getMessage());
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
		List<MessageVO> list = new ArrayList<MessageVO>();
		Connection con = null;
		PreparedStatement pstmt = null;
		MemberDAO dao = new MemberDAO();
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(SELECT_ALL_MESSAGE);
//"select messageID,mContent,mTime,messageID_response,memberID,courseID,status from Message"
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
		} catch (ClassNotFoundException e) {
			throw new RuntimeException("Couldn't load database driver. " + e.getMessage());
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
	public List<MessageVO> findMessageByCourseID(Integer courseID) {
		List<MessageVO> list = new ArrayList<MessageVO>();
		MessageVO messageVO = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		MemberDAO dao = new MemberDAO();
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
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
		return list;
	}
	public static void main(String[] args) {
		MessageDAO_JDBC dao = new MessageDAO_JDBC();
		//新增
//		MessageVO messageVO1 = new MessageVO();
//		messageVO1.setmContent("第2筆留言");
//		messageVO1.setmTime(new Timestamp(System.currentTimeMillis()));
//		messageVO1.setMemberID(100002);
//		messageVO1.setCourseID(200002);
//		messageVO1.setStatus((byte) 0);
//		int id =dao.insert(messageVO1);
//		System.out.println(id);
		
		//更新留言
//		MessageVO messageVO2 = new MessageVO();
//		messageVO2.setmContent("第一筆留言(改)");
//		messageVO2.setmTime(new Timestamp(System.currentTimeMillis()));
//		messageVO2.setMessageID(1001);
//		dao.update(messageVO2,"message");
		
		
		//新增回應
//		MessageVO messageVO3 = new MessageVO();
//		messageVO3.setmContent("第2筆回應");
//		messageVO3.setmTime(new Timestamp(System.currentTimeMillis()));
//		messageVO3.setMessageID_response(1002);//抓留言ID
//		messageVO3.setMemberID(100003);
//		messageVO3.setCourseID(200002);//抓課程ID與留言相同
//		messageVO3.setStatus((byte)0);
//		dao.insert_re(messageVO3);
		
		
		//更新回應
//		MessageVO messageVO4 = new MessageVO();
//		messageVO4.setmContent("第一筆回應(改)");
//		messageVO4.setmTime(new Timestamp(System.currentTimeMillis()));
//		messageVO4.setMessageID(1003);
//		dao.update(messageVO4,"messageresponse");
		
		
		//查詢單筆
//		MessageVO m=dao.findByPrimaryKey(1003);
//		System.out.println(m.getMessageID());
//		System.out.println(m.getmTime());
//		System.out.println(m.getmContent());
//		System.out.println(m.getMessageID_response());
//		System.out.println(m.getCourseID());
//		System.out.println(m.getMemberID());
//		System.out.println(m.getStatus());
		
		
		//查詢多個回應
//		List<MessageVO> messageVO=dao.findAllResponse(1002);
//		for(MessageVO m:messageVO){
//			System.out.print(m.getMessageID()+" ");
//			System.out.print(m.getmTime()+" ");
//			System.out.print(m.getmContent()+" ");
//			System.out.print(m.getMessageID_response()+" ");
//			System.out.print(m.getCourseID()+" ");
//			System.out.print(m.getMemberID()+" ");
//			System.out.println(m.getStatus());
//		}
		//查詢該課程多筆留言
//		List<MessageVO> messageVO=dao.findMessageByCourseID(200002);
//		for(MessageVO m:messageVO){
//			System.out.print(m.getMessageID()+" ");
//			System.out.print(m.getmTime()+" ");
//			System.out.print(m.getmContent()+" ");
//			System.out.print(m.getMessageID_response()+" ");
//			System.out.print(m.getCourseID()+" ");
//			System.out.print(m.getMemberID()+" ");
//			System.out.println(m.getStatus());
//		}
//		
		//查詢全部
//		List<MessageVO> messageVO=dao.getAll();
//		for(MessageVO m:messageVO){
//			System.out.print(m.getMessageID()+" ");
//			System.out.print(m.getmTime()+" ");
//			System.out.print(m.getmContent()+" ");
//			System.out.print(m.getMessageID_response()+" ");
//			System.out.print(m.getCourseID()+" ");
//			System.out.print(m.getMemberID()+" ");
//			System.out.println(m.getStatus());
//		}
		
	}


}
