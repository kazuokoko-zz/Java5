<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<!-- CSS only -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x"
	crossorigin="anonymous">
<link rel="stylesheet" href="/css/layout.css" type="text/css" />

</head>
<body>
	<div class="container">
		<div style="width: 90%; margin: 0 auto">
			<a href="/gaminggears/pagination">Back to List</a>
			<h2 style="width: 100%; text-align: center; margin-top: 2rem">Detail
				of Gear - ${gear.id}</h2>
			<form:form method="PUT" action="/gaminggears/update"
				modelAttribute="gear">
				<form:input type="hidden" path="id" value="${gear.id}" />

				<div class="form-group row">
					<form:label path="name" class="col-sm-2 form-label">Tên SP</form:label>
					<form:input path="name" value="${gear.name}"
						class="col form-control" />
				</div>

				<div class="form-group row">
					<form:label path="gearType" class="col-sm-2 form-label">loại</form:label>
					<form:select path="gearType" items="${gearType}"
						value="${gear.gearType }" class="col form-control" />
				</div>
				<div class="form-group row">
					<form:label path="created_date" class="col-sm-2 form-label">Ngày tạo</form:label>
					<fmt:formatDate var="created_date" value="${gear.created_date}"
						pattern="yyyy-MM-dd" />
					<form:input path="created_date" type="date" value="${created_date}"
						class="col form-control" />
				</div>
				<div class="form-group row">
					<form:label path="quantity" class="col-sm-2 form-label">Số lượng</form:label>
					<form:input path="quantity" type="number" value="${gear.quantity}"
						class="col form-control" />
				</div>
				<div class="form-group row">
					<form:label path="price" class="col-sm-2 form-label">Giá cả</form:label>
					<form:input path="price" type="number" value="${gear.price}"
						class="col form-control" />
				</div>
				<div class="form-group row">
					<div class="col-sm-2 form-label"></div>
					<div class="col form-control-plaintext">
						<input type="submit" value="Lưu" class="btn btn-primary" />
					</div>
				</div>
			</form:form>
		</div>
	</div>
</body>
</html>