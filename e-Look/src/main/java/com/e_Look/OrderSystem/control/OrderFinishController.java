package com.e_Look.OrderSystem.control;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.e_Look.Order.model.OrderVO;

@WebServlet("/OrderFinishController")
public class OrderFinishController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		if(request.getSession().getAttribute("orderVO")!=null){
			doPost(request, response);
		}else{
			response.sendRedirect(request.getContextPath());
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		OrderVO orderVO = (OrderVO) session.getAttribute("orderVO");
		
		OrderSystemService oss = new OrderSystemService();
		oss.setOrderFinish(orderVO);
		
		session.removeAttribute("orderVO");
		response.sendRedirect(request.getContextPath()+"/member/member.jsp");

		
	}

}
