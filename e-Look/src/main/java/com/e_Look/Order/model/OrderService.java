package com.e_Look.Order.model;

import java.util.List;

public class OrderService {
	private OrderDAO_interface dao;
	public OrderService() {
		dao=new OrderDAO();
	}
	public List<OrderVO> getMemberOrder(Integer memberID){
		return dao.getMemberAllOrder(memberID);
	}
}
