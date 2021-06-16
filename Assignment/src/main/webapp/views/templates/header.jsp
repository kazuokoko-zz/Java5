<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author"
	content="Mark Otto, Jacob Thornton, and Bootstrap contributors">
<meta name="generator" content="Hugo 0.83.1">
<title></title>

<!-- Bootstrap core CSS -->
<link
	href="https://getbootstrap.com/docs/5.0/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x"
	crossorigin="anonymous">

<!-- Favicons -->
<link rel="apple-touch-icon"
	href="https://getbootstrap.com/docs/5.0/assets/img/favicons/apple-touch-icon.png"
	sizes="180x180">
<link rel="icon"
	href="https://getbootstrap.com/docs/5.0/assets/img/favicons/favicon-32x32.png"
	sizes="32x32" type="image/png">
<link rel="icon"
	href="https://getbootstrap.com/docs/5.0/assets/img/favicons/favicon-16x16.png"
	sizes="16x16" type="image/png">
<link rel="manifest"
	href="https://getbootstrap.com/docs/5.0/assets/img/favicons/manifest.json">
<link rel="mask-icon"
	href="https://getbootstrap.com/docs/5.0/assets/img/favicons/safari-pinned-tab.svg"
	color="#7952b3">
<link rel="icon"
	href="https://getbootstrap.com/docs/5.0/assets/img/favicons/favicon.ico">
<meta name="theme-color" content="#7952b3">

<link
	href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css"
	rel="stylesheet" />
<style>
.bd-placeholder-img {
	font-size: 1.125rem;
	text-anchor: middle;
	-webkit-user-select: none;
	-moz-user-select: none;
	user-select: none;
}

@media ( min-width : 768px) {
	.bd-placeholder-img-lg {
		font-size: 3.5rem;
	}
	/* 	.navbar-expand-md .navbar-collapse { */
	/* 		display: flex !important; */
	/* 		flex-basis: auto; */
	/* 	} */
}

.carousel-item {
	height: 200px;
	text-align: center !important;
}
</style>

<!-- Custom styles for this template -->
<link
	href="https://getbootstrap.com/docs/5.0/examples/navbar-fixed/navbar-top-fixed.css"
	rel="stylesheet">



</head>
<body>
	<!-- HEADER -->



	<!-- NAV -->
	<nav class="navbar navbar-expand-xl navbar-dark fixed-top bg-dark">
		<div class="container-fluid" style="width: 95%; margin: 0 auto">
			<a class="navbar-brand" href="/">GEAR MA</a>
			<button class="navbar-toggler" type="button"
				data-bs-toggle="collapse" data-bs-target="#navbarCollapse"
				aria-controls="navbarCollapse" aria-expanded="false"
				aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="navbarCollapse">
				<ul class="navbar-nav me-auto mb-2 mb-md-0">
					<li class="nav-item"><a class="nav-link" aria-current="page"
						href="/">Trang chủ</a></li>
					<li class="nav-item dropdown"><a
						class="nav-link dropdown-toggle" href="/new" id="dropdown05"
						data-bs-toggle="dropdown" aria-expanded="true">Danh mục</a>
						<ul class="dropdown-menu " aria-labelledby="dropdown05"
							data-bs-popper="none">
							<li><a class="dropdown-item" href="/new">Mới</a></li>
							<li><a class="dropdown-item" href="/hot">Bán chạy</a></li>
							<li><a class="dropdown-item" href="/discount">Đang giảm
									giá</a></li>
						</ul></li>

					<li class="nav-item"><a class="nav-link" href="/about">Thông
							tin</a></li>
					<li class="nav-item"><a class="nav-link" href="/contact">Liên
							hệ</a></li>

				</ul>
				<div class="navbar-nav me-auto mb-2 mb-md-0">
					<form class="d-flex" method="GET">
						<input class="form-control me-2" type="search"
							placeholder="Tên sản phẩm" aria-label="Tìm kiếm" name="name">
						<button class="btn btn-outline-success" type="submit">Tìm</button>
					</form>
				</div>
				<div class="navbar-nav mb-2 mb-md-0">
					<a class="btn btn-outline-danger" href="/cart"> <i
						class="bi-cart-fill me-1"></i>Giỏ hàng<span
						class="badge  text-white rounded-pill">${cartCount}</span>
					</a>
				</div>
				<ul class="navbar-nav mb-2 mb-md-0">
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
		</div>
	</nav>


</body>
</html>