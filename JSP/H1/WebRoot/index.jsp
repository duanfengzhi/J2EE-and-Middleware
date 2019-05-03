<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
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
   <font size=7 >欢迎来到开心水果店购物</font><br><br><p>
    <hr size="6" width="70%" align="left" color="gray">
    <p>
   
    <form action="AddToCar" method="post">
             <table cellspacing="5"cellpadding="5" align="center">
             <tr><td>种类</td><td><B>单价</B></td><td><B>数量</B></td></tr>
             <tr><td>苹果</td><td>5.5</td><td><input type="text" name="apple"></td></tr>
             <tr><td>香蕉</td><td>4.5</td><td><input type="text" name="banana"></td></tr>
             <tr><td>葡萄</td><td>3.6</td><td><input type="text" name="grape"></td></tr>
          </table>
          
             
      <p><p>
      
        
    <hr size="6" width="70%" align="left" color="gray"><br>
    <input type="submit" value="放入购物车"/>
    </form>
    
  </body>
</html>
    

