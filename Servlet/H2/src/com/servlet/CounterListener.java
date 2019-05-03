package com.servlet;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
public class CounterListener implements ServletContextListener {
	String path="";
	public void contextInitialized(ServletContextEvent evt) {
		CounterFile f=new CounterFile();
		//��������CounterPath�л���ļ�·���ĳ�ʼֵ������������web.xml��
		String name=evt.getServletContext().getInitParameter("CounterPath");
		//����������ļ�·��
		//path=evt.getServletContext().getRealPath(name);
		//path="/H2/WebRoot/count.txt";
		path="D:/JAVA_shixun/workspace/H2/WebRoot/count.txt";
		try{	//���ļ��������ļ�����_��վ�ķ�����
			String temp=f.ReadFile(path);
			//�����������������ġ�Counter����
			System.out.println("��ʷ��¼���ļ�����temp="+temp);
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


