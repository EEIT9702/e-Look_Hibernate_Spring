package com.e_Look.Course;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import com.e_Look.member.model.MemberVO;

public class CourseDAO implements CourseDAO_interface {
	private static DataSource ds = null;
	static {
		try {
			Context ctx = new InitialContext();
			ds = (DataSource) ctx.lookup("java:comp/env/jdbc/eLookDB");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}
	private static final String INSERT_Course = "insert into Course (courseName,cPhoto,preTool,background,ability,targetgroup,soldPrice,courseLength,targetStudentNumber,fundStartDate,fundEndDate,courseStartDate,courseVideopathway,paper,status,courseContent,memberID,avgScore) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	private static final String UPDATE_Course = "update Course set courseName=?,preTool=?,background=?,ability=?,targetgroup=?,soldPrice=?,courseLength=?,targetStudentNumber=?,fundStartDate=?,fundEndDate=?,courseStartDate=?,courseContent=? where courseID= ?";
	private static final String UPDATE_Course_IMAGE ="update Course set cPhoto=? where courseID= ?";
	private static final String UPDATE_Course_PAPER ="update Course set paper=? where courseID= ?";
	private static final String UPDATE_Course_CourseVideopathway ="update Course set CourseVideopathway=? where courseID= ?";
	private static final String UPDATE_Proposal_Status = "update Course set Status=1 where courseID=?";
	private static final String UPDATE_Editor_Status = "update Course set Status=0 where courseID=?";
	private static final String UPDATE_Fund_Status = "update Course set Status=3 where courseID=?";
	private static final String UPDATE_Online_Status = "update Course set Status=2 where courseID=?";
	private static final String DELETE_Course = "delete from Course where courseID= ?";
	private static final String SELECT_ONE_Course = "select courseID,courseName,cPhoto,preTool,background,ability,targetgroup,soldPrice,courseLength,targetStudentNumber,fundStartDate,fundEndDate,courseStartDate,courseVideopathway,paper,status,courseContent,memberID,avgScore from Course where courseID= ?";
	private static final String SELECT_ALL_Course = "select courseID,courseName,cPhoto,preTool,background,ability,targetgroup,soldPrice,courseLength,targetStudentNumber,fundStartDate,fundEndDate,courseStartDate,courseVideopathway,paper,status,courseContent,memberID,avgScore from Course where memberID= ? and status= ?";
	private static final String SELECT_ALL_ReviewCourse = "select courseID,courseName,cPhoto,preTool,background,ability,targetgroup,soldPrice,courseLength,targetStudentNumber,fundStartDate,fundEndDate,courseStartDate,courseVideopathway,paper,status,courseContent,memberID,avgScore from Course where status= 1";
	private static final String CHANGE_Course_Stage = "update Course set status=? where courseID= ?";
	private static final String SELECT_ALL_ONLINECourse = "select courseID,courseName,cPhoto,preTool,background,ability,targetgroup,soldPrice,courseLength,targetStudentNumber,fundStartDate,fundEndDate,courseStartDate,courseVideopathway,paper,status,courseContent,memberID,avgScore from Course where  status= 2 ";
	private static final String UPDATE_AVG_SCORE = "UPDATE Course SET avgScore=? WHERE courseID=?";
	private static final String SELECT_ALL_FREE_COURSE = "SELECT courseID,courseName,cPhoto,preTool,background,ability,targetgroup,soldPrice,courseLength,targetStudentNumber,fundStartDate,fundEndDate,courseStartDate,courseVideopathway,paper,status,courseContent,memberID,avgScore FROM Course WHERE status=2 AND soldPrice=0";
	private static final String SELECT_ALL_ONLINE_COURSE = "SELECT courseID,courseName,cPhoto,preTool,background,ability,targetgroup,soldPrice,courseLength,targetStudentNumber,fundStartDate,fundEndDate,courseStartDate,courseVideopathway,paper,status,courseContent,memberID,avgScore FROM Course WHERE status=2 AND soldPrice>0";
	private static final String SELECT_ALL_FUNDRAISE_COURSE = "SELECT courseID,courseName,cPhoto,preTool,background,ability,targetgroup,soldPrice,courseLength,targetStudentNumber,fundStartDate,fundEndDate,courseStartDate,courseVideopathway,paper,status,courseContent,memberID,avgScore FROM Course WHERE status=3 AND fundStartDate <= getDate()";
	
	@Override
	public Integer insert(CourseVO courseVO) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet generatedKeys = null;
		int id = 0;
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(INSERT_Course,Statement.RETURN_GENERATED_KEYS);						
			pstmt.setString(1, courseVO.getCourseName());// 課程名稱
			pstmt.setBlob(2, courseVO.getcPhoto());// 課程封面照片
			pstmt.setString(3, courseVO.getPreTool());// 準備工具
			pstmt.setString(4, courseVO.getBackground());// 背景知識
			pstmt.setString(5, courseVO.getAbility());// 先備能力
			pstmt.setString(6, courseVO.getTargetgroup());// 適合學習的族群
			pstmt.setInt(7, courseVO.getSoldPrice());// 課程售價
			pstmt.setInt(8, courseVO.getCourseLength());// 影片時間長度
			pstmt.setInt(9, courseVO.getTargetStudentNumber());// 募資人數
			pstmt.setDate(10, courseVO.getFundStartDate());// 募資開始日期
			pstmt.setDate(11, courseVO.getFundEndDate());// 募資結束日期
			pstmt.setDate(12, courseVO.getCourseStartDate());// 課程開始上線日期
			pstmt.setString(13, courseVO.getCourseVideopathway());// 課程影片
			pstmt.setBlob(14, courseVO.getPaper());// 課程講義
			pstmt.setInt(15, courseVO.getStatus());// 課程狀態(草稿、上線、下架等...)
			pstmt.setString(16, courseVO.getCourseContent());// 課程介紹內容
			pstmt.setInt(17, courseVO.getMemberID());// 會員編號
			pstmt.setDouble(18, courseVO.getAvgScore());// 課程平均分數
			pstmt.executeUpdate();
			
			generatedKeys = pstmt.getGeneratedKeys();//取得SQL資料庫自動產生的流水號(課程ID)
			
			if (generatedKeys.next()) {
				id = generatedKeys.getInt(1);
			} else {
				throw new SQLException(
						"Creating user failed, no generated key obtained.");
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
		return id;
	}
	//以下為自動儲存草稿的功能
	@Override
	public void update(CourseVO courseVO) {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(UPDATE_Course);
			pstmt.setString(1, courseVO.getCourseName());// 課程名稱
//			pstmt.setBlob(2, courseVO.getcPhoto());// 課程封面照片
			pstmt.setString(2, courseVO.getPreTool());// 準備工具
			pstmt.setString(3, courseVO.getBackground());// 背景知識
			pstmt.setString(4, courseVO.getAbility());// 先備能力
			pstmt.setString(5, courseVO.getTargetgroup());// 適合學習的族群
			pstmt.setInt(6, courseVO.getSoldPrice());// 課程售價
			pstmt.setInt(7, courseVO.getCourseLength());// 影片時間長度
			pstmt.setInt(8, courseVO.getTargetStudentNumber());// 募資人數
			pstmt.setDate(9, courseVO.getFundStartDate());// 募資開始日期
			pstmt.setDate(10, courseVO.getFundEndDate());// 募資結束日期
			pstmt.setDate(11, courseVO.getCourseStartDate());// 課程開始上線日期
//			pstmt.setString(12, courseVO.getCourseVideopathway());// 課程影片路徑
//			pstmt.setBlob(13, courseVO.getPaper());// 課程講義
			pstmt.setString(12, courseVO.getCourseContent());// 課程介紹內容
			pstmt.setInt(13, courseVO.getCourseID());// 課程ID
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
	//更新平均分數
	@Override
	public void updateAVGScore(Integer courseID,Double avgScore) {
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try{
			con = ds.getConnection();
			pstmt = con.prepareStatement(UPDATE_AVG_SCORE);
			
			pstmt.setDouble(1, avgScore);
			pstmt.setInt(2, courseID);
			pstmt.executeUpdate();

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
	
	//以下為更新圖片的功能
	@Override
	public void updateimage(CourseVO courseVO) {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = ds.getConnection();
			
				pstmt = con.prepareStatement(UPDATE_Course_IMAGE);
				pstmt.setBlob(1, courseVO.getcPhoto());
				pstmt.setInt(2, courseVO.getCourseID());
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
	
	//以下為更新講義的功能
	@Override
	public void updatepaper(CourseVO courseVO) {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = ds.getConnection();
			
				pstmt = con.prepareStatement(UPDATE_Course_PAPER);
				pstmt.setBlob(1, courseVO.getPaper());
				pstmt.setInt(2, courseVO.getCourseID());
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
	
	//以下為更新影片路徑的功能
	@Override
	public void updatecourseVideopathway(CourseVO courseVO) {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = ds.getConnection();
			
				pstmt = con.prepareStatement(UPDATE_Course_CourseVideopathway);
				pstmt.setString(1, courseVO.getCourseVideopathway());
				pstmt.setInt(2, courseVO.getCourseID());
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
	
	//以下為刪除功能
	@Override
	public void delete(Integer courseID) {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(DELETE_Course);
			pstmt.setInt(1, courseID);
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
	//選擇草稿、選擇單一課程頁面
	@Override
	public CourseVO findByPrimaryKey(Integer courseID) {
		CourseVO courseVO = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(SELECT_ONE_Course);
			pstmt.setInt(1, courseID);
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				courseVO = new CourseVO();
				courseVO.setCourseID(rs.getInt(1));
				courseVO.setCourseName(rs.getString(2));
				courseVO.setcPhoto(rs.getBinaryStream(3));
				courseVO.setPreTool(rs.getString(4));
				courseVO.setBackground(rs.getString(5));
				courseVO.setAbility(rs.getString(6));
				courseVO.setTargetgroup(rs.getString(7));
				courseVO.setSoldPrice(rs.getInt(8));
				courseVO.setCourseLength(rs.getInt(9));
				courseVO.setTargetStudentNumber(rs.getInt(10));
				courseVO.setFundStartDate(rs.getDate(11));
				courseVO.setFundEndDate(rs.getDate(12));
				courseVO.setCourseStartDate(rs.getDate(13));
				courseVO.setCourseVideopathway(rs.getString(14));
				courseVO.setPaper(rs.getBinaryStream(15));
				courseVO.setStatus(rs.getInt(16));
				courseVO.setCourseContent(rs.getString(17));
				courseVO.setMemberID(rs.getInt(18));
				courseVO.setAvgScore(rs.getDouble(19));
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
		return courseVO;
	}
	//給開
	
	
	
	
	
	
	
	//會員後臺管理(選擇我的草稿、我開的課)、管理員後台待審核中的課程列表
	@Override
	public List<CourseVO> findAllCourse(Integer memberID, Integer status) {
		List<CourseVO> CourseList = new LinkedList<CourseVO>();
		Connection con = null;
		PreparedStatement pstmt = null;
		try{
			con = ds.getConnection();
			pstmt = con.prepareStatement(SELECT_ALL_Course);
			pstmt.setInt(1, memberID);
			pstmt.setInt(2, status);
			ResultSet  rs=pstmt.executeQuery();
			while(rs.next()){
				CourseVO courseVO=new CourseVO();
				courseVO.setCourseID(rs.getInt(1));
				courseVO.setCourseName(rs.getString(2));
				courseVO.setcPhoto(rs.getBinaryStream(3));
				courseVO.setPreTool(rs.getString(4));
				courseVO.setBackground(rs.getString(5));
				courseVO.setAbility(rs.getString(6));
				courseVO.setTargetgroup(rs.getString(7));
				courseVO.setSoldPrice(rs.getInt(8));
				courseVO.setCourseLength(rs.getInt(9));
				courseVO.setTargetStudentNumber(rs.getInt(10));
				courseVO.setFundStartDate(rs.getDate(11));
				courseVO.setFundEndDate(rs.getDate(12));
				courseVO.setCourseStartDate(rs.getDate(13));
				courseVO.setCourseVideopathway(rs.getString(14));
				courseVO.setPaper(rs.getBinaryStream(15));
				courseVO.setStatus(rs.getInt(16));
				courseVO.setCourseContent(rs.getString(17));
				courseVO.setMemberID(rs.getInt(18));
				courseVO.setAvgScore(rs.getDouble(19));
				CourseList.add(courseVO);			
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
		return CourseList;
	}
	//會員編輯草稿完成送出審核
	@Override
	public void postProposal(Integer courseID){
		Connection con = null;
		PreparedStatement pstmt = null;
		try{
		con = ds.getConnection();
		pstmt = con.prepareStatement(UPDATE_Proposal_Status);
		pstmt.setInt(1,courseID);
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
	//審核不過，退回成草稿狀態
		@Override
		public void changeStatustoEditor(Integer courseID){
			Connection con = null;
			PreparedStatement pstmt = null;
			try{
			con = ds.getConnection();
			pstmt = con.prepareStatement(UPDATE_Editor_Status);
			pstmt.setInt(1,courseID);
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
		//審核通過，改為上線狀態
				@Override
				public void changeStatustoOnline(Integer courseID){
					Connection con = null;
					PreparedStatement pstmt = null;
					try{
					con = ds.getConnection();
					pstmt = con.prepareStatement(UPDATE_Online_Status);
					pstmt.setInt(1,courseID);
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
				//審核通過，改為募資中的狀態
				@Override
				public void changeStatustoFund(Integer courseID){
					Connection con = null;
					PreparedStatement pstmt = null;
					try{
					con = ds.getConnection();
					pstmt = con.prepareStatement(UPDATE_Fund_Status);
					pstmt.setInt(1,courseID);
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
	
	//管理員改變課程狀態(通過審核、下架等等....)
	@Override
	public void updateStatus(CourseVO courseVO) {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(CHANGE_Course_Stage);
			pstmt.setInt(1,courseVO.getStatus());
			pstmt.setInt(2,courseVO.getCourseID());
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
	
	//顯示所有status2的免費課程
	@Override
	public List<CourseVO> getAllFreeCourse() {
		List<CourseVO> CourseList = new LinkedList<CourseVO>();
		Connection con = null;
		PreparedStatement pstmt = null;
		try{
			con = ds.getConnection();
			pstmt = con.prepareStatement(SELECT_ALL_FREE_COURSE);
			ResultSet  rs=pstmt.executeQuery();
			while(rs.next()){
				CourseVO courseVO=new CourseVO();
				courseVO.setCourseID(rs.getInt(1));
				courseVO.setCourseName(rs.getString(2));
				courseVO.setcPhoto(rs.getBinaryStream(3));
				courseVO.setPreTool(rs.getString(4));
				courseVO.setBackground(rs.getString(5));
				courseVO.setAbility(rs.getString(6));
				courseVO.setTargetgroup(rs.getString(7));
				courseVO.setSoldPrice(rs.getInt(8));
				courseVO.setCourseLength(rs.getInt(9));
				courseVO.setTargetStudentNumber(rs.getInt(10));
				courseVO.setFundStartDate(rs.getDate(11));
				courseVO.setFundEndDate(rs.getDate(12));
				courseVO.setCourseStartDate(rs.getDate(13));
				courseVO.setCourseVideopathway(rs.getString(14));
				courseVO.setPaper(rs.getBinaryStream(15));
				courseVO.setStatus(rs.getInt(16));
				courseVO.setCourseContent(rs.getString(17));
				courseVO.setMemberID(rs.getInt(18));
				courseVO.setAvgScore(rs.getDouble(19));
				CourseList.add(courseVO);			
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
		return CourseList;
	}
	
	//顯示所有status2的付費課程
	@Override
	public List<CourseVO> getAllOnlineCourseNotFree() {
		List<CourseVO> CourseList = new LinkedList<CourseVO>();
		Connection con = null;
		PreparedStatement pstmt = null;
		try{
			con = ds.getConnection();
			pstmt = con.prepareStatement(SELECT_ALL_ONLINE_COURSE);
			ResultSet  rs=pstmt.executeQuery();
			while(rs.next()){
				CourseVO courseVO=new CourseVO();
				courseVO.setCourseID(rs.getInt(1));
				courseVO.setCourseName(rs.getString(2));
				courseVO.setcPhoto(rs.getBinaryStream(3));
				courseVO.setPreTool(rs.getString(4));
				courseVO.setBackground(rs.getString(5));
				courseVO.setAbility(rs.getString(6));
				courseVO.setTargetgroup(rs.getString(7));
				courseVO.setSoldPrice(rs.getInt(8));
				courseVO.setCourseLength(rs.getInt(9));
				courseVO.setTargetStudentNumber(rs.getInt(10));
				courseVO.setFundStartDate(rs.getDate(11));
				courseVO.setFundEndDate(rs.getDate(12));
				courseVO.setCourseStartDate(rs.getDate(13));
				courseVO.setCourseVideopathway(rs.getString(14));
				courseVO.setPaper(rs.getBinaryStream(15));
				courseVO.setStatus(rs.getInt(16));
				courseVO.setCourseContent(rs.getString(17));
				courseVO.setMemberID(rs.getInt(18));
				courseVO.setAvgScore(rs.getDouble(19));
				CourseList.add(courseVO);			
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
		return CourseList;
	}
	
	//顯示所有status3的募資課程
	@Override
	public List<CourseVO> getAllFundRaiseCourse() {
		List<CourseVO> CourseList = new LinkedList<CourseVO>();
		Connection con = null;
		PreparedStatement pstmt = null;
		try{
			con = ds.getConnection();
			pstmt = con.prepareStatement(SELECT_ALL_FUNDRAISE_COURSE);
			ResultSet  rs=pstmt.executeQuery();
			while(rs.next()){
				CourseVO courseVO=new CourseVO();
				courseVO.setCourseID(rs.getInt(1));
				courseVO.setCourseName(rs.getString(2));
				courseVO.setcPhoto(rs.getBinaryStream(3));
				courseVO.setPreTool(rs.getString(4));
				courseVO.setBackground(rs.getString(5));
				courseVO.setAbility(rs.getString(6));
				courseVO.setTargetgroup(rs.getString(7));
				courseVO.setSoldPrice(rs.getInt(8));
				courseVO.setCourseLength(rs.getInt(9));
				courseVO.setTargetStudentNumber(rs.getInt(10));
				courseVO.setFundStartDate(rs.getDate(11));
				courseVO.setFundEndDate(rs.getDate(12));
				courseVO.setCourseStartDate(rs.getDate(13));
				courseVO.setCourseVideopathway(rs.getString(14));
				courseVO.setPaper(rs.getBinaryStream(15));
				courseVO.setStatus(rs.getInt(16));
				courseVO.setCourseContent(rs.getString(17));
				courseVO.setMemberID(rs.getInt(18));
				courseVO.setAvgScore(rs.getDouble(19));
				CourseList.add(courseVO);			
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
		return CourseList;
	}
	
	//顯示所有status2的課程(顯示首頁的熱門課程等....)
	@Override
	public List<CourseVO> getAllonlineCourse() {
		List<CourseVO> CourseList = new LinkedList<CourseVO>();
		Connection con = null;
		PreparedStatement pstmt = null;
		try{
			con = ds.getConnection();
			pstmt = con.prepareStatement(SELECT_ALL_ONLINECourse);
			ResultSet  rs=pstmt.executeQuery();
			while(rs.next()){
				CourseVO courseVO=new CourseVO();
				courseVO.setCourseID(rs.getInt(1));
				courseVO.setCourseName(rs.getString(2));
				courseVO.setcPhoto(rs.getBinaryStream(3));
				courseVO.setPreTool(rs.getString(4));
				courseVO.setBackground(rs.getString(5));
				courseVO.setAbility(rs.getString(6));
				courseVO.setTargetgroup(rs.getString(7));
				courseVO.setSoldPrice(rs.getInt(8));
				courseVO.setCourseLength(rs.getInt(9));
				courseVO.setTargetStudentNumber(rs.getInt(10));
				courseVO.setFundStartDate(rs.getDate(11));
				courseVO.setFundEndDate(rs.getDate(12));
				courseVO.setCourseStartDate(rs.getDate(13));
				courseVO.setCourseVideopathway(rs.getString(14));
				courseVO.setPaper(rs.getBinaryStream(15));
				courseVO.setStatus(rs.getInt(16));
				courseVO.setCourseContent(rs.getString(17));
				courseVO.setMemberID(rs.getInt(18));
				courseVO.setAvgScore(rs.getDouble(19));
				CourseList.add(courseVO);			
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
		return CourseList;
	}

	
	//顯示所有待審核(status1)的課程(顯示首頁的熱門課程等....)
		@Override
		public List<CourseVO> getAllReviewCourse() {
			List<CourseVO> CourseList = new LinkedList<CourseVO>();
			Connection con = null;
			PreparedStatement pstmt = null;
			try{
				con = ds.getConnection();
				pstmt = con.prepareStatement(SELECT_ALL_ReviewCourse);
				ResultSet  rs=pstmt.executeQuery();
				while(rs.next()){
					CourseVO courseVO=new CourseVO();
					courseVO.setCourseID(rs.getInt(1));
					courseVO.setCourseName(rs.getString(2));
					courseVO.setcPhoto(rs.getBinaryStream(3));
					courseVO.setPreTool(rs.getString(4));
					courseVO.setBackground(rs.getString(5));
					courseVO.setAbility(rs.getString(6));
					courseVO.setTargetgroup(rs.getString(7));
					courseVO.setSoldPrice(rs.getInt(8));
					courseVO.setCourseLength(rs.getInt(9));
					courseVO.setTargetStudentNumber(rs.getInt(10));
					courseVO.setFundStartDate(rs.getDate(11));
					courseVO.setFundEndDate(rs.getDate(12));
					courseVO.setCourseStartDate(rs.getDate(13));
					courseVO.setCourseVideopathway(rs.getString(14));
					courseVO.setPaper(rs.getBinaryStream(15));
					courseVO.setStatus(rs.getInt(16));
					courseVO.setCourseContent(rs.getString(17));
					courseVO.setMemberID(rs.getInt(18));
					courseVO.setAvgScore(rs.getDouble(19));
					CourseList.add(courseVO);			
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
			return CourseList;
		}
	
	
}