package com.otpService.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class OTPLog {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String otp;
	private String mailId;
	private String userId;
	private String generatedTime;
	private String valideTime; 
	private int attemptCount;
	
	public OTPLog() {
		super();
	}
	
	public OTPLog(String otp, String mailId) {
		super();
		this.otp = otp;
		this.mailId = mailId;
	}

	public OTPLog(Integer id, String otp, String mailId, String userId, String generatedTime, String valideTime,
			int attemptCount) {
		super();
		this.id = id;
		this.otp = otp;
		this.mailId = mailId;
		this.userId = userId;
		this.generatedTime = generatedTime;
		this.valideTime = valideTime;
		this.attemptCount = attemptCount;
	}

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getOtp() {
		return otp;
	}
	public void setOtp(String otp) {
		this.otp = otp;
	}
	public String getMailId() {
		return mailId;
	}
	public void setMailId(String mailId) {
		this.mailId = mailId;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getGeneratedTime() {
		return generatedTime;
	}
	public void setGeneratedTime(String generatedTime) {
		this.generatedTime = generatedTime;
	}
	public String getValideTime() {
		return valideTime;
	}
	public void setValideTime(String valideTime) {
		this.valideTime = valideTime;
	}
	public int getAttemptCount() {
		return attemptCount;
	}
	public void setAttemptCount(int attemptCount) {
		this.attemptCount = attemptCount;
	}
	
}
























