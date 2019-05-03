package  com.hfut;

import java.io.IOException;
import java.util.Hashtable;
import java.util.List;

import javax.annotation.Resource;
import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.QueueConnection;
import javax.jms.QueueConnectionFactory;
import javax.jms.QueueSession;
import javax.jms.TextMessage;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ejbtest.Cart;
import ejbtest.LogMessageBean;

public class SendLogServlet extends HttpServlet {

	//注入连接工厂和目的地
	@Resource(mappedName="java:/ConnectionFactory")
	private QueueConnectionFactory conFactory;
	@Resource(mappedName="java:/queue/test")
	private Destination destination;

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		 response.setContentType("text/html;charset=utf-8"); 
	     request.setCharacterEncoding("utf-8");
	     HttpSession mysession=request.getSession();   
	     
          Hashtable jndiProperties = new Hashtable();       
		 jndiProperties.put(Context.URL_PKG_PREFIXES, "org.jboss.ejb.client.naming");  
		           
		 String moduleName = "Client";                
		 String distinctName = "";                
		 String beanName = "CartBean";                
		 String viewClassName = Cart.class.getName();                
		 String namespace = "ejb:"+ "/" + moduleName 			
				  +"/" + beanName + "!" + viewClassName+"?stateful";    
		 
		QueueConnection queueConnection=null;

		QueueSession session=null;
		try {

			 Context context = new InitialContext(jndiProperties); 
				InitialContext ctx = new InitialContext();
				
				Cart car = (Cart)mysession.getAttribute("car");
				if(car==null){//创建一个购物车
					car= (Cart) ctx.lookup(namespace);
					 mysession.setAttribute("car", car);
				}		
				
			//创建队列连接
			 queueConnection=conFactory.createQueueConnection();
			 session=queueConnection.createQueueSession(false, QueueSession.AUTO_ACKNOWLEDGE);

			 //创建消息提供者
			MessageProducer producer=session.createProducer(destination);
			TextMessage message=session.createTextMessage();
			
			List<String> list=(List)car.getBuyItem();
			String log="";
			if(list!=null){
				for(int i=0;i<list.size()-1;i++)
				{ 
					log+=list.get(i)+":";
					
				}
				
				log+=list.get(list.size()-1)+"\n";
			}
			
			if(log!=null&&!"".equals(log))
			message.setText(log);
			//发送消息
			
			producer.send(message);
			
			car.remove();//清空购物车
			mysession.removeAttribute("do");
			mysession.removeAttribute("list");
			mysession.removeAttribute("err");
	
		} catch (Exception e) {
			e.printStackTrace();

		}finally{
			try {
				session.close();
				queueConnection.close();
			} catch (JMSException e) {
				e.printStackTrace();
			}
		}
		
		request.getRequestDispatcher("Login.jsp").forward(request, response);
	}
}
