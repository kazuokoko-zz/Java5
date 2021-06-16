<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Cart</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css"
	rel="stylesheet" />

<script src="/js/table-select.js" type="text/javascript"></script>
</head>
<body>
	<jsp:include page="/templates/header"></jsp:include>



	<div style="width: 80%; min-width: 768px; margin: 0 auto">
		<fmt:formatNumber pattern="HD################" value="${order.id }"
			var="orderId"></fmt:formatNumber>
		<div class="row g-2">
			<div class="col-sm-5">
				<label class="form-label" for="mhd">Mã hóa đơn</label>
			</div>
			<div class="col-auto">
				<label class="form-control-plaintext" for="mhd">${orderId }</label>
			</div>
		</div>
		<div class="row g-2">
			<div class="col-sm-5">
				<label class="form-label" for="mhd">Người mua</label>
			</div>
			<div class="col-auto">
				<label class="form-control-plaintext" for="mhd">${account.userName }</label>
			</div>
		</div>
		<fmt:formatNumber pattern="dd-MM-yyyy hh:mm aa"
			value="${order.dateCreated }" var="dateCreated"></fmt:formatNumber>
		<div class="row g-2">
			<div class="col-sm-5">
				<label class="form-label" for="mhd">Ngày mua</label>
			</div>
			<div class="col-auto">
				<label class="form-control-plaintext" for="mhd">${dateCreated }</label>
			</div>
		</div>
		<table class="table table-striped table-info">
			<thead>
				<tr>
					<th>Tên mặt hàng</th>
					<th>Số lượng</th>
					<th>Giá tiền</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="order.orderDetails">
					<tr>
						<td>Tên mặt hàng</td>
						<td>Số lượng</td>
						<td>Giá tiền</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>

	</div>



	<jsp:include page="/templates/footer"></jsp:include>

</body>
</html>