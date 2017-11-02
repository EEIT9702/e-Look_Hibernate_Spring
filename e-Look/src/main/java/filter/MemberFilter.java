package filter;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.DispatcherType;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.e_Look.Course.CourseDAO;
import com.e_Look.Course.CourseService;
import com.e_Look.Course.CourseVO;
import com.e_Look.buyCourse.model.BuyCourseService;
import com.e_Look.buyCourse.model.BuyCourseVO;
import com.e_Look.member.model.MemberService;
import com.e_Look.member.model.MemberVO;
import com.e_Look.memberBookmarks.model.MemberBookmarksService;
import com.e_Look.memberBookmarks.model.MemberBookmarksVO;
import com.e_Look.memberSubscription.MemberSubscriptionService;
import com.e_Look.memberSubscription.MemberSubscriptionVO;

/**
 * Servlet Filter implementation class MemberFilter
 */
@WebFilter(filterName = "MemberFilter", dispatcherTypes = { DispatcherType.REQUEST })
public class MemberFilter implements Filter {

	/**
	 * Default constructor.
	 */
	public MemberFilter() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
			throws IOException, ServletException {

		if (req instanceof HttpServletRequest && resp instanceof HttpServletResponse) {
			HttpServletRequest request = (HttpServletRequest) req;
			HttpServletResponse response = (HttpServletResponse) resp;

			CourseDAO dao = new CourseDAO();
			CourseService courseService =new CourseService();
			MemberService memberService = new MemberService();
			BuyCourseService CourseService = new BuyCourseService();
			MemberBookmarksService memberBookmarksService = new MemberBookmarksService();
			MemberSubscriptionService memberSubscriptionService = new MemberSubscriptionService();
			HttpSession session = request.getSession();
			MemberVO memberVO = (MemberVO) session.getAttribute("LoginOK");
			if(memberVO==null){
				response.sendRedirect(request.getContextPath()+"/HOME.jsp");
				return;
			}
			if (request.getParameter("memberID") == null) {
				List<CourseVO> list =courseService.getAllCourseData(memberVO.getMemberID(),2);
				List<BuyCourseVO> buyCourselist = CourseService.getBuyCourse(memberVO.getMemberID());
				List<CourseVO> list2 = new LinkedList<CourseVO>();
				List<CourseVO> list3 = new LinkedList<CourseVO>();
				List<CourseVO> list4 =courseService.getAllCourseData(memberVO.getMemberID(), 0);
				List<MemberVO> list5 = new LinkedList<MemberVO>();
				List<CourseVO> list6 =courseService.getAllCourseData(memberVO.getMemberID(), 1);
				for (BuyCourseVO buyCoursevo : buyCourselist) {
					list2.add(courseService.getCourseData(buyCoursevo.getCourseID()));
				}
				List<MemberBookmarksVO> mBookmarkList = memberBookmarksService
						.findPrimaryMemberBookmarks(memberVO.getMemberID());

				for (MemberBookmarksVO MemberBookmarksVO : mBookmarkList) {
					list3.add(dao.findByPrimaryKey(MemberBookmarksVO.getCourseID()));
				}
				List<MemberSubscriptionVO> memberSubscriptionList = memberSubscriptionService
						.findPrimaryMemberBookmarks(memberVO.getMemberID());
				for (MemberSubscriptionVO MemberSubscriptionVO : memberSubscriptionList) {
					list5.add(memberService.getMember(MemberSubscriptionVO.getMemberTrackID()));
				}
				request.setAttribute("mycourseCount", list.size());
				request.setAttribute("buycourseCount", list2.size());
				request.setAttribute("list", list);
				request.setAttribute("list2", list2);
				request.setAttribute("list3", list3);
				request.setAttribute("list4", list4);
				request.setAttribute("list5", list5);
				request.setAttribute("list6", list6);
				chain.doFilter(request, response);
			} else {
				Integer memberID = Integer.valueOf(request.getParameter("memberID"));
				MemberVO membervo = memberService.getMember(memberID);
				List<CourseVO> TeacherCourselist = courseService.getAllCourseData(memberID, 2);
				request.setAttribute("Submembervo", membervo);
				request.setAttribute("TeacherCourselist", TeacherCourselist);
				chain.doFilter(request, response);
			}

		}
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
