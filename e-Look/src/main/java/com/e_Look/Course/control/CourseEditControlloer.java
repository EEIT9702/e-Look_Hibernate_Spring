package com.e_Look.Course.control;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.e_Look.Course.CourseService;
import com.e_Look.Course.CourseVO;
import com.e_Look.CourseClassDetails.CourseClassDetailsDAO;
import com.e_Look.buyCourse.model.BuyCourseService;
import com.e_Look.courseClass.CourseClassDAO;
import com.e_Look.courseClass.CourseClassVO;
import com.e_Look.emailSystem.CourseReviewFailureEmail;
import com.e_Look.member.model.MemberService;
import com.e_Look.member.model.MemberVO;

import net.minidev.json.JSONValue;

/**
 * Servlet implementation class CreateNewCourseControlloer
 */
@MultipartConfig(location = "", fileSizeThreshold = 1024 * 1024, maxFileSize = 1024 * 1024 * 1024, maxRequestSize = 1024
		* 1024 * 1024)
@WebServlet(urlPatterns={"/com.e_Look.Course.control/CourseEditControlloer"},loadOnStartup=1)
public class CourseEditControlloer extends HttpServlet {
	private static final long serialVersionUID = 1L;
	java.util.Timer time = null;	
	@Override
	public void init() throws ServletException {
	System.out.println("募資審核時間器測試");
	time= new java.util.Timer();
	time.schedule(new java.util.TimerTask(){
	BuyCourseService BuyCourseService = new BuyCourseService();
		@Override
		public void run() {
			//System.out.println("成功啟用募資審核計時器");
			CourseService courseService = new CourseService();
			 List<CourseVO> AllFundCourse=courseService.getAllFundRaiseCourse();
			 //第一種取值的方式
			 for(int i=0;i<AllFundCourse.size();i++){
				System.out.println("募資起始時間："+AllFundCourse.get(i).getFundEndDate());
				 long FundEndTime=AllFundCourse.get(i).getFundEndDate().getTime();
				 long currentDate = System.currentTimeMillis();
				if(FundEndTime<=currentDate){
					
					if(BuyCourseService.getBuyCourseNumber(AllFundCourse.get(i).getCourseID())>=AllFundCourse.get(i).getTargetStudentNumber()){
						CourseVO  courseVO =  new CourseVO();
						courseVO.setStatus(4);
						courseVO.setCourseID(AllFundCourse.get(i).getCourseID());
						courseService.updateStatus(courseVO);
						System.out.println("課程募資時間已到，改為備課中的狀態");
					}else{
						CourseVO  courseVO =  new CourseVO();
						courseVO.setStatus(5);
						courseVO.setCourseID(AllFundCourse.get(i).getCourseID());
						courseService.updateStatus(courseVO);
						System.out.println("課程募資時間已到，募資失敗的狀態");
					}
				}else{
					System.out.println("募資尚未結束，不做任何動作");
				}
				}
			 //第二種取值的方式
//			for(CourseVO CourseVO:AllFundCourse){
//				System.out.println("募資起始時間："+CourseVO.getFundEndDate());
//			}
			//第三種取值的方式
//			Iterator<CourseVO> it = AllFundCourse.iterator();
//			while(it.hasNext()){
//				System.out.println(it.next().getFundEndDate());
//			}
		}}, new java.util.Date(), 1000*10);
	
	}
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Integer memberID= Integer.valueOf(request.getParameter("memberID"));
		if(request.getParameter("member")!=null){
		Integer courseID = Integer.valueOf(request.getParameter("courseID"));
		
		CourseClassDetailsDAO dao1 = new CourseClassDetailsDAO();
		dao1.delete(courseID);
		CourseService courseService = new CourseService();
		courseService.deleteCourse(courseID);
		}
		
		else if(request.getParameter("getProposalData")!=null){
			response.setHeader("Access-Control-Allow-Origin", "*");
			response.setHeader("content-type", "text/html;charset=UTF-8");
			response.setCharacterEncoding("UTF-8");
			PrintWriter out = response.getWriter();
			
			CourseService courseService1 = new CourseService();
			CourseVO proposalData=courseService1.getCourseData(Integer.valueOf(request.getParameter("courseID")));						
//			JSONObject jsonString =new JSONObject(proposalData);	
//			System.out.println(jsonString);
			String jsonString1 = JSONValue.toJSONString(proposalData); //另外一種把VO物件轉JSON的API
			//System.out.println(jsonString1);
			out.print(jsonString1);
		}
		
