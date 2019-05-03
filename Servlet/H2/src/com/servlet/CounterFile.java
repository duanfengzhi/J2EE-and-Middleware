package com.servlet;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
public class CounterFile {
	private BufferedReader file;
    public CounterFile(){    }
    public String ReadFile(String filePath) throws FileNotFoundException{
    	String currentRecord=null;
    	BufferedReader file=new BufferedReader(new FileReader(filePath));
    	String returnStr=null;
    	try{ 	currentRecord=file.readLine();    	}
    	catch(IOException e){	System.out.println("��ȡ�ļ�����");   	}
    	if(currentRecord==null){  	returnStr="û���κμ�¼";  	}
    	else{	returnStr=currentRecord;  	}
    	return returnStr;
}
    public synchronized void WriteFile(String filePath,String counter)throws FileNotFoundException{
    	int Writerstr=0;
    	Writerstr=Integer.parseInt(counter);
    	try{   	PrintWriter pw=new PrintWriter(new FileOutputStream(filePath));
    		pw.println(Writerstr);
    		pw.close();
    	}
    	catch(IOException e){
    		System.out.println("д���ļ�����"+e.getMessage());
    	}
    }
}

