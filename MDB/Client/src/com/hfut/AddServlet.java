package com.hfut;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Hashtable;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ejbtest.*;

public class AddServlet extends HttpServlet {

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		 response.setContentType("text/html;charset=utf-8"); 
	     request.setCharacterEncoding("utf-8");
	     HttpSession session=request.getSession();   
	     
          Hashtable jndiProperties = new Hashtable();       
		 jndiProperties.put(Context.URL_PKG_PREFIXES, "org.jboss.ejb.client.naming");  
		           
		 String moduleName = "Client";                
		 String distinctName = "";                
		 String beanName = "CartBean";                
		 String viewClassName = Cart.class.getName();                
		 String namespace = "ejb:"+ "/" + moduleName 			
				  +"/" + beanName + "!" + viewClassName+"?stateful";          
	try {   
	    Context context = new InitialContext(jndiProperties); 
		InitialContext ctx = new InitialContext();
		
		Cart car = (Cart)session.getAttribute("car");
		if(car==null){//创建一个购物车
			car= (Cart) ctx.lookup(namespace);
			 session.setAttribute("car", car);
		}
		String item=request.getParameter("item");
		
		car.AddBuyItem(item);
		
		List<String> buyitem=car.getBuyItem();
		
		session.setAttribute("list", buyitem);
		session.setAttribute("do", "添加");
	   request.getRequestDispatcher("Car.jsp").forward(request, response);
	
	} catch (Exception e) {
		e.printStackTrace();
	}

	}
	
}
