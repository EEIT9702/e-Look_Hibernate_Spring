package com.e_Look.eLookEvent;

import java.util.List;

public class eLookEventService {
private eLookEvent_interface dao;
public eLookEventService() {
	dao=new eLookEventDAO();
}
public eLookEventVO addeLookEvent(String eventName,java.sql.Date eStartDate, java.sql.Date eEndDate,
		Double discount,String courseClass1,String courseClass2,String courseClass3) {

	eLookEventVO eLookEventVO = new eLookEventVO();
	eLookEventVO.setEventName(eventName);
	eLookEventVO.seteStartDate(eStartDate);
	eLookEventVO.seteEndDate(eEndDate);
	eLookEventVO.setDiscount(discount);
	eLookEventVO.setCourseClass1(courseClass1);
	eLookEventVO.setCourseClass2(courseClass2);
	eLookEventVO.setCourseClass3(courseClass3);
	dao.insert(eLookEventVO);

	return eLookEventVO;
}
public eLookEventVO getOneeLookEvent(Integer eventID) {
	return dao.findByPrimaryKey(eventID);
}

public List<eLookEventVO> getAll() {
	return dao.getAll();
}
public void updateeLookEvent(eLookEventVO eLookEventVO) {
	dao.update(eLookEventVO);
}
}
