package com.e_Look.ReportCourse.model;

import com.e_Look.Course.CourseDAO;
import com.e_Look.Course.CourseVO;
import com.e_Look.member.model.MemberService;

public class ReportCourseService {
	private ReportCourseDAO_interface dao;
	public ReportCourseService (){
		dao= new ReportCourseDAO();
	}
	public void insertReportCourse(Integer courseID,Integer memberID,String reportContent){
			ReportCourseVO reportCourseVO = new ReportCourseVO();
			CourseVO courseVO = new CourseVO();
			
			//reportCourseVO.setReportCourseID(courseID);
			courseVO.setCourseID(courseID);
			reportCourseVO.setCourseVO(courseVO);
			
			reportCourseVO.setReportMemberID(memberID);
			reportCourseVO.setReportContent(reportContent);
			dao.insert(reportCourseVO);
	}

	public String getJSON(Integer status) {
		return dao.getJSON(status);
	}
	
	public void discontinuedCourse(Integer reportID,int status) {
		CourseDAO cdao = new CourseDAO();
		ReportCourseVO rcVO = dao.findByReportId(reportID);
		rcVO.setStatus((byte) 1);
		dao.update(rcVO);
		
		Integer memberID = rcVO.getCourseVO().getMemberID();
		
		CourseVO cVO = rcVO.getCourseVO();
		cVO.setStatus(status);
		cdao.updateStatus(cVO);
		
		MemberService mbServ = new MemberService();
		mbServ.updateMemberCount(memberID);
	}
	
	public void jugeCourse(Integer reportID,int status)	{
		ReportCourseVO rcVO = dao.findByReportId(reportID);
		rcVO.setStatus((byte) 2);
		dao.update(rcVO);
	}

}
