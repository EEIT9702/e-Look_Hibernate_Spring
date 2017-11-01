package com.e_Look.member.control;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.e_Look.Course.CourseService;
import com.e_Look.Course.CourseVO;
import com.e_Look.OrderDetails.model.OrderDetailsService;
import com.e_Look.OrderDetails.model.OrderDetailsVO;
import com.e_Look.sponsor.model.SponsorService;
import com.e_Look.sponsor.model.SponsorVO;

import net.minidev.json.JSONValue;

/**
 * Servlet implementation class MemberIncome
 */
@WebServlet("/MemberIncomeController")
public class MemberIncomeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberIncomeController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		String  memberID=request.getParameter("MemberID");
		CourseService courseService =new CourseService();
		//該會員的線上課程的被購買明細
		List<List<OrderDetailsVO>> list = new LinkedList<List<OrderDetailsVO>>();
		List<CourseVO> onlineCourse= courseService.getAllCourseData(Integer.valueOf(memberID), 2);
		OrderDetailsService orderDetailsService =new OrderDetailsService();
		for(CourseVO CourseVO:onlineCourse){
			if(CourseVO.getSoldPrice()>0){
			List<OrderDetailsVO> OrderDetailsVOlist=orderDetailsService.findByCourseID(CourseVO.getCourseID());
			if(OrderDetailsVOlist.size()>0){
				list.add(OrderDetailsVOlist);
			}
			}
		}
		//該會員的募資課程的被購買明細
		List<List<OrderDetailsVO>> list2 = new LinkedList<List<OrderDetailsVO>>();
		List<CourseVO> fundraisingCourse=courseService.getAllCourseData(Integer.valueOf(memberID),3);
		for(CourseVO CourseVO:fundraisingCourse){
			List<OrderDetailsVO> OrderDetailsVOlist2=orderDetailsService.findByCourseID(CourseVO.getCourseID());
			if(OrderDetailsVOlist2.size()>0){
				list2.add(OrderDetailsVOlist2);
			}
		}
		//該會員的免費課程的被贊助明細
		List<List<SponsorVO>> list3 = new LinkedList<List<SponsorVO>>();
		List<String> list4 = new LinkedList<String>();
		SponsorService sponsorService=new SponsorService();
		for(CourseVO CourseVO:onlineCourse){
			if(CourseVO.getSoldPrice()==0){
				List<SponsorVO> OrderDetailsVOlist3 = sponsorService.getSponsor(CourseVO.getCourseID());
				if (OrderDetailsVOlist3.size() > 0) {
					list3.add(OrderDetailsVOlist3);
					list4.add(CourseVO.getCourseName());
				}
			}
		}
		 Map<String,List> map=new LinkedHashMap<String,List>();
		 map.put("onlineCourse", list);
		 map.put("fundraisingCourse", list2);
		 map.put("freeCourse", list3);
		 map.put("CourseName", list4);
		 
		 String OrderVOJson= JSONValue.toJSONString(map);
		 //System.out.println(OrderVOJson);
		 response.getWriter().println(OrderVOJson);
		
	}

}
