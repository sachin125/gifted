<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.controller.DownloadController"%>
<%@page import="java.io.FileReader"%>
<%@page import="java.io.FileInputStream"%>
<%@page import="java.io.FileOutputStream"%>
<%@page import="java.io.File"%>
<%@include file="userheader.jsp" %>
<%@page import="com.dto.MailDTO"%>

        <div id="templatemo_menu">
            <ul>
                <li><a href="userhome.jsp" >Home</a></li>
                <li><a href="inbox.jsp">Inbox</a></li>
                <li><a href="sentbox.jsp">Sentbox</a></li>
                <li><a href="composemail.jsp">Compose mail</a></li>
                <li><a href="../logout.jsp">logout</a></li>
            </ul>    	
        </div> <!-- end of templatemo_menu -->
        
<div id="templatemo_slider_wrapper"></div>
<div id="templatemo_content_wrapper">
	<div id="content">
		<div class="col_w560" style="height: 500px;">
			<!-- black page -->

	<h1>READ MAil</h1>

	<jsp:useBean id="mailDTO" class="com.dto.MailDTO"></jsp:useBean>
	<jsp:setProperty property="*" name="mailDTO" />
	<jsp:useBean id="mailController" class="com.controller.MailController"></jsp:useBean>

	<%
		System.out.println(mailDTO.getSender());
		System.out.println(mailDTO.getLtime());

		String emailid = (String)httpSession.getAttribute("EMAILID");
		System.out.println("readmail : "+emailid);
		mailDTO.setReceiver(emailid);
		
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat();
		mailDTO = mailController.readMail(request, response, mailDTO);
		String time = simpleDateFormat.format(mailDTO.getLtime());
		String emailname = mailDTO.getEmailname();
		String subject = mailDTO.getSubject();
		File file = mailDTO.getDecfile();
		String filefilename = mailDTO.getFilename();
		
		System.out.println("1 "+emailname);
		System.out.println("2 "+file.getAbsolutePath());
		System.out.println("3 "+filefilename);
		%>
	<h4>subject</h4><%out.println(subject);%>
	
	<h4>message</h4>
		<%
		FileReader fr = new FileReader(file);
		while (true) {
			int x = fr.read();
			if (x == -1) {
				break;
			}
			out.println((char) x);
		}
		fr.close();
		
		%>
<br><br>
<a href="../DownloadController?filesession=<%=filefilename%>">Download file</a>



	
		</div><br><br><h6>Time: </h6><%out.println(""+time); %>
	</div>
	<div class="cleaner"></div>
</div>
<%@include file="../footer.jsp" %>
