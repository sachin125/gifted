<%@include file="header.jsp" %>
<%@page import="com.msg.MyMessage"%>
<script language="javascript">

function checkEmail() {

    var email = document.getElementById('emailid');
    var filter = /^([a-zA-Z0-9_\.\-])+\@(([a-zA-Z0-9\-])+\.)+([a-zA-Z0-9]{2,4})+$/;

    if (!filter.test(email.value)) {
    alert('Please provide a valid email address');
    email.focus;
    return false;
 }
}</script>
			<div id="templatemo_menu">
				<ul>
					 <li><a href="index.jsp">Home</a></li>
                <li><a href="about.jsp">About us</a></li>
                <li><a href="contact.jsp" >Contact</a></li>
                <li><a href="registration.jsp" >Registration</a></li>
                <li><a href="login.jsp" class="current">Login</a></li>
				</ul>
			</div>
			<!-- end of templatemo_menu -->

			<div id="templatemo_content_wrapper">
				<div id="content">

					<h2>Login here</h2>

					<div class="hr_divider"></div>


		<form method="post" class="signin" action="loginvarify.jsp">
			<%
				MyMessage myMessage = (MyMessage) request.getAttribute("LMSG");
				if (myMessage != null) {
					out.println("<b style='color:#ff9911;'>"
							+ myMessage.getLoginmessage() + "</b>");
				}
			%>
			<table>
				<tr>
					<td>Username:</td>
					<td><input required type="email" name="emailid" size="15"
						placeholder="Email id" onclick="Javascript:checkEmail();"/></td>
				</tr>
				<tr></tr><tr></tr><tr></tr><tr></tr>
				<tr>
					<td>password:</td>
					<td><input required type="password" name="password" type="password"
						size="15" placeholder="Password" /></td>
				</tr>
				<tr></tr><tr></tr><tr></tr><tr></tr>
				<tr>
					<td></td>
					<td><input value="Sign in" type="submit" /></td>
				</tr>
				<tr></tr><tr></tr><tr></tr><tr></tr>
				<tr>
					<td></td>
					<td><a href="forgotpassword.jsp">forgot your password</a></td>
				</tr>

				</form>
					<div class="cleaner"></div>

				</div>

				<div class="cleaner"></div>

			</div>

