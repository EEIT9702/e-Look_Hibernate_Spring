package com.e_Look.courseClass;

import java.util.List;

public interface CourseClass_interface {
	
	public void insert(CourseClassVO courseClassVO);
	public void delete(Integer CourseClassID);
	public void update(CourseClassVO courseClassVO);
	public CourseClassVO  getByCourseClassID(Integer CourseClassID);
	public List<CourseClassVO> getByEventID(Integer eventID);
	public List<CourseClassVO> getAll();
}
