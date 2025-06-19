//package com.otpService.Feign;
//
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.stereotype.Component;
//
//import com.otpService.Dto.MailTemplete;
//
//@Component
//public class MailFallback implements MailInterface{
//
//	@Override
//	public ResponseEntity<String> sendMail(MailTemplete mail) {
//		System.out.println("Feign fallback activated - Mail Service is down.");
//		return new ResponseEntity<String>("Service Down !!!!!!!!!!!",HttpStatus.OK);
//	}
//	
//    
//}

/// Not Working
