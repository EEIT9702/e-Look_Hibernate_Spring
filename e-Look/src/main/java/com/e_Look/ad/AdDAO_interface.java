package com.e_Look.ad;

import java.util.List;

public interface AdDAO_interface {
	
	public void insert(AdVO adVO);
	public void update(AdVO adVO);
	public void updateStatus(Byte status, Integer adID);
	public void delete(Integer adID);
	public AdVO findByAdID(Integer adID);
	public List<AdVO> getAll();
	public List<AdVO> findByStatus();
	
}
