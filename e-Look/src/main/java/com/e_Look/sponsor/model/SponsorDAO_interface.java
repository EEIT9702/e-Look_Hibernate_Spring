package com.e_Look.sponsor.model;

import java.util.List;

public interface SponsorDAO_interface {
	
	public void insert(SponsorVO sponsorVO);
	public void update(SponsorVO sponsorVO);
	public void delete(Integer courseID);
	public SponsorVO findByCourseID(Integer courseID);
	public List<SponsorVO>getCountMoney(Integer courseID);
	public List<SponsorVO>getAll();
	

}
