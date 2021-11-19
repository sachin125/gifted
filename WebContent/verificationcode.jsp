
<%@include file="header.jsp"%>
<%@page import="com.msg.MyMessage"%>

<div id="templatemo_content_wrapper">
	<div id="content">

		<div class="hr_divider"></div>

	<h4>please verify your account, a verification code sent to your emailid</h4>
	<%
		HttpSession httpSession = request.getSession();
		String emailid = (String)httpSession.getAttribute("EMAILID");
		System.out.println("verification code : emailid : "+emailid);
		MyMessage myMessage = (MyMessage) request.getAttribute("VMSG");
		if (myMessage != null) {
			out.println("<b style='color:#ff9911;'>"
					+ myMessage.getVericationcodemsg() + "</b>");
		}
	%>
	<form action="vcodedone.jsp" method="post">
		Enter your verication code here <input type="text" name="vvcode">
		<input type="submit" value="submit">
	</form>
		<div class="cleaner"></div>
	</div>
	<div class="cleaner"></div>
</div>

