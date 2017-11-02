package com.e_Look.Order.model;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class OrderDAO_JDBC implements OrderDAO_interface {
	String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
	String url = "jdbc:sqlserver://localhost:1433;DatabaseName=elook";
	String userid = "sa";
	//第一組密碼
	String passwd = "P@ssw0rd";
	//第二組密碼
	//String passwd = "123456";
	private static final String INSERT_Order = "insert into [Order] (memberID,orderTime) values (?,?)";
	private static final String UPDATE_Order = "update [Order] set memberID=? ,orderTime=? where OrderID=?";
	private static final String DELETE_Order = "delete from [Order] where OrderID=?";
	private static final String SELECT_Order = "select OrderID,memberID,orderTime from [Order] where OrderID=?";
	private static final String SELECT_ALL_Order = "select OrderID,memberID,orderTime from [Order]";
	private static final String SELECT_MEMBER_UNCHECK_Order = "select OrderID,memberID,orderTime from [Order] where memberID=? and orderTime is null";
	private static final String SELECT_MEMBER_ALL_Order = "select OrderID,memberID,orderTime from [Order] where memberID=? ";
	private static final String SELECT_ORDER_OF_DATE = "select OrderID,memberID,orderTime from [Order] where orderTime>=? and orderTime <=?";
	
	
	@Override
	public void insert(OrderVO orderVO) {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);		
			pstmt=con.prepareStatement(INSERT_Order);
			pstmt.setInt(1,orderVO.getMemberID());
			pstmt.setDate(2,orderVO.getOrderTime());
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
	public void update(OrderVO orderVO) {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);		
			pstmt=con.prepareStatement(UPDATE_Order);
			pstmt.setInt(1,orderVO.getMemberID());
			pstmt.setDate(2,orderVO.getOrderTime());
			pstmt.setInt(3, orderVO.getOrderID());
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
	public void delete(Integer orderID) {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);		
			
			pstmt=con.prepareStatement(DELETE_Order);
			
			pstmt.setInt(1,orderID);
			
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
	public OrderVO findByPrimaryKey(Integer orderID) {
		OrderVO orderVO = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(SELECT_Order);
			pstmt.setInt(1, orderID);
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				orderVO = new OrderVO();
				orderVO.setOrderID(rs.getInt(1));
				orderVO.setMemberID(rs.getInt(2));
				orderVO.setOrderTime(rs.getDate(3));
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
		return orderVO;
	}

	@Override
	public List<OrderVO> getAll() {
		List<OrderVO> list = new LinkedList<OrderVO>();
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);	
			
			pstmt = con.prepareStatement(SELECT_ALL_Order);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				
				OrderVO orderVO= new OrderVO();
				orderVO.setOrderID(rs.getInt(1));
				orderVO.setMemberID(rs.getInt(2));
				orderVO.setOrderTime(rs.getDate(3));
				list.add(orderVO);
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
	@Override
	public OrderVO findMemberUncheckOrder(Integer memberID) {
		Connection con = null;
		PreparedStatement pstmt = null;
		OrderVO orderVO = null;
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);	
			pstmt = con.prepareStatement(SELECT_MEMBER_UNCHECK_Order);
			pstmt.setInt(1, memberID);
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()){
				orderVO=new OrderVO();
				orderVO.setOrderID(rs.getInt(1));
				orderVO.setMemberID(rs.getInt(2));
				orderVO.setOrderTime(rs.getDate(3));
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
		
		return orderVO;
	}


	@Override
	public List<OrderVO> getMemberAllOrder(Integer memberID) {
		List<OrderVO> list = new LinkedList<OrderVO>();

		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);	
			pstmt = con.prepareStatement(SELECT_MEMBER_ALL_Order);
			pstmt.setInt(1, memberID);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				OrderVO OrderVO = new OrderVO();
				OrderVO.setOrderID(rs.getInt(1));
				OrderVO.setMemberID(rs.getInt(2));
				OrderVO.setOrderTime(rs.getDate(3));
				list.add(OrderVO);
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
	@Override
	public List<OrderVO> getOrderByDate(Date sDate, Date eDate) {
		List<OrderVO> list = new LinkedList<OrderVO>();
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);	
			pstmt = con.prepareStatement(SELECT_ORDER_OF_DATE);
			pstmt.setDate(1, sDate);
			pstmt.setDate(2, eDate);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()){
				OrderVO orderVO = new OrderVO();
				orderVO.setOrderID(rs.getInt(1));
				orderVO.setMemberID(rs.getInt(2));
				orderVO.setOrderTime(rs.getDate(3));
				list.add(orderVO);
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
		
		OrderDAO_JDBC dao=new OrderDAO_JDBC();
//		OrderVO orderVO=new OrderVO();
//		orderVO.setMemberID(100001);
//		orderVO.setOrderTime(null);
//		
//		dao.insert(orderVO);
		long aa=new java.util.Date().getTime();
		
		//2017=117   10月=9
		long ss=new Date(70,0,2).getTime();
		
		System.out.println(aa);
		System.out.println(ss);
		List<OrderVO> list = dao.getOrderByDate(new Date(aa), new Date(aa));
		System.out.println(list.size());
		for(OrderVO orderVO:list){
			System.out.print(orderVO.getOrderID()+",");
			System.out.print(orderVO.getMemberID()+",");
			System.out.println(orderVO.getOrderTime()+"");
		}
		
		
	}
}
