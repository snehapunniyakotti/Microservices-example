package com.mailService.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="mail_log")
public class MailLog {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String mailto;
	private String subject;
	private String msgBody;
	
	public MailLog(String mailto, String subject, String msgBody) {
		super();
		this.mailto = mailto;
		this.subject = subject;
		this.msgBody = msgBody;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
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
		return "MailTemplete [id=" + id + ", mailto=" + mailto + ", subject=" + subject + ", msgBody=" + msgBody + "]";
	}
	
	
	
}
