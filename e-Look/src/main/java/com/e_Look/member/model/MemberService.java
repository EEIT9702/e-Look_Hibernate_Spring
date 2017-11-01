package com.e_Look.member.model;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;

import com.e_Look.emailSystem.MemberCheckEmail;

public class MemberService {
	private MemberDAO_interface dao;
	public MemberService(){
		dao=new MemberDAO();
	}
	public MemberVO getMemberMail(String email){ 
		return dao.findByPrimaryKey(email);
	}
	public MemberVO getMember(Integer MemberID ){ 
		return dao.findByPrimaryKey(MemberID);
	}
	public  void insertFBMember(String email ,String mName,String mPhoto){
		MemberVO memberVO1= new MemberVO();
		memberVO1.setmName(mName);
		memberVO1.setEmail(email);
		memberVO1.setmPassword("");
		memberVO1.setRegisterDate(new Date(System.currentTimeMillis()));
		memberVO1.setStatus((byte) 1);
		memberVO1.setCount(0);
		try {
		HttpURLConnection con = (HttpURLConnection)(new URL(mPhoto).openConnection());
		String location = con.getHeaderField("Location" );
		con.setInstanceFollowRedirects( false );
		con.connect();
		//int responseCode = con.getResponseCode();
		//System.out.println( responseCode );
		URL url  = new URL(location);
		//System.out.println(url);
		memberVO1.setmPhoto(url.openStream());
	} catch (MalformedURLException e) {
		e.printStackTrace();
	} catch (IOException e) {
		e.printStackTrace();
	}
	dao.insert(memberVO1);
	}
	public void insertGoogleMember(String email, String mName, String mPhoto) {
		MemberVO memberVO1= new MemberVO();
		memberVO1.setmName(mName);
		memberVO1.setEmail(email);
		memberVO1.setmPassword("");
		memberVO1.setRegisterDate(new Date(System.currentTimeMillis()));
		memberVO1.setStatus((byte) 1);
		memberVO1.setCount(0);
		try {
		URL url  = new URL(mPhoto);
		memberVO1.setmPhoto(url.openStream());
	} catch (MalformedURLException e) {
		e.printStackTrace();
	} catch (IOException e) {
		e.printStackTrace();
	}
	dao.insert(memberVO1);
		
	}


	public void insertMember(String email, String name, String password, String path) {
		MemberVO memberVO1= new MemberVO();
		memberVO1.setmName(name);
		memberVO1.setEmail(email);
		memberVO1.setmPassword(password);
		memberVO1.setRegisterDate(new Date(System.currentTimeMillis()));
		memberVO1.setStatus((byte) 0);
		memberVO1.setCount(0);
		try {
			memberVO1.setmPhoto(new FileInputStream(new File(path+"/img/imember_image.png")));
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		}
		dao.insert(memberVO1);
		
		
		
	}
	public void updateMemberStatus(Integer memberID) {
		MemberVO memberVO1= new MemberVO();
		memberVO1.setMemberID(memberID);
		memberVO1.setStatus((byte) 1);
		dao.update(memberVO1, "status");
	}
	public void updateMember(MemberVO memberVO) {
		dao.update(memberVO, "member");
		
	}
	public void updateMemberImage(Integer memberID, Part part) {
		
		if(part.getSize()>0){
			MemberVO memberVO1= new MemberVO();
			memberVO1.setMemberID(memberID);
			try {
				memberVO1.setmPhoto(part.getInputStream());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			dao.updataimage(memberVO1);
		}
		
	}
	
}
