package com.e_Look.backStage.login.model;

public class ManagerService {
private ManagerDAO_interface dao;

public ManagerService() {
	dao=new ManagerDAO();
}

public ManagerVO findByManagerID(String managerID) {
	return dao.findByManagerID(managerID);
}


}
