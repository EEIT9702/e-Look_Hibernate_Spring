package com.e_Look.CourseClassDetails;

import java.util.List;

import com.e_Look.Course.CourseVO;
import com.e_Look.courseClass.CourseClassVO;

public interface CourseClassDetails_interface {
	
	public void insert(CourseVO courseVO, CourseClassVO courseClassVO);
	public void delete(Integer courseID);
	public void update(CourseClassVO courseClassVO, CourseVO courseVO);
	public List<CourseClassDetailsVO> getBycourseClassID(Integer CourseClassID);
	public List<CourseClassDetailsVO> findBycourseID(Integer courseID);
	public List<CourseClassDetailsVO> getAll();
}
