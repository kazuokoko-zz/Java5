<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title></title>
</head>
<body>

	<jsp:include page="/templates/header"></jsp:include>

	<div class=""
		style="width: 1024px; height: 600px; box-shadow: 0 0 3px 3px #00000011; margin: 5rem auto; border-radius: 10px">
		<div class="d-flex justify-content-evenly"
			style="height: 90% !important;">
			<div class="text-center"
				style="width: 600px; margin-top: 3rem !important;">
				<img src="http://lorempixel.com/500/400/" alt="img"
					style="border-radius: 1rem" />
			</div>
			<div class="d-flex flex-column"
				style="width: 400px; margin-top: 3rem !important">
				<span class="text-center h1 text-warning">${product.name }</span>
				<div class="h-50 d-flex flex-column justify-content-end">
					<span>Giá:</span>
					<c:choose>
						<c:when test="${product.discount >0 }">
							<span class="h3   mt-2 text-muted text-decoration-line-through">${product.price}</span>
							<span class="h3  mt-2 text-danger"> ${product.price - product.discount}</span>

						</c:when>
						<c:otherwise>
							<span class="text-muted text-decoration-line-through"></span>
							<span class="h3  mt-2 text-danger"> ${product.price - product.discount}</span>
						</c:otherwise>
					</c:choose>
				</div>
				<div class="text-center mt-5">
					<a class="btn btn-danger btn-lg w-75" href="/addToCart/${product.id }"><i
						class="bi-cart-fill me-1"></i>Mua ngay</a>
				</div>
			</div>
		</div>
	</div>

	<jsp:include page="/templates/footer"></jsp:include>
</body>
</html>