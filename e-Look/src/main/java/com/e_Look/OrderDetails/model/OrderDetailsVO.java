package com.e_Look.OrderDetails.model;

import java.io.Serializable;

import com.e_Look.Course.CourseVO;
import com.e_Look.Order.model.OrderVO;

public class OrderDetailsVO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private OrderVO orderVO;
	private CourseVO courseVO;
	private Integer buyingPrice;
	private Integer originalPrice;
	public OrderDetailsVO(){
		
	}
	public OrderDetailsVO(OrderVO orderVO, CourseVO courseVO, Integer buyingPrice, Integer originalPrice) {
		this.orderVO = orderVO;
		this.courseVO = courseVO;
		this.buyingPrice = buyingPrice;
		this.originalPrice = originalPrice;
	}


	public OrderVO getOrderVO() {
		return orderVO;
	}
	public void setOrderVO(OrderVO orderVO) {
		this.orderVO = orderVO;
	}
	public CourseVO getCourseVO() {
		return courseVO;
	}
	public void setCourseVO(CourseVO courseVO) {
		this.courseVO = courseVO;
	}
	public Integer getBuyingPrice() {
		return buyingPrice;
	}
	public void setBuyingPrice(Integer buyingPrice) {
		this.buyingPrice = buyingPrice;
	}
	public Integer getOriginalPrice() {
		return originalPrice;
	}
	public void setOriginalPrice(Integer originalPrice) {
		this.originalPrice = originalPrice;
	}
	
	
}
