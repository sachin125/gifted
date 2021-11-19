<%@include file="header.jsp"%>
<%@page import="com.msg.MyMessage"%>

<script language="javascript">


</script>
<div id="templatemo_menu">
	<ul>
		<li><a href="index.jsp">Home</a>
		</li>
		<li><a href="about.jsp">About us</a>
		</li>
		<li><a href="contact.jsp">Contact</a>
		</li>
		<li><a href="registration.jsp" class="current">Registration</a>
		</li>
		<li><a href="login.jsp">login</a>
		</li>
	</ul>
</div>
<!-- end of templatemo_menu -->

<div id="templatemo_content_wrapper">
	<div id="content">

		<h2>Registration here</h2>

		<div class="hr_divider"></div>


		<form action="registrationverify.jsp" method="post">
			<h3>Registration Form</h3>
			<%
				MyMessage myMessage = (MyMessage) request.getAttribute("RMSG");
				if (myMessage != null) {
					if(myMessage.getRegistrationmessage()==null){
						out.println("<b style='color:#ff9911;'>connection error, Try Again");
					}else{
						out.println("<b style='color:#ff9911;'>"
							+ myMessage.getRegistrationmessage() + "</b>");
					}
				}
			%>

			<table>
				<tr>
					<td>First Name:</td>
					<td><input type="text" name="fname" size="30"
						required placeholder="Enter First Name"/>
					</td>
				</tr>
				<tr></tr><tr></tr><tr></tr><tr></tr>
				<tr>
					<td>Last Name :</td>
					<td><input type="text" name="lname" size="30"
						required placeholder="enter last name"/>
					</td>
				</tr>
				<tr></tr><tr></tr><tr></tr><tr></tr>
				<tr>
					<td>Email id : </td>
					<td><input type="email" name="emailid" size="30" id="emailid"
						required placeholder="enter valid email address"/>
					</td>
				</tr>
				<tr></tr><tr></tr><tr></tr><tr></tr>
				<tr>
					<td>Password :</td>
					<td><input required type="password" name="password" size="30"
						 placeholder="enter your password"/>
					</td>
				</tr>
				<tr></tr><tr></tr><tr></tr><tr></tr>
				<tr>
					<td>Gender :</td>
					<td><select name="gender" required>
							<option>select</option>
							<option values="MALE">male</option>
							<option values="FEMALE">female</option>
					</td>
				</tr>
				<tr></tr><tr></tr><tr></tr><tr></tr>
				<tr>
					<td>DOB :</td>
					<td><input type="text" name="dob" size="20" placeholder="DD/MM/YYYY"
						 required pattern="\d{1,2}/\d{1,2}/\d{4}" required/>
					</td>
				</tr>
				<tr></tr><tr></tr><tr></tr><tr></tr>
				<tr>
					<td></td>
					<td><input type="submit" value="Sign Up"
						 />
					</td>
				</tr>
				
			</table>
		</form>


		<div class="cleaner"></div>

	</div>

	<div class="cleaner"></div>

</div>

<%@include file="footer.jsp"%>