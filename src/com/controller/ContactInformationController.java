package com.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dto.ContactInformationDTO;
import com.msg.MyMessage;
import com.service.MyService;

public class ContactInformationController {

	public void contactVerify(HttpServletRequest request,
			HttpServletResponse response, ContactInformationDTO contactInformationDTO) {
		
		MyMessage myMessage = new MyMessage();
		try {
			String ret = new MyService().contactVerify(contactInformationDTO);
			System.out.println("ret : "+ret);
			if (ret.equalsIgnoreCase("error")) {
				myMessage.setCimessage("try again");
				request.setAttribute("CIMSG", myMessage);
				request.getRequestDispatcher("contact.jsp").forward(request,
						response);

			} else {
				if (ret.equalsIgnoreCase("success")) {
					myMessage.setCimessage("successfully submitted");
					request.setAttribute("CIMSG", myMessage);
					request.getRequestDispatcher("contact.jsp").forward(request,
							response);
				}
			} 
		}catch (Exception ex) {
			ex.printStackTrace();
			myMessage.setCimessage("DATABASE ERROR");
			request.setAttribute("CIMSG", myMessage);
			try {
				request.getRequestDispatcher("contact.jsp").forward(request,
						response);
			} catch (Exception ex1) {
				ex1.printStackTrace();
			}
		}
	}
}
