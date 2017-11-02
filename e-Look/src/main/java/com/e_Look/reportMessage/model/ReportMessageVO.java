package com.e_Look.reportMessage.model;

import java.io.Serializable;
import java.sql.Date;

import com.e_Look.message.model.MessageVO;

public class ReportMessageVO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Integer reportId;
	//private Integer reportMessageId;
	private MessageVO messageVO;
	private Integer reportMemberID;
	private String reportContent;
	private Date reportTime;
	private Byte status;
	public ReportMessageVO(){};
	
	public ReportMessageVO(Integer reportId, MessageVO messageVO, Integer reportMemberID,
			String reportContent, Date reportTime, Byte status){
		this.reportId = reportId;
		this.messageVO = messageVO;
		this.reportMemberID = reportMemberID;
		this.reportContent = reportContent;
		this.reportTime = reportTime;
		this.status = status;
	};
	
	public Integer getReportId() {
		return reportId;
	}
	public void setReportId(Integer reportId) {
		this.reportId = reportId;
	}
	public MessageVO getMessageVO() {
		return messageVO;
	}
	public void setMessageVO(MessageVO messageVO) {
		this.messageVO = messageVO;
	}
	public Integer getReportMemberID() {
		return reportMemberID;
	}
	public void setReportMemberID(Integer reportMemberID) {
		this.reportMemberID = reportMemberID;
	}
	public String getReportContent() {
		return reportContent;
	}
	public void setReportContent(String reportContent) {
		this.reportContent = reportContent;
	}
	public Date getReportTime() {
		return reportTime;
	}
	public void setReportTime(Date reportTime) {
		this.reportTime = reportTime;
	}
	public Byte getStatus() {
		return status;
	}
	public void setStatus(Byte status) {
		this.status = status;
	}
}
