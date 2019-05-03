<%@ page language="java" import="java.util.*,com.test.User" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
String username = "";
String password = "";
Cookie[] cookies = request.getCookies();
if(cookies!=null)
 for (int i = 0; i < cookies.length; i++) {
          //对cookies中的数据进行遍历，找到用户名、密码的数据
         if ("username".equals(cookies[i].getName())) {
          
             username = java.net.URLDecoder.decode(cookies[i].getValue(),"UTF-8");
         } else if ("password".equals(cookies[i].getName())) {
             password =  java.net.URLDecoder.decode(cookies[i].getValue(),"UTF-8");
         }
  }

%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'index.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
  </head>
  
  <body>
      <form action="Main" method="post">

     用户名：<input type="text" name="username" value="<%=username%>"><br><br>
     密码：&nbsp;&nbsp;&nbsp;&nbsp;<input type="password" name="password" value="<%=password%>">&nbsp;&nbsp;&nbsp;&nbsp; 
    
    <input type="checkbox" value="save" name="save_password">记住用户名和密码<br><br><p>
     
     
           
   <input type="submit" value="登录"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
  <a href="Register.jsp"><font size=4>新用户注册</font></a>
    </form>

  </body>
</html>
