package com.servlet;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
public class CounterListener implements ServletContextListener {
	String path="";
	public void contextInitialized(ServletContextEvent evt) {
		CounterFile f=new CounterFile();
		//从上下文CounterPath中获得文件路径的初始值，改上下文在web.xml中
		String name=evt.getServletContext().getInitParameter("CounterPath");
		//获得真正的文件路径
		//path=evt.getServletContext().getRealPath(name);
		//path="/H2/WebRoot/count.txt";
		path="D:/JAVA_shixun/workspace/H2/WebRoot/count.txt";
		try{	//打开文件，读出文件内容_网站的访问数
			String temp=f.ReadFile(path);
			//将访问数存入上下文“Counter”中
			System.out.println("历史记录从文件读出temp="+temp);
			evt.getServletContext().setAttribute("Counter", temp);
		}
		catch(Exception e){
			System.out.println(e.toString());
		}
		System.out.println("Servlet load context!");
	}
	public void contextDestroyed(ServletContextEvent evt) {
		try{	String current=(String)evt.getServletContext().getAttribute("Counter");
			CounterFile f=new CounterFile();
			if(current==null) current="0";
			f.WriteFile(path,current);
		}
		catch(Exception e){
			System.out.println("Context destroy error "+e.toString());
		}
		System.out.println("Context destroy");
	}
}


