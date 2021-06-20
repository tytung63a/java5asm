<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style>
.thumb1 {
	background: url(blah.jpg) 50% 50% no-repeat;
	/* 50% 50% centers image in div */
	width: 50px;
	height: 50px;
}

.message {
	color: green;
	font-weight: bold;
	text-align: center;
}
</style>
</head>
<body>
	<div>
		<br>
		<div class="col-2 d-flex justify-content-end">
			<a href="${pageContext.request.contextPath}/admin/products/create"
				class="btn btn-primary"> CREATE PRODUCT </a>
		</div>
		<br>
		<div class="message">${message}</div>
		<table class="table table-hover">
			<thead class="text-center">
				<tr>
					<th>ID</th>
					<th>NAME</th>
					<th>PRICE</th>
					<th>QUANTITY</th>
					<th>IMAGE</th>
					<th>AVAILABLE</th>
					<th>CATEGORY_ID</th>
					<th>CREATE_DATE</th>
					<th>ACTION</th>
				</tr>
			</thead>

			<tbody class="text-center">
				<c:forEach var="product" items="${list}">
					<tr>
						<td>${product.id}</td>
						<td>${product.name}</td>
						<td>${product.price}</td>
						<td>${product.quantity}</td>
						<td><img src="/images/${ product.image }" class="thumb1"></td>
						<td>${product.available}</td>
						<td>${product.category.id}</td>
						<td>${product.createDate}</td>
						<td><a
							href="${pageContext.request.contextPath}/admin/products/edit/${product.id}"
							class="btn btn-info"><i class="fas fa-edit fa-lg"></i></a>&emsp; <a
							href="${pageContext.request.contextPath}/admin/products/delete/${product.id}"
							class="btn btn-danger"
							onclick="return confirm('Are you sure you want to Remove?');"><i
								class="fas fa-trash fa-lg"></i></a>
						</td>
					</tr>
				</c:forEach>
			</tbody>

		</table>
	</div>
</body>
</html>