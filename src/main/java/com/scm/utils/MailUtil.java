package com.scm.utils;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.internet.MimeMessage;

import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;  

/** 
*  发邮件工具类
*/  
public class MailUtil {  

  /** 
   * 发件人邮箱服务器 
   */  
  private String emailHost = "smtp.163.com";  
  
  /** 
   * 发件人邮箱 
   */  
  private String emailFrom = "no14724@163.com";  

  /** 
   * 发件人用户名 
   */  
  private String emailUserName = "no14724@163.com";  

  /** 
   * 发件人密码 
   */  
  private String emailPassword = "jing19900906";  

  /** 
   * 收件人邮箱，多个邮箱以“;”分隔 
   */  
  private String toEmails;  
  
  /** 
   * 邮件主题 
   */  
  private String subject = "无主题";  
  
  /** 
   * 邮件内容 
   */  
  private String content = "";  
  
  /** 
   * 邮件中的图片，为空时无图片。map中的key为图片ID，value为图片地址 
   */  
  private Map<String, String> pictures; 
  
  /** 
   * 邮件中的附件，为空时无附件。map中的key为附件ID，value为附件地址 
   */  
  private Map<String, String> attachments;  

  public void setEmailHost(String emailHost){
	  this.emailHost = emailHost;
  }
  
  public void setEmailFrom(String emailFrom){
	  this.emailFrom = emailFrom;
  }

  public void setEmailUserName(String emailUserName){
	  this.emailUserName = emailUserName;
  }
  
  public void setEmailPassword(String emailPassword){
	  this.emailPassword = emailPassword;
  }
  
  public void setToEmails(String toEmails){
	  this.toEmails = toEmails;
  }
  
  public void setSubject(String subject){
	  this.subject = subject;
  }
  
  public void setContent(String content){
	  this.content = content;
  }
  
  public void setPictures(Map<String, String> pictures) {  
      this.pictures = pictures;  
  }  

  public void setAttachments(Map<String, String> attachments) {  
      this.attachments = attachments;  
  }  

  /** 
   * 发送邮件 
   */  
  public void sendEmail() {  
	  try {
		sendEmailBase(emailHost, emailFrom, emailUserName, 
				  emailPassword, toEmails, subject, 
				  content, pictures, attachments);
	} catch (Exception e) {
		e.printStackTrace();
	}
  }  
  
  /** 
   * 发送邮件 
   */
  public void sendEmail(String toEmails,String subject,String content) 
		   {
	  try {
		sendEmailBase(emailHost, emailFrom, emailUserName, 
				  emailPassword, toEmails, subject, 
				  content, pictures, attachments);
	} catch (Exception e) {
		e.printStackTrace();
	}
  }
  
  /** 
   * 发送邮件 
   */
  @SuppressWarnings("rawtypes")
  public void sendEmail(String toEmails,String subject,String content,
		  Map pictures,Map attachments) 
		   {
	  try {
		sendEmailBase(emailHost, emailFrom, emailUserName, 
				  emailPassword, toEmails, subject, 
				  content, pictures, attachments);
	} catch (Exception e) {
		e.printStackTrace();
	}
  }
  
