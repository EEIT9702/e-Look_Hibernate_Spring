package com.e_Look.memberBookmarks.model;

import java.io.Serializable;

public class MemberBookmarksVO implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private Integer memberID;
	private Integer courseID;
	public MemberBookmarksVO(){}
	
	public MemberBookmarksVO(Integer memberID, Integer courseID){
		this.memberID = memberID;
		this.courseID = courseID;
	}

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

}
