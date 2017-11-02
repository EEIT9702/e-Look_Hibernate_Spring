package filter;

import java.io.IOException;

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
import com.e_Look.member.model.MemberVO;

/**
 * Servlet Filter implementation class CreateCourseFilter
 */
@WebFilter(filterName = "CreateCourseFilter", dispatcherTypes = { DispatcherType.REQUEST })
public class CreateCourseFilter implements Filter {

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
//			System.out.println(request.getHeader("referer"));
			// 判斷有從會員中心送來的請求
			if (request.getParameter("CourseID") == null) {
				// 判斷"向"哪一個網頁發出請求，當.indexOf()的值不等於-1時，表示對CreateCourse.jsp發出請求
//				if (request.getServletPath().indexOf("CreateCourse.jsp") != -1) {
					// 判斷"從"哪一個網頁發出請求，當.indexOf()的值等於-1時，表示從CreateCourse.jsp送出請求
					if (request.getHeader("referer").indexOf("CreateCourse.jsp") == -1) {
						HttpSession session = request.getSession();
						MemberVO memberVO = (MemberVO) session.getAttribute("LoginOK");
						if (memberVO == null) {
							session.setAttribute("loginerr", "123");
							response.sendRedirect(request.getHeader("referer"));
						} else {

							CourseService courseService = new CourseService();
							Integer CourseID = courseService.CreateNewCourse(memberVO.getMemberID());
							request.setAttribute("CourseID", CourseID);
							chain.doFilter(request, response);
						}
					} else {
						chain.doFilter(request, response);
					}
//				} else {
//					chain.doFilter(request, response);
//				}

			} else {
				Integer courseID=Integer.valueOf(request.getParameter("CourseID"));
				CourseService courseService = new CourseService();
				CourseVO CourseVo=  courseService.getCourseData(courseID);
				request.setAttribute("CourseID", courseID);
				request.setAttribute("CoursedData", CourseVo);
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
