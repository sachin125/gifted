<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>composemaildone.jsp</title>
</head>
<body>

	<jsp:useBean id="mailController" class="com.controller.MailController"></jsp:useBean>
	<%
	 
	String receiver = request.getParameter("receiver");
	String subject = request.getParameter("subject");
	String email = request.getParameter("email");
	System.out.println("compose maildone :receiver  "+receiver+"  subject "+subject+"  email"+email);
		mailController.sendMailDone(request, response);
	%>
</body>
</html>