package com.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dto.LoginDTO;
import com.msg.MyMessage;
import com.service.MyService;

public class LoginController {
	public void loginVerify(HttpServletRequest request,
			HttpServletResponse response, LoginDTO loginDTO) {
		MyMessage myMessage = new MyMessage();
		try {
			String ret = new MyService().loginVerify(loginDTO);

			if (ret.equalsIgnoreCase("error")) {
				myMessage.setLoginmessage("invalid username or password");
				request.setAttribute("LMSG", myMessage);
				request.getRequestDispatcher("login.jsp").forward(request,
						response);

			} else {
				HttpSession httpSession = request.getSession(true);
				httpSession.setAttribute("EMAILID", loginDTO.getEmailid());
				httpSession.setAttribute("level", ret);
				httpSession.setAttribute("OBJECT", loginDTO);

				if (ret.equalsIgnoreCase("user")) {
					response.sendRedirect("user/userhome.jsp");
				} else if (ret.equalsIgnoreCase("admin")) {
					response.sendRedirect("admin/adminhome.jsp");
				}
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			myMessage.setLoginmessage("DATABASE ERROR");
			request.setAttribute("LMSG", myMessage);
			try {
				request.getRequestDispatcher("login.jsp").forward(request,
						response);
			} catch (Exception ex1) {
				ex1.printStackTrace();
			}
		}

	}
}
