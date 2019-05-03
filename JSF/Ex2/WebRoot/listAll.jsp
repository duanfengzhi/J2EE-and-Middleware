<%@ page language="java" import="com.bean.ManagedBean,java.util.*" pageEncoding="UTF-8"%>
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
    
    <title>My JSP 'listAll.jsp' starting page</title>
    
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
    <h:dataTable bgcolor="lightblue" 
                 value="#{student.list}" var="list" 
                 border="5" cellpadding="10" cellspacing="4">
      <h:column>
        <f:facet name="header">
          <h:outputText id="headerText1" value="学号"/>
        </f:facet>
        <h:outputText value="#{list.id}"/>
      </h:column>
      <h:column>
        <f:facet name="header">
          <h:outputText id="headerText2" value="姓名"/>
        </f:facet>
        <h:outputText value="#{list.name}"/>
      </h:column>
      
         <h:column>
        <f:facet name="header">
          <h:outputText id="headerText3" value="性别"/>
        </f:facet>
        <h:outputText value="#{list.sex}"/>
      </h:column>
      
         <h:column>
        <f:facet name="header">
          <h:outputText id="headerText4" value="年龄"/>
        </f:facet>
        <h:outputText value="#{list.age}"/>
      </h:column>
      
    </h:dataTable><p>
    <h:commandButton value="返回上一页" action="listBack"/> 
    
    </h:form>
  </f:view>

  </body>
</html>
