<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
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
<link rel="stylesheet" href="/css/admin.css" />
<script src="/js/table-select.js" type="text/javascript"></script>
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
						href="/admin/account">Sản phẩm</a></li>

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


	<div class="bg-light"
		style="width: 1600px; min-height: 600px; box-shadow: 0 0 3px 3px #00000011; margin: 5rem auto; border-radius: 10px; position: relative;">
		<div
			style="width: 90%; margin: 3rem auto; position: absolute; left: 5%">

			<form:form method="POST" action="/admin/account/insert"
				modelAttribute="tk">
				<div class="form-group row">
					<form:label path="id" class="col-sm-2 form-label">Mã tài khoản</form:label>
					<form:input path="id" class="col form-control-plaintext" />
				</div>
				<div class="form-group row">
					<form:label path="userName" class="col-sm-2 form-label">Tên đăng nhập</form:label>
					<form:input path="userName" class="col form-control-plaintext" />
				</div>

				<div class="form-group row">
					<form:label path="encrytedPassword" class="col-sm-2 form-label">Mật khẩu Mới</form:label>
					<form:input path="encrytedPassword" type="password" value=""
						class="col form-control" />
				</div>
				<div class="form-group row">
					<form:label path="email" class="col-sm-2 form-label">Email</form:label>
					<form:input path="email" class="col form-control" />
				</div>
				<div class="form-group row">
					<form:label path="phone" class="col-sm-2 form-label">Điện thoại</form:label>
					<form:input path="phone" type="string" class="col form-control" />
				</div>
				<div class="form-group row">
					<form:label path="actived" class="col-sm-2 form-label">Role</form:label>
					<div class="col form-check">
						<form:checkbox path="actived" class="form-check-input"></form:checkbox>
					</div>
				</div>
				<div class="form-group row">
					<div class="col-sm-2 form-label"></div>
					<input type="submit" value="Lưu lại" class="btn btn-primary" /> <a
						href="/admin/account/new/" class="btn btn-success ml-2">Thêm
						sản phẩm</a>
				</div>
			</form:form>
		</div>
	</div>


</body>
</html>