package com.e_Look.search;

import java.sql.Date;
import java.util.List;

public interface SearchDAO_interface {
	
	public void insert(SearchVO searchVO);
	public void update(SearchVO oldSearchVO,SearchVO newSearchVO);
	public void delete(SearchVO searchVO);
	public void dateDelete(Date date);
	public List<SearchVO> getAll();
}
