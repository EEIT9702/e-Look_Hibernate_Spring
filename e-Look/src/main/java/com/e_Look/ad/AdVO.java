package com.e_Look.ad;

import java.io.InputStream;
import java.io.Serializable;

public class AdVO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Integer adID;
	private String fileName;
	private InputStream adFile;
	private Byte status;
	public AdVO(){}
	
	public AdVO(Integer adID, String fileName, InputStream adFile, Byte status){
		this.adID = adID;
		this.fileName = fileName;
		this.adFile = adFile;
		this.status = status;
	}
	
	
	public Integer getAdID() {
		return adID;
	}
	public void setAdID(Integer adID) {
		this.adID = adID;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public InputStream getAdFile() {
		return adFile;
	}
	public void setAdFile(InputStream adFile) {
		this.adFile = adFile;
	}
	public Byte getStatus() {
		return status;
	}
	public void setStatus(Byte status) {
		this.status = status;
	}
}