  @SuppressWarnings({ "rawtypes", "unchecked" })
  private void sendEmailBase(String emailHost,
		  String emailFrom,
		  String emailUserName,
		  String emailPassword,
		  String toEmails,
		  String subject,
		  String content,
		  Map pictures,
		  Map attachments) throws Exception { 

      if (emailHost.equals("") 
    		  || emailFrom.equals("")  
              || emailUserName.equals("")  
              || emailPassword.equals("")) {  
          throw new RuntimeException("发件人信息不完全，请确认发件人信息！");  
      }  

      JavaMailSenderImpl senderImpl = new JavaMailSenderImpl();  

      // 设定mail server  
      senderImpl.setHost(emailHost);  

      // 建立邮件消息  
      MimeMessage mailMessage = senderImpl.createMimeMessage();  

      MimeMessageHelper messageHelper = null;  
      messageHelper = new MimeMessageHelper(mailMessage, true, "UTF-8");  
      // 设置发件人邮箱  
      messageHelper.setFrom(emailFrom);  

      // 设置收件人邮箱  
      String[] toEmailArray = toEmails.split(";");  
      List<String> toEmailList = new ArrayList<String>();  
      if (null == toEmailArray || toEmailArray.length <= 0) {  
          throw new RuntimeException("收件人邮箱不得为空！");  
      } else {  
          for (String s : toEmailArray) {  
              if (!s.equals("")) {  
                  toEmailList.add(s);  
              }  
          }  
          if (null == toEmailList || toEmailList.size() <= 0) {  
              throw new RuntimeException("收件人邮箱不得为空！");  
          } else {  
              toEmailArray = new String[toEmailList.size()];  
              for (int i = 0; i < toEmailList.size(); i++) {  
                  toEmailArray[i] = toEmailList.get(i);  
              }  
          }  
      }  
      messageHelper.setTo(toEmailArray);  

      // 邮件主题  
      messageHelper.setSubject(subject);  

      // true 表示启动HTML格式的邮件  
      messageHelper.setText(content, true);  

      // 添加图片  
      if (null != pictures) {  
          for (Iterator<Map.Entry<String, String>> it = pictures.entrySet()  
                  .iterator(); it.hasNext();) {  
              Map.Entry<String, String> entry = it.next();  
              String cid = entry.getKey();  
              String filePath = entry.getValue();  
              if (null == cid || null == filePath) {  
                  throw new RuntimeException("请确认每张图片的ID和图片地址是否齐全！");  
              }  

              File file = new File(filePath);  
              if (!file.exists()) {  
                  throw new RuntimeException("图片" + filePath + "不存在！");  
              }  

              FileSystemResource img = new FileSystemResource(file);  
              messageHelper.addInline(cid, img);  
          }  
      }  

      // 添加附件  
      if (null != attachments) {  
          for (Iterator<Map.Entry<String, String>> it = attachments  
                  .entrySet().iterator(); it.hasNext();) {  
              Map.Entry<String, String> entry = it.next();  
              String cid = entry.getKey();  
              String filePath = entry.getValue();  
              if (null == cid || null == filePath) {  
                  throw new RuntimeException("请确认每个附件的ID和地址是否齐全！");  
              }  

              File file = new File(filePath);  
              if (!file.exists()) {  
                  throw new RuntimeException("附件" + filePath + "不存在！");  
              }  

              FileSystemResource fileResource = new FileSystemResource(file);  
              messageHelper.addAttachment(cid, fileResource);  
          }  
      }  

      Properties prop = new Properties();  
      prop.put("mail.smtp.auth", "true"); // 将这个参数设为true，让服务器进行认证,认证用户名和密码是否正确  
      prop.put("mail.smtp.timeout", "25000");
      // 添加验证  
      MyAuthenticator auth = new MyAuthenticator(emailUserName, emailPassword);  

      Session session = Session.getInstance(prop, auth);  
      senderImpl.setSession(session);  

      // 发送邮件  
      senderImpl.send(mailMessage);
  }
  

  public static void main(String[] args) throws Exception {  
      MailUtil mu = new MailUtil();  
      test1(mu);  
      // test2(mu);  
      // test3(mu);  
      // test4(mu);  
      // test5(mu);  
     // test6(mu);  
  }  

  //示例1 简单邮件
  public  static String  test1(MailUtil mu) throws Exception {  
      String toEmails = "290196712@qq.com";  
      String subject = "第一封，简单文本邮件";  
      StringBuilder builder = new StringBuilder();  
      String randowmNum = StringUtil.createRandowmNum(6);
      builder.append("<html><body>欢迎使用店铺分析系统：<br />您本次验证码为：<span style=\"color:red\">"+randowmNum+"</span>.请勿直接回复，谢谢！</body></html>");  
      String content = builder.toString();  
      mu.sendEmail(toEmails,subject,content);  
      return randowmNum ;
  }  

  //示例2 HTML格式
  public static void test2(MailUtil mu) throws Exception {  
      String toEmails = "30961171@qq.com";  
      String subject = "第二封，HTML邮件";  
      StringBuilder builder = new StringBuilder();  
      builder.append("<html><body>老婆：<br />我是你的老公吗？<br />是的，是很久了。<br /></body></html>");  
      String content = builder.toString();  

      mu.sendEmail(toEmails,subject,content);  
  }  

