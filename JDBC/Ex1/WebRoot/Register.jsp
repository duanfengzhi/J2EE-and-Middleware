<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'Register.jsp' starting page</title>
    
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
     <form action="Regist" method="post">
            输入您的注册信息:<br><br>
           用户名：<input type="text" name="username" value='${param.username}'>

   <% String error=(String)request.getAttribute("error");if(error!=null){%>
   <font size=3 color="red"> <%=error%><%} %></font><br><br>
    
     密码：&nbsp;&nbsp;&nbsp;&nbsp;<input type="password" name="password" value='${param.password}'><br><br>
           
   <input type="submit" value="注册"/>
    </form>
  </body>
</html>
