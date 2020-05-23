<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix='c' uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML>

<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>Shop &mdash; Free Website Template, Free HTML5 Template
	by gettemplates.co</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description"
	content="Free HTML5 Website Template by gettemplates.co" />
<meta name="keywords"
	content="free website templates, free html5, free template, free bootstrap, free website template, html5, css3, mobile first, responsive" />
<meta name="author" content="gettemplates.co" />

<!-- 
	//////////////////////////////////////////////////////

	FREE HTML5 TEMPLATE 
	DESIGNED & DEVELOPED by FreeHTML5.co
		
	Website: 		http://freehtml5.co/
	Email: 			info@freehtml5.co
	Twitter: 		http://twitter.com/fh5co
	Facebook: 		https://www.facebook.com/fh5co

	//////////////////////////////////////////////////////
	 -->

<!-- Facebook and Twitter integration -->
<meta property="og:title" content="" />
<meta property="og:image" content="" />
<meta property="og:url" content="" />
<meta property="og:site_name" content="" />
<meta property="og:description" content="" />
<meta name="twitter:title" content="" />
<meta name="twitter:image" content="" />
<meta name="twitter:url" content="" />
<meta name="twitter:card" content="" />
<!-- Animate.css -->
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/animate.css">
<!-- Icomoon Icon Fonts-->
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/icomoon.css">
<!-- Bootstrap  -->
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/bootstrap.css">

<!-- Flexslider  -->
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/flexslider.css">


<!-- Owl Carousel  -->
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/owl.carousel.min.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/owl.theme.default.min.css">

<!-- Theme style  -->
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/style.css">

<!-- Modernizr JS -->
<script
	src="${pageContext.request.contextPath}/js/modernizr-2.6.2.min.js"></script>
<script src="${pageContext.request.contextPath}/js/jquery-1.12.2.min.js"></script>
<script src="${pageContext.request.contextPath}/js/jquery-3.4.1.js"></script>
<script src="${pageContext.request.contextPath}/js/jquery.easing.1.3.js"></script>
<!-- Bootstrap -->
<script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
<!-- Waypoints -->
<script
	src="${pageContext.request.contextPath}/js/jquery.waypoints.min.js"></script>
<!-- Carousel -->
<script src="${pageContext.request.contextPath}/js/owl.carousel.min.js"></script>
<!-- countTo -->
<script src="${pageContext.request.contextPath}/js/jquery.countTo.js"></script>
<!-- Flexslider -->
<script
	src="${pageContext.request.contextPath}/js/jquery.flexslider-min.js"></script>
<!-- Main -->
<script src="${pageContext.request.contextPath}/js/main.js"></script>
<!-- FOR IE9 below -->
<!--[if lt IE 9]>
	<script src="js/respond.min.js"></script>
	<![endif]-->
</head>
<body>

	<div class="fh5co-loader"></div>

	<div id="page">
		<jsp:include page="shopTop.jsp" />

		<!-- ------------------------------------------------------------------------------------------------------- -->

		<header id="fh5co-header" class="fh5co-cover fh5co-cover-sm"
			role="banner" style="background-image: url(images/img_bg_2.jpg);">
			<div class="overlay"></div>



			<div class="container">
				<div class="row">
					<div class="col-md-8 col-md-offset-2 text-center">
						<div class="display-t">
							<div class="display-tc animate-box" data-animate-effect="fadeIn">
								<h1>Contact Us</h1>
								<h2>
									Free html5 templates Made by <a href="http://freehtml5.co"
										target="_blank">freehtml5.co</a>
								</h2>
							</div>
						</div>
					</div>
				</div>
			</div>
		</header>

		<!-- ------------------------------------------------------------------------------------------------------- -->


		<div id="fh5co-contact">
			<div class="container">
				<div class="row">
					<div class="col-md-3 col-md-push-1 animate-box">

						<div class="fh5co-contact-info">
							<h3>Pet Product</h3>
							<ul>
								<li class="icon-cake"><a href="#" id='cate1' >寵物食品</a>
								<form id="myform1" method="post" action="url"></form></li>
								<li class="icon-image"><a href="#" id='cate2'>寵物衣服</a></li>
								<li class="icon-game-controller"><a href="#" id='cate3'>寵物玩具</a></li>
								<li class="icon-shopping-cart"><a href="#">購物車</a></li>
							</ul>
						</div>

					</div>


					<div class="col-md-9 animate-box">
						<div align="center">
							<h3>Get In Touch</h3>
						</div>
						<c:forEach var="product" items="${productList}">
						<div class="col-md-3 text-center animate-box">

							<div class="product ">
								<div class="product-grid ">
									<div class="card ">
