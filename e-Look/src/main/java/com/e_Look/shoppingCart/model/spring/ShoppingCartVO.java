package com.e_Look.shoppingCart.model.spring;

import java.io.Serializable;

import com.e_Look.Course.CourseVO;

public class ShoppingCartVO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Integer memberID;
	private Integer courseID;
	public Integer getMemberID() {
		return memberID;
	}
	public void setMemberID(Integer memberID) {
		this.memberID = memberID;
	}
	public Integer getCourseID() {
		return courseID;
	}
	public void setCourseID(Integer courseID) {
		this.courseID = courseID;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}



}
