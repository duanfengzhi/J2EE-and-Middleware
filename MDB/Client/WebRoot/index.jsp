
<%@ page contentType="text/html; charset=GBK"%>
<%@ page import="java.util.*,javax.naming.*"%>
<%@ page import="ejbtest.*"%>
<%
         final Hashtable jndiProperties = new Hashtable();        
		 jndiProperties.put(Context.URL_PKG_PREFIXES, "org.jboss.ejb.client.naming");        
		 final Context context = new InitialContext(jndiProperties);   
		              
		 final String moduleName = "Client";                
		 final String distinctName = "";                
		 final String beanName = "CartBean";                
		 final String viewClassName = Cart.class.getName();                
		 final String namespace = "ejb:"+ "/" + moduleName 			
				  +"/" + beanName + "!" + viewClassName+"?stateful";                
	try {
		InitialContext ctx = new InitialContext();
		//Cart cat=(Cart)ctx.lookup(namespace);
		Cart cat = (Cart)session.getAttribute("cat");
		String s=Cart.class.getName();
		if(cat==null){//创建一个购物车
			cat = (Cart) ctx.lookup(namespace);
			 session.setAttribute("cat", cat);
		}
		cat.AddBuyItem("《莫言全集》");
		cat.AddBuyItem("《毛泽东选集》");
		cat.AddBuyItem("算法导论");
		
		cat.deleteBuyItem("算法导论");
		
		List<String> buyitem = cat.getBuyItem();
		out.println("购物车的商品列表：<br>");
		for(String name : buyitem){
			out.println("  "+ name+ "<br>");
		}		
	} catch (Exception e) {
		out.println(e.getMessage());
	}
%>
		
