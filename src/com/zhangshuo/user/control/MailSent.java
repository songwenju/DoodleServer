package com.zhangshuo.user.control;

import java.util.Date;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import com.zhangshuo.common.ProjectConstant;
/**
 * 发邮件
 */
public class MailSent {
	private String fromMail = ProjectConstant.EMAIL_FROM; 		//发件人邮箱地址
	private String user = ProjectConstant.EMAIL_USER;		//发件人称号
	String password = ProjectConstant.EMAIL_PWD;			//发件人邮箱密码

	//构造函数
	public MailSent(){
	}

	/**
	 * 发送验证信息的邮件
	 * @param to
	 * @param text
	 * @param title
	 */
	public void sendMail(String toMail,String mailContent,String mailTitle) {  
		Properties props = new Properties(); //可以加载一个配置文件  
		// 使用smtp：简单邮件传输协议  
		props.put("mail.smtp.host", "smtp.163.com");//存储发送邮件服务器的信息  
		props.put("mail.smtp.auth", "true");//同时通过验证  

		Session session = Session.getInstance(props);//根据属性新建一个邮件会话  
		//session.setDebug(true); //有他会打印一些调试信息。  

		MimeMessage message = new MimeMessage(session);//由邮件会话新建一个消息对象  
		try{  
			message.setFrom(new InternetAddress(fromMail));//设置发件人的地址  
			message.setRecipient(Message.RecipientType.TO, new InternetAddress(toMail));//设置收件人,并设置其接收类型为TO  
			message.setSubject(mailTitle);//设置标题  
			//设置信件内容  
			//message.setText(mailContent); //发送 纯文本 邮件 todo  
			message.setContent(mailContent, "text/html;charset=gbk"); //发送HTML邮件，内容样式比较丰富  
			message.setSentDate(new Date());//设置发信时间  
			message.saveChanges();//存储邮件信息  

			//发送邮件  
			//Transport transport = session.getTransport("smtp");  
			Transport transport = session.getTransport("smtp");  
			transport.connect(user, password);  
			transport.sendMessage(message, message.getAllRecipients());//发送邮件,其中第二个参数是所有已设好的收件人地址  
			transport.close();  
		} catch(MessagingException e){  
			e.printStackTrace();  
		}  
	}  


	/**
	 * 
	 * @param to
	 * @param userName
	 * @return
	 */
	public void sendRegistMail(String to,String userName){
		String text = ProjectConstant.EMAIL_REGISTER_TEXT;	
		String title = ProjectConstant.EMAIL_REGISTER_TITLE;
		sendMail(to,text,title);
	}
	/**
	 * @param to
	 * @param userName
	 */
	public String sendResetPwdMail(String to,String userName){
		String checkCode = "" +((int)(Math.random()*100000));
		String text = ProjectConstant.EMAIL_FINDPWD_TEXT+"<h4>"+checkCode+"</h4>";
		String title = ProjectConstant.EMAIL_FINDPWD_TITLE;
		sendMail(to,text,title);
		return checkCode;
	}

	/*	public  static void main(String[]arg){
	SendMail s = new SendMail();
	s.sendRegistMail("1565270590@qq.com", "swj");
	}*/
}
