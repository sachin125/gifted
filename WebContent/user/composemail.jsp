<%@page import="com.msg.MyMessage"%>
<%@include file="userheader.jsp"%>
<div id="templatemo_menu">
	<ul>
		<li><a href="userhome.jsp">Home</a>
		</li>
		<li><a href="inbox.jsp">Inbox</a>
		</li>
		<li><a href="sentbox.jsp">Sentbox</a>
		</li>
		<li><a href="composemail.jsp" class="current">Compose mail</a>
		</li>
		<li><a href="../logout.jsp">logout</a>
		</li>
	</ul>
</div>
<!-- end of templatemo_menu -->

<div id="templatemo_slider_wrapper"></div>
<div id="templatemo_content_wrapper">
	<div id="content">
		<h3>compose mail</h3>
		<div class="col_w560" style="height: 500px;">
			<!-- black page -->

			<form action="composemaildone.jsp" method="post"
				enctype="multipart/form-data">
			<%
				MyMessage myMessage = (MyMessage) request.getAttribute("MMSG");
				if (myMessage != null) {
					out.println("<b style='color:#ff9911;'>"
							+ myMessage.getMailmsg() + "</b>");
				}
			%>
				<table>
					<tr>
						<td>emailid:</td>
						<td><input required type="email" name="receiver" placeholder="enter valid email address"/>
						</td>
					</tr>

					<tr>
						<td>subject</td>
						<td><input type="text" name="subject" placeholder="enter subject here" />
						</td>
					</tr>
					<tr>
						<td>message</td>
						<td>
						<textarea id="text" name="email" rows="15" cols="80"
						class="required" placeholder="write your message here"></textarea>
						</td>
					<tr>
					<tr>
						<td>
						upload file :</td>
						<td><input type="file" id="idfile" name="myfile"  placeholder="choose file"/></td>
					</tr>
					<td></td>
					<td><input type="submit" value="send" />
					</td>
					</tr>

				</table>
			</form>

		</div>
	</div>
	<div class="cleaner"></div>
</div>
<%@include file="../footer.jsp"%>