package com.e_Look.member.control;

import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.e_Look.Order.model.OrderService;
import com.e_Look.Order.model.OrderVO;
import com.e_Look.OrderDetails.model.OrderDetailsService;
import com.e_Look.OrderDetails.model.OrderDetailsVO;

import net.minidev.json.JSONValue;

/**
 * Servlet implementation class MemberConsumeController
 */
@WebServlet("/MemberConsumeController")
public class MemberConsumeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		 String  memberID=request.getParameter("MemberID");
		 OrderService orderService=new OrderService();
		 OrderDetailsService orderDetailsService=new OrderDetailsService();
		 List<OrderVO>  list=orderService.getMemberOrder(Integer.valueOf(memberID));
		 List< List<OrderDetailsVO>> OrderDetailsVOlist = new LinkedList< List<OrderDetailsVO>>();
		 for(OrderVO OrderVO :list){
			 List<OrderDetailsVO>  list2=orderDetailsService.findByOrderID(OrderVO.getOrderID());
			 OrderDetailsVOlist.add(list2);
		 }
		 Map<String,List> map=new LinkedHashMap<String,List>();
		 map.put("order", list);
		 map.put("OrderDetails", OrderDetailsVOlist);
		 //String OrderVOJson1= JSONValue.toJSONString(OrderDetailsVOlist);
		 //String OrderVOJson2= JSONValue.toJSONString(list);
		String OrderVOJson= JSONValue.toJSONString(map);
		 response.getWriter().println(OrderVOJson);
		 //response.getWriter().println(OrderVOJson2);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
