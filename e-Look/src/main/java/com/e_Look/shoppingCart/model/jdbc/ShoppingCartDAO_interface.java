package com.e_Look.shoppingCart.model.jdbc;

import java.util.List;

import com.e_Look.Course.CourseVO;

public interface ShoppingCartDAO_interface {
	public void insert(ShoppingCartVO shoppingCartVO);
	//deprecated
	public void update(ShoppingCartVO shoppingCartVO,ShoppingCartVO shoppingCartVO2);
	public void delete(ShoppingCartVO shoppingCartVO);
	public ShoppingCartVO findByPrimaryKey(ShoppingCartVO shoppingCartVO);
	public List<CourseVO> findByMemberID(Integer memberID);
	public List<ShoppingCartVO> getAll();
}
