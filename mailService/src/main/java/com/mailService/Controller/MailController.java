package com.mailService.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.mailService.Entity.MailLog;
import com.mailService.Service.MailService;

@RestController
@RequestMapping("/mail")
public class MailController {

	@Autowired
	private MailService mailService;
	
	@Value("${service.name}")
	private String name;
	
	@Autowired
	Environment environment;
	
	public MailController() {
		super();
	}

	public MailController(String name) {
		super();
		this.name = name;
		System.out.println("printing the application.properties name : "+name);
	}

	@PostMapping("/send")
	public ResponseEntity<String> sendMail(@RequestBody MailLog mail){
		try {
			System.out.println(name);
			System.err.println(environment.getProperty("local.server.port"));
		    System.out.println("printing mail request : "+mail.toString());
		    return mailService.sendMail(new MailLog(mail.getMailto(), mail.getSubject(), mail.getMsgBody()));
		} catch (Exception e) {
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
}
