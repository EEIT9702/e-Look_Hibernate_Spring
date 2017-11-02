package com.e_Look.shoppingCart.model.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import javax.naming.spi.DirStateFactory.Result;

import com.e_Look.Course.*;

public class ShoppingCartDAO_JDBC implements ShoppingCartDAO_interface {
	String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
	String url = "jdbc:sqlserver://localhost:1433;DatabaseName=elook";
	String userid = "sa";
	// 第一組密碼
	String passwd = "P@ssw0rd";
	// 第二組密碼
	// String passwd = "123456";
	private static final String INSERT_SHOPPINGCART = "insert into Shoppingcart (memberID,courseID) values (?,?)";
	private static final String UPDATE_SHOPPINGCART = "update Shoppingcart set memberID=? , courseID=? where memberID=? and courseID=?";
	private static final String DELETE_SHOPPINGCART = "delete from Shoppingcart where memberID=? and courseID=?";
	private static final String SELECT_MEMBER_SHOPPINGCART = "select memberID,courseID from Shoppingcart where memberID=?";
	private static final String SELECT_ALL_SHOPPINGCART = "select memberID,courseID from Shoppingcart";
	private static final String SELECT_ONE_SHOPPINGCART = "select memberID,courseID from Shoppingcart where memberID=? and courseID=?";

	@Override
	public void insert(ShoppingCartVO shoppingCartVO) {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(INSERT_SHOPPINGCART);
			pstmt.setInt(1, shoppingCartVO.getMemberID());
			pstmt.setInt(2, shoppingCartVO.getCourseVO().getCourseID());
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

	// shoppingCartVO 修改後
	// shoppingCartVO2修改前
	@Override
	public void update(ShoppingCartVO shoppingCartVO, ShoppingCartVO shoppingCartVO2) {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(UPDATE_SHOPPINGCART);
			pstmt.setInt(1, shoppingCartVO.getMemberID());
			pstmt.setInt(2, shoppingCartVO.getCourseVO().getCourseID());
			pstmt.setInt(3, shoppingCartVO2.getMemberID());
			pstmt.setInt(4, shoppingCartVO2.getCourseVO().getCourseID());
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
	public void delete(ShoppingCartVO shoppingCartVO) {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(DELETE_SHOPPINGCART);
			pstmt.setInt(1, shoppingCartVO.getMemberID());
			pstmt.setInt(2, shoppingCartVO.getCourseVO().getCourseID());
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
	public List<CourseVO> findByMemberID(Integer memberID) {
		List<CourseVO> list = new LinkedList<CourseVO>();

		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(SELECT_MEMBER_SHOPPINGCART);
			pstmt.setInt(1, memberID);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				Integer courseID = rs.getInt(2);
				CourseVO courseVO = new CourseDAO_JDBC().findByPrimaryKey(courseID);
				list.add(courseVO);
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
	public List<ShoppingCartVO> getAll() {
		List<ShoppingCartVO> list = new LinkedList<ShoppingCartVO>();

		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(SELECT_ALL_SHOPPINGCART);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				ShoppingCartVO shoppingCartVO = new ShoppingCartVO();
				shoppingCartVO.setMemberID(rs.getInt(1));
				Integer courseID = rs.getInt(2);
				shoppingCartVO.setCourseVO(new CourseDAO_JDBC().findByPrimaryKey(courseID));
				list.add(shoppingCartVO);
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
	public ShoppingCartVO findByPrimaryKey(ShoppingCartVO shoppingCartVO) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ShoppingCartVO shoppingCartVO2 = null;
		CourseDAO_JDBC cdao = new CourseDAO_JDBC();
		
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt=con.prepareStatement(SELECT_ONE_SHOPPINGCART);
			pstmt.setInt(1, shoppingCartVO.getMemberID());
			pstmt.setInt(2, shoppingCartVO.getCourseVO().getCourseID());
			ResultSet rs=pstmt.executeQuery();
			if(rs.next()){
				shoppingCartVO2 = new ShoppingCartVO();
				shoppingCartVO2.setMemberID(rs.getInt(1));
				shoppingCartVO2.setCourseVO(cdao.findByPrimaryKey(rs.getInt(2)));
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
		return shoppingCartVO2;
	}

	public static void main(String[] args) {
		ShoppingCartDAO_JDBC dao = new ShoppingCartDAO_JDBC();

		ShoppingCartVO shoppingCartVO = new ShoppingCartVO();
		CourseDAO_JDBC cdao = new CourseDAO_JDBC();

		shoppingCartVO.setMemberID(100001);
		shoppingCartVO.setCourseVO(cdao.findByPrimaryKey(200004));
		dao.insert(shoppingCartVO);

		List<ShoppingCartVO> list = dao.getAll();
		for (ShoppingCartVO vo : list) {
			System.out.print("會員編號：" + vo.getMemberID() + "的購物車有課程：");
			System.out.println(vo.getCourseVO().getCourseID());
		}

	}

}
