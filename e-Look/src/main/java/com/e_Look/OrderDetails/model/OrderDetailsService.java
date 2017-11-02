package com.e_Look.OrderDetails.model;

import java.util.List;

public class OrderDetailsService {
 private OrderDetailsDAO_interface dao;
	public OrderDetailsService(){
	 dao=new OrderDetailsDAO() ;
 }
	public List<OrderDetailsVO> findByOrderID(Integer orderID){
		return dao.findByOrderID(orderID);
	}
	public List<OrderDetailsVO> findByCourseID(Integer orderID){
		return dao.findByCourseID(orderID);
	}
}
