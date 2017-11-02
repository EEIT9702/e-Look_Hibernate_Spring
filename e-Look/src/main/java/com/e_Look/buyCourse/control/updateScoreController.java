package com.e_Look.buyCourse.control;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.e_Look.buyCourse.model.BuyCourseService;


@WebServlet("/updateScoreController")
public class updateScoreController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public updateScoreController() {
        super();

    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		Integer score=Integer.parseInt(request.getParameter("score"));
		Integer memberID=Integer.parseInt(request.getParameter("memberID"));
		Integer courseID=Integer.parseInt(request.getParameter("courseID"));
		System.out.println(score+","+memberID+","+courseID);
		
		BuyCourseService buyCourseService=new BuyCourseService();
		buyCourseService.updateScore(score, memberID, courseID);
	
	}

}
