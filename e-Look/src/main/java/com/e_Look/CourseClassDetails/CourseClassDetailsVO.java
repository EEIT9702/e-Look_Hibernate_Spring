package com.e_Look.CourseClassDetails;

import java.io.Serializable;
import com.e_Look.courseClass.CourseClassVO;
import com.e_Look.Course.CourseVO;
public class CourseClassDetailsVO  implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private String courseName;
	private String ccName;
	private CourseClassVO courseClassVO;
	private CourseVO courseVO;
	
	public CourseClassDetailsVO(){}
	public CourseClassDetailsVO( CourseVO courseVO,CourseClassVO courseClassVO){
		this.courseClassVO=courseClassVO;
		this.courseVO=courseVO;
		
	}
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	public String getCcName() {
		return ccName;
	}
	public void setCcName(String ccName) {
		this.ccName = ccName;
	}
	public CourseClassVO getCourseClassVO() {
		return courseClassVO;
	}
	public void setCourseClassVO(CourseClassVO courseClassVO) {
		this.courseClassVO = courseClassVO;
	}
	public CourseVO getCourseVO() {
		return courseVO;
	}
	public void setCourseVO(CourseVO courseVO) {
		this.courseVO = courseVO;
	}
	
	

	
}
