package com.e_Look.search;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class SearchDAO_JDBC implements SearchDAO_interface {
	String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
	String url = "jdbc:sqlserver://localhost:1433;DatabaseName=elook";
	String userid = "sa";
	// 第一組密碼
	String passwd = "P@ssw0rd";
	// 第二組密碼
	// String passwd = "123456";
	private static final String INSERT_SEARCH = "insert into Search (keyWord,enterTime) values (?,getdate())";
	// deprecated
	private static final String UPDATE_SEARCH = "update Search set keyWord=? , enterTime=? where keyWord=? and enterTime=?";
	private static final String DELETE_SEARCH = "delete from Search where keyWord=? and enterTime=?";
	private static final String DELETE_DATE_SEARCH = "delete from Search where enterTime < ?";
	private static final String SELECT_ALL_SEARCH = "select keyWord,enterTime from Search";

	@Override
	public void insert(SearchVO searchVO) {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(INSERT_SEARCH);
			pstmt.setString(1, searchVO.getKeyWord());
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
	public void update(SearchVO oldSearchVO, SearchVO newSearchVO) {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(UPDATE_SEARCH);
			pstmt.setString(1, oldSearchVO.getKeyWord());
			pstmt.setDate(2, oldSearchVO.getEnterTime());
			pstmt.setString(3, newSearchVO.getKeyWord());
			pstmt.setDate(4, newSearchVO.getEnterTime());
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
	public void delete(SearchVO searchVO) {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(DELETE_SEARCH);
			pstmt.setString(1, searchVO.getKeyWord());
			pstmt.setDate(2, searchVO.getEnterTime());
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
	public void dateDelete(Date date) {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(DELETE_DATE_SEARCH);
			pstmt.setDate(1, date);
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
	public List<SearchVO> getAll() {
		List<SearchVO> list = new ArrayList<SearchVO>();
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(SELECT_ALL_SEARCH);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				SearchVO searchVO = new SearchVO();
				searchVO.setKeyWord(rs.getString("keyWord"));
				searchVO.setEnterTime(rs.getDate("enterTime"));
				list.add(searchVO);
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
		SearchDAO_JDBC dao=new SearchDAO_JDBC();
		
		SearchVO searchVO=new SearchVO();
		searchVO.setKeyWord("Java");
		searchVO.setEnterTime(new Date(System.currentTimeMillis()));
		dao.insert(searchVO);
		

//		List<SearchVO> list = dao.getAll();
//		for(SearchVO searchVO2:list){
//			System.out.print(searchVO2.getKeyWord()+"\t");
//			System.out.println(searchVO2.getEnterTime());
//			
//		}
//		
		
	}

}
