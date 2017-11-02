package com.e_Look.shoppingCart.model.jdbc;

import java.io.Serializable;

import com.e_Look.Course.CourseVO;

public class ShoppingCartVO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Integer memberID;
	private CourseVO courseVO;
	public ShoppingCartVO(Integer memberID, CourseVO courseVO) {
		this.memberID = memberID;
		this.courseVO = courseVO;
	}
	public ShoppingCartVO() {
	}
	
	
	public Integer getMemberID() {
		return memberID;
	}
	public void setMemberID(Integer memberID) {
		this.memberID = memberID;
	}
	public CourseVO getCourseVO() {
		return courseVO;
	}
	public void setCourseVO(CourseVO courseVO) {
		this.courseVO = courseVO;
	}




}
