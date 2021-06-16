<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
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
<script type="text/javascript">
function selectAllHandle(){
	document.getElementsByName("selectone").forEach(
			(item)=>{
				item.checked = document.getElementById("selectAll").checked?true:false;
					});
	}
	
function selectOneHandle(){
	let isSame = true;
	let isSel = document.getElementsByName("selectone").item(0).checked;
	const list = document.getElementsByName("selectone");
	for(i = 0;i <list.length;i++){
        let row = list.item(i);
		if(row.checked != isSel){
			isSame=false;
            break;
		}
    }
			
	if (isSame)
		document.getElementById("selectAll").checked=isSel;
	}
	
function deleteHandle(){
	if(!confirm("Xác nhận xóa")){
		return false;
	}
}

function deleteAllHandle(event){
	if(confirm("Xác nhận xóa")){
		const list = [];
		document.getElementsByName("selectone").forEach(e=>{if(e.checked)list.push(e.value)});
		document.getElementById("deleteAll").href="/gaminggears/delete?ids	="+list;
		return true;
	}else{
		return false;
	}
}
</script>
</head>
<body>
	<div class="container">
		<div style="width: 90%; margin: 0 auto">
			<div style="height: 2rem"></div>
			<table class="table table-secondary table-striped">
				<thead>
					<tr class="table-dark" style="width: 100%">
						<th colspan="5">Quản lý Gear</th>
						<th><c:if test="${findByType}">
								<form>
									<input type="hidden" name="curPage" value="1" /> 
									<select
										type="submit" name="type" onchange="submit()"
										class="form-control">
										<option value="">All</option>
										<c:forEach items="${gearType }" var="item">
											<option value="${item }" ${item ==type? "selected": "" }>${item }</option>
										</c:forEach>
									</select>
								</form>
							</c:if></th>
						<th style="text-align: center"><a class="btn btn-success"
							href="/gaminggears/new"><svg
									xmlns="http://www.w3.org/2000/svg" width="16" height="16"
									fill="currentColor" class="bi bi-plus-circle-fill"
									viewBox="0 0 16 16">
  							<path
										d="M16 8A8 8 0 1 1 0 8a8 8 0 0 1 16 0zM8.5 4.5a.5.5 0 0 0-1 0v3h-3a.5.5 0 0 0 0 1h3v3a.5.5 0 0 0 1 0v-3h3a.5.5 0 0 0 0-1h-3v-3z" />
				</svg> Thêm mới </a> <%-- 				<c:if test="${isPagging }"> --%> <a
							id="deleteAll" class="btn btn-danger" href=""
							onclick="return deleteAllHandle()"> <svg
									xmlns="http://www.w3.org/2000/svg" width="16" height="16"
									fill="currentColor" class="bi bi-dash-circle"
									viewBox="0 0 16 16">
  <path
										d="M8 15A7 7 0 1 1 8 1a7 7 0 0 1 0 14zm0 1A8 8 0 1 0 8 0a8 8 0 0 0 0 16z" />
  <path d="M4 8a.5.5 0 0 1 .5-.5h7a.5.5 0 0 1 0 1h-7A.5.5 0 0 1 4 8z" />
</svg> Xóa
						</a> <%-- 							</c:if> --%></th>
					</tr>
					<tr>
						<th><input type="checkbox" class="form-check-input"
							id="selectAll" onchange="selectAllHandle()" /></th>
						<!-- 						<th>Mã SP</th> -->
						<th>Tên SP</th>
						<th>Loại SP</th>
						<th>Ngày tạo</th>
						<th>Số lượng</th>
						<th>Giá</th>
						<th></th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="gear" items="${gamingGears}">
						<tr>
							<td><input type="checkbox" class="form-check-input"
								name="selectone" onchange="selectOneHandle()"
								value="${gear.id }" /></td>
							<%-- 							<td>${gear.code }</td> --%>
							<td>${gear.name }</td>
							<td>${gear.gearType }</td>
							<td><fmt:formatDate var="created_date"
									value="${gear.created_date}" pattern="dd/MM/yyyy" />
								${created_date}</td>
							<td>${gear.quantity }</td>
							<td>${gear.price }</td>
							<td style="text-align: center"><a class="btn btn-primary"
								href="/gaminggears/${gear.id }">Chi Tiết</a> <a
								class="btn btn-danger" href="/gaminggears/delete/${gear.id }"
								onclick="return deleteHandle()">Xóa</a></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
		<c:if test="${isPagging }">
			<div style="width: 90%; margin: 0 auto; text-align: right">
				<div class="btn-group" role="group">
					<a
						href="/gaminggears/pagination?curPage=${curPage>1?curPage - 1:curPage}&type=${type}"
						class="btn btn-primary">Trang trước</a>
					<button class="btn btn-secondary " disabled>Page:
						${curPage} / ${totalPage}</button>
					<a
						href="/gaminggears/pagination?curPage=${curPage < totalPage ? curPage + 1 : totalPage}&type=${type}"
						class="btn btn-primary">Trang sau</a>
				</div>
			</div>
		</c:if>
	</div>
</body>
</html>