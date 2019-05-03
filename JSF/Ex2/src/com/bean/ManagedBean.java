package com.bean;

import java.io.File;
import java.io.FileWriter;
import java.sql.Connection;

import javax.faces.context.FacesContext; 

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.faces.event.ActionEvent;


import javax.servlet.http.HttpServletRequest;

import java.sql.PreparedStatement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ManagedBean {
	
	private String id;
	private String name;
	private String sex;
	private int age;
	private List<ManagedBean> list;
	private String[] ss;
	private List<ManagedBean> addlist= new ArrayList<ManagedBean>(); ;	//待完善信息的学生list
	private String log;	//操作日志
	
	private PreparedStatement stmt;
	private Connection con;
	private ResultSet results;
	private String url;
	private String user;
	private String password;
	private String driver;
	private String Select="SELECT * FROM student";
	private String Insert="INSERT INTO student values(?,?,'M',0)";	//默认性别为"M",年龄为0,在添加信息页面再更新。
	private String Delete="delete from student where Id=?";
	private String Update="Update student set sex=?,age=? where id=?";
	
	public ManagedBean(){
		con=null;   //声明Connection对象
	    stmt = null;

	      driver = "com.mysql.jdbc.Driver";	//驱动程序名
	      url = "jdbc:mysql://localhost:3306/h1";	//URL指向要访问的数据库名mydata
	      user = "root";	//MySQL配置时的用户名
	      password = "123456";		//MySQL配置时的密码
	     
	     try{
	    	 Class.forName(driver);	//加载驱动程序
	     }catch (Exception e) {
	          e.printStackTrace();
	        } 
	}
	
	public ManagedBean(String Id,String name,String sex,int age){
		this.id=Id;
		this.name=name;
		this.sex=sex;
		this.age=age;
	}
	
	public ManagedBean(String Id,String name){
		this.id=Id;
		this.name=name;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	public List<ManagedBean> getList(){
		return list;
	}
	public void setList(List<ManagedBean>list) {
		this.list=list;
	}
	public void setSs(String[]ss){
		this.ss=ss;
	}
	public String[] getSs(){
		return ss;
	}
	public List<ManagedBean> getAddlist() {
		return addlist;
	}

	public void setAddlist(List<ManagedBean>addlist) {
		this.addlist = addlist;
	}
	
	public void  setStudent(ActionEvent event){
		
		if(ss.length==2){
			String id=ss[0];
			String name=ss[1];
			
			ManagedBean stu=new ManagedBean(id,name);
			addlist.add(stu);
		
		try {
			con = DriverManager.getConnection(url,user,password);	
			stmt=con.prepareStatement(Insert);
			stmt.setString(1, id);
			stmt.setString(2, name);
			stmt.executeUpdate();	
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
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
		Date date = new Date();    
	    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	    String time = dateFormat.format( date );
		
		 log="新建学生成功----------"+time+"\n";
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
		}
	}
	
	public void addInfo(ActionEvent event){
		try {
			
			con = DriverManager.getConnection(url,user,password);	
			stmt=con.prepareStatement(Update);
			String sex=this.sex;
			int age=this.age;
			stmt.setString(1,sex);
			stmt.setInt(2, age);
			stmt.setString(3,this.id);
			stmt.executeUpdate();	
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
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
		Date date = new Date();    
	    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	    String time = dateFormat.format( date );
		 log="将学号为："+this.id+"的学生信息添加成功!----------"+time+"\n";
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
	}
	
	public void deleteStu(ActionEvent event){
		try {
			con = DriverManager.getConnection(url,user,password);	
			stmt=con.prepareStatement(Delete);
			String id=this.id;
			stmt.setString(1,id);
			stmt.executeUpdate();	
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
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
		Date date = new Date();    
	    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	    String time = dateFormat.format( date );
		 log="成功将学号为："+this.id+"的学生删除!----------"+time+"\n";
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
	}

	

	public void listAll(ActionEvent event){
		list = new ArrayList<ManagedBean>();
		
		 try {
			con = DriverManager.getConnection(url,user,password);	
			stmt = con.prepareStatement(Select);
			results = stmt.executeQuery();
			
            while (results.next()) {
                String id=results.getString(1);
                String name=results.getString(2);
                String sex=results.getString(3);
                int age=results.getInt(4);
                ManagedBean student=new ManagedBean(id,name,sex,age);
                list.add(student);  
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
	}


}
