<%@page import="com.dto.ContactInformationDTO"%>
<%@page import="com.controller.AdminController"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.List"%>
<%@include file="adminheader.jsp"%>
<div id="templatemo_menu">
	<ul>
		<li><a href="adminhome.jsp">Home</a>
		</li>
		<li><a href="viewcontactinformation.jsp">View Contact</a>
		</li>
		<li><a href="../logout.jsp">logout</a>
		</li>
	</ul>
</div>
<!-- end of templatemo_menu -->

<div id="templatemo_slider_wrapper"></div>
<div id="templatemo_content_wrapper">
	<div id="content">
		<h3>View</h3>
		<div class="col_w560" style="height: 500px;">
			<!-- black page -->

			Welcome on Administrator page


			<form action="readmail.jsp" method="post">
				<table width="800px" border="1">
					<tr>
						<td align="center"><b style="color: white;"> S.no. </b>
						</td>
						<td align="center"><b style="color: white;"> Email </b>
						</td>
						<td align="center"><b style="color: white;"> Name </b>
						</td>
						<td align="center"><b style="color: white;"> Subject </b>
						</td>
						</td>
						<td align="center"><b style="color: white;">operation </b>
						</td>

					</tr>
					
			<%int i=0;
			AdminController adminController = new AdminController();
			List<ContactInformationDTO> ContactInformationDTOlist = adminController.viewContactInformation(request, response);
			for (ContactInformationDTO emp : ContactInformationDTOlist) {
				i++;
			%>
					<tr>
						<td><%=i%></a>
						</td>
						<td><%=emp.getEmail()%></a>
						</td>
						<td><%=emp.getName()%></a>
						</td>
						<td><%=emp.getSubject() %></td>
						<td><a
							href="view.jsp?email=<%=emp.getEmail()%>">viewmessage</a>
					</tr>

					</td>
					<%
						}
					%>

				</table>
			</form>

		</div>
	</div>
	<div class="cleaner"></div>
</div>
<%@include file="../footer.jsp"%>

