<%@include file="adminheader.jsp" %>
<%@page import="com.dto.MailDTO"%>

        <div id="templatemo_menu">
            <ul>
                <li><a href="adminhome.jsp" >Home</a></li>
                <li><a href="viewcontactinformation.jsp">view contact</a></li>
                <li><a href="../logout.jsp">logout</a></li>
            </ul>    	
        </div> <!-- end of templatemo_menu -->
        
<div id="templatemo_slider_wrapper"></div>
<div id="templatemo_content_wrapper">
	<div id="content">
		<div class="col_w560" style="height: 500px;">
			<!-- black page -->

	<h1>View all</h1>

	<jsp:useBean id="contactInformationDTO"
		class="com.dto.ContactInformationDTO"></jsp:useBean>
	<jsp:useBean id="adminController"
		class="com.controller.AdminController"></jsp:useBean>
	<%
		String email = (String) request.getParameter("email");
	System.out.println(""+email);
		contactInformationDTO.setEmail(email);
		
		contactInformationDTO = adminController.view(request, response, email);
		
		
		%>
	<h4>subject</h4><%out.println(contactInformationDTO.getSubject());%>
	
	<h4>message</h4>
		<%
			out.println(contactInformationDTO.getMessage());
		
		%>
<br><br>
		</div>
	</div>
	<div class="cleaner"></div>
</div>
<%@include file="../footer.jsp" %>

