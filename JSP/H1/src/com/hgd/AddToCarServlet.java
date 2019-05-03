package com.hgd;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hgd.Fruit;

public class AddToCarServlet extends HttpServlet {

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

        response.setContentType("text/html;charset=gb2312");

		HttpSession session=request.getSession();
		
		 Fruit f=(Fruit)session.getAttribute("Fruit");
		 
		 String str1=request.getParameter("apple");
		 String str2=request.getParameter("banana");
		 String str3=request.getParameter("grape");
		 
		 
			if(f==null){
				f=new Fruit();	
				session.setAttribute("Fruit", f);
			}
			
			int newAppleAmount=0,newBananaAmount=0,newGrapeAmount=0;
			
			if(str1==null||str1.equals(""))newAppleAmount=f.getA();
			else  newAppleAmount=f.getA()+Integer.parseInt(str1);
				
			
			if(str2==null||str2.equals(""))newBananaAmount=f.getB();
			else newBananaAmount=f.getB()+Integer.parseInt(str2);
			
			if(str3==null||str3.equals(""))newGrapeAmount=f.getG();
			else newGrapeAmount=f.getG()+Integer.parseInt(str3);
			
			
			
			
			
	    f.set(newAppleAmount, newBananaAmount, newGrapeAmount);
		
		session.setAttribute("Fruit", f);
		
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
		out.println("<HTML>");
		out.println("  <HEAD><TITLE>A Servlet</TITLE></HEAD>");
		out.println("  <BODY>");
		
		out.println("你的购物车里有<br><br>");
		out.println(newAppleAmount+"斤苹果"+newBananaAmount+"斤香蕉"+newGrapeAmount+"斤葡萄<br><br>");
		out.println("<a href='index.jsp'>回到水果店</a>");
		out.println("  </BODY>");
		out.println("</HTML>");
		out.flush();
		out.close();
	}

}
