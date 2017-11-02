package com.e_Look.image;



import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.awt.image.WritableRaster;
import java.io.IOException;
import java.util.Iterator;

import javax.imageio.ImageIO;
import javax.imageio.ImageWriter;
import javax.imageio.stream.ImageOutputStream;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class dyna_image
 */
@WebServlet("/dyna_image.jpg")
public class dyna_image extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public dyna_image() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession  session=request.getSession();
         BufferedImage bufferedImage = new BufferedImage(50, 20, BufferedImage.TYPE_INT_RGB); 
         Graphics2D bufferedGraphics = bufferedImage.createGraphics(); 
         bufferedGraphics.setColor(Color.WHITE); 
         bufferedGraphics.fillRect(0, 0, 50, 20); //30 15
         bufferedGraphics.setColor(Color.BLACK); 
         //bufferedGraphics.drawRect(0, 0, 29, 14); //畫矩形框 

         String number = Integer.toString((int) (Math.random() * 10000)); //產生隨機安全校驗碼 
         while (number.length() < 4) { 
             number = "0" + number; 
         } 
         //session.setAttribute("SessionVariable",number); //將安全校驗碼存進session變數，供login來比對 
         session.setAttribute("verify",number); //將安全校驗碼存進session變數，供login來比對 
       
         bufferedGraphics.setFont( new Font("Arial", Font.BOLD, 20) ); //設定字型  //12
         bufferedGraphics.drawString(number, 3, 18); //1,12

         WritableRaster raster = bufferedImage.getRaster(); 
         int[] color = {0,0,0}; //black color 
         for(int i=0;i<100;i++) { //隨機畫50個點 
            int x = (int) (Math.random() * 50); //0 <= x <= 29 
            int y = (int) (Math.random() * 20); //0 <= y <= 14 
            raster.setPixel(x,y,color); //畫點 
         } 

         response.setContentType("image/jpeg"); 
         ServletOutputStream outstream = response.getOutputStream(); 

         Iterator ite = ImageIO.getImageWritersByFormatName("jpeg"); 
         ImageWriter imageWriter = (ImageWriter) ite.next(); 

         ImageOutputStream ios = ImageIO.createImageOutputStream(outstream); 
         imageWriter.setOutput(ios); 
         imageWriter.write(bufferedImage); 
         ios.flush(); 
         outstream.close(); 
	}

}
