package com.e_Look.message.model;

import java.io.Serializable;
import java.io.InputStream;
import java.sql.Date;
import java.sql.Timestamp;

public class MessageVO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Integer messageID;
	private String mContent;
	private Timestamp mTime;
	private Integer messageID_response;
	private Integer memberID;
	private Integer courseID;
	private Long bought;
	private Byte status;
	
	public MessageVO(){}
	

	public MessageVO(Integer messageID,String mContent,Timestamp mTime, Integer messageID_response, Integer memberID,
			Integer courseID, Long bought, Byte status) {
		this.messageID = messageID;
		this.mContent = mContent;
		this.mTime = mTime;
		this.messageID_response = messageID_response;
		this.memberID = memberID;
		this.courseID = courseID;
		this.bought = bought;
		this.status = status;
	}


	public Integer getMessageID() {
		return messageID;
	}

	public void setMessageID(Integer messageID) {
		this.messageID = messageID;
	}

	public String getmContent() {
		return mContent;
	}

	public void setmContent(String mContent) {
		this.mContent = mContent;
	}

	public Timestamp getmTime() {
		return mTime;
	}

	public void setmTime(Timestamp mTime) {
		this.mTime = mTime;
	}

	public Integer getMessageID_response() {
		return messageID_response;
	}

	public void setMessageID_response(Integer messageID_response) {
		this.messageID_response = messageID_response;
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

	public Long getBought() {
		return bought;
	}

	public void setBought(Long bought) {
		this.bought = bought;
	}

	public Byte getStatus() {
		return status;
	}

	public void setStatus(Byte status) {
		this.status = status;
	}


	@Override
	public String toString() {
		return "MessageVO [messageID=" + messageID + ", mContent=" + mContent + ", mTime=" + mTime
				+ ", messageID_response=" + messageID_response + ", memberID=" + memberID + ", courseID=" + courseID
				+ ", bought=" + bought + ", status=" + status + "]";
	};
	
	
}
