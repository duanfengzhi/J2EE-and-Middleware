<%@ page contentType="text/html; charset=GBK"%>
<%@ page import="java.util.*,javax.naming.*,cart.*"%>
<%
	try {
		Cart cat = (Cart)session.getAttribute("cat");
		 //Cart cat ;     
		if(cat==null){//����һ�����ﳵ
		
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
		cat.AddBuyItem("��Ī��ȫ����");
		List<String> buyitem = cat.getBuyItem();
		out.println("���ﳵ����Ʒ�б�<br>");
		for(String n : buyitem){
			out.println("  "+ n+ "<br>");
		}		
	} catch (NamingException e) {
		System.out.println(" error");
		out.println(e.getMessage());
	}
	System.out.println("success!");
%>
