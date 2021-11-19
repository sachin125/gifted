package com.dto;

import java.util.Date;

public class RegistrationDTO {
	private String fname;
	private String lname;
	private String emailid;
	private String password;
	private String gender;
	private String dob;
	private Date reg_date;
	private String ul;
	private String reg_verified;
	
	//default constructor
	public RegistrationDTO() {
		super();
	}

	public RegistrationDTO(String fname, String lname, String emailid,
			String password, String dob, String gender, Date reg_date,
			String ul, String reg_verified) {
		super();
		this.fname = fname;
		this.lname = lname;
		this.emailid = emailid;
		this.password = password;
		this.dob = dob;
		this.gender = gender;
		this.reg_date = reg_date;
		this.ul = ul;
		this.reg_verified = reg_verified;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
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

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Date getReg_date() {
		return reg_date;
	}

	public void setReg_date(Date reg_date) {
		this.reg_date = reg_date;
	}

	public String getUl() {
		return ul;
	}

	public void setUl(String ul) {
		this.ul = ul;
	}

	public String getReg_verified() {
		return reg_verified;
	}

	public void setReg_verified(String reg_verified) {
		this.reg_verified = reg_verified;
	}

	
}
