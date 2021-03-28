package com.liutao.common;

import com.liutao.util.RedisUtil;
import com.sun.mail.util.MailSSLSocketFactory;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import java.io.InputStream;
import java.security.GeneralSecurityException;
import java.util.Properties;

public class MailCommon {
     
	InputStream in = RedisUtil.class.getClassLoader().getResourceAsStream("config/mail.properties");
    public void sendMail(String acceptMail,String flag,String code) throws Exception {
    	
    	Properties p = new Properties();
		p.load(in);
		String sendmail = p.getProperty("sendmail");
		String authorizeCode = p.getProperty("authorize.code");
    	
    	//创建一个配置文件并保存
        Properties properties = new Properties();

        properties.setProperty("mail.host","smtp.qq.com");

        properties.setProperty("mail.transport.protocol","smtp");

        properties.setProperty("mail.smtp.auth","true");


        //QQ存在一个特性设置SSL加密
        MailSSLSocketFactory sf = new MailSSLSocketFactory();
        sf.setTrustAllHosts(true);
        properties.put("mail.smtp.ssl.enable", "true");
        properties.put("mail.smtp.ssl.socketFactory", sf);

        //创建一个session对象
        Session session = Session.getDefaultInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(sendmail,authorizeCode);
            }
        });

        //开启debug模式
        session.setDebug(true);

        //获取连接对象
        Transport transport = session.getTransport();

        //连接服务器
        transport.connect("smtp.qq.com",sendmail,authorizeCode);

        //创建邮件对象
        MimeMessage mimeMessage = new MimeMessage(session);

        //邮件发送人
        mimeMessage.setFrom(new InternetAddress(sendmail));

        //邮件接收人
        mimeMessage.setRecipient(Message.RecipientType.TO,new InternetAddress(acceptMail));
        
        String contents = mailFormwork(flag,code);
        //邮件标题
        mimeMessage.setSubject("套猴子技术支持");

        //邮件内容
        mimeMessage.setContent(contents,"text/html;charset=UTF-8");

        //发送邮件
        transport.sendMessage(mimeMessage,mimeMessage.getAllRecipients());

        //关闭连接
        transport.close();
    }
    
    private String mailFormwork(String flag,String code) {
    	String registeCode = "您注册的验证码为："
    						+ "<br>" + code;
    	String forgetPwd = "您本次重置密码的验证码为："
    						+ "<br>" + code;
    	
    	if("registe".equals(flag)) {
    		return registeCode;
    	}
    	return forgetPwd;
    }
}

