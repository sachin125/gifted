<%@include file="header.jsp"%>
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
	}
</script>

<div id="templatemo_content_wrapper">
	<div id="content">

		<div class="hr_divider"></div>

		<h1>forgot password</h1>
		<%
			MyMessage myMessage = (MyMessage) request
					.getAttribute("RECOVERYMSG");
			if (myMessage != null) {
				out.println("<b style='color:#ff9911;'>"
						+ myMessage.getRecoverymsg() + "</b>");
			}
		%>
		<form action="recoverypassworddone.jsp" method="post">

			enter your email id:<input required type="email" name="emailid"> <input
				type="submit" value="submit">
		</form>
		<div class="cleaner"></div>
	</div>
	<div class="cleaner"></div>
</div>

