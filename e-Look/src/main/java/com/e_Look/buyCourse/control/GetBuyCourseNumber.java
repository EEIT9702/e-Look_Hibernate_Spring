package com.e_Look.buyCourse.control;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.e_Look.buyCourse.model.BuyCourseDAO;
import com.e_Look.buyCourse.model.BuyCourseVO;

import net.minidev.json.JSONValue;

/**
 * Servlet implementation class GetBuyCourseNumber
 */
@WebServlet("/GetBuyCourseNumber")
public class GetBuyCourseNumber extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		BuyCourseDAO dao=new BuyCourseDAO();
		List<BuyCourseVO>  list=dao.getByCourseID(Integer.valueOf(request.getParameter("courseID")));
		String OrderVOJson= JSONValue.toJSONString(list);
		response.getWriter().println(OrderVOJson);
		
	}

}
