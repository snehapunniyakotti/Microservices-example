package com.ThirdParty.Service;

import java.net.URI;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Call;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

@Service
public class MessageService {


	@Value("${twilio.account_sid}")
	String TWILIO_SID;

	@Value("${twilio.auth_token}")
	String TWILIO_TOKEN;

	@Value("${phone_number}")
	String PHONE_NUMBER;

	@Value("${twilio.voice_url}")
	String TWILIO_VOICE_URL;

	public ResponseEntity<?> sendSMS(String toPhoneNumber, String message) {
		Twilio.init(TWILIO_SID, TWILIO_TOKEN);

		Message msg = Message.creator(new PhoneNumber(toPhoneNumber), new PhoneNumber(PHONE_NUMBER), message).create();

		return new ResponseEntity<String>( "Message Sent successfully", HttpStatus.OK);   
	}

	public ResponseEntity<?> voiceCall(String phoneNumber) {
		Twilio.init(TWILIO_SID, TWILIO_TOKEN);

		Call call = Call
				.creator(new PhoneNumber(phoneNumber), new PhoneNumber(PHONE_NUMBER), URI.create(TWILIO_VOICE_URL))
				.create();

		return new ResponseEntity<String>( "Call sent successfully", HttpStatus.OK);
   }
}













