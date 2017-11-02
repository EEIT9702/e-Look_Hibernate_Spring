package com.e_Look.OrderDetails.model;

import java.util.List;


public interface OrderDetailsDAO_interface {
	public void insert(OrderDetailsVO orderDetailsVO);
	public void update(OrderDetailsVO orderDetailsVO);
	public void delete(OrderDetailsVO orderDetailsVO);
	public OrderDetailsVO findByPrimaryKey(OrderDetailsVO orderDetailsVO);
	public List<OrderDetailsVO> findByCourseID(Integer courseID);
	public List<OrderDetailsVO> findByOrderID(Integer orderID);
	public List<OrderDetailsVO> getAll();
}
