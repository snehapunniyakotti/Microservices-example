package com.otpService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication  
@EnableFeignClients("com.otpService.Feign")
public class OtpServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(OtpServiceApplication.class, args);
		System.out.println("OTP Server Started!!!!!!!!!!!!!!!!!!!!!!");
	}

}
