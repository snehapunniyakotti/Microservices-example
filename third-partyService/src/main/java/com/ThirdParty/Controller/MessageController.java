package com.ThirdParty.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ThirdParty.Service.MessageService;

@RestController
@RequestMapping("/thirdparty") 
public class MessageController {

	@Autowired
	private MessageService messageService;

	@PostMapping("/sendSMS")
	public ResponseEntity<?> sendMessage(@RequestParam String phoneNumber, @RequestParam String message) {
		try {
			return messageService.sendSMS(phoneNumber, message);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PostMapping("/voiceCall")
	public ResponseEntity<?> voiceCall(@RequestParam String phoneNumber) {
		try {
			return messageService.voiceCall(phoneNumber);
		} catch (Exception e) {
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
