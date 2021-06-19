<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Cart</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css"
	rel="stylesheet" />

<script src="/js/table-select.js" type="text/javascript"></script>
<script type="text/javascript">
 function changeHandle(id){
	 let el = document.getElementById(id);
	 let quantity = el.value;
	 let ok = true;
	 if(quantity <= 0){
		 ok = confirm("Xác nhận xóa sản phẩm?");
	 }
	if(ok){
		document.getElementById("form"+el.id).action="/cart/update/" + el.id + "?quantity="+ quantity;
		return true;
	}else{
		el.value=1;
		return false;
	}
 }
 
</script>
</head>
<body>
	<jsp:include page="/templates/header"></jsp:include>



	<div style="width: 80%; min-width: 768px; margin: 0 auto">
		<c:choose>
			<c:when test="${haveItems }">
				<table class="table table-striped  mt-3">
					<thead class="table-dark">
						<tr>
							<th><input type="checkbox" class="form-check-input"
								id="selectAll" onchange="selectAllHandle()" /></th>
							<th><span style="line-height: 38px">Tên sản phẩm</span></th>
							<th><span style="line-height: 38px">Số lượng</span></th>
							<th><span style="line-height: 38px">Giá tiền</span></th>
							<th><a href="" class="btn btn-danger" id="deleteAll"
								onclick='return deleteAllHandle("/cart/delete")'>Xóa đã chọn</a></th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${cart }" var="entry">
							<tr>
								<td><input type="checkbox" class="form-check-input"
									name="selectone" onchange="selectOneHandle()"
									value="${entry.key }" /></td>
								<td><a class="text-decoration-none"
									href="/product/${entry.key }">${entry.value.name }</a></td>
								<td>
									<form id="form${entry.key }" method="POST">
										<input type="number" step="1" min="0" name="quantity"
											id="${entry.key }" value="${entry.value.quantity }"
											onchange='if(changeHandle("${entry.key }")) submit();'
											class="form-text-input" />
									</form>

								</td>


								<td>${entry.value.price }</td>

								<td><a href="/cart/delete/${entry.key}"
									class="btn btn-danger" onclick="return deleteHandle()">Xóa</a></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
				<div class="d-flex justify-content-between">
				<span>Tổng tiền: ${sumPrice }</span>
					<a href="/cart/buy" class="btn btn-primary">Thanh toán</a>
				</div>
			</c:when>
			<c:otherwise>
				<div class="alert alert-warning mt-3">Bạn không có sản phẩm
					nào trong giỏ hàng</div>
			</c:otherwise>
		</c:choose>




	</div>



	<jsp:include page="/templates/footer"></jsp:include>

</body>
</html>