package ejbtest;

import java.io.File;
import java.io.FileWriter;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

@MessageDriven(activationConfig={

		@ActivationConfigProperty(propertyName="destinationType",propertyValue="javax.jms.Queue"),

		@ActivationConfigProperty(propertyName="destination",propertyValue="java:/queue/test")

})

public class LogMessageBean implements MessageListener {

	@Override
	public void onMessage(Message msg) {

		TextMessage message=(TextMessage) msg;
		
		 File f=new File("D:\\JAVA_shixun\\workspace\\Client\\WebRoot\\log.txt");
		 
		  try{
			  String log=message.getText();
		
			  FileWriter fw=new FileWriter(f,true);  
			  fw.write(log);	//使用MDB实现把字符串追加写入log.txt文件
			  fw.close();
			} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
