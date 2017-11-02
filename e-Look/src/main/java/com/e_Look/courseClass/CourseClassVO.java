package com.e_Look.courseClass;

import java.io.Serializable;

import com.e_Look.eLookEvent.eLookEventVO;

public class CourseClassVO  implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private Integer CourseClassID;
	private String ccName;
	//private Integer eventID;
	private eLookEventVO eventVO;
	public CourseClassVO(){}
	public CourseClassVO(Integer CourseClassID, String ccName, eLookEventVO eventVO) {
		this.CourseClassID = CourseClassID;
		this.ccName = ccName;
		this.eventVO = eventVO;
		
	}
	
	public Integer getCourseClassID() {
		return CourseClassID;
	}
	
	public void setCourseClassID(Integer courseClassID) {
		CourseClassID = courseClassID;
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
