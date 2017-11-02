package fileupload;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.e_Look.eLookEvent.eLookEventDAO;
import com.e_Look.eLookEvent.eLookEventVO;

/*@MultipartConfig 之屬性設定
location:檔案上傳中，暫存時所存放的位置。若該資料夾不存在會丟出例外。	default=""
fileSizeThreshold:暫存檔案的大小限制。						default=0(bytes)
maxFileSize:單支檔案的最大上限限制。							default=unlimit(bytes)
maxRequestSize:該次請求所有檔案的大小限制。					default=unlimit(bytes)
也可設定於web.xml
檔案限制數值很大的話記得加上L
*/
@MultipartConfig(location = "", 
fileSizeThreshold = 1024 * 1024, 
maxFileSize = 1024 * 1024 * 1024* 2L , 
maxRequestSize = 1024 * 1024 * 1024* 3L)
@WebServlet("/Upload1")
public class Upload1 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {		

		//getPart()方法是getParameter()的檔案版
		Part part = request.getPart("myFile");
		System.out.println(part);
		
		//取得MineType
		String fileName = part.getSubmittedFileName();
		System.out.println(fileName);
		//取得副檔名".jpg"
		String subFileName=fileName.substring(fileName.lastIndexOf("."));
		System.out.println(subFileName);
		//以下參考基礎JAVA IO
		InputStream is = part.getInputStream();
		
		Double d = 0.8;
		eLookEventVO vo=new eLookEventVO();
		Date da=new Date(2017,10,16);
		Date da1=new Date(2017,10,18);
		vo.setEventName("ss");
//		vo.setePhoto(is);
		vo.seteStartDate(da);
		vo.seteEndDate(da1);
		vo.setDiscount(d);
		new eLookEventDAO().insert(vo);
		
		//建立資料夾		
		//之後上傳檔案的路徑可以根據memberID和courseID動態變更		
		//JAVA 路徑的兩種表示方式  由於\為跳脫字元 所以要打\\
		//應該可省略判定資料夾是否存在，因為已經測試過傳不一樣名稱的檔案進去，這行並不會把原有的資料夾砍掉重建
		
		
/*		FileOutputStream fos = new FileOutputStream("D:\\eLookvideo\\courseID\\courseID"+subFileName);
		int data;
		while((data=is.read())!=-1){
			fos.write(data);
		}
		fos.close();
		is.close();	*/	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
