package com.e_Look.eLookEvent;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.LinkedList;
import java.util.List;

public class eLookEventDAO_JDBC implements eLookEvent_interface {
	String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
	String url = "jdbc:sqlserver://localhost:1433;DatabaseName=elook";
	String userid = "sa";
	// 第一組密碼
	
	String passwd = "P@ssw0rd";
	// 第二組密碼
	// String passwd = "123456";

//	private static final String INSERT_ELOOKEVENT = "insert into eLookEvent (eventName,ePhoto,eStartDate,eEndDate,discount) values ( ?, ?, ?, ?, ?)";
//	private static final String UPDATE_ELOOKEVENT = "update eLookEvent set eventName=?, ePhoto=?, eStartDate=?, eEndDate=?, discount=? where eventID= ?";
//	private static final String DELETE_ELOOKEVENT = "delete from eLookEvent where eventID= ?";
//	private static final String SELECT_ONE_ELOOKEVENT = "select eventID,eventName ,ePhoto,eStartDate,eEndDate,discount from eLookEvent where eventID= ?";
//	private static final String SELECT_ALL_ELOOKEVENT = "select eventID,eventName ,ePhoto,eStartDate,eEndDate,discount from eLookEvent";

	private static final String INSERT_ELOOKEVENT = "insert into eLookEvent (eventName,eStartDate,eEndDate,discount,courseClass1,courseClass2,courseClass3) values ( ?,  ?, ?, ?,?,?,?)";
	private static final String UPDATE_ELOOKEVENT = "update eLookEvent set eventName=?,  eStartDate=?, eEndDate=?, discount=?,courseClass1=?,courseClass2=?,courseClass3=? where eventID= ?";
	private static final String DELETE_ELOOKEVENT = "delete from eLookEvent where eventID= ?";
	private static final String SELECT_ONE_ELOOKEVENT = "select eventID,eventName ,eStartDate,eEndDate,discount,courseClass1,courseClass2,courseClass3 from eLookEvent where eventID= ?";
	private static final String SELECT_ALL_ELOOKEVENT = "select eventID,eventName,eStartDate,eEndDate,discount,courseClass1,courseClass2,courseClass3 from eLookEvent";

	@Override
	public void insert(eLookEventVO eLookEventVO) {

		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);

