<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css"
>
</head>
<body>
	<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"
	></script>
	<script
		src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"
></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"
></script>

	<jsp:include page="top.jsp" />
<section>
	<div id="carouselExampleCaptions" class="carousel slide"
		data-ride="carousel">
		<ol class="carousel-indicators">
			<li data-target="#carouselExampleCaptions" data-slide-to="0"
				class="active"></li>
			<li data-target="#carouselExampleCaptions" data-slide-to="1"></li>
			<li data-target="#carouselExampleCaptions" data-slide-to="2"></li>
		</ol>
		<div class="carousel-inner">
			<div class="carousel-item active">
				<img src="img/first.jpg" class="d-block w-100" alt="...">
				<div class="carousel-caption d-none d-md-block"
					style="margin-bottom: 130px; font-family: monospace;">
					<h1>
						Caring for <br>Your Furry <br>Friends
					</h1>

				</div>
			</div>
			<div class="carousel-item">
				<img src="img/second.jpg" class="d-block w-100" alt="...">
				<div class="carousel-caption d-none d-md-block"
					style="margin-bottom: 130px; font-family: monospace;">
					<h1>
						Caring for <br>Your Furry <br>Friends
					</h1>
				</div>
			</div>
			<div class="carousel-item">
				<img src="img/third.jpg" class="d-block w-100" alt="...">
				<div class="carousel-caption d-none d-md-block"
					style="margin-bottom: 130px; font-family: monospace;">
					<h1>
						Caring for <br>Your Furry <br>Friends
					</h1>
				</div>
			</div>
		</div>
		<a class="carousel-control-prev" href="#carouselExampleCaptions"
			role="button" data-slide="prev"> <span
			class="carousel-control-prev-icon" aria-hidden="true"></span> <span
			class="sr-only">Previous</span>
		</a> <a class="carousel-control-next" href="#carouselExampleCaptions"
			role="button" data-slide="next"> <span
			class="carousel-control-next-icon" aria-hidden="true"></span> <span
			class="sr-only">Next</span>
		</a>
	</div>
</section>

	<jsp:include page="footer.jsp" />


</body>
</html>