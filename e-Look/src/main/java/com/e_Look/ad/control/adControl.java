package com.e_Look.ad.control;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.e_Look.ad.AdDAO;
import com.e_Look.ad.AdVO;

@MultipartConfig(location = "", fileSizeThreshold = 1024 * 1024, maxFileSize = 1024 * 1024 * 1024, maxRequestSize = 1024
		* 1024 * 1024)
@WebServlet("/backstage/adControl")
public class adControl extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

        req.setCharacterEncoding("UTF-8");
		String action = req.getParameter("action");
		Map<String, String> errorMsgs = new HashMap<String, String>();
		req.setAttribute("ErrMsg", errorMsgs);
//新增
		if ("insert".equals(action)) {
			try {
				String fileName = req.getParameter("fileName");
				if (fileName == null || fileName.trim().length() == 0) {
					errorMsgs.put("errName", "請輸入廣告名");
				}
				Part part=req.getPart("adFile");
				InputStream adFile = part.getInputStream();

				AdVO adVO = new AdVO();
				adVO.setFileName(fileName);
				adVO.setAdFile(adFile);
				adVO.setStatus(Byte.parseByte(req.getParameter("status")));
				AdDAO dao = new AdDAO();
				dao.insert(adVO);

				RequestDispatcher successView = req.getRequestDispatcher("backAd.jsp"); 
				successView.forward(req, res);
				
			} catch (Exception e) {
			e.printStackTrace();
				RequestDispatcher failureView = req.getRequestDispatcher("backAd.jsp");
				failureView.forward(req, res);
			}

		}
//修改
		if("update".equals(action)) {
			try {
				String fileName = req.getParameter("fileName");
				if (fileName == null || fileName.trim().length() == 0) {
					errorMsgs.put("errName", "請輸入廣告名");
				}
				Part part=req.getPart("adFile");
				InputStream adFile = part.getInputStream();
                Integer adID=new Integer(req.getParameter("adID").trim());
				
				AdVO adVO = new AdVO();
				adVO.setFileName(fileName);
				adVO.setAdFile(adFile);
				adVO.setStatus(Byte.parseByte(req.getParameter("status")));
				adVO.setAdID(adID);
				AdDAO dao = new AdDAO();
				dao.update(adVO);

				RequestDispatcher successView = req.getRequestDispatcher("backAd.jsp"); 
				successView.forward(req, res);
				
			} catch (Exception e) {
			e.printStackTrace();
				RequestDispatcher failureView = req.getRequestDispatcher("backAd.jsp");
				failureView.forward(req, res);
			}
	
}
	if("delete".equals(action)) {
	   try { Integer adID=new Integer(req.getParameter("adID").trim());
	    System.out.println(adID);
	    AdDAO dao = new AdDAO();
		dao.delete(adID);
		
		String url = "backAd.jsp";
		RequestDispatcher successView = req.getRequestDispatcher(url);// 刪除成功後,轉交回送出刪除的來源網頁
		successView.forward(req, res);}
	
	   catch(Exception e) {
		   RequestDispatcher failureView = req
					.getRequestDispatcher("backAd.jsp");
			failureView.forward(req, res);
	   }
	}	
		
	}
}
