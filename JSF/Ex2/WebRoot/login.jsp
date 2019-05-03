<%@ page language="java" pageEncoding="UTF-8"%>
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

	<title>My JSF 'login.jsp' starting page</title>
	
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
           <h3>输入用户名和密码</h3> 
	    用户名: <h:inputText id="name" value="#{user.name}"/>&nbsp;&nbsp;&nbsp;&nbsp;
	 <h:outputText id="errMessage" style="color:red" value="#{user.errMessage}"/><p>
	    密码:&nbsp;&nbsp;&nbsp;&nbsp; <h:inputSecret id="password" value="#{user.password}"/><p> 
  
	  <h:commandButton value="登录" action="#{user.verify}" /> 
	  
	</h:form> 
	</f:view>
</body>
</html>