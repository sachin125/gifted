package com.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dto.RegistrationDTO;
import com.msg.MyMessage;
import com.service.MyService;
import com.utils.CodeGenerator;
import com.utils.SendEmail;

public class RegistrationController {

	public void registrationVerify(HttpServletRequest request,
			HttpServletResponse response, RegistrationDTO registrationDTO) {
		MyMessage myMessage = new MyMessage();
		SendEmail sendEmail = null;
		CodeGenerator codeGenerator = null;
		try {
			String ret = new MyService().registrationVerify(registrationDTO);
			codeGenerator = new CodeGenerator();
			System.out.println("RegistrationController : ret :" + ret);
			if (ret.equalsIgnoreCase("error")) {
				myMessage.setRegistrationmessage("try again");
				request.setAttribute("RMSG", myMessage);
				request.getRequestDispatcher("registration.jsp").forward(
						request, response);

			} else {
				if (ret.equalsIgnoreCase("success")) {
					String vcode = codeGenerator.generateCode(2);
					sendEmail = new SendEmail();
					sendEmail.send(vcode,registrationDTO.getEmailid());

					HttpSession httpSession = request.getSession(true);
					httpSession.setAttribute("VCODE", vcode);
					System.out.println("RegistrationController :vcode " + vcode);
					httpSession.setAttribute("EMAILID",registrationDTO.getEmailid());
					httpSession.setAttribute("OBJECT", registrationDTO);
					
					response.sendRedirect("verificationcode.jsp");
				}
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			myMessage.setLoginmessage("DATABASE ERROR");
			request.setAttribute("RMSG", myMessage);
			try {
				request.getRequestDispatcher("registration.jsp").forward(
						request, response);
			} catch (Exception ex1) {
				ex1.printStackTrace();
			}
		}
	}

	public void verificationCodeVerify(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		MyMessage myMessage = new MyMessage();
		HttpSession httpSession = request.getSession(true);		
		String vcode = (String) httpSession.getAttribute("VCODE");
		String emailid = (String)httpSession.getAttribute("EMAILID");
		System.out.println("registrationcontroller : vcodeverify : vcode:"
				+ vcode);
		
		String vvcode = request.getParameter("vvcode");
		
		if (!vcode.equalsIgnoreCase(vvcode)) {
			myMessage.setVericationcodemsg("code mismatched,try again");
			request.setAttribute("VMSG", myMessage);
			request.getRequestDispatcher("verificationcode.jsp").forward(
					request, response);
		} else {
			MyService myService = new MyService();
			String ret =null;
			if(emailid!=null){
				ret = myService.verificationverify(emailid);
				if(ret=="success"){
					response.sendRedirect("user/userhome.jsp");
				}
			}else{
				myMessage.setRegistrationmessage("try again");
				request.setAttribute("RMSG", myMessage);
				request.getRequestDispatcher("registration.jsp").forward(
						request, response);
			}
		}

	}

	public void recoveryPassword(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		MyMessage myMessage = new MyMessage();
		SendEmail sendEmail = null;
		String emailid = request.getParameter("emailid");
		System.out.println("recoveryPassword : emailid : "+emailid);
		try {
			String ret = new MyService().recoverypassword(emailid);
			if (ret.equalsIgnoreCase("error")) {
				myMessage.setRecoverymsg("try again");
				request.setAttribute("RECOVERYMSG", myMessage);
				request.getRequestDispatcher("forgotpassword.jsp").forward(
						request, response);
			} else {
				sendEmail = new SendEmail();
				sendEmail.send(ret,emailid);
				myMessage.setLoginmessage("email sent on your account");
				request.setAttribute("LMSG", myMessage);
				request.getRequestDispatcher("login.jsp").forward(
						request, response);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

}
