<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Error</title>

<!-- Bootstrap core CSS -->
<link
	href="https://getbootstrap.com/docs/5.0/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x"
	crossorigin="anonymous">

<!-- Favicons -->
<link rel="manifest"
	href="https://getbootstrap.com/docs/5.0/assets/img/favicons/manifest.json">
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

	<!-- NAV -->
	<nav class="navbar navbar-expand-lg navbar-dark fixed-top bg-dark">
		<div class="container-fluid" style="width: 95%; margin: 0 auto">
			<a class="navbar-brand" href="/">GEAR MA</a>

		</div>


	</nav>


	<div style="width: 80%; margin: 0 auto">${message }</div>

	<jsp:include page="/templates/footer"></jsp:include>

</body>
</html>