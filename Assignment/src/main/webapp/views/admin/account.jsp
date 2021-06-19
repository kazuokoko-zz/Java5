<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
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


	<div
		style="width: 1600px; box-shadow: 0 0 3px 3px #00000011; margin: 5rem auto; border-radius: 10px">
		<div style="width: 90%; margin-top: 3rem">
			<table class="table table-striped " style="border-radius: 5px">
				<thead class="table-dark">
					<tr>
						<th colspan="5">
							<form method="POST" action="/admin/account">
								<div class="d-flex justify-content-between">
									<div class="w-25"></div>
									<div class="w-50 d-flex justify-content-end">
										<div class="w-75">
											<input type="text" name="name" value="${name }"
												placeholder="Tên đăng nhập" class="form-control" />
										</div>
										<div class=" mb-2 mb-md-0" style="margin-left: 1rem">
											<button class="btn  btn-primary">Tìm</button>
										</div>
									</div>
								</div>
							</form>
						</th>
						<th class="text-center"><a href="/admin/account/new"
							class="btn btn-success">Thêm mới</a></th>
					</tr>
					<tr>
						<th style="text-align: center; width: 2rem"><input
							type="checkbox" id="selectAll" onchange="selectAllHandle()" /></th>
						<th><span>Tên đăng nhập</span></th>
						<th><span>Email</span></th>
						<th><span>Số điện thoại</span></th>
						<th><span>Kích hoạt</span></th>
						<th><a href="" class="btn btn-danger" id="deleteAll"
							onclick='return deleteAllHandle("/admin/account/delete")'>Xóa
								đã chọn</a></th>
					</tr>
				</thead>
				<tbody class="table-secondary">
					<c:forEach items="${tks  }" var="tk">
						<tr>
							<td style="text-align: center;"><input type="checkbox"
								name="selectone" onchange="selectOneHandle()" value="${tk.id }" /></td>
							<td>${tk.userName }</td>
							<td>${tk.email }</td>
							<td>${tk.phone }</td>
							<td style="text-align: center;"><div
									class="form-check form-switch">
									<input class="form-check-input" type="checkbox"
										onclick="return false" ${tk.actived? "checked" :"" } /><label
										class="form-check-label" for="flexSwitchCheckDefault"></label>
								</div></td>
							<td style="text-align: center"><a class="btn btn-primary"
								href="/admin/account/${tk.id }">Chi Tiết</a> <a
								class="btn btn-danger" href="/admin/account/delete/${tk.id }"
								onclick="return deleteHandle()">Xóa</a></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
			<div class="text-right">
				<div class="btn-group" role="group">
					<a
						href="/admin/account?p=${curPage>1?curPage - 1:curPage}&name=${name}"
						class="btn btn-primary">Trang trước</a>
					<button class="btn btn-secondary " disabled>Page:
						${curPage} / ${totalPage}</button>
					<a
						href="/admin/account?p=${curPage < totalPage ? curPage + 1 : totalPage}&name=${name}"
						class="btn btn-primary">Trang sau</a>
				</div>
			</div>
		</div>
	</div>




</body>
</html>