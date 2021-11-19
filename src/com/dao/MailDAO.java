package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.db.MyConnection;
import com.dto.MailDTO;

public class MailDAO {


	public MailDTO readMail(MailDTO mailDTO) throws Exception {
		Connection con = null;
		try {
			String receiver = mailDTO.getReceiver();
			String sender = mailDTO.getSender();
			Long ltime = mailDTO.getLtime();
			
			System.out.println("sender : "+sender+" receiver : "+receiver+" ltime: "+ltime);
			con = new com.db.MyConnection().getConnection();
			PreparedStatement ps = con.prepareStatement("select * from transfer where receiver= ? and sender=? and time = ?");
			ps.setString(1, receiver);
			ps.setString(2, sender);
			ps.setLong(3, ltime);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				mailDTO.setLtime(rs.getLong("time"));
				mailDTO.setEmailname(rs.getString("emailname"));
				mailDTO.setPublickey(rs.getString("publickey"));
				mailDTO.setFilename(rs.getString("filename"));
				mailDTO.setEmail_signature(rs.getString("email_signature"));
				mailDTO.setFile_signature("file_signature");
			}

			rs.close();
			ps.close();
		} finally {
			con.close();
		}
		return mailDTO;
	}

	
	
	public String sendMailDone(MailDTO mailDTO) throws Exception {
		String ret = "error";
		Connection con = null;
		String sender = mailDTO.getSender();

		try {
			con = new MyConnection().getConnection();
			PreparedStatement ps = con
					.prepareStatement("insert into transfer (sender,receiver,subject,emailname,filename,time,email_signature,publickey,file_signature) values (?,?,?,?,?,?,?,?,?)");
			ps.setString(1, sender);
			ps.setString(2, mailDTO.getReceiver());
			ps.setString(3, mailDTO.getSubject());
			ps.setString(4, mailDTO.getEmailname());
			ps.setString(5, mailDTO.getFilename());
			ps.setLong(6, mailDTO.getLtime());
			ps.setString(7, mailDTO.getEmail_signature());
			ps.setString(8, mailDTO.getPublickey());
			ps.setString(9, mailDTO.getFile_signature());
			
			ps.executeUpdate();
			ps.close();
			ret = "success";
			System.out.println("maildao: ret  :" + ret);
		} finally {
			con.close();
		}
		return ret;
	}

	@SuppressWarnings("hiding")
	public <MailDTO> List getInboxMail(String emailid) throws Exception {
		List<com.dto.MailDTO> mailList = new ArrayList<com.dto.MailDTO>();
		Connection con = null;
		try {
			System.out.println("maildao : emailid : " + emailid);
			
			con = new com.db.MyConnection().getConnection();
			PreparedStatement ps = con
					.prepareStatement("select * from transfer where receiver=?");
			ps.setString(1, emailid);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				
				com.dto.MailDTO mailDTO = new com.dto.MailDTO();
				
				String sender = rs.getString("sender");
				String subject = rs.getString("subject");
				String emailname = rs.getString("emailname");
				long Ltime = rs.getLong("time");
				String filename = rs.getString("filename");
				
				System.out.println("maildao : emailname : "+emailname);
				
				mailDTO.setSender(sender);
				mailDTO.setSubject(subject);
				mailDTO.setLtime(Ltime);
				mailDTO.setEmailname(emailname);
				mailDTO.setFilename(filename);
				
				mailList.add(mailDTO);
			}

			rs.close();
			ps.close();
		} finally {
			con.close();
		}
		return mailList;
	}

	public List getSentMail(String emailid) throws Exception {
		List<com.dto.MailDTO> mailList = new ArrayList<com.dto.MailDTO>();
		Connection con = null;
		try {
			System.out.println("maildao : emailid : " + emailid);
			
			con = new com.db.MyConnection().getConnection();
			PreparedStatement ps = con
					.prepareStatement("select * from transfer where sender=?");
			ps.setString(1, emailid);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				
				com.dto.MailDTO mailDTO = new com.dto.MailDTO();
				
				String sender = rs.getString("sender");
				String subject = rs.getString("subject");
				String emailname = rs.getString("emailname");
				String receiver = rs.getString("receiver");
				long Ltime = rs.getLong("time");
				String filename = rs.getString("filename");
				System.out.println("maildao : emailname : "+emailname);
				
				mailDTO.setSender(sender);
				mailDTO.setSubject(subject);
				mailDTO.setLtime(Ltime);
				mailDTO.setEmailname(emailname);
				mailDTO.setReceiver(receiver);
				mailDTO.setFilename(filename);
				
				mailList.add(mailDTO);
			}

			rs.close();
			ps.close();
		} finally {
			con.close();
		}
		return mailList;
		
	}

	public MailDTO readSentMail(MailDTO mailDTO) throws Exception {
		Connection con = null;
		try {
			String receiver = mailDTO.getReceiver();
			String sender = mailDTO.getSender();
			Long ltime = mailDTO.getLtime();
			
			System.out.println("sender : "+sender+" receiver : "+receiver+" ltime: "+ltime);
			con = new com.db.MyConnection().getConnection();
			PreparedStatement ps = con.prepareStatement("select * from transfer where receiver= ? and sender=? and time = ?");
			ps.setString(1, receiver);
			ps.setString(2, sender);
			ps.setLong(3, ltime);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				mailDTO.setLtime(rs.getLong("time"));
				mailDTO.setEmailname(rs.getString("emailname"));
				mailDTO.setPublickey(rs.getString("publickey"));
				mailDTO.setFilename(rs.getString("filename"));
				mailDTO.setEmail_signature(rs.getString("email_signature"));
				mailDTO.setFile_signature("file_signature");
			}

			rs.close();
			ps.close();
		} finally {
			con.close();
		}
		return mailDTO;
	}

}
