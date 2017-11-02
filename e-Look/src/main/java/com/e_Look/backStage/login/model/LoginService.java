package com.e_Look.backStage.login.model;

public class LoginService {
private Login_interface dao;

public LoginService() {
	dao=new LoginDAO();
}

public LoginVO findByManagerID(String managerID) {
	return dao.findByManagerID(managerID);
}


}
