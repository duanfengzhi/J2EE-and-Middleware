
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
		if(cat==null){//����һ�����ﳵ
			cat = (Cart) ctx.lookup(namespace);
			 session.setAttribute("cat", cat);
		}
		cat.AddBuyItem("��Ī��ȫ����");
		cat.AddBuyItem("��ë��ѡ����");
		cat.AddBuyItem("�㷨����");
		
		cat.deleteBuyItem("�㷨����");
		
		List<String> buyitem = cat.getBuyItem();
		out.println("���ﳵ����Ʒ�б�<br>");
		for(String name : buyitem){
			out.println("  "+ name+ "<br>");
		}		
	} catch (Exception e) {
		out.println(e.getMessage());
	}
%>
		
