package com.otpService.Service;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.otpService.Dto.MailTemplete;
import com.otpService.Entity.OTPLog;
import com.otpService.Feign.MailInterface;
import com.otpService.Repository.OTPRepository;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@Service
public class OTPService {

	@Autowired
	private OTPRepository otpRepository;

	@Autowired
	private MailInterface mailInterface;

	@CircuitBreaker(name = "${microservice.name.mail}", fallbackMethod = "fallbackGotError" )
	public ResponseEntity<String> generateOTP(String mail) {
		String otp = String.format("%06d", new Random().nextInt(999999));

		/// call Mail Service 
        MailTemplete req = new MailTemplete();
        req.setMailto(mail);
        req.setSubject("OTP From Mail Service");
        req.setMsgBody(otp);
       
		String res = mailInterface.sendMail(req).getBody();    
		
		System.err.println("printing the mail Interface res : "+res);

		otpRepository.save(new OTPLog(otp, mail));
		return new ResponseEntity<String>( "OTP : " + otp + " and "+res, HttpStatus.OK);
	}
	
	public ResponseEntity<String> fallbackGotError(Throwable ex){
		System.out.println("printing inside the fallback method throwable : "+ex.getMessage());
		return new ResponseEntity<String>("Service Down !!!!!!!!!!! : "+ex.getMessage(),HttpStatus.OK); 
	} 
  
}
