package com.service;

import java.util.List;

import com.dao.AdminDAO;
import com.dao.ContactInformationDAO;
import com.dao.LoginDAO;
import com.dao.MailDAO;
import com.dao.RegistrationDAO;
import com.dto.AdminDTO;
import com.dto.ContactInformationDTO;
import com.dto.LoginDTO;
import com.dto.MailDTO;
import com.dto.RegistrationDTO;

public class MyService {

	public String sendMailDone(MailDTO mailDTO) throws Exception {
		return new MailDAO().sendMailDone(mailDTO);
	}

	public String registrationVerify(RegistrationDTO registrationDTO)
			throws Exception {
		return new RegistrationDAO().registrationVerify(registrationDTO);
	}

	public String loginVerify(LoginDTO loginDTO) throws Exception {
		return new LoginDAO().loginverify(loginDTO);
	}

	public String recoverypassword(String emailid) throws Exception {
		return new RegistrationDAO().recoverypassword(emailid);
	}

	@SuppressWarnings({ "rawtypes", "hiding" })
	public <MailDTO> List getInboxMail(String emailid) throws Exception {
		return new MailDAO().getInboxMail(emailid);
	}

	public MailDTO readMail(MailDTO mailDTO) throws Exception {
		return new MailDAO().readMail(mailDTO);
	}

	public String contactVerify(ContactInformationDTO contactInformationDTO)
			throws Exception {
		return new ContactInformationDAO().contactverify(contactInformationDTO);
	}

	public String verificationverify(String emailid) throws Exception {
		return new RegistrationDAO().verificationverify(emailid);
	}

	@SuppressWarnings({ "rawtypes", "hiding" })
	public <MailDTO> List getSentMail(String emailid) throws Exception {
		return new MailDAO().getSentMail(emailid);
	}

	public AdminDTO adminwork() throws Exception {
		return new AdminDAO().adminwork();
	}

	public MailDTO readSentMail(MailDTO mailDTO) throws Exception {
		return new MailDAO().readSentMail(mailDTO);
	}

	public <ContactInformationDTO> List viewContactInformation()
			throws Exception {
		return new AdminDAO().viewContactInformation();
	}

	public ContactInformationDTO view(String email) throws Exception {
		return new AdminDAO().view(email);
	}
}
