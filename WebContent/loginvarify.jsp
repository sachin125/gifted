<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<jsp:useBean id="loginDTO" class="com.dto.LoginDTO"></jsp:useBean>
	<jsp:setProperty property="*" name="loginDTO"/>
	<jsp:useBean id="loginController" class="com.controller.LoginController"></jsp:useBean>
	<%
	System.out.println("loginverify : "+request.getParameter("emailid"));
		loginController.loginVerify(request, response, loginDTO);
	%>
</body>
</html>