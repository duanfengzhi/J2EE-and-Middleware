使用的EJB容器：JBOSS
消息队列类型：点对点类型：@ActivationConfigProperty(propertyName="destinationType",propertyValue="javax.jms.Queue"),
消息队列名称：@ActivationConfigProperty(propertyName="destination",propertyValue="java:/queue/test")
连接工厂：@Resource(mappedName="java:/ConnectionFactory")
运行项目：将服务器端的项目EJBTest导出成jar包，并在客户端项目Client使用该jar包，然后将客户端项目Client以war包方式发布到\jboss-as-7.1.1.Final\standalone\deployments目录下，运行jboss即可自动部署。
注：其他配置细节及项目构成和运行情况请看实验报告。



