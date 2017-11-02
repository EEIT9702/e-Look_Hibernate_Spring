package com.e_Look.eLookEvent;

import java.io.Serializable;
import java.sql.Date;

import javax.print.DocFlavor.STRING;
public class eLookEventVO implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private Integer eventID;
	private String eventName;
	private Date eStartDate;
	private Date eEndDate;
	private Double discount;
	private String courseClass1;
	private String courseClass2;
	private String courseClass3;
	public eLookEventVO(){}
	public eLookEventVO(Integer eventID, String eventName,
			Date eStartDate, Date eEndDate,Double discount,String courseClass1,String courseClass2,String courseClass3){
this.eventID=eventID;
this.eventName=eventName;
this.eStartDate=eStartDate;
this.eEndDate=eEndDate;
this.discount=discount;
this.courseClass1=courseClass1;
this.courseClass2=courseClass2;
this.courseClass3=courseClass3;
}

	
	public Integer getEventID() {
		return eventID;
	}
	public void setEventID(Integer eventID) {
		this.eventID = eventID;
	}
	public String getEventName() {
		return eventName;
	}
	public void setEventName(String eventName) {
		this.eventName = eventName;
	}
	public Date geteStartDate() {
		return eStartDate;
	}
	public void seteStartDate(Date eStartDate) {
		this.eStartDate = eStartDate;
	}
	public Date geteEndDate() {
		return eEndDate;
	}
	public void seteEndDate(Date eEndDate) {
		this.eEndDate = eEndDate;
	}
	public String getCourseClass1() {
		return courseClass1;
	}

	public void setCourseClass1(String courseClass1) {
		this.courseClass1 = courseClass1;
	}

	public String getCourseClass2() {
		return courseClass2;
	}

	public void setCourseClass2(String courseClass2) {
		this.courseClass2 = courseClass2;
	}

	public String getCourseClass3() {
		return courseClass3;
	}

	public void setCourseClass3(String courseClass3) {
		this.courseClass3 = courseClass3;
	}

	public Double getDiscount() {
		return discount;
	}
	public void setDiscount(Double discount) {
		this.discount = discount;
	}

	
}
