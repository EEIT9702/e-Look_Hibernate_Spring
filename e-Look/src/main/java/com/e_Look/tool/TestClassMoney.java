package com.e_Look.tool;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.e_Look.OrderSystem.control.OrderSystemService;

import net.minidev.json.JSONValue;

/**
 * Servlet implementation class TestClassMoney
 */
@WebServlet("/TestClassMoney")
public class TestClassMoney extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		OrderSystemService oss = new OrderSystemService();
		Integer[] mm=oss.getMoneyOfCourseClass();
		
		for(int i = 0 ; i<mm.length;i++){
//			System.out.println(mm[i]);
		}
		String xxx = JSONValue.toJSONString(mm);
		
		response.getWriter().write(xxx);
		System.out.println(xxx);
	}
	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
