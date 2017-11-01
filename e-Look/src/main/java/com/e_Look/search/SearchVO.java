package com.e_Look.search;

import java.io.Serializable;
import java.sql.Date;

public class SearchVO implements Serializable {
	private static final long serialVersionUID = 1L;
	private String keyWord;
	private Date enterTime;
	public SearchVO(){
	}
	public SearchVO(String keyWord,Date enterTime){
		this.keyWord = keyWord;
		this.enterTime = enterTime;
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
}

	