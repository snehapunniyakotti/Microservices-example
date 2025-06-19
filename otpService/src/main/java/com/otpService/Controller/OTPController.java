package com.otpService.Controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.otpService.Service.OTPService;

@RestController  
@RequestMapping("/otp")
public class OTPController {

	
	@Autowired
	private OTPService otpService;
	
	@Autowired
	private Environment environment;
	
	@PostMapping("/send")
	public ResponseEntity<String> generateOTP(@RequestParam("Mail") String mail){
		try {
			System.err.println(environment.getProperty("local.server.port"));
			return otpService.generateOTP(mail);
		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
