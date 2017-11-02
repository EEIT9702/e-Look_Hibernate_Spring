package com.e_Look.buyCourse.control;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.e_Look.Course.CourseService;
import com.e_Look.buyCourse.model.BuyCourseService;
import com.e_Look.buyCourse.model.BuyCourseVO;

import net.minidev.json.JSONValue;


@WebServlet("/countScoreController")
public class countScoreController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		Integer memberID= Integer.parseInt(request.getParameter("memberID"));
//		System.out.println(memberID);
		
		BuyCourseService buyCourseService = new BuyCourseService();
		List<BuyCourseVO> buyList=buyCourseService.findCourseID(memberID);
		String scoreValue = JSONValue.toJSONString(buyList);
		PrintWriter out =response.getWriter();
//		System.out.println(scoreValue);
		out.print(scoreValue);
		out.close();
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		Integer courseID= Integer.parseInt(request.getParameter("courseID"));
//		System.out.println(courseID);
		
		
		
		BuyCourseService buyCourseService = new BuyCourseService();
		Double Score1=buyCourseService.avgScore(courseID);
		
		CourseService courseService = new CourseService();
		courseService.updateAVGScore(courseID, Score1);
		
		
		
		String Score=Score1.toString();
		String scoreValue = JSONValue.toJSONString(Score);
		
//		System.out.println(scoreValue);
		PrintWriter out =response.getWriter();
		
		out.print(scoreValue);
		out.close();
	}

}
