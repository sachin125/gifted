package com.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dto.AdminDTO;
import com.dto.ContactInformationDTO;
import com.service.MyService;

public class AdminController {

	public AdminDTO adminwork(HttpServletRequest request,HttpServletResponse response) throws Exception{
		return	new MyService().adminwork();
	}
	public <ContactInformationDTO> List viewContactInformation(HttpServletRequest request,HttpServletResponse response) throws Exception {
		 return new MyService().viewContactInformation();
	}
	public ContactInformationDTO view(HttpServletRequest request,HttpServletResponse response,String email) throws Exception{
		return	new MyService().view(email);
	}
}
