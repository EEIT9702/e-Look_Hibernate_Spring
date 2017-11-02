package com.e_Look.Order.model;
import java.sql.Date;
import java.util.List;
public interface OrderDAO_interface {
public void insert(OrderVO OrderVO);
public void update(OrderVO OrderVO);
public void delete(Integer orderID);
public OrderVO findMemberUncheckOrder(Integer memberID);
public OrderVO findByPrimaryKey(Integer orderID);
public List<OrderVO> getAll();
public List<OrderVO> getMemberAllOrder(Integer memberID);
public List<OrderVO> getOrderByDate(Date sDate, Date eDate);
}