			pstmt = con.prepareStatement(INSERT_ELOOKEVENT);
			pstmt.setString(1, eLookEventVO.getEventName());
//			pstmt.setBlob(2, eLookEventVO.getePhoto());
			pstmt.setDate(2, eLookEventVO.geteStartDate());
			pstmt.setDate(3, eLookEventVO.geteEndDate());
			pstmt.setDouble(4, eLookEventVO.getDiscount());
			pstmt.setString(5,eLookEventVO.getCourseClass1());
			pstmt.setString(6,eLookEventVO.getCourseClass2());
			pstmt.setString(7,eLookEventVO.getCourseClass3());
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
	public void delete(Integer eventID) {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(DELETE_ELOOKEVENT);
			pstmt.setInt(1, eventID);

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
	public void update(eLookEventVO eLookEventVO) {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(UPDATE_ELOOKEVENT);
			pstmt.setString(1, eLookEventVO.getEventName());
//			pstmt.setBlob(2, eLookEventVO.getePhoto());
			pstmt.setDate(2, eLookEventVO.geteStartDate());
			pstmt.setDate(3, eLookEventVO.geteEndDate());
			pstmt.setDouble(4, eLookEventVO.getDiscount());
//			pstmt.setInt(6, eLookEventVO.getEventID());
			pstmt.setString(5,eLookEventVO.getCourseClass1());
			pstmt.setString(6,eLookEventVO.getCourseClass2());
			pstmt.setString(7,eLookEventVO.getCourseClass3());
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
	public eLookEventVO findByPrimaryKey(Integer eventID) {
		eLookEventVO eLookEventVO = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(SELECT_ONE_ELOOKEVENT);
			pstmt.setInt(1, eventID);
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				eLookEventVO = new eLookEventVO();
				eLookEventVO.setEventID(rs.getInt(1));
				eLookEventVO.setEventName(rs.getString(2));
//				eLookEventVO.setePhoto(rs.getBinaryStream(3));
				eLookEventVO.seteStartDate(rs.getDate(3));
				eLookEventVO.seteEndDate(rs.getDate(4));
				eLookEventVO.setDiscount(rs.getDouble(5));
				eLookEventVO.setCourseClass1(rs.getString(6));
				eLookEventVO.setCourseClass2(rs.getString(7));
				eLookEventVO.setCourseClass3(rs.getString(8));
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
		return eLookEventVO;
	}

	@Override
	public List<eLookEventVO> getAll() {
		List<eLookEventVO> list = new LinkedList<eLookEventVO>();

		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(SELECT_ALL_ELOOKEVENT);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				eLookEventVO eLookEventVO = new eLookEventVO();
				eLookEventVO = new eLookEventVO();
				eLookEventVO.setEventID(rs.getInt(1));
				eLookEventVO.setEventName(rs.getString(2));
//				eLookEventVO.setePhoto(rs.getBinaryStream(3));
				eLookEventVO.seteStartDate(rs.getDate(3));
				eLookEventVO.seteEndDate(rs.getDate(4));
				eLookEventVO.setDiscount(rs.getDouble(5));
				eLookEventVO.setCourseClass1(rs.getString(6));
				eLookEventVO.setCourseClass2(rs.getString(7));
				eLookEventVO.setCourseClass3(rs.getString(8));
				list.add(eLookEventVO);
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
		//insert一筆資料

		eLookEventDAO_JDBC daoJDBC=new eLookEventDAO_JDBC();
		
		eLookEventVO dao = new eLookEventVO();

//		dao.setEventName("萬聖節派對");
//			String dateFirst="2017/10/25";//日期輸入位置
//			String dateSecond="2017/12/25";//日期輸入位置
//			String eStartDate=null;
//			String eEndDate=null;
//			if(dateFirst.indexOf("/")!=-1){
//				eStartDate=dateFirst.replace('/', '-');
//			}
//			if(dateSecond.indexOf("/")!=-1){				
//				eEndDate=dateSecond.replace('/', '-');
//			}
//			dao.seteStartDate(java.sql.Date.valueOf(eStartDate));
//			dao.seteEndDate(java.sql.Date.valueOf(eEndDate));
//	
//			try {
//				dao.setePhoto(new FileInputStream(new File("D:/1.png")));
//			} catch (FileNotFoundException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		dao.setDiscount(0.8);
//		daoJDBC.insert(dao);
		
		//刪除單筆
//		eLookEventVO list1 = daoJDBC.findByPrimaryKey(1001);
//		daoJDBC.delete(1001);		
		
		//更新資料
//		dao.setEventID(1001);;
//		dao.setEventName("生日派對");
//		String dateFirst="2017/02/25";//日期輸入位置
//		String dateSecond="2017/03/25";//日期輸入位置
//		String eStartDate=null;
//		String eEndDate=null;
//		
//		if(dateFirst.indexOf("/")!=-1){
//			eStartDate=dateFirst.replace('/', '-');
//		}
//		if(dateSecond.indexOf("/")!=-1){
//			
//			eEndDate=dateSecond.replace('/', '-');
//		}
//		dao.seteStartDate(java.sql.Date.valueOf(eStartDate));
//		dao.seteEndDate(java.sql.Date.valueOf(eEndDate));
//
//		try {
//			dao.setePhoto(new FileInputStream(new File("D:/1.png")));
//		} catch (FileNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		dao.setDiscount(0.5);
//		daoJDBC.update(dao);
		
		
		//查單筆
		eLookEventVO list1 = daoJDBC.findByPrimaryKey(1004);
	
			System.out.print(list1.getEventName()+",");
//			System.out.print(list1.getePhoto()+",");
			System.out.print(list1.geteStartDate()+",");
			System.out.print(list1.geteEndDate()+",");
			System.out.print(list1.getDiscount()+",");
			System.out.print(list1.getCourseClass1()+",");
			System.out.print(list1.getCourseClass2()+",");
			System.out.print(list1.getCourseClass3()+",");
			
//			

		//查全部

//		List<eLookEventVO> list2 = daoJDBC.getAll();
//		for(eLookEventVO eLookEventVO:list2){
//			System.out.print(eLookEventVO.getEventName()+",");
//			System.out.print(eLookEventVO.geteStartDate()+",");
//			System.out.print(eLookEventVO.getePhoto()+",");
//			System.out.print(eLookEventVO.geteEndDate()+",");
//			System.out.print(eLookEventVO.getDiscount()+",");
//		}

	}

}
