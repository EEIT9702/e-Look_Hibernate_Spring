package com.e_Look.reportMessage.model;

import java.util.List;

public interface ReportMessageDAO_interface {

	public void insert(ReportMessageVO reportMessageVO);
	public void update(ReportMessageVO reportMessageVO);//update status
	public void delete(Integer reportID);
	public ReportMessageVO findByReportId(Integer reportId);
	public List<ReportMessageVO> getNotHandle();
	public List<ReportMessageVO> getAll();
	public String getJSON(Integer status);
}
 