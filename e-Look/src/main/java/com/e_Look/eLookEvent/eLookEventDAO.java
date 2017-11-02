package com.e_Look.eLookEvent;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class eLookEventDAO implements eLookEvent_interface {
	private static DataSource ds = null;
	static {
		try {
			Context ctx = new InitialContext();
			ds = (DataSource) ctx.lookup("java:comp/env/jdbc/eLookDB");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}

	// private static final String INSERT_ELOOKEVENT = "insert into eLookEvent
	// (eventName,ePhoto,eStartDate,eEndDate,discount) values ( ?, ?, ?, ?, ?)";
	// private static final String UPDATE_ELOOKEVENT = "update eLookEvent set
	// eventName=?, ePhoto=?, eStartDate=?, eEndDate=?, discount=? where eventID=
	// ?";
	// private static final String DELETE_ELOOKEVENT = "delete from eLookEvent where
	// eventID= ?";
	// private static final String SELECT_ONE_ELOOKEVENT = "select eventID,eventName
	// ,ePhoto,eStartDate,eEndDate,discount from eLookEvent where eventID= ?";
	// private static final String SELECT_ALL_ELOOKEVENT = "select eventID,eventName
	// ,ePhoto,eStartDate,eEndDate,discount from eLookEvent";

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
			con = ds.getConnection();
			pstmt = con.prepareStatement(INSERT_ELOOKEVENT);
			pstmt.setString(1, eLookEventVO.getEventName());
			// pstmt.setBlob(2, eLookEventVO.getePhoto());
			pstmt.setDate(2, eLookEventVO.geteStartDate());
			pstmt.setDate(3, eLookEventVO.geteEndDate());
			pstmt.setDouble(4, eLookEventVO.getDiscount());
			if (eLookEventVO.getCourseClass1() == null) {
				pstmt.setNull(5,java.sql.Types.NCHAR);
			} else {
				pstmt.setString(5, eLookEventVO.getCourseClass1());
			}
			if (eLookEventVO.getCourseClass2() == null) {
				pstmt.setNull(6,java.sql.Types.NCHAR);
			} else {
				pstmt.setString(6, eLookEventVO.getCourseClass2());
			}
			if (eLookEventVO.getCourseClass3() == null) {
				pstmt.setNull(7,java.sql.Types.NCHAR);
			} else {
				pstmt.setString(7, eLookEventVO.getCourseClass3());
			}
			pstmt.executeUpdate();
		} catch (SQLException e) {
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
			con = ds.getConnection();
			pstmt = con.prepareStatement(DELETE_ELOOKEVENT);
			pstmt.setInt(1, eventID);

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
	public void update(eLookEventVO eLookEventVO) {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(UPDATE_ELOOKEVENT);
			pstmt.setString(1, eLookEventVO.getEventName());
			pstmt.setDate(2, eLookEventVO.geteStartDate());
			pstmt.setDate(3, eLookEventVO.geteEndDate());
			pstmt.setDouble(4, eLookEventVO.getDiscount());
			// pstmt.setInt(5, eLookEventVO.getEventID());
			pstmt.setString(5, eLookEventVO.getCourseClass1());
			pstmt.setString(6, eLookEventVO.getCourseClass2());
			pstmt.setString(7, eLookEventVO.getCourseClass3());
			pstmt.setInt(8,eLookEventVO.getEventID() );
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
	public eLookEventVO findByPrimaryKey(Integer eventID) {
		eLookEventVO eLookEventVO = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(SELECT_ONE_ELOOKEVENT);
			pstmt.setInt(1, eventID);
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				eLookEventVO = new eLookEventVO();
				eLookEventVO.setEventID(rs.getInt(1));
				eLookEventVO.setEventName(rs.getString(2));
				// eLookEventVO.setePhoto(rs.getBinaryStream(3));
				eLookEventVO.seteStartDate(rs.getDate(3));
				eLookEventVO.seteEndDate(rs.getDate(4));
				eLookEventVO.setDiscount(rs.getDouble(5));
				eLookEventVO.setCourseClass1(rs.getString(6));
				eLookEventVO.setCourseClass2(rs.getString(7));
				eLookEventVO.setCourseClass3(rs.getString(8));
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
		return eLookEventVO;
	}

	@Override
	public List<eLookEventVO> getAll() {
		List<eLookEventVO> list = new LinkedList<eLookEventVO>();

		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(SELECT_ALL_ELOOKEVENT);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				eLookEventVO eLookEventVO = new eLookEventVO();
				eLookEventVO = new eLookEventVO();
				eLookEventVO.setEventID(rs.getInt(1));
				eLookEventVO.setEventName(rs.getString(2));
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
