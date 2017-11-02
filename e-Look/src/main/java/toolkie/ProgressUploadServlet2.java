package toolkie;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.e_Look.Course.CourseService;
import com.e_Look.Course.CourseVO;

@WebServlet("/toolkie/ProgressUploadServlet1")
public class ProgressUploadServlet2 extends HttpServlet {
	// 用途不明
	// private static final long serialVersionUID = -4935921396709035718L;

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		// 上傳狀態
		UploadStatus status = new UploadStatus();

		// 監視器
		UploadListener listener = new UploadListener(status);

		// 將狀態放入Session裡
		request.getSession(true).setAttribute("uploadStatus", status);

		ServletFileUpload upload = new ServletFileUpload(new DiskFileItemFactory());

		// 設定上傳listener
		upload.setProgressListener(listener);
		
		try {
			List itemList = upload.parseRequest(request);// 傳送所有參數
				System.out.println(itemList);
			for (Iterator it = itemList.iterator(); it.hasNext();) {// 檢查所有參數
				FileItem item = (FileItem) it.next();
				if (item.isFormField()) {// 如果是表單資料					
					//System.out.println("FormField: " + item.getFieldName() + " = " + item.getString());
				} else {// 否則上傳檔案
					if (!item.getName().equals("")) {
						System.out.println("File: " + item.getName());

						// 統一 Linux windows 路徑分格符號
						// String fileName = item.getName().replace("/", "\\");
						// fileName =
						// fileName.substring(fileName.lastIndexOf("\\"));

						File saved = new File(request.getServletContext().getRealPath("")+"\\paper", item.getName());
						System.out.println("D:\\TEST\\"+ item.getName());						
						saved.getParentFile().mkdirs();
											 

						InputStream ins = item.getInputStream();
						OutputStream ous = new FileOutputStream(saved);

						byte[] tmp = new byte[1024];
						int len = -1;

						while ((len = ins.read(tmp)) != -1) {
							ous.write(tmp, 0, len);
						}

						ous.close();
						ins.close();
						
						response.getWriter().println("�w�x�s�ɮסG" + saved);
					}
				}
			}
						
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
			response.getWriter().println("�W�ǵo�Ϳ��~�G" + e.getMessage());
		}
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setHeader("Cache-Control", "no-store");
		response.setHeader("Pragrma", "no-cache");
		response.setDateHeader("Expires", 0);

		UploadStatus status = (UploadStatus) request.getSession(true).getAttribute("uploadStatus");

		if (status == null) {
			response.getWriter().println("�S���W�Ǹ�T");
			return;
		}

		long startTime = status.getStartTime();
		long currentTime = System.currentTimeMillis();

		// 已上傳的時間s
		long time = (currentTime - startTime) / 1000 + 1;

		// 傳輸速度Gbyte/s 傳送速率 計算剩餘時間用
		double velocity = ((double) status.getBytesRead()) / (double) time;

		// 估計時間
		double totalTime = status.getContentLength() / velocity;

		// 剩餘時間
		double timeLeft = totalTime - time;

		// 已完成百分比
		int percent = (int) (100 * (double) status.getBytesRead() / (double) status.getContentLength());

		// 已完成數
		// double length = ((double) status.getBytesRead()) / 1024 / 1024;

		// 總長度
		double totalLength = ((double) status.getContentLength()) / 1024 / 1024;

		// 百分比||檔案總長度||傳輸速度||已上傳的時間||估計時間||剩餘時間
		String value = percent + "||" + totalLength + "||" + velocity + "||" + time + "||" + totalTime + "||"
				+ timeLeft;

		response.getWriter().println(value);

	}

}
