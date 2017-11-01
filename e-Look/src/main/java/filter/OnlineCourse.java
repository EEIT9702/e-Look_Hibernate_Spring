package filter;

import java.io.IOException;
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
import com.e_Look.buyCourse.model.BuyCourseDAO;
import com.e_Look.buyCourse.model.BuyCourseService;
import com.e_Look.buyCourse.model.BuyCourseVO;
import com.e_Look.member.model.MemberService;
import com.e_Look.member.model.MemberVO;
import com.e_Look.memberBookmarks.model.MemberBookmarksService;
import com.e_Look.memberBookmarks.model.MemberBookmarksVO;

import com.e_Look.memberSubscription.MemberSubscriptionService;
import com.e_Look.memberSubscription.MemberSubscriptionVO;


/**
 * Servlet Filter implementation class OnlineCourse
 */
@WebFilter(filterName = "OnlineCourseFilter", dispatcherTypes = { DispatcherType.REQUEST })
public class OnlineCourse implements Filter {

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
			throws IOException, ServletException {
		if (req instanceof HttpServletRequest && resp instanceof HttpServletResponse) {
			HttpServletRequest request = (HttpServletRequest) req;
			HttpServletResponse response = (HttpServletResponse) resp;
			String courseID = request.getParameter("CourseID");
			if (courseID == null||courseID.length()==0) {
				response.sendRedirect(request.getContextPath()+"/HOME.jsp");
				return;
			}
			else if (courseID != null) {
				CourseService courseService = new CourseService();
				CourseVO courseVO = courseService.getCourseData(Integer.valueOf(courseID));
				if (courseVO.getStatus() == 2) {
					MemberService service = new MemberService();
					MemberVO memberVo = service.getMember(courseVO.getMemberID());
					List<CourseVO> list = courseService.getAllCourseData(courseVO.getMemberID(), 2);
					HttpSession session = request.getSession();
					MemberVO memberVoOK = (MemberVO) session.getAttribute("LoginOK");
					BuyCourseService CourseService = new BuyCourseService();
					List<BuyCourseVO> list2 = null;
					List<MemberBookmarksVO> mBookmarkList = null;
					List<MemberSubscriptionVO> memberSubscriptionVO = null;
					MemberBookmarksService memberBookmarksService = new MemberBookmarksService();

					MemberSubscriptionService memberSubscriptionService =new MemberSubscriptionService();

					if (memberVoOK != null) {

						list2 = CourseService.getBuyCourse(memberVoOK.getMemberID());
						mBookmarkList = memberBookmarksService.findPrimaryMemberBookmarks(memberVoOK.getMemberID());
						memberSubscriptionVO=memberSubscriptionService.findPrimaryMemberBookmarks(memberVoOK.getMemberID());
					}

					if (mBookmarkList != null) {
						request.setAttribute("mBookmarkList", mBookmarkList);

					}
					request.setAttribute("list", list);
					request.setAttribute("list2", list2);
					request.setAttribute("courseVO", courseVO);
					request.setAttribute("memberVo", memberVo);
					request.setAttribute("memberSubscription", memberSubscriptionVO);
					chain.doFilter(request, response);
				}else if(courseVO.getStatus() == 3){
					MemberService service = new MemberService();
					MemberVO memberVo = service.getMember(courseVO.getMemberID());
					List<CourseVO> list = courseService.getAllCourseData(courseVO.getMemberID(), 2);
					HttpSession session = request.getSession();
					MemberVO memberVoOK = (MemberVO) session.getAttribute("LoginOK");
					BuyCourseService CourseService = new BuyCourseService();
					List<BuyCourseVO> list2 = null;
					List<MemberBookmarksVO> mBookmarkList = null;
					List<MemberSubscriptionVO> memberSubscriptionVO = null;
					MemberBookmarksService memberBookmarksService = new MemberBookmarksService();

					MemberSubscriptionService memberSubscriptionService =new MemberSubscriptionService();

					if (memberVoOK != null) {

						list2 = CourseService.getBuyCourse(memberVoOK.getMemberID());
						mBookmarkList = memberBookmarksService.findPrimaryMemberBookmarks(memberVoOK.getMemberID());
						memberSubscriptionVO=memberSubscriptionService.findPrimaryMemberBookmarks(memberVoOK.getMemberID());
					}

					if (mBookmarkList != null) {
						request.setAttribute("mBookmarkList", mBookmarkList);

					}
					request.setAttribute("list", list);
					request.setAttribute("list2", list2);
					request.setAttribute("courseVO", courseVO);
					request.setAttribute("memberVo", memberVo);
					request.setAttribute("memberSubscription", memberSubscriptionVO);
					chain.doFilter(request, response);
					
				}else{
					response.sendRedirect(request.getContextPath()+"/HOME.jsp");
				}
			}
		}
		
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

}
