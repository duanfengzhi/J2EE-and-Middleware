<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'Car.jsp' starting page</title>
    
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

 <form action="Add" method="post">
 输入商品名称： <input type="text"  name="item"> <p>
 <input type="submit" value="添加"/>
 <%List<String> buyitem=(List)session.getAttribute("list");
 String Do=(String)session.getAttribute("do");
 if(Do!=null&&!"".equals(Do))
 {
 if(buyitem!=null&&Do.equals("添加"))
 {
 	out.println("购物车中的商品列表:");
 	for(int i=0;i<buyitem.size();i++)
 	out.println(buyitem.get(i)+"  ");
 }else if(Do.equals("清空"))
 {out.println("购物车为空!");}
 }
  %>
  </form>
   
  <form action="Delete" method="post">
 <input type="submit" value="清空"/>
   </form>
   
    <form action="SendLog" method="post">
 <input type="submit" value="提交"/>
   </form>

   
  </body>
</html>
