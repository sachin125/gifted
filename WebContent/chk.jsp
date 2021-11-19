<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" session="false"%>
<%
	

	response.addHeader("Cache-Control","no-cache");
	response.addHeader("Cache-Control","no-store");

	HttpSession httpSession = request.getSession(false);
	if(httpSession==null){
		response.sendRedirect("../login.jsp");
		return;
	}else{
		String userId=(String)httpSession.getAttribute("EMAILID");
		if(userId==null){
			response.sendRedirect("../login.jsp");
			return;
		}
	}
%>