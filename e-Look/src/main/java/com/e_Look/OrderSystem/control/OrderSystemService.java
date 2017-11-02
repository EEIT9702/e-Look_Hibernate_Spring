package com.e_Look.OrderSystem.control;

import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.sql.Date;
import java.util.List;

import com.e_Look.Course.CourseVO;
import com.e_Look.CourseClassDetails.CourseClassDetailsDAO;
import com.e_Look.CourseClassDetails.CourseClassDetailsVO;
import com.e_Look.CourseClassDetails.CourseClassDetails_interface;
import com.e_Look.Order.model.*;
import com.e_Look.OrderDetails.model.*;
import com.e_Look.buyCourse.model.*;
import com.e_Look.courseClass.CourseClassDAO;
import com.e_Look.courseClass.CourseClassVO;
import com.e_Look.courseClass.CourseClass_interface;
import com.e_Look.tool.BuyingPrice;

import allPay.payment.integration.AllInOne;
import allPay.payment.integration.domain.AioCheckOutOneTime;

public class OrderSystemService {
	private OrderDAO_interface orderDAO;
	private OrderDetailsDAO_interface orderDetailsDAO;
	private BuyCourseDAO_interface buyCourseDAO;
	private CourseClass_interface courseClassDAO;
	private CourseClassDetails_interface courseClassDetailsDAO;
	
	public static AllInOne all;

	public OrderSystemService() {
		orderDAO = new OrderDAO();
		orderDetailsDAO = new OrderDetailsDAO();
		buyCourseDAO = new BuyCourseDAO();
		courseClassDAO =new CourseClassDAO();
		courseClassDetailsDAO = new CourseClassDetailsDAO();
	}

	public void refreshOrderBuyingPrice(Integer memberID) {
		OrderVO orderVO = orderDAO.findMemberUncheckOrder(memberID);
		List<OrderDetailsVO> orderDetailsVOs = orderDetailsDAO.findByOrderID(orderVO.getOrderID());
		for (OrderDetailsVO orderDetailsVO : orderDetailsVOs) {
			Integer buyingPrice = BuyingPrice.getBuyingPrice(orderDetailsVO.getCourseVO().getCourseID());
			orderDetailsVO.setBuyingPrice(buyingPrice);
			orderDetailsDAO.update(orderDetailsVO);
		}
	}

	public String getOPay(OrderVO orderVO) throws UnsupportedEncodingException {
		String totalBuyingPrice = getOrderTotalBuyingPrice(orderVO).toString();
		String courseName = getCourseName(orderVO);

		all = new AllInOne("");// 實體化(new) AllInOne類別參數內可放置log4j.properties的位置路徑
		AioCheckOutOneTime oPayObj = new AioCheckOutOneTime();

		SimpleDateFormat sfdForNo = new SimpleDateFormat("yyyyMMddHHmmss");
		SimpleDateFormat sdfForDate = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		java.util.Date now = new java.util.Date();

		String merchantTradeNo = sfdForNo.format(now);
		String oPayDate = sdfForDate.format(now);

		oPayObj.setMerchantTradeNo(merchantTradeNo + "o");
		oPayObj.setItemName(courseName);
		oPayObj.setMerchantTradeDate(oPayDate);
		oPayObj.setTotalAmount(totalBuyingPrice);
		oPayObj.setTradeDesc("感謝您的購買!");
		oPayObj.setReturnURL("http://211.23.128.214:5000");
		oPayObj.setClientBackURL("http://localhost:8081/e-Look/OrderFinishController");
		oPayObj.setNeedExtraPaidInfo("N");
		oPayObj.setHoldTradeAMT("0");
		oPayObj.setUseRedeem("N");
		oPayObj.setRedeem("Y");
		String form = all.aioCheckOut(oPayObj, null);
		return form;
	}

	public Integer getOrderTotalBuyingPrice(OrderVO orderVO) {
		refreshOrderBuyingPrice(orderVO.getMemberID());
		List<OrderDetailsVO> orderDetailsVOs = orderDetailsDAO.findByOrderID(orderVO.getOrderID());
		Integer totalBuyingPrice = null;
		if (orderDetailsVOs.size() != 0) {
			totalBuyingPrice = 0;
			for (OrderDetailsVO orderDetailsVO : orderDetailsVOs) {
				Integer buyingPrice = orderDetailsVO.getBuyingPrice();
				totalBuyingPrice += buyingPrice;
			}
		}
		return totalBuyingPrice;
	}

	public String getCourseName(OrderVO orderVO) {
		List<OrderDetailsVO> orderDetailsVOs = orderDetailsDAO.findByOrderID(orderVO.getOrderID());
		String courseNames = null;
		if (orderDetailsVOs.size() != 0) {
			courseNames = "";
			for (OrderDetailsVO orderDetailsVO : orderDetailsVOs) {
				String courseName = orderDetailsVO.getCourseVO().getCourseName();
				courseNames += courseName + "#";
			}
			courseNames = courseNames.substring(0, courseNames.length() - 1);
		}
		return courseNames;
	}

	public void setOrderFinish(OrderVO orderVO) {
		orderVO.setOrderTime(new java.sql.Date(System.currentTimeMillis()));
		orderDAO.update(orderVO);
		List<OrderDetailsVO> orderDetailVOs = orderDetailsDAO.findByOrderID(orderVO.getOrderID());
		for (OrderDetailsVO orderDetailVO : orderDetailVOs) {
			BuyCourseVO bcVO = new BuyCourseVO();
			bcVO.setMemberID(orderVO.getMemberID());
			bcVO.setCourseID(orderDetailVO.getCourseVO().getCourseID());
			buyCourseDAO.insert(bcVO);
		}
	}
	
	public Integer getMoneyOfMonth(Date sDate,Date eDate){
		Integer sumMoney = 0;
		List<OrderVO> orderVOs = orderDAO.getOrderByDate(sDate, eDate);
		for(OrderVO orderVO:orderVOs){
			List<OrderDetailsVO> orderDetailsVOs = orderDetailsDAO.findByOrderID(orderVO.getOrderID());
			for(OrderDetailsVO orderDetailsVO:orderDetailsVOs){
				sumMoney+=orderDetailsVO.getBuyingPrice();
			}
		}
		return sumMoney;
	}
	public Integer[] getMoneyOfCourseClass(){
		List<CourseClassVO> ccVOs = courseClassDAO.getAll();
		Integer[] cMoney = new Integer[ccVOs.size()];
		int count = 0;
		for(CourseClassVO ccVO:ccVOs){
			List<CourseClassDetailsVO> ccdVOs = courseClassDetailsDAO.getBycourseClassID(ccVO.getCourseClassID());
			Integer money = 0;
			for(CourseClassDetailsVO ccdVO:ccdVOs){
				List<OrderDetailsVO> orderDetailsVOs = orderDetailsDAO.findByCourseID(ccdVO.getCourseVO().getCourseID());
				for(OrderDetailsVO orderDetailsVO:orderDetailsVOs){
					if(orderDetailsVO.getOrderVO().getOrderTime()!=null){
						money+=orderDetailsVO.getBuyingPrice();
					}
				}
			}
			cMoney[count]=money;
			count++;
		}
		return cMoney;
	}
}
