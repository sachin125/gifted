package com.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.db.MyConnection;
import com.dto.RegistrationDTO;

public class RegistrationDAO {

	public String registrationVerify(RegistrationDTO registrationDTO)
			throws Exception {
		Long time = System.currentTimeMillis();
		String ret = "error";
		Connection con = null;
		try {
			con = new MyConnection().getConnection();
			PreparedStatement ps = con
					.prepareStatement("insert into registration (fname,lname,emailid,password,gender,dob,reg_date,ul,reg_verified) values (?,?,?,?,?,?,?,?,?)");
			ps.setString(1, registrationDTO.getFname());
			ps.setString(2, registrationDTO.getLname());
			ps.setString(3, registrationDTO.getEmailid());
			ps.setString(4, registrationDTO.getPassword());
			ps.setString(5, registrationDTO.getGender());
			ps.setString(6, registrationDTO.getDob());
			ps.setLong(7, time);
			ps.setString(8, "user");
			ps.setString(9, "unverified");

			ps.executeUpdate();
			ps.close();
			ret = "success";
		} finally {
			con.close();
		}
		return ret;
	}

	
	public String recoverypassword(String emailid) throws Exception {
		String ret = "error";
		Connection con = null;
		try {
			con = new MyConnection().getConnection();
			PreparedStatement ps = con.prepareStatement("select reg_verified from registration where emailid='"+ emailid + "'");
			ResultSet rs = ps.executeQuery();
			String reg_verified = null;
			if (rs.next()) {
				reg_verified = rs.getString("reg_verified");
				System.out.println(""+reg_verified);
			}
			if(reg_verified.equalsIgnoreCase("unverified")){
				ps = con.prepareStatement("update registration set reg_verified='verified' where emailid=?");
				ps.setString(1, emailid);
				ps.executeUpdate();
			}
			rs =  ps.executeQuery("select password from registration where emailid='"+ emailid + "'");
			if (rs.next()) {
				ret = rs.getString("password");
				System.out.println("password : "+ret);
			}
			rs.close();
			ps.close();
		} finally {
			con.close();
		}
		return ret;
	}
	public String verificationverify(String emailid) throws Exception {
		String ret = "error";
		Connection con = null;
		try {
			con = new MyConnection().getConnection();
			PreparedStatement ps = con
					.prepareStatement("update registration set reg_verified='verified' where emailid=?");
			ps.setString(1, emailid);
			ps.executeUpdate();
			ret = "success";
			ps.close();
		} finally {
			con.close();
		}
		return ret;
	}
	
}
