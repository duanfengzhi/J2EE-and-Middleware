package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDao {
	
    String driver = "com.mysql.jdbc.Driver";	//����������
    String url = "jdbc:mysql://localhost:3306/h1";	//URLָ��Ҫ���ʵ����ݿ���mydata
    String user = "root";	//MySQL����ʱ���û���
    String password = "123456";		//MySQL����ʱ������
    String SELECT = "SELECT * FROM user";
    String insert = "INSERT INTO user values(?, ?)";
    
	Connection con=null;   //����Connection����
    PreparedStatement stmt = null;
    ResultSet results = null;
    
    public UserDao(){
    	
    	try {
			Class.forName(driver);
			con = DriverManager.getConnection(url,user,password);	
		} catch (Exception e) {
			e.printStackTrace();
		}	
    }
        
    
   
    public boolean regist(String name,String psw){
    	
    	boolean q=true;
    	try{
    		
    		   stmt = con.prepareStatement(SELECT);
		        results = stmt.executeQuery();
	    
	        while (results.next()) {
	            String username=results.getString(1);
	       
	            if(name.equals(username)){
	            	q=false;
	            	break;
	            }
	            
	        }
    		
	        if(q)
	        {
	        	stmt = con.prepareStatement(insert);
	    		stmt.setString(1, name);
	    		stmt.setString(2, psw);
	    		 stmt.executeUpdate();
	        }
    		      
    	}catch(Exception e){
    		e.printStackTrace();
    	}
    	
    	return q;
    	
    }
	
	public boolean verify(String str1,String str2){
	    
		boolean t=false;
	    try { 
	    	   
		        stmt = con.prepareStatement(SELECT);
		        results = stmt.executeQuery();
	    
	        while (results.next()) {
	            String username=results.getString(1);
	            String password=results.getString(2);
	            
	            if(str1.equals(username)){
	            	if(str2.equals(password))
	            	{
	            		t=true;
	            		break;
	            	}
	            }
	            
	        }
	    } catch (Exception e) {
	      e.printStackTrace();
	    } finally {
	        if (results != null) {
	            try { results.close(); } catch (SQLException e) {}
	        }
	        if (stmt != null) {
	            try { stmt.close(); } catch (SQLException e) {}
	        }
	        if (con!= null) {
	            try { con.close(); } catch (SQLException e) {}
	        }
	    }
	    return t;	
	}
 
}
