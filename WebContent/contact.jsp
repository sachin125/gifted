<%@page import="com.msg.MyMessage"%>
<%@include file="header.jsp"%>
<div id="templatemo_menu">
	<ul>
		<li><a href="index.jsp">Home</a>
		</li>

		<li><a href="about.jsp">About us</a>
		</li>
		<li><a href="contact.jsp" class="current">Contact</a>
		</li>
		<li><a href="registration.jsp">Registration</a>
		</li>
		<li><a href="login.jsp">login</a>
		</li>
	</ul>
</div>
<!-- end of templatemo_menu -->

<div id="templatemo_slider_wrapper">

	<div id="templatemo_slider">

		<div id="one" class="contentslider">
			<div class="cs_wrapper">
				<div class="cs_slider">

					<div class="cs_article">
						<div class="slider_content_wrapper">

							<div class="slider_image">
								<img src="images/slider/gifted1.jpg"
							 /></div>
							<div class="slider_content">
                                        <h2>Gifted Features</h2>
                                        	<p>	Delivery on time</p>
                                        	<p>In budget</p>
                                           <p>Quality items</p>
                                           <p> Privacy and surprising</p>
									</div>
                                
					</div>
					<!-- End cs_article -->





				</div>
				<!-- End cs_slider -->
			</div>
			<!-- End cs_wrapper -->
		</div>
		<!-- End contentslider -->

		<!-- Site JavaScript -->
		<script type="text/javascript" src="js/jquery-1.3.1.min.js"></script>
		<script type="text/javascript" src="js/jquery.easing.1.3.js"></script>
		<script type="text/javascript" src="js/jquery.ennui.contentslider.js"></script>
		<script type="text/javascript">
			$(function() {
				$('#one').ContentSlider({
					width : '940px',
					height : '240px',
					speed : 400,
					easing : 'easeOutSine'
				});
			});
		</script>
		<script src="js/jquery.chili-2.2.js" type="text/javascript"></script>
		<script src="js/chili/recipes.js" type="text/javascript"></script>
		<div class="cleaner"></div>

	</div>

</div>
<div id="templatemo_content_wrapper">
	<div id="content">

		<h2>Contact Information</h2>

		<p>
			<em><a href="http://validator.w3.org/check?uri=referer"
				rel="nofollow"></a> <a
				href="http://jigsaw.w3.org/css-validator/check/referer"
				rel="nofollow"></a>
		</p>

		<div class="hr_divider"></div>

		<div class="col_w420 float_l">
			<div id="contact_form">
				<h4>Quick Contact Form</h4>

				<form method="post" action="contactDONE.jsp">
					<%
						MyMessage myMessage = (MyMessage) request.getAttribute("CIMSG");
						if (myMessage != null) {
							out.println("<b style='color:#ff9911;'>"
									+ myMessage.getCimessage() + "</b>");
						}
					%>

					<label for="author">Name:</label> <input required type="text" id="author"
						name="name" class="required input_field" class="required"/>
					<div class="cleaner_h10"></div>

					<label for="email">Email:</label> <input required type="email" id="email"
						name="email" class="validate-email required input_field" class="required" />
					<div class="cleaner_h10"></div>

					<label for="subject">Subject:</label> <input required type="text"
						name="subject" id="subject" class="input_field" class="required"/>
					<div class="cleaner_h10"></div>

					<label for="text">Message:</label>
					<textarea id="text" name="message" rows="0" cols="0"
						class="required"></textarea>
					<div class="cleaner_h10"></div>

					<input type="submit" class="submit_btn float_l" name="submit"
						id="submit" value="Send" /> <input type="reset"
						class="submit_btn float_r" name="reset" id="reset" value="Reset" />

				</form>

			</div>
		</div>

		<div class="col_w420 last_box">
			<h4>Mailing Address</h4>
			<h6>Location One</h6>
			<h5>Team Gifted</h5>
			Philadelphia, USA<br/>
			Email Address: gifted@gmail.com<br/>
			<br/> Mobile No:1234567890

			<div class="hr_divider"></div>

			</div>
			<div class="col_w420 last_box">
			<h6>Location Two</h6>
			<h5>Team gifted</h5>
			Philadelphia, USA
			<br/> Email Address:  support@gifted.com<br />	
			<br /> Mobile No:9876543210

			<div class="hr_divider"></div>

			</div>

		<div class="cleaner"></div>

	</div>

	<div class="cleaner"></div>
</div>

<%@include file="footer.jsp"%>
