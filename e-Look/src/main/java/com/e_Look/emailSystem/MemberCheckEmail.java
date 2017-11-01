package com.e_Look.emailSystem;

import java.io.UnsupportedEncodingException;
import java.security.Security;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;

public class MemberCheckEmail {

	

    static String  user = "eeit9702@gmail.com";
     static String  pwd = "eeit9702eeit9702";
	@SuppressWarnings("static-access")
	public  static  void sendmail(String email ,String getRequestURL) {
		Transport transport=null;
   
        //接收者的email.
        String to = email;
        //寄件人的email
        String from = "eeit9702@gmail.com";
        // 寄件的smtp伺服器
        String host = "smtp.gmail.com";
        // 主旨
        String subject = "會員認證信";
        //內文
        String body = "請愛的會員請您點擊該網址完成會員驗證,"+getRequestURL+"?emailID="+to;
 
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

	





 class SmtpAuthenticator extends Authenticator {

    private String USER;
    private String PASSWORD;

    //空的建構子
    public SmtpAuthenticator() {

        super();
    }

    //可以讓外部傳送帳號密碼進來的建構子
    public SmtpAuthenticator(String user, String password) {
        this();
        this.USER = user;
        this.PASSWORD = password;
    }

    @Override
    protected PasswordAuthentication getPasswordAuthentication() {
        String username = USER;
        String password = PASSWORD;
        if ((username != null) && (username.length() > 0)
                && (password != null)
                && (password.length() > 0)) {

            return new PasswordAuthentication(username, password);
        }

        return null;
    }

}