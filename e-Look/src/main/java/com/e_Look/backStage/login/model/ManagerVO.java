package com.e_Look.backStage.login.model;

import java.io.Serializable;

import javax.print.DocFlavor.STRING;

public class ManagerVO implements Serializable{
	private static final long serialVersionUID = 1L;
	private String managerID;
	private String mPassword;
	public ManagerVO(){}
 


	public ManagerVO(String managerID, String mPassword) {
		super();
		this.managerID = managerID;
		this.mPassword = mPassword;
	}



	public String getmPassword() {
		return mPassword;
	}



	public void setmPassword(String mPassword) {
		this.mPassword = mPassword;
	}



	public String getManagerID() {
		return managerID;
	}



	public void setManagerID(String managerID) {
		this.managerID = managerID;
	}



}
