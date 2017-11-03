package com.e_Look.courseClass;

import java.io.Serializable;

import com.e_Look.eLookEvent.eLookEventVO;

public class CourseClassVO  implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private Integer courseClassID;
	private String ccName;
	private eLookEventVO eventVO;
	
	public CourseClassVO(){}
	public CourseClassVO(Integer courseClassID, String ccName, eLookEventVO eventVO) {
		this.courseClassID = courseClassID;
		this.ccName = ccName;
		this.eventVO = eventVO;
		
	}
	
	public Integer getCourseClassID() {
		return courseClassID;
	}
	
	public void setCourseClassID(Integer courseClassID) {
		this.courseClassID = courseClassID;
	}
	
	public String getCcName() {
		return ccName;
	}
	
	public void setCcName(String ccName) {
		this.ccName = ccName;
	}
	
	public eLookEventVO getEventVO() {
		return eventVO;
	}
	
	public void setEventVO(eLookEventVO eventVO) {
		this.eventVO = eventVO;
	}

}
