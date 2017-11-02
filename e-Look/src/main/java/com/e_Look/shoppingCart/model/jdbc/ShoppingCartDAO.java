package com.e_Look.shoppingCart.model.jdbc;

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
import javax.naming.spi.DirStateFactory.Result;
import javax.sql.DataSource;

import com.e_Look.Course.*;

public class ShoppingCartDAO implements ShoppingCartDAO_interface {
	private static DataSource ds = null;
	static {
		try {
			Context ctx = new InitialContext();
			ds = (DataSource) ctx.lookup("java:comp/env/jdbc/eLookDB");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}
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

			con = ds.getConnection();
			pstmt = con.prepareStatement(INSERT_SHOPPINGCART);
			pstmt.setInt(1, shoppingCartVO.getMemberID());
			pstmt.setInt(2, shoppingCartVO.getCourseVO().getCourseID());
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

	// shoppingCartVO 修改後
	// shoppingCartVO2修改前
	@Override
	public void update(ShoppingCartVO shoppingCartVO, ShoppingCartVO shoppingCartVO2) {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {

			con = ds.getConnection();
			pstmt = con.prepareStatement(UPDATE_SHOPPINGCART);
			pstmt.setInt(1, shoppingCartVO.getMemberID());
			pstmt.setInt(2, shoppingCartVO.getCourseVO().getCourseID());
			pstmt.setInt(3, shoppingCartVO2.getMemberID());
			pstmt.setInt(4, shoppingCartVO2.getCourseVO().getCourseID());
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
	public void delete(ShoppingCartVO shoppingCartVO) {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {

			con = ds.getConnection();
			pstmt = con.prepareStatement(DELETE_SHOPPINGCART);
			pstmt.setInt(1, shoppingCartVO.getMemberID());
			pstmt.setInt(2, shoppingCartVO.getCourseVO().getCourseID());
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
	public List<CourseVO> findByMemberID(Integer memberID) {
		List<CourseVO> list = new LinkedList<CourseVO>();

		Connection con = null;
		PreparedStatement pstmt = null;
		try {

			con = ds.getConnection();
			pstmt = con.prepareStatement(SELECT_MEMBER_SHOPPINGCART);
			pstmt.setInt(1, memberID);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				Integer courseID = rs.getInt(2);
				CourseVO courseVO = new CourseDAO().findByPrimaryKey(courseID);
				list.add(courseVO);
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
	public List<ShoppingCartVO> getAll() {
		List<ShoppingCartVO> list = new LinkedList<ShoppingCartVO>();

		Connection con = null;
		PreparedStatement pstmt = null;
		try {

			con = ds.getConnection();
			pstmt = con.prepareStatement(SELECT_ALL_SHOPPINGCART);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				ShoppingCartVO shoppingCartVO = new ShoppingCartVO();
				shoppingCartVO.setMemberID(rs.getInt(1));
				Integer courseID = rs.getInt(2);
				shoppingCartVO.setCourseVO(new CourseDAO().findByPrimaryKey(courseID));
				list.add(shoppingCartVO);
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
	public ShoppingCartVO findByPrimaryKey(ShoppingCartVO shoppingCartVO) {
		ShoppingCartVO shoppingCartVO2 = null;
		CourseDAO cdao = new CourseDAO();
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = ds.getConnection();
			pstmt=con.prepareStatement(SELECT_ONE_SHOPPINGCART);
			pstmt.setInt(1, shoppingCartVO.getMemberID());
			pstmt.setInt(2, shoppingCartVO.getCourseVO().getCourseID());
			ResultSet rs=pstmt.executeQuery();
			if(rs.next()){
				shoppingCartVO2 = new ShoppingCartVO();
				shoppingCartVO2.setMemberID(rs.getInt(1));
				shoppingCartVO2.setCourseVO(cdao.findByPrimaryKey(rs.getInt(2)));
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

		return shoppingCartVO2;
	}

}
