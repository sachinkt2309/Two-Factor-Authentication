package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailSenderService {

	@Autowired
	 JavaMailSender javaMailSender;
	
	public void sendEmail(String toEmail, String body) {
		SimpleMailMessage msg = new SimpleMailMessage();
		msg.setFrom("sachin1ga18cs410@gmail.com");
		msg.setTo(toEmail);
		msg.setSubject("Otp verification from bank app");
		msg.setText(body);

		javaMailSender.send(msg);
		
		System.out.println("mail sent");
	}
}
