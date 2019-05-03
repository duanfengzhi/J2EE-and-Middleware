<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'Login.jsp' starting page</title>
    
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
   <form action="Login" method="post">
   
   用户名:&nbsp;&nbsp;<input type="text"  name="username" value="${username}"><p>
   密码：&nbsp;&nbsp;&nbsp;<input type="password" name="password" value="${password}"><p>
  <input type="submit" value="登录"/>
  <%String err=(String)session.getAttribute("err");if(err!=null&&!"".equals(err))out.print(err); %>
  
   </form>
   
   
  </body>
</html>
