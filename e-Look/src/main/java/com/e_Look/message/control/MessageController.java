package com.e_Look.message.control;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.e_Look.member.model.MemberDAO;
import com.e_Look.member.model.MemberVO;
import com.e_Look.message.model.MessageService;
import com.e_Look.message.model.MessageVO;

import net.minidev.json.JSONValue;

/**
 * Servlet implementation class MessageController
 */
@WebServlet("/_Ccc/MessageController")
public class MessageController extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest requestuest, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
//		String messageID=requestuest.getParameter("messageID");
//		String mTime=requestuest.getParameter("mTime");
		
//		Integer memberID = new Integer(request.getParameter("memberID"));
//		Integer courseID = new Integer(requestuest.getParameter("courseID"));
//		Long bought= new Long(requestuest.getParameter("bought"));
//		Byte status= new Byte(requestuest.getParameter("status"));
		String action = request.getParameter("action");
		String update = request.getParameter("update");
		
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.setHeader("content-type", "text/html;charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
				
		HttpSession session = request.getSession(false);
		
				
      if ("insert".equals(action)) { 
       
		MessageVO messageVO = null;
		// 準備存放錯誤訊息的物件
		
				// 將errorMsgMap放入request物件內，識別字串為 "errorMsgs"
		        List<String> errorMsgs = new LinkedList<String>();
				request.setAttribute("errorMsgs", errorMsgs);
//				if (status == 1) {
//					errorMsgs.add("無法新增留言");
//				}
				try{
				    String mContent=request.getParameter("mContent");	//留言
				    if (mContent == null || mContent.length() == 0) {
				    	errorMsgs.add("必須輸入內文");
				    }
					String str = request.getParameter("courseID");             //courseID
					
					Integer courseID = null;
					courseID = new Integer(str);
					
				if (!errorMsgs.isEmpty()) {
					RequestDispatcher rd = request.getRequestDispatcher("/_Ccc/Message.jsp");
					rd.forward(request, response);
					return;
					}

				
				MessageService service = new MessageService();
//				MessageDAO md;
//要再轉型   		MessageVO mb = new MessageVO(messageID, mContent, mTime, messageID_response, memberID,courseID,bought,status);
				MemberDAO mdao = new MemberDAO();
				MessageVO messageVO1= new MessageVO();
				messageVO1.setmContent(mContent);
//				messageVO1.setmTime();
//				MemberVO member=(MemberVO)session.getAttribute("LoginOK");
//				Integer memberID = member.getMemberID();
//				messageVO1.setMemberID(member.getMemberID());
				messageVO1.setMemberVO(mdao.findByPrimaryKey(100001));
//				messageVO1.setCourseID(200001);
				messageVO1.setBought((long) 123);
				messageVO1.setStatus((byte) 1);
				Integer memberID=Integer.valueOf(request.getParameter("memberID"));
				Integer messageID_response=Integer.valueOf(request.getParameter("messageID_response"));
//				Integer memberID = 100001;
//				Integer courseID = 200001;
				Long bought= (long)123;
				Byte status= 1;
				
				if(messageID_response>0){
					//messageVO = service.addReMessage(mContent,messageID_response,memberID,courseID,bought,status);
					}else{}
				    //messageVO = service.addMessage(mContent,memberID,courseID,bought,status);};
				
				session.setAttribute("MessageVO", messageVO);
				session.setAttribute("MessageInsertOK", "新增留言成功");
				System.out.println(messageVO);
				
				String jsonString = JSONValue.toJSONString(messageVO); 
				out.println(jsonString);
				
				response.sendRedirect(request.getContextPath() +"/_Ccc/Message3.jsp");
				} catch (Exception e) {
					errorMsgs.add("新增資料失敗:"+e.getMessage());
					RequestDispatcher failureView = request
							.getRequestDispatcher("/_Ccc/Message.jsp");
					failureView.forward(request, response);
				}
			}
      if ("update".equals(action)) { 
    	    MessageVO messageVO = null;
			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			request.setAttribute("errorMsgs", errorMsgs);
			
			if ("message".equals(update)){    // 修改留言
			String mContent=request.getParameter("mContent").trim();	
			try{Integer messageID_response = new Integer(request.getParameter("messageID_response"));
					}catch(Exception e) {
						errorMsgs.add("修改資料失敗:"+e.getMessage());
						RequestDispatcher failureView = request
								.getRequestDispatcher("/_Ccc/Message.jsp");
						failureView.forward(request, response);
					}
			try {
				/***************************1.接收請求參數 - 輸入格式的錯誤處理**********************/
				Integer messageID = new Integer(request.getParameter("messageID").trim());
				
//				if (mContent == null || mContent.trim().length() == 0) {
//					errorMsgs.add("必須輸入內文");
//				}
				
				if (!errorMsgs.isEmpty()) {
					RequestDispatcher rd = request.getRequestDispatcher("/_Ccc/Message.jsp");
					rd.forward(request, response);
					return;
					}
				
				MessageService service = new MessageService();
//				MessageDAO md;
//要再轉型   		MessageVO mb = new MessageVO(messageID, mContent, mTime, messageID_response, memberID,courseID,bought,status);
				
//				MessageVO messageVO1= new MessageVO();
//				messageVO1.setmContent(mContent);
//				messageVO1.setmTime();
//				MemberVO member=(MemberVO)session.getAttribute("LoginOK");
//				messageVO1.setMemberID(member.getMemberID());
//				messageVO1.setMemberID(100001);
//				messageVO1.setCourseID(200001);
//				messageVO1.setBought((long) 123);
//				messageVO1.setStatus((byte) 1);
				
				Integer memberID = 100001;
				Integer courseID = 200001;
				Long bought= (long)123;
				Byte status= 1;
				
				/***************************2.開始修改資料*****************************************/			
				//messageVO = service.updateMessage(messageID,mContent, memberID,courseID,bought,status,update);

				/***************************3.修改完成,準備轉交(Send the Success view)*************/
				request.setAttribute("messageVO",messageVO); // 資料庫update成功後,正確的的empVO物件,存入requestuest
				
				RequestDispatcher successView = request.getRequestDispatcher("/_Ccc/Message.jsp"); // 修改成功後,轉交
				successView.forward(request, response);
				/***************************其他可能的錯誤處理*************************************/
				} catch (Exception e) {
					errorMsgs.add("修改資料失敗:"+e.getMessage());
					RequestDispatcher failureView = request
							.getRequestDispatcher("/_Ccc/Message.jsp");
					failureView.forward(request, response);
				}
			}
	
      }
      
      if ("delete".equals(action)) { // 來自listAllEmp.jsp

			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			request.setAttribute("errorMsgs", errorMsgs);
	
			try {
				/***************************1.接收請求參數***************************************/
				Integer messageID = new Integer(request.getParameter("messageID"));
				
				/***************************2.開始刪除資料***************************************/
				MessageService messageSvc = new MessageService();
				//messageSvc.deleteMessage(messageID);
				
				/***************************3.刪除完成,準備轉交(Send the Success view)***********/								
				
				RequestDispatcher successView = request.getRequestDispatcher("/_Ccc/Message.jsp");// 刪除成功後,轉交回送出刪除的來源網頁
				successView.forward(request, response);
				
				/***************************其他可能的錯誤處理**********************************/
			} catch (Exception e) {
				errorMsgs.add("刪除資料失敗:"+e.getMessage());
				RequestDispatcher failureView = request
						.getRequestDispatcher("/_Ccc/Message.jsp");
				failureView.forward(request, response);
			}
		}
      
      if ("getOne_For_Display".equals(action)) { // 來自select_page.jsp的請求
    	  
			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			request.setAttribute("errorMsgs", errorMsgs);      //放前後沒差,先設空的也可以

			try {
				/***************************1.接收請求參數 - 輸入格式的錯誤處理**********************/
				
//				CourseVO course=(CourseVO)session.getAttribute("CourseVO");
//				Integer courseID = course.getCourseID();
				String str = request.getParameter("courseID");
								
				Integer courseID = null;
				courseID = new Integer(str);
								
				/***************************2.開始查詢資料*****************************************/
				MessageService messageSvc = new MessageService();
				//List<MessageVO> messageVO = messageSvc.getOneMessageM(courseID);
				
				/*if (messageVO == null) {
					errorMsgs.add("查無資料");
				}*/
				// Send the use back to the form, if there were errors
				if (!errorMsgs.isEmpty()) {
					RequestDispatcher failureView = request
							.getRequestDispatcher("/_Ccc/Message.jsp");
					failureView.forward(request, response);
					return;//程式中斷
				}
				
				/***************************3.查詢完成,準備轉交(Send the Success view)*************/
				//String jsonString = JSONValue.toJSONString(messageVO); 
		
			//	System.out.print(jsonString);
				//out.println(jsonString);
				
//				request.setAttribute("messageVO", messageVO); // 資料庫取出的VO物件,存入request
//				out.print(messageVO);
//				RequestDispatcher successView = request.getRequestDispatcher("/_Ccc/Message3.jsp"); // 成功轉交 listOneEmp.jsp
//				successView.forward(request, response);

				/***************************其他可能的錯誤處理*************************************/
			} catch (Exception e) {
				errorMsgs.add("無法取得資料:" + e.getMessage());
				RequestDispatcher failureView = request
						.getRequestDispatcher("/_Ccc/Message.jsp");
				failureView.forward(request, response);
			}
		}
		
		
		if ("getOne_For_Update".equals(action)) { // 來自listAllEmp.jsp的請求

			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			request.setAttribute("errorMsgs", errorMsgs);
			
			try {
				/***************************1.接收請求參數****************************************/
				Integer messageID = new Integer(request.getParameter("messageID"));
				
				/***************************2.開始查詢資料****************************************/
				MessageService messageSvc = new MessageService();
				MessageVO messageVO = messageSvc.getOneMessage(messageID);
												
				/***************************3.查詢完成,準備轉交(Send the Success view)************/
				request.setAttribute("messageVO", messageVO);         // 資料庫取出的VO物件,存入request
				
				RequestDispatcher successView = request.getRequestDispatcher("/_Ccc/Message.jsp");// 成功轉交 update_emp_input.jsp
				successView.forward(request, response);

				/***************************其他可能的錯誤處理**********************************/
			} catch (Exception e) {
				errorMsgs.add("無法取得要修改的資料:" + e.getMessage());
				RequestDispatcher failureView = request
						.getRequestDispatcher("/_Ccc/Message.jsp");
				failureView.forward(request, response);
			}
		}
		
		
      }
      
	}
	
