package com.e_Look.message.model;

import java.io.Serializable;
import java.sql.Timestamp;

import com.e_Look.member.model.MemberVO;

public class MessageVO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Integer messageID;
	private String mContent;
	private Timestamp mTime;
	private Integer messageID_response;
	private MemberVO memberVO;
	private Integer courseID;
	private Long bought;
	private Byte status;
	
	public MessageVO(){}
	

	public MessageVO(Integer messageID,String mContent,Timestamp mTime, Integer messageID_response, MemberVO memberVO,
			Integer courseID, Long bought, Byte status) {
		this.messageID = messageID;
		this.mContent = mContent;
		this.mTime = mTime;
		this.messageID_response = messageID_response;
		this.memberVO = memberVO;
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

	public MemberVO getMemberVO() {
		return memberVO;
	}

	public void setMemberVO(MemberVO memberVO) {
		this.memberVO = memberVO;
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


//	@Override
//	public String toString() {
//		return "MessageVO [messageID=" + messageID + ", mContent=" + mContent + ", mTime=" + mTime
//				+ ", messageID_response=" + messageID_response + ", memberID=" + memberID + ", courseID=" + courseID
//				+ ", bought=" + bought + ", status=" + status + "]";
//	};
	
	
}
