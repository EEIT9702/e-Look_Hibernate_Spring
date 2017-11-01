package com.e_Look.eLookEvent;

import java.util.List;



public interface eLookEvent_interface {

	public void insert(eLookEventVO eLookEventVO);
	public void delete(Integer eventID);
	public void update(eLookEventVO eLookEventVO);
	public eLookEventVO  findByPrimaryKey(Integer eventID);
	public List<eLookEventVO> getAll(); 
	
}
