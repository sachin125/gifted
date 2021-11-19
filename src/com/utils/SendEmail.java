package com.utils;

import java.security.Security;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class SendEmail {

	public static void send(String vcode,String emailid) throws Exception{
		
		//sender email id and password
		final String username = "abc@gmail.com";
		final String password = "12345678";

		//receiver email id
		String receiver = emailid;
		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");
		
		Session session = Session.getDefaultInstance(props,
				new Authenticator() {
				protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
				}});
		
		try {
			if(session!=null) {
				// Create a default MimeMessage object.
				Message message = new MimeMessage(session);
				// Set From: header field of the header.
				message.setFrom(new InternetAddress(username));
				// Set To: header field of the header.
				message.setRecipients(Message.RecipientType.TO,
						InternetAddress.parse(receiver));
		
				message.setSubject("your Gifted code is :");
				// ret is a verification code
				message.setText(vcode);
//				Transport.send(message);
				System.out.println("verification code sent successfully");
			}else {
				System.out.println("Mail session is null");
			}

		} catch (MessagingException e) {
			System.out.println("sendmail me problem");
			throw e;
		}
	}
}
