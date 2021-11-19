<%@page import="com.dto.MailDTO"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.List"%>
<%@page import="com.controller.MailController"%>
<%@include file="userheader.jsp"%>
<div id="templatemo_menu">
	<ul>
		<li><a href="userhome.jsp">Home</a>
		</li>
		<li><a href="inbox.jsp" class="current">Inbox</a>
		</li>
		<li><a href="sentbox.jsp">Sentbox</a>
		</li>
		<li><a href="composemail.jsp">Compose mail</a>
		</li>
		<li><a href="../logout.jsp">logout</a>
		</li>
	</ul>
</div>
<!-- end of templatemo_menu -->

<div id="templatemo_slider_wrapper"></div>
<div id="templatemo_content_wrapper">
	<div id="content">
		<h3>Inbox</h3>
		<div class="col_w560" style="height: 500px;">
			<!-- black page -->


			<form action="readmail.jsp" method="post">
				<table width="800px" border="1">
					<tr>
						<td align="center"><b style="color: white;"> S.no. </b>
						</td>
						<td align="center"><b style="color: white;"> sender </b>
						</td>
						<td align="center"><b style="color: white;"> subject </b>
						</td>
						<td align="center"><b style="color: white;"> Time </b>
						</td>
						</td>
						<td align="center"><b style="color: white;">operation </b>
						</td>

					</tr>
					<%
						String emailid = (String)httpSession.getAttribute("EMAILID");
						System.out.println("inbox emailid :"+emailid);
						MailController mailController = new MailController();
						List<MailDTO> mailList = mailController.getInBoxMail(emailid);
						SimpleDateFormat sdf = new SimpleDateFormat();
						int i = 0;
						for (MailDTO emp : mailList) {
							i++;
							String sender = emp.getSender();
							String subject = emp.getSubject();
							long ltime = emp.getLtime();
					%>

					<tr>
						<td><%=i%></a>
						</td>
						<td><%=sender%></a>
						</td>
						<td><%=subject%></a>
						</td>
						<td><%=sdf.format(ltime)%></td>
						<td><a
							href="readmail.jsp?sender=<%=sender%>&ltime=<%=ltime%>">readmail</a>
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