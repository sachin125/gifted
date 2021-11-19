<%@page import="com.dto.MailDTO"%>
<%@page import="java.util.List"%>
<%@page import="com.controller.MailController"%>
<%@page import="java.io.File"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.io.FileReader"%>
<%@include file="userheader.jsp" %>
        <div id="templatemo_menu">
            <ul>
                <li><a href="userhome.jsp" >Home</a></li>
                <li><a href="inbox.jsp">Inbox</a></li>
                <li><a href="sentbox.jsp" class="current">Sentbox</a></li>
                <li><a href="composemail.jsp">Compose mail</a></li>
                <li><a href="../logout.jsp">logout</a></li>
            </ul>    	
        </div> <!-- end of templatemo_menu -->
        
<div id="templatemo_slider_wrapper"></div>
<div id="templatemo_content_wrapper">
	<div id="content">
		<h3>sentbox</h3>
		<div class="col_w560" style="height: 500px;">
			
			<form action="readmail.jsp" method="post">
				<table width="800px" border="1">
					<tr>
						<td align="center"><b style="color: white;"> S.no. </b>
						</td>
						<td align="center"><b style="color: white;"> Receiver </b>
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
						MailController mailController = new MailController();
						List<MailDTO> mailList = mailController.getSentMail(emailid);
						SimpleDateFormat sdf = new SimpleDateFormat();
						int i = 0;
						for (MailDTO emp : mailList) {
							i++;
							String receiver = emp.getReceiver();
							String subject = emp.getSubject();
							long ltime = emp.getLtime();
					%>

					<tr>
						<td><%=i%></a>
						</td>
						<td><%=receiver%></a>
						</td>
						<td><%=subject%></a>
						</td>
						<td><%=sdf.format(ltime)%></td>
						<td><a
							href="readsentmail.jsp?receiver=<%=receiver%>&ltime=<%=ltime%>&">readmail</a>
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
<%@include file="../footer.jsp" %>