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
					<th><a
						href="${pageContext.request.contextPath}/admin/products?field=id">ID
							<i class="fas fa-sort-amount-down"></i>
					</a></th>
					<th><a
						href="${pageContext.request.contextPath}/admin/products?field=name">NAME
							<i class="fas fa-sort-amount-down"></i>
					</a></th>
					<th><a
						href="${pageContext.request.contextPath}/admin/products?field=price">PRICE
							<i class="fas fa-sort-amount-down"></i>
					</a></th>
					<th><a
						href="${pageContext.request.contextPath}/admin/products?field=quantity">QUANTITY
							<i class="fas fa-sort-amount-down"></i>
					</a></th>
					<th><a
						href="${pageContext.request.contextPath}/admin/products?field=image">IMAGE
							<i class="fas fa-sort-amount-down"></i>
					</a></th>
					<th><a
						href="${pageContext.request.contextPath}/admin/products?field=available">AVAILABLE
							<i class="fas fa-sort-amount-down"></i>
					</a></th>
					<th><a
						href="${pageContext.request.contextPath}/admin/products?field=category">CATEGORY_ID
							<i class="fas fa-sort-amount-down"></i>
					</a></th>
					<th><a
						href="${pageContext.request.contextPath}/admin/products?field=createDate">CREATE_DATE
							<i class="fas fa-sort-amount-down"></i>
					</a></th>
					<th>ACTION</th>
				</tr>
			</thead>

			<tbody class="text-center">
				<c:forEach var="product" items="${list.content}">
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
	
	<div class="d-flex justify-content-center">
		<nav aria-label="Page navigation example">
			<ul class="pagination">
				<c:if test="${list.number > 0}">
					<li class="page-item"><a class="page-link"
						href="${pageContext.request.contextPath}/admin/products/?page=0">First</a></li>
				</c:if>


				<c:if test="${list.number > 0}">
					<li class="page-item"><a class="page-link"
						href="${pageContext.request.contextPath}/admin/products/?page=${list.number - 1}">${list.number }</a></li>
				</c:if>


				<li class="page-item active" aria-current="page"><a
					class="page-link" href="#">${list.number + 1}<span
						class="visually-hidden">(current)</span></a></li>

				<c:if test="${list.number <list.totalPages -1}">
					<li class="page-item"><a class="page-link"
						href="${pageContext.request.contextPath}/admin/products/?page=${list.number + 1}">${list.number +2}</a></li>
				</c:if>


				<c:if test="${list.number <list.totalPages -1}">
					<li class="page-item"><a class="page-link"
						href="${pageContext.request.contextPath}/admin/products/?page=${list.totalPages -1}">Last</a></li>
				</c:if>

			</ul>
		</nav>
	</div>
	
</body>
</html>