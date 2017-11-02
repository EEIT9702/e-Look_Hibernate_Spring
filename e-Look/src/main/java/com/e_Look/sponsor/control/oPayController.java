package com.e_Look.sponsor.control;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.e_Look.sponsor.model.SponsorService;

@WebServlet("/oPayController")
public class oPayController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String SponsorName=request.getParameter("SponsorName");
		String money=request.getParameter("money");
		String courseID=request.getParameter("courseID");
		String courseName=request.getParameter("courseName");
		//用時間當oPay流水號
		SimpleDateFormat sfd=new SimpleDateFormat("yyyyMMddHHmmss");
		String MerchantTradeNo=sfd.format(new Date());
		
		HttpSession sessionSponsor = request.getSession();
		Map<String,Object> sponsor=new HashMap<String,Object>();
		sponsor.put("money", money);
		sponsor.put("SponsorName",SponsorName);
		sponsor.put("courseID",courseID);
		sponsor.put("addressSpon",request.getHeader("referer"));
		sessionSponsor.setAttribute("sponsor", sponsor);
		
		
		
		String url="http://localhost:8081/e-Look/SponsorInserController";

		System.out.println(url);

		
		SponsorService SponsorService=new SponsorService();
		String formElement=SponsorService.getOPay(MerchantTradeNo,courseName, money,url);
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out =response.getWriter();
		
		out.print("<html>");
		out.print("<meta http-equiv='Content-Type' content='text/html; charset=UTF-8'>");
		out.print("<title>oPay</title>");
		out.print("<body>");
		out.print(formElement);
		out.print("</body>");
		out.print("</html>");
		out.close();
		
		
		
		
	}

}
