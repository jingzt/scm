package com.scm.utils;

import java.io.File;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;

public class Email {
	@Autowired
	private JavaMailSender mailSender;
	private String from;

	public void sendMail(String adressTo,String subject, String content){
        MimeMessage mime = mailSender.createMimeMessage();   
        MimeMessageHelper helper;   
        try {
			helper = new MimeMessageHelper(mime,true,"utf-8");   
			helper.setFrom(from);
			helper.setTo(adressTo);   
			helper.setSubject(subject);   
			//需要将附件显示在html中   
			helper.setText("Just a test<p>1.<img src='cid:addInline.png'/></p><p>2.<img src='cid:addAttachment.png'/></p>"+content,true);   
			File attachment = new File("D:/test.png");
			helper.addAttachment("addAttachment.png",attachment);
			helper.addInline("addInline.png", attachment);
		} catch (MessagingException e) {
			e.printStackTrace();
		}   
       
        mailSender.send(mime);   
	}

	public JavaMailSender getMailSender() {
		return mailSender;
	}

	public void setMailSender(JavaMailSender mailSender) {
		this.mailSender = mailSender;
	}

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}
}
