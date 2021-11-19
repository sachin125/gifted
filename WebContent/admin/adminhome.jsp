<%@page import="com.dto.AdminDTO"%>
<%@page import="com.controller.AdminController"%>
<%@include file="adminheader.jsp"%>
<div id="templatemo_menu">
	<ul>
		<li><a href="adminhome.jsp" class="current">Home</a></li>
		<li><a href="viewcontactinformation.jsp">viewContact</a></li>
		<li><a href="../logout.jsp">logout</a></li>
	</ul>
</div>

<div id="templatemo_slider_wrapper"></div>
<div id="templatemo_content_wrapper">
	<div id="content">
		<h3>Admin home</h3>
		<div class="col_w560" style="height: 500px;">

			Welcome on Administrator page
			<%
			AdminController adminController = new AdminController();
			AdminDTO adminDTO = adminController.adminwork(request, response);
		%>
			<h6>total number of user :</h6><%=adminDTO.getTotal_no_of_user()%>
			<h6>total number of mail transfer :</h6><%=adminDTO.getTotal_no_of_mailsent()%>

		</div>
	</div>
	<div class="cleaner"></div>
</div>
<%@include file="../footer.jsp"%>