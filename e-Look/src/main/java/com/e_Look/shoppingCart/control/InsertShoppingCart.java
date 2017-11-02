package com.e_Look.shoppingCart.control;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.e_Look.Course.CourseDAO;
import com.e_Look.shoppingCart.model.jdbc.ShoppingCartDAO;
import com.e_Look.shoppingCart.model.jdbc.ShoppingCartVO;

/**
 * Servlet implementation class InsertShoppingCart
 */
@WebServlet("/InsertShoppingCart")
public class InsertShoppingCart extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		Integer memberID=Integer.parseInt(request.getParameter("memberID")); 
		Integer courseID=Integer.parseInt(request.getParameter("courseID"));
		
		ShoppingCartDAO scdao = new ShoppingCartDAO();
		CourseDAO cdao = new CourseDAO();
		
		ShoppingCartVO scVO = new ShoppingCartVO(memberID, cdao.findByPrimaryKey(courseID));
		if(scdao.findByPrimaryKey(scVO)==null){
			scdao.insert(scVO);
		}
	}
}
