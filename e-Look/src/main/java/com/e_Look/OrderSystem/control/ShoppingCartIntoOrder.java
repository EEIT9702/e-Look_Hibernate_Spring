package com.e_Look.OrderSystem.control;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.e_Look.Course.CourseVO;
import com.e_Look.Order.model.OrderDAO;
import com.e_Look.Order.model.OrderVO;
import com.e_Look.OrderDetails.model.OrderDetailsDAO;
import com.e_Look.OrderDetails.model.OrderDetailsVO;
import com.e_Look.member.model.MemberVO;
import com.e_Look.shoppingCart.model.jdbc.ShoppingCartDAO;
import com.e_Look.shoppingCart.model.jdbc.ShoppingCartVO;

@WebServlet("/ShoppingCartIntoOrder")
public class ShoppingCartIntoOrder extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter rw = response.getWriter();
		
		ShoppingCartDAO scdao = new ShoppingCartDAO();
		OrderDAO orderDAO = new OrderDAO();
		OrderDetailsDAO odDAO=new OrderDetailsDAO();
		
		
		HttpSession session = request.getSession();
		MemberVO memberVO=(MemberVO) session.getAttribute("LoginOK");
		Integer memberID = memberVO.getMemberID();
		
		
		OrderVO orderVO = orderDAO.findMemberUncheckOrder(memberID);
		List<CourseVO> list = scdao.findByMemberID(memberID);
		if(orderVO==null && list.size()==0){
			rw.write("<script>alert('請先選購商品'); location.href='"+request.getHeader("Referer")+"'</script>");
			return;
		}else{
			if(orderVO==null){
				orderVO=new OrderVO();
				orderVO.setMemberID(memberID);
				orderDAO.insert(orderVO);
				orderVO=orderDAO.findMemberUncheckOrder(memberID);
			}
				for(CourseVO courseVO:list){
					ShoppingCartVO scVO = new ShoppingCartVO(memberID, courseVO);
					scdao.delete(scVO);
					OrderDetailsVO odVO=new OrderDetailsVO();
					odVO.setCourseVO(courseVO);
					odVO.setOrderVO(orderVO);
					odVO.setOriginalPrice(courseVO.getSoldPrice());
					//記得調整成特價後的價格
					odVO.setBuyingPrice(courseVO.getSoldPrice());
					
					odDAO.insert(odVO);
				}
				response.sendRedirect(request.getContextPath()+"/settled/settled.jsp");
				return;
				
		}
		
		
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
