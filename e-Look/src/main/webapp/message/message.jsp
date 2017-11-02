<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
 <form action="<%=request.getContextPath()%>/message/MessageController" method="post">
              <table width="300" height="300" border="0" align="center">
             
                <tr height="80" align="center">
                
                    <td colspan="2"><font size="24">留言發布欄</font></td>
                </tr>
               
                <tr height="30">
                  
                    <td width="80" align="right">用戶名：</td>
                   
                    <td><input type="text" name="name"></td>
                </tr>
                
                <tr height="30">
                  
                    <td width="80" align="right"> 密&nbsp;&nbsp;碼：</td>
                    
                    <td> <input type="password" name="password"></td>
                </tr>
                
                <tr height="20"><td colspan="2"></td></tr>
                
                <tr height="30">
                  
                    <td width="80" align="right">標&nbsp;&nbsp;題：</td>
                   
                    <td><input type="text" name="biaoti"></td>
                </tr>
                
                <tr>
                    <td width="80" align="right">內&nbsp;&nbsp;容：</td>
                  
                    <td><textarea name="neirong" rows="4" cols="20"></textarea></td>
                    <font color='red'>${ErrorMsgKey.mContentError}</font>
                    <font color='red'>${ErrorMsgKey.mContentError}</font>
                    <font color='red'>${MessageInsertOK}</font>
                </tr>
               
                <tr>
                    <td height="40" align="center" colspan="2">
                           <input type="submit" value="提交">
                    </td>
                </tr>
              
           </table>
    
        </form>

</body>
</html>