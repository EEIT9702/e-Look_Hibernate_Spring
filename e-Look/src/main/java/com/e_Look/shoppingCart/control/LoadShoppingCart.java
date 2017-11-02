package com.e_Look.shoppingCart.control;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.e_Look.Course.CourseVO;
import com.e_Look.shoppingCart.model.jdbc.*;

import net.minidev.json.JSONValue;

/**
 * Servlet implementation class LoadShoppingCart
 */
@WebServlet("/LoadShoppingCart")
public class LoadShoppingCart extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("不合法的請求");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try{
			//刪購物車
			Integer courseID = Integer.parseInt(request.getParameter("courseID"));
			Integer memberID = Integer.parseInt(request.getParameter("memberID"));
			ShoppingCartDAO dao = new ShoppingCartDAO();
			ShoppingCartVO shoppingCartVO=new ShoppingCartVO();
			CourseVO courseVO=new CourseVO();
			
			courseVO.setCourseID(courseID);
			shoppingCartVO.setMemberID(memberID);
			shoppingCartVO.setCourseVO(courseVO);
			dao.delete(shoppingCartVO);
			System.out.println("會員："+memberID+",刪除了購物車中的課程："+courseID);
		}catch(NumberFormatException e){
			//載入購物車
			Integer memberID = Integer.parseInt(request.getParameter("memberID"));
			response.setCharacterEncoding("UTF-8");
			ShoppingCartDAO dao = new ShoppingCartDAO();
			List<CourseVO> courseVOs = dao.findByMemberID(memberID);
			String jsonString = JSONValue.toJSONString(courseVOs);  
			PrintWriter rw = response.getWriter();
			rw.print(jsonString);
			rw.close();
			
		}
		
		
	}

}
