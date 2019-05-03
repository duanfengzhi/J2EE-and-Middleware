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
    
    <title>My JSP 'addInfo.jsp' starting page</title>
    
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
    	输入将要被添加信息的学生学号：<p>
    	<h:inputText  value="#{student.id}"/><p>
    	添加性别和年龄：<br><br>
    	
    	性别：<h:inputText  id="sex" value="#{student.sex}">
    	<f:validator  validatorId="sexvalidator"/>
    	</h:inputText>
    	<h:message for="sex" style="color:red"/><p>
    	
    	年龄：<h:inputText id="age" value="#{student.age}">
    	<f:validateDoubleRange minimum="15" maximum="30"/>
    	</h:inputText>
    	<h:message for="age" style="color:red"/><p>
    	
    	<h:commandButton value="添加信息" actionListener="#{student.addInfo}"/>
    	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    	<h:commandButton value="返回" action="addBack"/> 
    	</h:form>
    </f:view>
  </body>
</html>
