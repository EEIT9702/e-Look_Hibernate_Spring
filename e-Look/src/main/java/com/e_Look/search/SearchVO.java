package com.e_Look.search;

import java.io.Serializable;
import java.sql.Date;

public class SearchVO implements Serializable {
	private static final long serialVersionUID = 1L;
	private String keyWord;
	private Date enterTime;
	private Integer searchID;
	public SearchVO(){
	}
	public SearchVO(String keyWord,Date enterTime,Integer searchID){
		this.keyWord = keyWord;
		this.enterTime = enterTime;
		this.searchID = searchID;
	}	
	
	public String getKeyWord() {
		return keyWord;
	}
	public void setKeyWord(String keyWord) {
		this.keyWord = keyWord;
	}
	public Date getEnterTime() {
		return enterTime;
	}
	public void setEnterTime(Date enterTime) {
		this.enterTime = enterTime;
	}
	public Integer getSearchID() {
		return searchID;
	}
	public void setSearchID(Integer searchID) {
		this.searchID = searchID;
	}
}

	