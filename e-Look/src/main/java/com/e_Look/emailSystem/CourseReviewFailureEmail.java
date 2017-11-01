package com.e_Look.emailSystem;

import java.io.UnsupportedEncodingException;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import com.e_Look.Course.CourseVO;
import com.e_Look.member.model.MemberVO;

public class CourseReviewFailureEmail {
	 static String  user = "eeit9702@gmail.com";
     static String  pwd = "eeit9702eeit9702";
	@SuppressWarnings("static-access")
	public  static  void sendmail(MemberVO memberVO ,CourseVO courseVO) {
		Transport transport=null;
   
        //接收者的email.
        String to = memberVO.getEmail();
        //寄件人的email
        String from = "eeit9702@gmail.com";
        // 寄件的smtp伺服器
        String host = "smtp.gmail.com";
        // 主旨
        String subject = "會員認證信";
        //內文
        String body = "請愛的"+memberVO.getmName()+"您好，\n您送審的課程:"+courseVO.getCourseName()+"，經審核後發現內容有不適當之處，以將該課程退回為草稿狀態，請至會員中心修改該課程不當之處，修改完成後請再次送審。";
 
        // 建立一個Properties來設定Properties
        Properties properties = System.getProperties();

        //設定傳輸協定為smtp
        properties.setProperty("mail.transport.protocol", "smtp");
        //設定mail Server
        properties.setProperty("mail.smtp.host", host);
        properties.setProperty("mail.smtp.port", "465");
        //需要驗證帳號密碼
        properties.put("mail.smtp.auth", "true");
        //Bypass the SSL authentication
        properties.put("mail.smtp.ssl.enable", true);
        properties.put("mail.smtp.starttls.enable", true);

        //帳號，密碼
        SmtpAuthenticator authentication = 
                new SmtpAuthenticator(user, pwd);

        // 建立一個Session物件，並把properties傳進去
        Session mailSession = Session.
                getDefaultInstance(properties, authentication);

        try {
            //建立一個 MimeMessage object.
            MimeMessage message = new MimeMessage(mailSession);

            // 設定寄件人                                          Java是收件人顯示寄件人的名稱
            message.setFrom(new InternetAddress(from,"e-Look學習平台"));

            // 設定收件人
            message.addRecipient(Message.RecipientType.TO,
                    new InternetAddress(to));

            // 設定主旨
            message.setSubject(subject);

            //設定內文
            message.setText(body);

            transport = mailSession.getTransport();

            // 傳送信件         
            Transport.send(message);
            
//           System.out.println("發送成功");
           
        } catch (MessagingException | UnsupportedEncodingException mex) {
        System.out.println(mex.getMessage());
        }
        
    }
}
