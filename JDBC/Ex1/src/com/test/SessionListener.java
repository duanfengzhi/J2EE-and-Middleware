package com.test;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSessionListener;
import javax.servlet.http.HttpSessionEvent;
public class SessionListener implements HttpSessionListener {
	
        public void sessionCreated(HttpSessionEvent evt) {
        	
        	ServletContext context = evt.getSession().getServletContext();
            
            Integer count = (Integer) context.getAttribute("online");
            if (count == null) {
                count = 1;
            } else {
                count++;
            }
            context.setAttribute("online", count);
          

       }

    public void sessionDestroyed(HttpSessionEvent evt) {

    	 ServletContext context = evt.getSession().getServletContext();
         Integer count = (Integer) context.getAttribute("online");

          count--;
         context.setAttribute("online", count);
         

    }
}

