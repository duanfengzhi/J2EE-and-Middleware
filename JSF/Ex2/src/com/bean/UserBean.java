package com.bean;



import java.io.File;
import java.io.FileWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.faces.event.ActionEvent;

public class UserBean {  
private String name; 
private String password;  
private String errMessage;  
private String log;	//������־����¼��¼����.


	public void setName(String name) {  
		this.name = name;  
	} 
	public void setPassword(String password) {  
		this.password = password;  
	} 

	public String getName() {  
	return name;  
	} 
	
	public String getPassword(){
		return password;
	}
	
  public String verify() {  
	  if(!name.equals("admin")||!password.equals("admin123")) {  
		  errMessage = "���ƻ��������"; 

		Date date = new Date();    
	    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	    String time = dateFormat.format( date );
		  log="��¼ʧ��! ----------"+time+"\n";
		  File f=new File("D:\\JAVA_shixun\\workspace\\Ex2\\WebRoot\\log.txt");
		  FileWriter fw;
		  try{
			  fw=new FileWriter(f,true);  
			  fw.write(log);
			  fw.close();
			} catch(Exception e)
			  { 
				e.printStackTrace();
			}

		  return "failure";  
	  } else {
		  errMessage=null;
		  Date date = new Date();    
		 SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		 String time = dateFormat.format( date );
		  log="��¼�ɹ�! ----------"+time+"\n";
		  File f=new File("D:\\JAVA_shixun\\workspace\\Ex2\\WebRoot\\log.txt");
		  FileWriter fw;
		  try{
			  fw=new FileWriter(f,true);  
			  fw.write(log);
			  fw.close();
			} catch(Exception e)
			  { 
				e.printStackTrace();
			}
		  
		  	return "success";  
	  } 
	  
	  
  } 
	
  
  public String getErrMessage(){
	  return errMessage;
  }

}