		else if(request.getParameter("rollbackEditorStatus")!=null){
			Integer courseID = Integer.valueOf(request.getParameter("courseID"));
			CourseService courseService3 = new CourseService();
			courseService3.rollbacktoEditorStatus(courseID);
			CourseVO courseVO=courseService3.getCourseData(courseID);
			MemberService memberService =new MemberService();
			MemberVO memberVO=memberService.getMember(courseVO.getMemberID());
			CourseReviewFailureEmail.sendmail(memberVO, courseVO);
		}
		
		else if(request.getParameter("changeStatustoOnlineStatus")!=null){
			Integer courseID = Integer.valueOf(request.getParameter("courseID"));
			CourseService courseService4 = new CourseService();
			courseService4.changeStatustoOnlineStatus(courseID);
		}
		
		else if(request.getParameter("changeStatustoFundStatus")!=null){
			Integer courseID = Integer.valueOf(request.getParameter("courseID"));
			CourseService courseService5 = new CourseService();
			courseService5.changeStatustoFundStatus(courseID);
		}
	
		 else {			
				Integer courseID = Integer.valueOf(request.getParameter("courseID"));
				CourseService courseService = new CourseService();
				courseService.updateProposalStatus(courseID);
		}
		
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		CourseService service = null;
		CourseVO courseVO = null;
		Integer courseID = new Integer(request.getParameter("CourseID"));
		String courseName = request.getParameter("courseName");
		String preTool = request.getParameter("preTool");
		String background = request.getParameter("background");
		String ability = request.getParameter("ability");
		String targetgroup = request.getParameter("targetgroup");

		Integer soldPrice = 0;
		String soldPriceTEST = request.getParameter("soldPrice");
		if (soldPriceTEST != null) {
			if (soldPriceTEST.length() > 0) {
				soldPrice = new Integer(request.getParameter("soldPrice"));
			}
		}

		Integer courseLength = 0;
		String courseLengthTEST = request.getParameter("courseLength");
		if (!courseLengthTEST.equals("")) {
			courseLength = new Integer(request.getParameter("courseLength"));
		}
		Integer targetStudentNumber = 0;
		String targetStudentNumberTEST = request.getParameter("targetStudentNumber");
		if (targetStudentNumberTEST != null) {
			if (targetStudentNumberTEST.length() > 0)
				targetStudentNumber = new Integer(request.getParameter("targetStudentNumber"));
		}

		Date fundStartDate = null;
		String fundStartDateTEST = request.getParameter("fundStartDate");
		if (fundStartDateTEST != null) {
			if (fundStartDateTEST.length() > 0)
				fundStartDate = Date.valueOf(request.getParameter("fundStartDate"));
		}

		Date fundEndDate = null;
		String fundEndDateTEST = request.getParameter("fundEndDate");
		if (fundEndDateTEST != null) {
			if (fundEndDateTEST.length() > 0)
				fundEndDate = Date.valueOf(request.getParameter("fundEndDate"));
		}

		Date courseStartDate = null;
		String courseStartDateTEST = request.getParameter("courseStartDate");
		if (courseStartDateTEST != null) {
			if (courseStartDateTEST.length() > 0)
				courseStartDate = Date.valueOf(request.getParameter("courseStartDate"));
		}

		String courseContent = request.getParameter("courseContent");

		service = new CourseService();
		courseVO = new CourseVO(courseID, courseName, preTool, background, ability, targetgroup, soldPrice,
				courseLength, targetStudentNumber, fundStartDate, fundEndDate, courseStartDate, courseContent);
		service.updateCourseContent(courseVO);
		service.updateCourseImage(courseID, request.getPart("picture"));
		service.updateCoursePaper(courseID, request.getPart("paper"));

		String[] CourseClass = request.getParameterValues("CourseClass");
		if (CourseClass != null) {
			if (CourseClass.length > 0) {
				CourseClassDetailsDAO dao1 = new CourseClassDetailsDAO();//先載入課程類別清單CourseClassDetailsDAO，建立dao1物件
					dao1.delete(courseID);
				for (int i = 0; i < CourseClass.length; i++) {
					CourseVO courseVO2 = new CourseVO();//建立CourseVO2物件
					courseVO2.setCourseID(courseID);//將取到的courseID用set方法放到courseVO2
					courseVO2.setCourseName(courseName);//將取到的courseName用set方法放到courseVO2
					CourseClassDAO dao = new CourseClassDAO();//先載入課程類別CourseClassDAO，並建立dao物件
					//先載入課程類別(CourseClassVO)的VO，使用CourseClassDAO的getByCourseClassID方法取得courseClassVO物件存入courseClassVO
					CourseClassVO courseClassVO = dao.getByCourseClassID(Integer.valueOf(CourseClass[i]));
					dao1.insert(courseVO2, courseClassVO);//使用CourseClassDetailsDAO的方法，存入課程類別明細
				}
				// System.out.println("myCheckBoxValue:"+CourseClass[i]);
			}
		}
		
		
		

	}

}
