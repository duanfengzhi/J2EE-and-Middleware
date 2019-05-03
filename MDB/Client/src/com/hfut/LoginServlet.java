package com.hfut;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Hashtable;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ejbtest.*;

public class LoginServlet extends HttpServlet {

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		 response.setContentType("text/html;charset=utf-8"); 
	     request.setCharacterEncoding("utf-8");
	     HttpSession session=request.getSession();
	        
          Hashtable jndiProperties = new Hashtable();       
		 jndiProperties.put(Context.URL_PKG_PREFIXES, "org.jboss.ejb.client.naming");  
		           
		 String moduleName = "Client";                
		 String distinctName = "";                
		 String beanName = "LoginBean";                
		 String viewClassName = Login.class.getName();                
		 String namespace = "ejb:"+ "/" + moduleName 			
				  +"/" + beanName + "!" + viewClassName;          
	try {   
	    Context context = new InitialContext(jndiProperties); 
		InitialContext ctx = new InitialContext();
		Login login=(Login)ctx.lookup(namespace);
		String str1=request.getParameter("username");
		String str2=request.getParameter("password");
		
		if(login.isTrue(str1, str2))
		{
			request.getRequestDispatcher("Car.jsp").forward(request, response);
		}
	     
		else
		{
			String err="用户名或密码错误，请重新登录";
			session.setAttribute("err",err);
			request.getRequestDispatcher("Login.jsp").forward(request, response);
		}
		  
		
	
	} catch (Exception e) {
		e.printStackTrace();
	}

	}
	
}
