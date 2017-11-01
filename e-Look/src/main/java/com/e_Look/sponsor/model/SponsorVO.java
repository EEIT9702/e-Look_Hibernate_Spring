package com.e_Look.sponsor.model;

import java.io.Serializable;
import java.sql.Date;

public class SponsorVO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Integer courseID;
	private String SponsorName;
	private Integer money;
	private Date dateSponsor;
	public SponsorVO() {};
	
	public SponsorVO(Integer courseID, String SponsorName, Integer money,Date dateSponsor) {
		this.courseID = courseID;
		this.SponsorName = SponsorName;
		this.money = money;
		this.dateSponsor=dateSponsor;
	}
	
	public Integer getCourseID() {
		return courseID;
	}

	public void setCourseID(Integer courseID) {
		this.courseID = courseID;
	}

	public String getSponsorName() {
		return SponsorName;
	}

	public void setSponsorName(String sponsorName) {
		SponsorName = sponsorName;
	}

	public Integer getMoney() {
		return money;
	}

	public void setMoney(Integer money) {
		this.money = money;
	}

	public Date getDateSponsor() {
		return dateSponsor;
	}

	public void setDateSponsor(Date dateSponsor) {
		this.dateSponsor = dateSponsor;
	}

}
