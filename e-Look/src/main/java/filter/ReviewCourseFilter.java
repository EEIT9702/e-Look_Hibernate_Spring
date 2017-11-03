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
 * Servlet Filter implementation class ReviewCourseFilter
 */
@WebFilter(filterName = "ReviewCourseFilter", dispatcherTypes = { DispatcherType.REQUEST })
public class ReviewCourseFilter implements Filter {

	/**
	 * Default constructor.
	 */
	public ReviewCourseFilter() {
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
			String courseID = request.getParameter("CourseID");
			if (courseID == null || courseID.length() == 0) {
				response.sendRedirect(request.getContextPath() + "/HOME.jsp");
				return;
			} else if (courseID != null) {
				
				if (request.getHeader("referer")!=null||request.getHeader("referer").indexOf("CourseReview.jsp") != -1) {
					CourseService courseService = new CourseService();
					CourseVO courseVO = courseService.getCourseData(Integer.valueOf(courseID));
					if (courseVO.getStatus() == 1) {
						MemberService service = new MemberService();
						MemberVO memberVo = service.getMember(courseVO.getMemberID());
						request.setAttribute("courseVO", courseVO);
						request.setAttribute("memberVo", memberVo);
						chain.doFilter(request, response);
					} else {
						response.sendRedirect(request.getContextPath() + "/HOME.jsp");
						return;
					}
				}else {
					response.sendRedirect(request.getContextPath() + "/HOME.jsp");
					return;
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

}
