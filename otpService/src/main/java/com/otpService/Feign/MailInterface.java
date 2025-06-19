package com.otpService.Feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.otpService.Dto.MailTemplete;

/// @FeignClient(name = "mail-service", fallback = MailFallback.class) // not wprking
//@FeignClient(name = "mail-service")
@FeignClient(name = "${microservice.name.mail}")
public interface MailInterface {
 
	@PostMapping("${microservice.endpoint.mail.send}")
	public ResponseEntity<String> sendMail(@RequestBody MailTemplete mail);
}





