package com.e_Look.emailSystem;

public class ResetPwdSystem {

public String pwdGenerator(){
	
	
	
	String password="";
	char a = 0;
	for(int i=1;i<=10;i++){
		int selsetor=(int)(Math.random()*3)+1;
		 //System.out.println(selsetor);
		 //System.out.println(1);
		switch (selsetor) {
		case 1:
			int number=(int)(Math.random()*10)+48;
			a=(char) number;
			break;
		case 2:
			int capital=(int)(Math.random()*26)+65;
			a=(char) capital;
			break;
		case 3:
			int lower=(int)(Math.random()*26)+97;
			a=(char)lower;
			break;
		}
	password=password+a;
	}
	return password;
	
}
 public static void main(String[] args) {
	 ResetPwdSystem test=new  ResetPwdSystem();
	 System.out.println(test.pwdGenerator());
}
}