<!-- 										<img class="card-img-top" -->
<%-- 											src="data:image/jpg;base64,${product.getBiPhoto()}" --%>
<!-- 											alt="Card image cap"> -->
										<div class="card-body">
											<h5 class="card-title">${product.getName()}</h5>
											<p class="card-text">${product.getDescriptrion()}</p>

										</div>
										<div class="card-footer ">
											<a href="#" class="btn btn-primary">加入最愛</a> <br> <a
												href="#" class="btn btn-primary">加入購物</a>
										</div>

									</div>
								</div>
							</div>
						</div>
						</c:forEach>
					</div>
				</div>

			</div>
		</div>

		<div id="map" class="animate-box" data-animate-effect="fadeIn"></div>

		<div id="fh5co-started">
			<div class="container">
				<div class="row animate-box">
					<div class="col-md-8 col-md-offset-2 text-center fh5co-heading">
						<h2>Newsletter</h2>
						<p>Just stay tune for our latest Product. Now you can
							subscribe</p>
					</div>
				</div>
				<div class="row animate-box">
					<div class="col-md-8 col-md-offset-2">
						<form class="form-inline">
							<div class="col-md-6 col-sm-6">
								<div class="form-group">
									<label for="email" class="sr-only">Email</label> <input
										type="email" class="form-control" id="email"
										placeholder="Email">
								</div>
							</div>
							<div class="col-md-6 col-sm-6">
								<button type="submit" class="btn btn-default btn-block">Subscribe</button>
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>

		<footer id="fh5co-footer" role="contentinfo">
			<div class="container">
				<div class="row row-pb-md">
					<div class="col-md-4 fh5co-widget">
						<h3>Shop.</h3>
						<p>Facilis ipsum reprehenderit nemo molestias. Aut cum
							mollitia reprehenderit. Eos cumque dicta adipisci architecto
							culpa amet.</p>
					</div>
					<div class="col-md-2 col-sm-4 col-xs-6 col-md-push-1">
						<ul class="fh5co-footer-links">
							<li><a href="#">About</a></li>
							<li><a href="#">Help</a></li>
							<li><a href="#">Contact</a></li>
							<li><a href="#">Terms</a></li>
							<li><a href="#">Meetups</a></li>
						</ul>
					</div>

					<div class="col-md-2 col-sm-4 col-xs-6 col-md-push-1">
						<ul class="fh5co-footer-links">
							<li><a href="#">Shop</a></li>
							<li><a href="#">Privacy</a></li>
							<li><a href="#">Testimonials</a></li>
							<li><a href="#">Handbook</a></li>
							<li><a href="#">Held Desk</a></li>
						</ul>
					</div>

					<div class="col-md-2 col-sm-4 col-xs-6 col-md-push-1">
						<ul class="fh5co-footer-links">
							<li><a href="#">Find Designers</a></li>
							<li><a href="#">Find Developers</a></li>
							<li><a href="#">Teams</a></li>
							<li><a href="#">Advertise</a></li>
							<li><a href="#">API</a></li>
						</ul>
					</div>
				</div>

				<div class="row copyright">
					<div class="col-md-12 text-center">
						<p>
							<small class="block">&copy; 2016 Free HTML5. All Rights
								Reserved.</small> <small class="block">Designed by <a
								href="http://freehtml5.co/" target="_blank">FreeHTML5.co</a>
								Demo Images: <a href="http://blog.gessato.com/" target="_blank">Gessato</a>
								&amp; <a href="http://unsplash.co/" target="_blank">Unsplash</a></small>
						</p>
						<p>
						<ul class="fh5co-social-icons">
							<li><a href="#"><i class="icon-twitter"></i></a></li>
							<li><a href="#"><i class="icon-facebook"></i></a></li>
							<li><a href="#"><i class="icon-linkedin"></i></a></li>
							<li><a href="#"><i class="icon-dribbble"></i></a></li>
						</ul>
						</p>
					</div>
				</div>

			</div>
		</footer>
	</div>

	<div class="gototop js-top">
		<a href="#" class="js-gotop"><i class="icon-arrow-up"></i></a>
	</div>



</body>
</html>

