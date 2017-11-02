package com.e_Look.ad;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AdDAO_JDBC implements AdDAO_interface {
	String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
	String url = "jdbc:sqlserver://localhost:1433;DatabaseName=elook";
	String userid = "sa";
	//第一組密碼
	String passwd = "P@ssw0rd";
	//第二組密碼
	//String passwd = "123456";
	
	private static final String INSERT_AD =
			"INSERT INTO Ad (fileName, adFile, status) VALUES (?,?,?) ";
	private static final String UPDATE_AD =
			"UPDATE Ad SET fileName=?, adFile=?, status=? WHERE adID=?";
	private static final String UPDATE_STATUS =
		    "UPDATE Ad SET status=? WHERE adID=?";
	private static final String DELETE_AD =
		    "DELETE FROM Ad WHERE adID =?";
	private static final String SELECT_ONE_AD =
			"SELECT adID, fileName, adFile, status FROM Ad WHERE adID=?";
	private static final String SELECT_ALL_AD =
			"SELECT adID, fileName, adFile, status FROM Ad";
	
	@Override
	public void insert(AdVO adVO) {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(INSERT_AD);
			pstmt.setString(1, adVO.getFileName());
			pstmt.setBlob(2, adVO.getAdFile());
			pstmt.setByte(3, adVO.getStatus());
			pstmt.executeUpdate();
			
			// Handle any driver errors
		} catch (ClassNotFoundException e) {
			throw new RuntimeException("Couldn't load database driver. "
					+ e.getMessage());
			// Handle any SQL errors
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. "
					+ se.getMessage());
			// Clean up JDBC resources
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
	public void update(AdVO adVO) {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			//"UPDATE Ad SET fileName=?, adFile=?, status=? WHERE adID=?";
			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(UPDATE_AD);
			pstmt.setString(1, adVO.getFileName());
			pstmt.setBlob(2, adVO.getAdFile());
			pstmt.setByte(3, adVO.getStatus());
			pstmt.setInt(4, adVO.getAdID());
			pstmt.executeUpdate();
		
			// Handle any driver errors
		} catch (ClassNotFoundException e) {
			throw new RuntimeException("Couldn't load database driver. "
					+ e.getMessage());
			// Handle any SQL errors
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. "
					+ se.getMessage());
			// Clean up JDBC resources
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
	public void updateStatus(Byte status, Integer adID){
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			//"UPDATE Ad SET status=? WHERE adID=?";
			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(UPDATE_STATUS);
			pstmt.setByte(1, status);
			pstmt.setInt(2, adID);
			pstmt.executeUpdate();
		
			// Handle any driver errors
		} catch (ClassNotFoundException e) {
			throw new RuntimeException("Couldn't load database driver. "
					+ e.getMessage());
			// Handle any SQL errors
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. "
					+ se.getMessage());
			// Clean up JDBC resources
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
	public void delete(Integer adID) {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			//"DELETE FROM Ad WHERE adID =?";
			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt=con.prepareStatement(DELETE_AD);
			pstmt.setInt(1, adID);
			pstmt.executeUpdate();
			
			// Handle any driver errors
		} catch (ClassNotFoundException e) {
			throw new RuntimeException("Couldn't load database driver. "
					+ e.getMessage());
			// Handle any SQL errors
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. "
					+ se.getMessage());
			// Clean up JDBC resources
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
	public AdVO findByAdID(Integer adID) {
		AdVO adVO = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			//"SELECT adID, fileName, adFile, status FROM Ad WHERE adID=?";
			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(SELECT_ONE_AD);

			pstmt.setInt(1, adID);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				// adVO 也稱為 Domain objects
				adVO = new AdVO();
				adVO.setAdID(rs.getInt("adID"));
				adVO.setFileName(rs.getString("fileName"));
				adVO.setAdFile(rs.getBinaryStream("adFile"));
				adVO.setStatus(rs.getByte("status"));
			}

			// Handle any driver errors
		} catch (ClassNotFoundException e) {
			throw new RuntimeException("Couldn't load database driver. "
					+ e.getMessage());
			// Handle any SQL errors
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. "
					+ se.getMessage());
			// Clean up JDBC resources
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
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
		return adVO;
	}

	@Override
	public List<AdVO> getAll() {
		List<AdVO> list = new ArrayList<AdVO>();
		AdVO adVO = null;

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			//"SELECT adID, fileName, adFile, status FROM Ad";
			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(SELECT_ALL_AD);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				// adVO 也稱為 Domain objects
				adVO = new AdVO();
				adVO.setAdID(rs.getInt("adID"));
				adVO.setFileName(rs.getString("fileName"));
				adVO.setAdFile(rs.getBinaryStream("adFile"));
				adVO.setStatus(rs.getByte("status"));
				list.add(adVO); // Store the row in the list
			}

			// Handle any driver errors
		} catch (ClassNotFoundException e) {
			throw new RuntimeException("Couldn't load database driver. "
					+ e.getMessage());
			// Handle any SQL errors
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. "
					+ se.getMessage());
			// Clean up JDBC resources
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
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

	public static void main(String[] args) throws FileNotFoundException {
		
		AdDAO_JDBC dao = new AdDAO_JDBC();

		// 新增
		AdVO adVO1 = new AdVO();
		adVO1.setFileName("聖誕大特賣");
		adVO1.setAdFile(new FileInputStream(new File("src/main/webapp/body/img/xmas video sale.jpg")));
		adVO1.setStatus((byte) 0);
		dao.insert(adVO1);
		
		//修改
//		AdVO adVO2 = new AdVO();
//		adVO2.setFileName("聖誕大特賣");
//		adVO2.setAdFile(new FileInputStream(new File("src/main/webapp/body/img/xmas video sale.jpg")));
//		adVO2.setStatus((byte) 1);
//		adVO2.setAdID(1001);
//		dao.update(adVO2);
		
		//刪除
//		dao.delete(1001);
		
		//查詢單一
		AdVO adVO3 = dao.findByAdID(1002);
		System.out.println(adVO3.getAdID());
		System.out.println(adVO3.getFileName());
		System.out.println(adVO3.getAdFile());
		System.out.println(adVO3.getStatus());
		System.out.println("---------------------------");
		
		//查詢全部
		List<AdVO> list = dao.getAll();
		for(AdVO adVO : list){
			System.out.print(adVO.getAdID() + "  ");
			System.out.print(adVO.getFileName() + "  ");
			System.out.print(adVO.getAdFile() + "  ");
			System.out.print(adVO.getStatus());
		}
	}

	@Override
	public List<AdVO> findByStatus() {
		// TODO Auto-generated method stub
		return null;
	}

}
