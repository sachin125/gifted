package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.db.MyConnection;
import com.dto.ContactInformationDTO;

public class ContactInformationDAO {

	public String contactverify(ContactInformationDTO contactInformationDTO) throws Exception {
		String ret = "error";
		Connection con = null;
		try {
			con = new MyConnection().getConnection();
			PreparedStatement ps = con
					.prepareStatement("insert into contactinformation (name,subject,emailid,message) values (?,?,?,?)");
			ps.setString(1, contactInformationDTO.getName());
			ps.setString(2, contactInformationDTO.getSubject());
			ps.setString(3, contactInformationDTO.getEmail());
			ps.setString(4, contactInformationDTO.getMessage());

			ps.executeUpdate();
			ps.close();
			ret = "success";
		} finally {
			con.close();
		}
		
		return ret;
	}

	
}
