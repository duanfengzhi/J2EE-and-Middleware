package com.servlet;

import javax.servlet.http.HttpSessionListener;
import javax.servlet.http.HttpSessionEvent;
public class SessionListener implements HttpSessionListener {
        public void sessionCreated(HttpSessionEvent evt) {
        // 修改在线人数+1
        System.out.println("Session created!!!!");
        String  current= (String)evt.getSession().getServletContext().getAttribute("online");
         if(current==null)current="0";
         int c=Integer.parseInt(current);
         c++;
         current=String.valueOf(c);
         evt.getSession().getServletContext().setAttribute("online",current);
         //修改历史人数+1
         String  his= (String)evt.getSession().getServletContext().getAttribute("Counter");
         if(his==null)his="0";
         int total=Integer.parseInt(his)+1;
         his=String.valueOf(total);
         evt.getSession().getServletContext().setAttribute("Counter",his);
    }
    public void sessionDestroyed(HttpSessionEvent evt) {
          // 修改在线人数-1
         String  current= (String)evt.getSession().getServletContext().getAttribute("online");
         if(current==null)current="0";
         int c=Integer.parseInt(current);
         c--;
         current=String.valueOf(c);
         evt.getSession().getServletContext().setAttribute("online",current);
    }
}

