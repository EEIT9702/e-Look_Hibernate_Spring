package com.e_Look.buyCourse.control;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.e_Look.buyCourse.model.BuyCourseService;

import net.minidev.json.JSONValue;

@WebServlet("/BuyCourseNumber")
public class BuyCourseNumber extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		BuyCourseService buyCourseService=new BuyCourseService();
		Integer courseID= Integer.parseInt(request.getParameter("courseID"));
		Integer number=buyCourseService.getBuyCourseNumber(courseID);
//		System.out.println(number);
		String numberPeople=JSONValue.toJSONString(number);
		PrintWriter out =response.getWriter();
//		System.out.println(numberPeople);
		out.print(numberPeople);
		out.close();
	} 

}
