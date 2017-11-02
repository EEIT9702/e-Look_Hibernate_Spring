package com.e_Look.OrderSystem.control;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.mail.Session;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.e_Look.Course.CourseDAO;
import com.e_Look.Course.CourseVO;
import com.e_Look.Order.model.OrderDAO;
import com.e_Look.Order.model.OrderVO;
import com.e_Look.OrderDetails.model.OrderDetailsDAO;
import com.e_Look.OrderDetails.model.OrderDetailsVO;
import com.e_Look.member.model.MemberVO;
import com.e_Look.tool.BuyingPrice;

import net.minidev.json.JSONValue;

@WebServlet("/OrderEdit")
public class OrderEdit extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter rw = response.getWriter();
		HttpSession session=request.getSession();
		MemberVO memberVO=(MemberVO) session.getAttribute("LoginOK");
		
		String action=request.getParameter("action");
		CourseDAO cdao=new CourseDAO();
		OrderDAO odao=new OrderDAO();
		OrderDetailsDAO oddao = new OrderDetailsDAO();
		OrderVO orderVO = odao.findMemberUncheckOrder(memberVO.getMemberID());
		if("loading".equals(action)){
			List<OrderDetailsVO> odVOs= oddao.findByOrderID(orderVO.getOrderID());
			for(OrderDetailsVO odVO:odVOs){
				odVO.setBuyingPrice(BuyingPrice.getBuyingPrice(odVO.getCourseVO().getCourseID()));
				oddao.update(odVO);
			}
			
			String jsonString = JSONValue.toJSONString(oddao.findByOrderID(orderVO.getOrderID()));  
			response.getWriter().print(jsonString);
		}else{
			Integer courseID=Integer.parseInt(request.getParameter("courseID"));
			CourseVO courseVO=cdao.findByPrimaryKey(courseID);
			OrderDetailsVO odVO = new OrderDetailsVO(orderVO,courseVO , BuyingPrice.getBuyingPrice(courseID), courseVO.getSoldPrice());
			oddao.delete(odVO);
		}
		
		
	}

}
