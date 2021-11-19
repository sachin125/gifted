<%@include file="header.jsp" %>
        <div id="templatemo_menu">
            <ul>
                <li><a href="index.jsp" class="current">Home</a></li>
                
                
                <li><a href="about.jsp">About us</a></li>
                <li><a href="contact.jsp">Contact</a></li>
                <li><a href="registration.jsp">Registration</a></li>
                <li><a href="login.jsp">Login</a></li>
            </ul>    	
        </div> <!-- end of templatemo_menu -->
        
        <div id="templatemo_slider_wrapper">
        
        	<div id="templatemo_slider">
            
				<div id="one" class="contentslider">
                    <div class="cs_wrapper">
                        <div class="cs_slider">
                        
                            <div class="cs_article">
                            	<div class="slider_content_wrapper">
									
									<div class="slider_image">
										<img src="images/slider/gifted1.jpg" alt="Mauris quis eros arcu" />
									</div>
									
									<div class="slider_content">
                                        <h2>Gifted Features</h2>
											<p>	Delivery on time</p>
                                        	<p>In budget</p>
                                           <p>Quality items</p>
                                           <p> Privacy and surprising</p>
									</div>
                                
								</div>
                            </div><!-- End cs_article -->
                            
                          
                      </div><!-- End cs_slider -->
                    </div><!-- End cs_wrapper -->
                          
                </div><!-- End contentslider -->
                
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
            	
                <h2>Why You Should Choose Us</h2>
                
                <div class="reasons">
                	<h3>Deliver on time</h3>
                    <img src="images/reason1.png" alt="Reason1" />
                    <p> Gifted provides items on deliver time with no extra charges. </p>
                </div>
                
                <div class="reasons">
                	<h3>In budget</h3>
                    <img src="images/reason2.png" alt="Reason2" />
                    <p>	Gifted provides items in quality budget. </p>
                </div>
                
                <div class="reasons">
                	<h3>Care about privacy</h3>
                    <img src="images/reason3.png" alt="Reason3" />
                    <p>  We care about privacy and surprise </p>
                </div>
                
                <div class="hr_divider"></div>
                
                
                
              
                <div class="cleaner"></div>
                
            </div>
			
            <div class="cleaner"></div>        
        
		</div>
		
<%@include file="footer.jsp" %>
