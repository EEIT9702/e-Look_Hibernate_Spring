package com.e_Look.OrderSystem.control;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.e_Look.Order.model.OrderDAO;
import com.e_Look.Order.model.OrderVO;
import com.e_Look.member.model.MemberVO;

@WebServlet("/OrderoPayController")
public class OrderoPayController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.sendRedirect(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		OrderDAO orderdao = new OrderDAO();
		HttpSession session = request.getSession();
		MemberVO memberVO = (MemberVO) session.getAttribute("LoginOK");

		OrderVO orderVO = orderdao.findMemberUncheckOrder(memberVO.getMemberID());
		session.setAttribute("orderVO", orderVO);
		
		OrderSystemService oss = new OrderSystemService();
		String formElement = oss.getOPay(orderVO);
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter pw =response.getWriter();
		
		pw.print("<html>");
		pw.print("<meta http-equiv='Content-Type' content='text/html; charset=UTF-8'>");
		pw.print("<title>oPay</title>");
		pw.print("<body>");
		pw.print(formElement);
		pw.print("</body>");
		pw.print("</html>");
		pw.close();
	}

}
