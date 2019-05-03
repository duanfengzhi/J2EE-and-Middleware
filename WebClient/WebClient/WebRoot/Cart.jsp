<%@ page contentType="text/html; charset=GBK"%>
<%@ page import="java.util.*,javax.naming.*,cart.*"%>
<%
	try {
		Cart cat = (Cart)session.getAttribute("cat");
		 //Cart cat ;     
		if(cat==null){//创建一个购物车
		
		final Hashtable jndiProperties = new Hashtable();        
		 jndiProperties.put(Context.URL_PKG_PREFIXES, "org.jboss.ejb.client.naming");        
		 final Context context = new InitialContext(jndiProperties);   
		 
		 final String appName = "";                
		 final String moduleName = "Cart";                
		 final String distinctName = "";                
		 final String beanName = "CartBean";                
		 final String viewClassName = Cart.class.getName();                
		 final String namespace = "ejb:" + appName + "/" + moduleName 			
				 + "/" + distinctName + "/" + beanName + "!" + viewClassName;                
		 System.out.println("-----------"+namespace);
		
		System.out.println("two");
		cat = (Cart)context.lookup(namespace);
		System.out.println("three");	
		System.out.println("ffffffffffffffffff");
			session.setAttribute("cat", cat);
		}
		cat.AddBuyItem("《莫言全集》");
		List<String> buyitem = cat.getBuyItem();
		out.println("购物车的商品列表：<br>");
		for(String n : buyitem){
			out.println("  "+ n+ "<br>");
		}		
	} catch (NamingException e) {
		System.out.println(" error");
		out.println(e.getMessage());
	}
	System.out.println("success!");
%>
