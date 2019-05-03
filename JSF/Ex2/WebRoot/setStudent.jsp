<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'setStudent.jsp' starting page</title>
    
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
    <f:view>
    	<h:form>
    	请输入学生学号和姓名，格式： 学号：姓名<br><br>
    	<h:inputText converter="myconverter" value="#{student.ss}"/><p>
    	<h:commandButton value="提交" actionListener="#{student.setStudent}"/> 
    	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    	<h:commandButton value="返回" action="return"/> 
    	</h:form>
    </f:view>
  </body>
</html>
