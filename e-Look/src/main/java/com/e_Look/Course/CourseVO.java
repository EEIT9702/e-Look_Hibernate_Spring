package com.e_Look.Course;

import java.io.InputStream;
import java.io.Serializable;
import java.sql.Date;

public class CourseVO implements Serializable {
	

	private static final long serialVersionUID = 1L;
	
	private Integer courseID;
	private String courseName;
	private InputStream cPhoto;
	private String preTool;
	private String background;
	private String ability;
	private String targetgroup;
	private Integer soldPrice;
	private Integer courseLength;
	private Integer targetStudentNumber;
	private Date fundStartDate;
	private Date fundEndDate;
	private Date courseStartDate;
	private String courseVideopathway;
	private InputStream paper;
	private Integer status;
	private String courseContent;
	private Integer memberID;
	private Double avgScore;
	
	
	public CourseVO(){
		
	};		

	public CourseVO(Integer courseID, String courseName, String preTool,
			String background, String ability, String targetgroup, Integer soldPrice, Integer courseLength,
			Integer targetStudentNumber, Date fundStartDate, Date fundEndDate, Date courseStartDate,
			String courseContent) {		
		this.courseID = courseID;
		this.courseName = courseName;
		this.preTool = preTool;
		this.background = background;
		this.ability = ability;
		this.targetgroup = targetgroup;
		this.soldPrice = soldPrice;
		this.courseLength = courseLength;
		this.targetStudentNumber = targetStudentNumber;
		this.fundStartDate = fundStartDate;
		this.fundEndDate = fundEndDate;
		this.courseStartDate = courseStartDate;
		this.courseContent = courseContent;
	}



	public Integer getCourseID() {
		return courseID;
	}

	public void setCourseID(Integer courseID) {
		this.courseID = courseID;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}	

	public InputStream getcPhoto() {
		return cPhoto;
	}

	public void setcPhoto(InputStream cPhoto) {
		this.cPhoto = cPhoto;
	}

	public String getPreTool() {
		return preTool;
	}

	public void setPreTool(String preTool) {
		this.preTool = preTool;
	}

	public String getBackground() {
		return background;
	}

	public void setBackground(String background) {
		this.background = background;
	}

	public String getAbility() {
		return ability;
	}

	public void setAbility(String ability) {
		this.ability = ability;
	}

	public String getTargetgroup() {
		return targetgroup;
	}

	public void setTargetgroup(String targetgroup) {
		this.targetgroup = targetgroup;
	}

	public Integer getSoldPrice() {
		return soldPrice;
	}

	public void setSoldPrice(Integer soldPrice) {
		this.soldPrice = soldPrice;
	}

	public Integer getCourseLength() {
		return courseLength;
	}

	public void setCourseLength(Integer courseLength) {
		this.courseLength = courseLength;
	}

	public Integer getTargetStudentNumber() {
		return targetStudentNumber;
	}

	public void setTargetStudentNumber(Integer targetStudentNumber) {
		this.targetStudentNumber = targetStudentNumber;
	}

	public Date getFundStartDate() {
		return fundStartDate;
	}

	public void setFundStartDate(Date fundStartDate) {
		this.fundStartDate = fundStartDate;
	}

	public Date getFundEndDate() {
		return fundEndDate;
	}

	public void setFundEndDate(Date fundEndDate) {
		this.fundEndDate = fundEndDate;
	}

	public Date getCourseStartDate() {
		return courseStartDate;
	}

	public void setCourseStartDate(Date courseStartDate) {
		this.courseStartDate = courseStartDate;
	}



	public InputStream getPaper() {
		return paper;
	}

	public void setPaper(InputStream paper) {
		this.paper = paper;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getCourseContent() {
		return courseContent;
	}

	public void setCourseContent(String courseContent) {
		this.courseContent = courseContent;
	}

	public Integer getMemberID() {
		return memberID;
	}

	public void setMemberID(Integer memberID) {
		this.memberID = memberID;
	}

	public Double getAvgScore() {
		return avgScore;
	}

	public void setAvgScore(Double avgScore) {
		this.avgScore = avgScore;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getCourseVideopathway() {
		return courseVideopathway;
	}

	public void setCourseVideopathway(String courseVideopathway) {
		this.courseVideopathway = courseVideopathway;
	};
	
	
}
