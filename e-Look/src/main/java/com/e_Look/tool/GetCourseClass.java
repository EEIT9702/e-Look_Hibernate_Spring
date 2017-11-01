package com.e_Look.tool;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.e_Look.CourseClassDetails.CourseClassDetailsDAO;
import com.e_Look.CourseClassDetails.CourseClassDetailsVO;

/**
 * Servlet implementation class GetCourseClass
 */
@WebServlet("/GetCourseClass")
public class GetCourseClass extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		Integer courseID = Integer.parseInt(request.getParameter("courseID"));
		CourseClassDetailsDAO ccddao = new CourseClassDetailsDAO();
		List<CourseClassDetailsVO> ccdVOs = ccddao.findBycourseID(courseID);
		String ccNames = "";
		for (CourseClassDetailsVO ccdVO : ccdVOs) {
			String ccName = ccdVO.getCourseClassVO().getCcName();
			ccNames += ccName+" ";
		}
		response.getWriter().write(ccNames);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

}
