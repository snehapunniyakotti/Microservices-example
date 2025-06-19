package com.mailService.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.mailService.Entity.MailLog;
import com.mailService.Repository.MailRepository;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

@Service
public class MailService {

	@Autowired
	private MailRepository mailRepository;

	@Autowired
	private JavaMailSender javaMailSender;

	@Value("${spring.mail.username}")
	String from;
	
//	@Value("${my.profile.name}")
//	String name;
	
	@Autowired
    private Environment environment;

	public ResponseEntity<String> sendMail(MailLog mail) {

		try {  
//			if(mail != null) {
//				throw new IllegalArgumentException("yusafyhszvfua");
//			}
			
			SimpleMailMessage smm = new SimpleMailMessage();
			smm.setFrom(from);
			smm.setTo(mail.getMailto());
			smm.setSubject(mail.getSubject());
			smm.setText(mail.getMsgBody());

			javaMailSender.send(smm);
			mail.setMsgBody("");
			mailRepository.save(mail);
            System.out.println("printing the name : "+environment.getProperty("my.profile.name"));
			return new ResponseEntity<String>("Mail Send Successfully", HttpStatus.OK);

		} catch (Exception e) {
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
