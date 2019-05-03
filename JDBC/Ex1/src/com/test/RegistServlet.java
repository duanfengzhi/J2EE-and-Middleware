package com.test;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.UserDao;

public class RegistServlet extends HttpServlet {

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		
    response.setContentType("text/html;charset=utf-8"); 
	request.setCharacterEncoding("utf-8");
	     
	UserDao ud=new UserDao();
	String name=request.getParameter("username");
	String psw=request.getParameter("password");
	
	boolean q=ud.regist(name, psw);
	String error;
	
	boolean t;
	if(psw!=null&&!psw.equals("")) t=true;
	else t=false;
	
	if(q&&t)
	{
		error=null;
		request.setAttribute("error", error);
		request.getRequestDispatcher("login.jsp").forward(request, response);
	}
		
	else if(!t)
	{
		error="密码不能为空！";
		request.setAttribute("error", error);
		request.getRequestDispatcher("Register.jsp").forward(request, response);
	}
	
	else 
	{
	      error="注册失败，用户名已被占用，请重新注册";
		 request.setAttribute("error", error);
		request.getRequestDispatcher("Register.jsp").forward(request, response);	
	 }

  }
	
	

}
