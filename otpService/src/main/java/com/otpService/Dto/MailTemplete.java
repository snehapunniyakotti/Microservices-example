package com.otpService.Dto;


public class MailTemplete {
	private String mailto;
	private String subject;
	private String msgBody;

	public MailTemplete() {
		super();
	}

	public MailTemplete(String mailto, String subject, String msgBody) {
		super();
		this.mailto = mailto;
		this.subject = subject;
		this.msgBody = msgBody;
	}

	public String getMailto() {
		return mailto;
	}

	public void setMailto(String mailto) {
		this.mailto = mailto;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getMsgBody() {
		return msgBody;
	}

	public void setMsgBody(String msgBody) {
		this.msgBody = msgBody;
	}

	@Override
	public String toString() {
		return "MailTemplete [mailto=" + mailto + ", subject=" + subject + ", msgBody=" + msgBody + "]";
	}

}
