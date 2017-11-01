package com.e_Look.ReportCourse.model;

import java.util.List;

public interface ReportCourseDAO_interface {

	public void insert(ReportCourseVO reportCourseVO);
	public void update(ReportCourseVO reportCourseVO);
	public void delete(Integer reportID);
	public ReportCourseVO findByReportId(Integer reportId);
	public List<ReportCourseVO> getNotHandle(byte status);
	public List<ReportCourseVO> getAll();
	public String getJSON(Integer status);

}
 