<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'Welcome.jsp' starting page</title>
    
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
  <font size=12>欢迎来到WEB聊天室</font><p>
   <font size=5>当前在线人数：</font>
   <%Integer online=(Integer)application.getAttribute("online");if(online==null)online=0;
   out.print(online);%>人
   
    <form action="sendMess" method="post">
<textarea  cols="80" rows="20" name="show_textarea">
<%String mess=(String)application.getAttribute("mess");if(mess!=null)out.print(mess); %>
</textarea><p><p>

 <textarea  cols="80" rows="4"  name="mess"></textarea><br><br>
    
           
   <input type="submit" value="发送信息"/>
    </form>
  </body>
</html>