  //示例3 图片邮件
  public static void test3(MailUtil mu) throws Exception {  
      String toEmails = "30961171@qq.com";  
      String subject = "第三封，图片邮件";  

      Map<String, String> pictures = new HashMap<String, String>();  
      pictures.put("d1", "D:/work/download/d1.jpg");  
      pictures.put("d2", "D:/work/download/测试图片2.jpg");  
      pictures.put("d3", "D:/work/download/d3.jpg");  

      StringBuilder builder = new StringBuilder();  
      builder.append("<html><body>看看下面的图，你会知道花儿为什么是这样红的：<br />");  
      builder.append("<img src=\"cid:d1\" /><br />");  
      builder.append("<img src=\"cid:d2\" /><br />");  
      builder.append("<img src=\"cid:d3\" /><br />");  
      builder.append("</body></html>");  
      String content = builder.toString();  

      mu.setPictures(pictures);  

      mu.sendEmail(toEmails,subject,content);

  }  

  //示例4 附件
  public static void test4(MailUtil mu) throws Exception {  
      String toEmails = "30961171@qq.com";  
      String subject = "第四封，附件邮件";  
      Map<String, String> attachments = new HashMap<String, String>();  
      attachments.put("d1.jar", "D:/work/download/activation.jar");  
      attachments.put("d2.doc",  
              "C:/Documents and Settings/Administrator/桌面/Java设计模式.doc");  
      StringBuilder builder = new StringBuilder();  
      builder.append("<html><body>看看附件中的资料，你会知道世界为什么是平的。</body></html>");  
      String content = builder.toString();  

      mu.setAttachments(attachments);  

      mu.sendEmail(toEmails,subject,content);  
  }  

  //示例5 图片+附件
  public static void test5(MailUtil mu) throws Exception {  
      String toEmails = "30961171@qq.com";  
      String subject = "第五封，综合邮件";  

      Map<String, String> attachments = new HashMap<String, String>();  
      attachments.put("d1.jar", "D:/work/download/activation.jar");  
      attachments.put("d2.doc",  
              "C:/Documents and Settings/Administrator/桌面/Java设计模式.doc");  

      Map<String, String> pictures = new HashMap<String, String>();  
      pictures.put("d1", "D:/work/download/d1.jpg");  
      pictures.put("d2", "D:/work/download/测试图片2.jpg");  
      pictures.put("d3", "D:/work/download/d3.jpg");  

      StringBuilder builder = new StringBuilder();  
      builder.append("<html><body>看看附件中的资料，你会知道世界为什么是平的。<br />");  
      builder.append("看看下面的图，你会知道花儿为什么是这样红的：<br />");  
      builder.append("<img src=\"cid:d1\" /><br />");  
      builder.append("<img src=\"cid:d2\" /><br />");  
      builder.append("<img src=\"cid:d3\" /><br />");  
      builder.append("</body></html>");  
      String content = builder.toString();  

      mu.setPictures(pictures);  
      mu.setAttachments(attachments);  

      mu.sendEmail(toEmails,subject,content);  
  }  

  //示例6 图片+附件+群发
  public static void test6(MailUtil mu) throws Exception {  
      String toEmails = "30961171@qq.com;l30961171@yeah.net";  
      String subject = "第6封，群发邮件";  

      Map<String, String> attachments = new HashMap<String, String>();  
      attachments.put("d1.txt", "D:/test.txt");  

      Map<String, String> pictures = new HashMap<String, String>();  
      pictures.put("d1", "D:/test.png");  

      StringBuilder builder = new StringBuilder();  
      builder.append("<html><body>看看附件中的资料，你会知道世界为什么是平的。<br />");  
      builder.append("看看下面的图，你会知道花儿为什么是这样红的：<br />");  
      builder.append("<img src=\"cid:d1\" /><br />");  
      builder.append("<img src=\"cid:d2\" /><br />");  
      builder.append("<img src=\"cid:d3\" /><br />");  
      builder.append("</body></html>");  
      String content = builder.toString();  

      mu.setPictures(pictures);  
      mu.setAttachments(attachments);  

      mu.sendEmail(toEmails,subject,content);  
  }  

  public class MyAuthenticator extends Authenticator {  
	   private String username;  
	   private String password;  
	 
	   public MyAuthenticator(String username, String password) {  
	       super();  
	       this.username = username;  
	       this.password = password;  
	   }  
	 
	   protected PasswordAuthentication getPasswordAuthentication() {  
	       return new PasswordAuthentication(username, password);  
	   }  
	}  
}  
