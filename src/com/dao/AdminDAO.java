package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import java.util.List;

import com.dto.AdminDTO;
import com.dto.ContactInformationDTO;
import com.service.MyService;

public class AdminDAO {

	public AdminDTO adminwork() throws Exception {
		Connection con = null;
		AdminDTO adminDTO = null;
		try {
			adminDTO = new AdminDTO();
			con = new com.db.MyConnection().getConnection();
			ResultSet rs = null;
			PreparedStatement ps = con
					.prepareStatement("select count(*) from transfer");

			rs = ps.executeQuery();
			int total_no_of_mail_transfer = 0;
			while (rs.next()) {
				total_no_of_mail_transfer = rs.getRow();
			}

			adminDTO.setTotal_no_of_mailsent(total_no_of_mail_transfer);

			rs = ps.executeQuery("select count(*) from registration");
			int total_no_of_user = 0;
			while (rs.next()) {
				total_no_of_user = rs.getRow();
			}
			adminDTO.setTotal_no_of_user(total_no_of_user);
			ps.close();
		} finally {
			con.close();
		}
		return adminDTO;
	}

	@SuppressWarnings({ "hiding", "rawtypes" })
	public <ContactInformationDTO> List viewContactInformation()
			throws Exception {
		List<com.dto.ContactInformationDTO> contactInformationDTOList = new ArrayList<com.dto.ContactInformationDTO>();
		Connection con = null;
		try {
			con = new com.db.MyConnection().getConnection();
			PreparedStatement ps = con
					.prepareStatement("select * from contactinformation");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				com.dto.ContactInformationDTO contactInformationDTO = new com.dto.ContactInformationDTO();
				contactInformationDTO.setEmail(rs.getString("emailid"));
				contactInformationDTO.setName(rs.getString("name"));
				contactInformationDTO.setSubject(rs.getString("subject"));
				contactInformationDTO.setMessage(rs.getString("message"));
				contactInformationDTOList.add(contactInformationDTO);
			}
			rs.close();
			ps.close();
		} finally {
			con.close();
		}
		return contactInformationDTOList;
	}

	public ContactInformationDTO view(String email) throws Exception {
		Connection con = null;
		ContactInformationDTO contactInformationDTO = null;
		try {
			contactInformationDTO = new ContactInformationDTO();
			con = new com.db.MyConnection().getConnection();
			ResultSet rs = null;
			PreparedStatement ps = con
					.prepareStatement("select * from contactinformation where emailid='"
							+ email + "'");
			System.out.println("" + email);
			rs = ps.executeQuery();
			while (rs.next()) {
				contactInformationDTO.setEmail(rs.getString("emailid"));
				contactInformationDTO.setName(rs.getString("name"));
				contactInformationDTO.setSubject(rs.getString("subject"));
				contactInformationDTO.setMessage(rs.getString("message"));
			}
			rs.close();
			ps.close();
		} finally {
			con.close();
		}
		return contactInformationDTO;
	}

}
