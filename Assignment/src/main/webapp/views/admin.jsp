<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
<!--Made with love by Mutiullah Samim -->

<!--Bootsrap 4 CDN-->
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
	integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO"
	crossorigin="anonymous">

<!--Fontawesome CDN-->
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.3.1/css/all.css"
	integrity="sha384-mzrmE5qonljUremFsqc01SB46JvROS7bZs3IO2EmfFsd15uHvIt+Y8vEf7N7fWAU"
	crossorigin="anonymous">

<!--Custom styles-->
<link rel="stylesheet" type="text/css" href="styles.css">

<link
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css"
	rel="stylesheet" id="bootstrap-css">
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<!------ Include the above in your HEAD tag ---------->
<style type="text/css">
@import url('https://fonts.googleapis.com/css?family=Numans');

html, body {
	background-image:
		url('http://getwallpapers.com/wallpaper/full/a/5/d/544750.jpg');
	background-size: cover;
	background-repeat: no-repeat;
	height: 100%;
	font-family: 'Numans', sans-serif;
}

.container {
	height: 100%;
	align-content: center;
}

.card {
	height: 370px;
	margin-top: auto;
	margin-bottom: auto;
	width: 400px;
	background-color: rgba(0, 0, 0, 0.5) !important;
}

.social_icon span {
	font-size: 60px;
	margin-left: 10px;
	color: #FFC312;
}

.social_icon span:hover {
	color: white;
	cursor: pointer;
}

.card-header h3 {
	color: white;
}

.social_icon {
	position: absolute;
	right: 20px;
	top: -45px;
}

.input-group-prepend span {
	width: 50px;
	background-color: #FFC312;
	color: black;
	border: 0 !important;
}

input:focus {
	outline: 0 0 0 0 !important;
	box-shadow: 0 0 0 0 !important;
}

.remember {
	color: white;
}

.remember input {
	width: 20px;
	height: 20px;
	margin-left: 15px;
	margin-right: 5px;
}

.login_btn {
	color: black;
	background-color: #FFC312;
	width: 100px;
}

.login_btn:hover {
	color: black;
	background-color: white;
}

.links {
	color: white;
}

.links a {
	margin-left: 4px;
}
</style>
</head>
<body>
	<!-- NAV -->
	<nav class="navbar navbar-expand-lg navbar-dark fixed-top bg-dark">
		<div class="container-fluid" style="width: 95%; margin: 0 auto">
			<a class="navbar-brand" href="/home">GEAR MA</a>
			<button class="navbar-toggler" type="button"
				data-bs-toggle="collapse" data-bs-target="#navbarCollapse"
				aria-controls="navbarCollapse" aria-expanded="false"
				aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="navbarCollapse">
				<ul class="navbar-nav me-auto mb-2 mb-md-0">
					<li class="nav-item"><a class="nav-link" aria-current="page"
						href="/admin">Trang chủ</a></li>
					<li class="nav-item"><a class="nav-link" aria-current="page"
						href="/admin/product">Sản phẩm</a></li>

					<li class="nav-item"><a class="nav-link" href="/admin/account">tài
							khoản</a></li>


				</ul>
			</div>

			<ul class="navbar-nav me-auto mb-2 mb-md-0">
				<c:if test="${pageContext.request.userPrincipal != null}">
					<div class="nav-item dropdown">
						<a class="nav-link " href="/new" id="dropdown05"
							data-bs-toggle="dropdown" aria-expanded="true">${pageContext.request.userPrincipal.name}</a>
						<ul class="dropdown-menu " aria-labelledby="dropdown05"
							data-bs-popper="none">
							<li><a class="dropdown-item" href="/info">Thông tin</a></li>
							<li><a class="dropdown-item" href="/logout">Đăng Xuất</a></li>
						</ul>
					</div>
				</c:if>
				<c:if test="${pageContext.request.userPrincipal == null}">
					<li class="nav-item "><a class=" nav-link" href="/login">Đăng
							nhập</a></li>
				</c:if>
			</ul>
		</div>
	</nav>


	<div class="container"></div>




	<jsp:include page="/templates/footer"></jsp:include>
</body>
</html>