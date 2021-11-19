package com.dto;

import java.io.File;

public class MailDTO {
	private String sender;
	private String receiver;
	private String subject;
	private String emailname;
	private String filename;
	private long ltime;
	private String email_signature;
	private String file_signature;
	private String publickey;
	private File decfile;
	

	public MailDTO() {
		super();
	}


	public String getSender() {
		return sender;
	}


	public void setSender(String sender) {
		this.sender = sender;
	}


	public String getReceiver() {
		return receiver;
	}


	public void setReceiver(String receiver) {
		this.receiver = receiver;
	}


	public String getSubject() {
		return subject;
	}


	public void setSubject(String subject) {
		this.subject = subject;
	}


	public String getEmailname() {
		return emailname;
	}


	public void setEmailname(String emailname) {
		this.emailname = emailname;
	}


	public String getFilename() {
		return filename;
	}


	public void setFilename(String filename) {
		this.filename = filename;
	}


	public long getLtime() {
		return ltime;
	}


	public void setLtime(long ltime) {
		this.ltime = ltime;
	}


	public String getEmail_signature() {
		return email_signature;
	}


	public void setEmail_signature(String email_signature) {
		this.email_signature = email_signature;
	}


	public String getFile_signature() {
		return file_signature;
	}


	public void setFile_signature(String file_signature) {
		this.file_signature = file_signature;
	}


	public String getPublickey() {
		return publickey;
	}


	public void setPublickey(String publickey) {
		this.publickey = publickey;
	}


	public File getDecfile() {
		return decfile;
	}


	public void setDecfile(File decfile) {
		this.decfile = decfile;
	}

	
}
