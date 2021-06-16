<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Home</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css"
	rel="stylesheet" />
</head>
<body>
	<jsp:include page="/templates/header"></jsp:include>



	<!-- Header-->
	<div class="bg-dark py-5 mt-0">
		<div id="carouselExampleControls" class="carousel slide"
			data-bs-ride="carousel">
			<div class="carousel-inner">
				<div class="carousel-item active">
					<img
						src="https://cdn.tgdd.vn/Files/2017/01/19/939425/fresh-windows-10-wallpaper-full-background_1280x720.jpg"
						class=" h-100" alt="...">
				</div>
				<div class="carousel-item">
					<img
						src="https://cdn.tgdd.vn/Files/2017/02/21/952698/huong-dan-dung-video-lam-man-hinh-desktop-20-760x367.png"
						class="  h-100" alt="...">
				</div>
				<div class="carousel-item">
					<img
						src="https://png.pngtree.com/thumb_back/fh260/background/20201101/pngtree-cyber-monday-big-sale-at-the-center-on-digital-computer-background-image_446172.jpg"
						class=" h-100" alt="...">
				</div>
			</div>
			<button class="carousel-control-prev" type="button"
				data-bs-target="#carouselExampleControls" data-bs-slide="prev">
				<span class="carousel-control-prev-icon" aria-hidden="true"></span>
				<span class="visually-hidden">Previous</span>
			</button>
			<button class="carousel-control-next" type="button"
				data-bs-target="#carouselExampleControls" data-bs-slide="next">
				<span class="carousel-control-next-icon" aria-hidden="true"></span>
				<span class="visually-hidden">Next</span>
			</button>
		</div>
	</div>

	<!-- Section-->
	<section class="py-5">
		<div class="container px-4 px-lg-5 mt-3">
			<div
				class="row gx-4 gx-lg-5 row-cols-2 row-cols-md-3 row-cols-xl-4 justify-content-center">

				<c:forEach items="${gamingGears }" var="gear">

					<div class="col mb-5">
						<div class="card h-100">
							<!-- Sale badge-->
							<c:if test="${gear.discount >0 }">
								<div class="badge bg-danger text-white position-absolute"
									style="top: 0.25rem; right: 0.25rem">Sale</div>
							</c:if>
							<!-- Product image-->
							<img class="card-img-top bg-dark" style="height: 180px"
								src="http://lorempixel.com/223/180/" alt="img" />
							<!-- Product details-->
							<div class="card-body p-4">
								<div class="text-center">
									<!-- Product name-->
									<h5 class="fw-bolder">
										<a class="text-decoration-none" href="/product/${gear.id }">${gear.name}<a></a>
									</h5>
									<!-- Product price-->
									<c:choose>
										<c:when test="${gear.discount >0 }">
											<span class="text-muted text-decoration-line-through">${gear.price}</span> ${gear.price - gear.discount}</c:when>
										<c:otherwise>
											<span class="text-muted text-decoration-line-through"></span> ${gear.price}</c:otherwise>
									</c:choose>
								</div>
							</div>
							<!-- Product actions-->
							<div class="card-footer p-4 pt-0 border-top-0 bg-transparent">
								<div class="text-center">
									<a class="btn btn-danger" href="/addToCart/${gear.id }"><i
										class="bi-cart-fill me-1"></i>Mua ngay</a>
								</div>
							</div>
						</div>
					</div>


				</c:forEach>

			</div>
		</div>

	</section>

	<div style="width: 90%; margin: 0 auto; text-align: right">
		<div class="btn-group" role="group">
			<c:if test="${curPage > 1 }">
				<c:choose>
					<c:when test="${finding}">
						<a href='/home?name=${name }&p=${curPage - 1}'
							class="btn btn-primary">Trang trước</a>
					</c:when>
					<c:otherwise>
						<a href='/home?p=${curPage - 1}' class="btn btn-primary">Trang
							trước</a>
					</c:otherwise>
				</c:choose>

			</c:if>
			<button class="btn btn-secondary " disabled>Page: ${curPage}
				/ ${totalPage}</button>
			<c:if test="${curPage < totalPage }">
				<c:choose>
					<c:when test="${finding}">
						<a href='/home?name=${name }&p=${curPage + 1 }'
							class="btn btn-primary">Trang sau</a>
					</c:when>
					<c:otherwise>
						<a href='/home?p=${curPage + 1 }' class="btn btn-primary">Trang
							sau</a>
					</c:otherwise>
				</c:choose>

			</c:if>

		</div>
	</div>





	<jsp:include page="/templates/footer"></jsp:include>

</body>
</html>