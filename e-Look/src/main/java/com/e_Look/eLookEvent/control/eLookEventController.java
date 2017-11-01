package com.e_Look.eLookEvent.control;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.e_Look.eLookEvent.eLookEventDAO;
import com.e_Look.eLookEvent.eLookEventService;
import com.e_Look.eLookEvent.eLookEventVO;

@WebServlet("/backstage/elookeventinsert")
public class eLookEventController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doPost(req, res);
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		req.setCharacterEncoding("UTF-8");
		String action = req.getParameter("action");
		
		
		Map<String, String> errorMsgs = new HashMap<String, String>();
		req.setAttribute("ErrMsg", errorMsgs);


		/****************************(insert)*/
		
		if ("insert".equals(action)) { // 來自eLookEvent.jsp的請求
			try {
				/*********************** 1.接收請求參數 - 輸入格式的錯誤處理 *************************/
				String eventName = req.getParameter("eventName");
				if (eventName == null || eventName.trim().length() == 0) {
					errorMsgs.put("errName", "請輸入活動名稱!");
				}
				// 以下練習正則(規)表示式(regular-expression)
				java.sql.Date eStartDate = null;
				try {
					eStartDate = java.sql.Date.valueOf(req.getParameter("eStartDate").trim());
				} catch (IllegalArgumentException e) {
					eStartDate = new java.sql.Date(System.currentTimeMillis());
					errorMsgs.put("errStartDate", "請選擇起始日期!");
				}

				java.sql.Date eEndDate = null;
				try {
					eEndDate = java.sql.Date.valueOf(req.getParameter("eEndDate").trim());
				} catch (IllegalArgumentException e) {
					eEndDate = new java.sql.Date(System.currentTimeMillis());
					errorMsgs.put("errEndDate", "請選擇結束日期!");
				}

				Double d = null;
				try {
					d = new Double(req.getParameter("discount").trim());
					if (d >= 1 || d == 0) {
						errorMsgs.put("errCount","請輸入小數!");
					}

				} catch (NumberFormatException e) {
					errorMsgs.put("errCount", "請輸入折扣優惠!");
				}
				
			
				// Integer courseClass1 = new Integer(req.getParameter("courseClass1").trim());
				//
				// Integer courseClass2 = new Integer(req.getParameter("courseClass2").trim());
				//
				// Integer courseClass3 = new Integer(req.getParameter("courseClass3").trim());
				//
				eLookEventVO eLookEventVO = new eLookEventVO();
				eLookEventVO.setEventName(eventName);
				eLookEventVO.seteStartDate(eStartDate);
				eLookEventVO.seteEndDate(eEndDate);
				eLookEventVO.setDiscount(d);
				if ("null".equals(req.getParameter("courseClass1"))) {
				} else {
					eLookEventVO.setCourseClass1(req.getParameter("courseClass1"));
				}
				if ("null".equals(req.getParameter("courseClass2"))) {
					
				} else {
					eLookEventVO.setCourseClass2(req.getParameter("courseClass2"));
				}
				if ("null".equals(req.getParameter("courseClass3"))) {
				} else {
					eLookEventVO.setCourseClass3(req.getParameter("courseClass3"));
				}

				// Send the use back to the form, if there were errors
				if (!errorMsgs.isEmpty()) {
					req.setAttribute("eLookEventVO", eLookEventVO); // 含有輸入格式錯誤的empVO物件,也存入req
					RequestDispatcher failureView = req
							.getRequestDispatcher("event.jsp");
					failureView.forward(req, res);
					return;}
				/*************************** 2.開始新增資料 ***************************************/
				//eLookEventService eLookEventSvc = new eLookEventService();
				//eLookEventVO = eLookEventSvc.addeLookEvent(eventName, eStartDate, eEndDate, d, courseClass1, courseClass2,
				//		courseClass3);

				eLookEventDAO dao=new eLookEventDAO();
				dao.insert(eLookEventVO);
				
				
				/*************************** 3.新增完成,準備轉交(Send the Success view) ***********/
				RequestDispatcher successView = req.getRequestDispatcher("event.jsp"); // 新增成功後轉交listAllEmp.jsp
				successView.forward(req, res);

				/*************************** 其他可能的錯誤處理 **********************************/
			} catch (Exception e) {
				e.printStackTrace();
				RequestDispatcher failureView = req.getRequestDispatcher("event.jsp");
				failureView.forward(req, res);
			}
		}

	if ("update1".equals(action)) { // 來自update_emp_input.jsp的請求
			

		try {
			/*********************** 1.接收請求參數 - 輸入格式的錯誤處理 *************************/
			Integer eventID = new Integer(req.getParameter("eventID").trim());

			String eventName = req.getParameter("eventName");
			if (eventName == null || eventName.trim().length() == 0) {
				
			}
			// 以下練習正則(規)表示式(regular-expression)
			java.sql.Date eStartDate = null;
			try {
				eStartDate = java.sql.Date.valueOf(req.getParameter("eStartDate").trim());
			} catch (IllegalArgumentException e) {
				eStartDate = new java.sql.Date(System.currentTimeMillis());
				
			}

			java.sql.Date eEndDate = null;
			try {
				eEndDate = java.sql.Date.valueOf(req.getParameter("eEndDate").trim());
			} catch (IllegalArgumentException e) {
				eEndDate = new java.sql.Date(System.currentTimeMillis());
				
			}

			Double d = null;
			try {
				d = new Double(req.getParameter("discount").trim());
				if (d >= 1 && d == 0) {
					
				}

			} catch (NumberFormatException e) {
			
			}
			
		
			// Integer courseClass1 = new Integer(req.getParameter("courseClass1").trim());
			//
			// Integer courseClass2 = new Integer(req.getParameter("courseClass2").trim());
			//
			// Integer courseClass3 = new Integer(req.getParameter("courseClass3").trim());
			//
			eLookEventVO eLookEventVO = new eLookEventVO();
			eLookEventVO.setEventID(eventID);
			eLookEventVO.setEventName(eventName);
			eLookEventVO.seteStartDate(eStartDate);
			eLookEventVO.seteEndDate(eEndDate);
			eLookEventVO.setDiscount(d);
			if ("null".equals(req.getParameter("courseClass1"))) {
			} else {
				eLookEventVO.setCourseClass1(req.getParameter("courseClass1"));
			}
			if ("null".equals(req.getParameter("courseClass2"))) {
				
			} else {
				eLookEventVO.setCourseClass2(req.getParameter("courseClass2"));
			}
			if ("null".equals(req.getParameter("courseClass3"))) {
			} else {
				eLookEventVO.setCourseClass3(req.getParameter("courseClass3"));
			}


				/***************************2.開始修改資料*****************************************/
//			eLookEventService empSvc = new eLookEventService();
//			eLookEventVO = empSvc.updateeLookEvent(empno, ename, job, hiredate, sal,comm, deptno);
//				
			eLookEventDAO dao=new eLookEventDAO();
			dao.update(eLookEventVO);
				/***************************3.修改完成,準備轉交(Send the Success view)*************/
				req.setAttribute("eLookEventVO", eLookEventVO); // 資料庫update成功後,正確的的empVO物件,存入req
				String url = "event.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url); // 修改成功後,轉交listOneEmp.jsp
				successView.forward(req, res);

				/***************************其他可能的錯誤處理*************************************/
			} catch (Exception e) {
				e.printStackTrace();
				RequestDispatcher failureView = req
						.getRequestDispatcher("event.jsp");
				failureView.forward(req, res);
			}
		}
	
	
	if ("delete".equals(action)) { // 來自listAllEmp.jsp

		try {
			/***************************1.接收請求參數***************************************/
			Integer eventID = new Integer(req.getParameter("eventID"));
			
			/***************************2.開始刪除資料***************************************/
//			EmpService empSvc = new EmpService();
//			empSvc.deleteEmp(empno);
			eLookEventDAO dao=new eLookEventDAO();
			dao.delete(eventID);
			/***************************3.刪除完成,準備轉交(Send the Success view)***********/								
			String url = "event.jsp";
			RequestDispatcher successView = req.getRequestDispatcher(url);// 刪除成功後,轉交回送出刪除的來源網頁
			successView.forward(req, res);
			
			/***************************其他可能的錯誤處理**********************************/
		} catch (Exception e) {
			RequestDispatcher failureView = req
					.getRequestDispatcher("event.jsp");
			failureView.forward(req, res);
		}
	}
		
	}

}
