package com.xworkz.vaccination.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

@Component
public class MailTrigger {

	@Autowired
	private JavaMailSender mailSender;

	public MailTrigger() {
		System.out.println("Created" + this.getClass().getSimpleName());
	}

	public boolean mailTrigger(String email, String subject, String text) {
		try {
			SimpleMailMessage mailMessage = new SimpleMailMessage();
			mailMessage.setTo(email);
			mailMessage.setSubject(subject);
			mailMessage.setText(text);
			this.mailSender.send(mailMessage);
			return true;
		}catch (Exception e) {
			e.printStackTrace();
			System.out.println("You have an exception "+e.getMessage());
			return false;
		}
		
		
	}
}
