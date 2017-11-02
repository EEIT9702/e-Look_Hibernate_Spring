package com.e_Look.OrderSystem.control;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/TestGetMoney")
public class TestGetMoney extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		OrderSystemService oss = new OrderSystemService();
		Integer money=oss.getMoneyOfMonth(java.sql.Date.valueOf("2017-10-29"), java.sql.Date.valueOf("2017-10-31"));
		
		response.getWriter().write(money.toString());
		
		System.out.println(money);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
