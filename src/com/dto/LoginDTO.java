package com.dto;

public class LoginDTO {
	private String emailid;
	private String password;
	private String level;
	
	public LoginDTO() {
		super();
	}
	public LoginDTO(String emailid, String password, String level) {
		super();
		this.emailid = emailid;
		this.password = password;
		this.level = level;
	}
	public String getEmailid() {
		return emailid;
	}
	public void setEmailid(String emailid) {
		this.emailid = emailid;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getLevel() {
		return level;
	}
	public void setLevel(String level) {
		this.level = level;
	}
	
}
