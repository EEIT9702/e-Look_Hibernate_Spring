package com.e_Look.OrderDetails.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import com.e_Look.Course.CourseDAO;
import com.e_Look.Course.CourseDAO_JDBC;
import com.e_Look.Order.model.OrderDAO;
import com.e_Look.Order.model.OrderDAO_JDBC;

public class OrderDetailsDAO_JDBC implements OrderDetailsDAO_interface {
	String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
	String url = "jdbc:sqlserver://localhost:1433;DatabaseName=elook";
	String userid = "sa";
	// 第一組密碼
	String passwd = "P@ssw0rd";
	// 第二組密碼
	// String passwd = "123456";

	private static final String INSERT_ORDERDETAILS = "insert into OrderDetails (orderID,courseID,buyingPrice,originalPrice) values(?,?,?,?)";
	private static final String UPDATE_ORDERDETAILS = "update OrderDetails set orderID=?,courseID=?,buyingPrice=?,originalPrice=? where orderID=? and courseID=?";
	private static final String DELETE_ORDERDETAILS = "delete from OrderDetails where orderID=? and courseID=?";
	private static final String SELECT_ORDER_ORDERDETAILS = "select orderID,courseID,buyingPrice,originalPrice from OrderDetails where orderID = ?";
	private static final String SELECT_ALL_ORDERDETAILS = "select orderID,courseID,buyingPrice,originalPrice from OrderDetails";
	private static final String SELECT_ONE_ORDERDETAILS = "select orderID,courseID,buyingPrice,originalPrice from OrderDetails where orderID=? and courseID=?";
	private static final String SELECT_ORDERDETAILS_BY_COURSEID = "select orderID,courseID,buyingPrice,originalPrice from OrderDetails where courseID=?";
	
	@Override
	public void insert(OrderDetailsVO orderDetailsVO) {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(INSERT_ORDERDETAILS);
			pstmt.setInt(1, orderDetailsVO.getOrderVO().getOrderID());
			pstmt.setInt(2, orderDetailsVO.getCourseVO().getCourseID());
			pstmt.setInt(3, orderDetailsVO.getBuyingPrice());
			pstmt.setInt(4, orderDetailsVO.getOriginalPrice());
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
	public void update(OrderDetailsVO orderDetailsVO) {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(UPDATE_ORDERDETAILS);
			pstmt.setInt(1, orderDetailsVO.getOrderVO().getOrderID());
			pstmt.setInt(2, orderDetailsVO.getCourseVO().getCourseID());
			pstmt.setInt(3, orderDetailsVO.getBuyingPrice());
			pstmt.setInt(4, orderDetailsVO.getOriginalPrice());
			pstmt.setInt(5, orderDetailsVO.getOrderVO().getOrderID());
			pstmt.setInt(6, orderDetailsVO.getCourseVO().getCourseID());
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
	public void delete(OrderDetailsVO orderDetailsVO) {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(DELETE_ORDERDETAILS);
			pstmt.setInt(1, orderDetailsVO.getOrderVO().getOrderID());
			pstmt.setInt(2, orderDetailsVO.getCourseVO().getCourseID());
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
	public List<OrderDetailsVO> findByOrderID(Integer orderID) {
		List<OrderDetailsVO> list = new LinkedList<OrderDetailsVO>();
		CourseDAO_JDBC cdao = new CourseDAO_JDBC();
		OrderDAO_JDBC odao = new OrderDAO_JDBC();
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(SELECT_ORDER_ORDERDETAILS);
			pstmt.setInt(1, orderID);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				OrderDetailsVO vo = new OrderDetailsVO();
				vo.setOrderVO(odao.findByPrimaryKey(rs.getInt(1)));
				vo.setCourseVO(cdao.findByPrimaryKey(rs.getInt(2)));
				vo.setBuyingPrice(rs.getInt(3));
				vo.setOriginalPrice(rs.getInt(4));
				list.add(vo);
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
	public List<OrderDetailsVO> getAll() {
		List<OrderDetailsVO> list = new LinkedList<OrderDetailsVO>();
		Connection con = null;
		PreparedStatement pstmt = null;
		CourseDAO_JDBC cdao = new CourseDAO_JDBC();
		OrderDAO_JDBC odao = new OrderDAO_JDBC();
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(SELECT_ALL_ORDERDETAILS);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				OrderDetailsVO vo = new OrderDetailsVO();
				vo.setOrderVO(odao.findByPrimaryKey(rs.getInt(1)));
				vo.setCourseVO(cdao.findByPrimaryKey(rs.getInt(2)));
				vo.setBuyingPrice(rs.getInt(3));
				vo.setOriginalPrice(rs.getInt(4));
				list.add(vo);
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
	public OrderDetailsVO findByPrimaryKey(OrderDetailsVO orderDetailsVO) {
		Connection con = null;
		PreparedStatement pstmt = null;
		OrderDetailsVO orderDetailsVO2 = null;		
		CourseDAO_JDBC cdao = new CourseDAO_JDBC();
		OrderDAO_JDBC odao = new OrderDAO_JDBC();
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(SELECT_ONE_ORDERDETAILS);
			pstmt.setInt(1, orderDetailsVO.getOrderVO().getOrderID());
			pstmt.setInt(2, orderDetailsVO.getCourseVO().getCourseID());
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				orderDetailsVO2 = new OrderDetailsVO();
				orderDetailsVO2.setOrderVO(odao.findByPrimaryKey(rs.getInt(1)));
				orderDetailsVO2.setCourseVO(cdao.findByPrimaryKey(rs.getInt(2)));
				orderDetailsVO2.setBuyingPrice(rs.getInt(3));
				orderDetailsVO2.setOriginalPrice(rs.getInt(4));
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
		return orderDetailsVO2;
	}
	@Override
	public List<OrderDetailsVO> findByCourseID(Integer courseID) {
		List<OrderDetailsVO> list = new LinkedList<OrderDetailsVO>();
		Connection con = null;
		PreparedStatement pstmt = null;
		CourseDAO_JDBC cdao = new CourseDAO_JDBC();
		OrderDAO_JDBC odao = new OrderDAO_JDBC();
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(SELECT_ORDERDETAILS_BY_COURSEID);
			pstmt.setInt(1, courseID);
			ResultSet rs=pstmt.executeQuery();
			while(rs.next()){
				OrderDetailsVO odVO = new OrderDetailsVO();
				odVO.setOrderVO(odao.findByPrimaryKey(rs.getInt(1)));
				odVO.setCourseVO(cdao.findByPrimaryKey(rs.getInt(2)));
				odVO.setBuyingPrice(rs.getInt(3));
				odVO.setOriginalPrice(rs.getInt(4));
				list.add(odVO);
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
	
	
	
	
	public static void main(String[] args) {
		OrderDetailsDAO_JDBC dao = new OrderDetailsDAO_JDBC();
		// OrderDetailsVO vo=new OrderDetailsVO();
		//
		// dao.insert(vo);
		//

		List<OrderDetailsVO> list = dao.getAll();
		for (OrderDetailsVO odvo : list) {
			System.out.println(odvo.getOrderVO().getOrderID());
			System.out.println(odvo.getCourseVO().getCourseID());
			System.out.println(odvo.getBuyingPrice());
			System.out.println(odvo.getOriginalPrice());
		}

	}
}
