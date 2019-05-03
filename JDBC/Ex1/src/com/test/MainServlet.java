package com.test;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.UserDao;

public class MainServlet extends HttpServlet {

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		
		 response.setContentType("text/html;charset=utf-8"); 
	     request.setCharacterEncoding("utf-8");
	        
		String str1=request.getParameter("username");
		String str2=request.getParameter("password");
		String checkBox = request.getParameter("save_password");
		
		request.getSession().setAttribute("nameSession", str1);
		
		UserDao ud=new UserDao();
		boolean t=ud.verify(str1, str2);
		
		
		
		if(t)
		{
			 if ("save".equals(checkBox)) 
			 {
				
	                String name = URLEncoder.encode(str1,"UTF-8");
	                Cookie nameCookie = new Cookie("username", name);
	                //设置Cookie的有效期为3天
	                nameCookie.setMaxAge(60 * 60 * 24 * 3);
	                String pwd = URLEncoder.encode(str2,"UTF-8");
	                Cookie pwdCookie = new Cookie("password", pwd);
	                pwdCookie.setMaxAge(60 * 60 * 24 * 3);
	                response.addCookie(nameCookie);
	                response.addCookie(pwdCookie);

			 }
					 
			 request.getRequestDispatcher("Welcome.jsp").forward(request, response);
		}
			
		
		else
			request.getRequestDispatcher("LoginFall.jsp").forward(request, response);
		
	}

}
