package com.email.notification.mail;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("sendEmail")
public class MailController {
	@Autowired
	JavaMailSender mailSender;
	@PostMapping
	public String sendEmail(@RequestBody Email pp) {
		SimpleMailMessage mail = new SimpleMailMessage();
		mail.setFrom("fkelenna@gmail.com");
		mail.setTo(pp.getEmail());
		mail.setText(pp.getText());
		mail.setSubject(pp.getSubject());
		mailSender.send(mail);
		return "email Sent";
		
	}

}
