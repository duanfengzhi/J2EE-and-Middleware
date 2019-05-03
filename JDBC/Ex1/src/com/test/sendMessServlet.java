package com.test;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.core.Application;

public class sendMessServlet extends HttpServlet {

	 
	public String mymess="";
	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

        response.setContentType("text/html;charset=utf-8"); 
        request.setCharacterEncoding("utf-8");
		
		String mess=request.getParameter("mess");
		String username = (String)request.getSession().getAttribute("nameSession");
		
		Date date = new Date();    
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String time = dateFormat.format( date );


		mymess+=username+": "+mess+"                                  "+time+"\n";
		ServletContext context = this.getServletContext();
		context.setAttribute("mess",mymess);
		
		//request.setAttribute("mess",mymess);
		
		request.getRequestDispatcher("Welcome.jsp").forward(request, response);
	
		
	}

}
