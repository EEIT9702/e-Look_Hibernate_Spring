package com.e_Look.ReportCourse.model;

import java.io.Serializable;
import java.sql.Date;

import com.e_Look.Course.CourseVO;

public class ReportCourseVO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Integer reportId;
	//private Integer reportCourseID;
	private CourseVO courseVO;
	private Integer reportMemberID;
	private String reportContent;
	private Date reportTime;
	private Byte status;
	public ReportCourseVO(){}
	public ReportCourseVO(Integer reportId,CourseVO courseVO,Integer reportMemberID,
			String reportContent, Date reportTime, Byte status){
		this.reportId = reportId;
		this.courseVO = courseVO;
		this.reportMemberID = reportMemberID;
		this.reportContent = reportContent;
		this.reportTime = reportTime;
		this.status = status;
	};
	
	public Integer getReportId() {
		return reportId;
	}
	public void setReportId(Integer reportId) {
		this.reportId = reportId;
	}

	public CourseVO getCourseVO() {
		return courseVO;
	}

	public void setCourseVO(CourseVO courseVO) {
		this.courseVO = courseVO;
	}

	public Integer getReportMemberID() {
		return reportMemberID;
	}
	public void setReportMemberID(Integer reportMemberID) {
		this.reportMemberID = reportMemberID;
	}
	public String getReportContent() {
		return reportContent;
	}
	public void setReportContent(String reportContent) {
		this.reportContent = reportContent;
	}
	public Date getReportTime() {
		return reportTime;
	}
	public void setReportTime(Date reportTime) {
		this.reportTime = reportTime;
	}
	public Byte getStatus() {
		return status;
	}
	public void setStatus(Byte status) {
		this.status = status;
	}
}
