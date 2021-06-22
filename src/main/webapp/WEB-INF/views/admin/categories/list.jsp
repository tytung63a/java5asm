<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style>
.thumb1 {
	background: url(blah.jpg) 50% 50% no-repeat;
	width: 50px;
	height: 50px;
}

.message {
	color: green;
	font-weight: bold;
	text-align: center;
}

thead {
	font-weight: bold;
}

</style>

</head>
<body>

	<div>
		<br>
		<div class="col-2 d-flex justify-content-end">
			<a href="${pageContext.request.contextPath}/admin/categories/create"
				class="btn btn-primary"> CREATE CATEGORY </a>
		</div>
		<br>

		<div class="message">${message}</div>
	</div>

		<table class="table table-hover">
			<thead class="text-center">
				<tr>
					<td><a
						href="${pageContext.request.contextPath}/admin/categories?field=id">ID
							<i class="fas fa-sort-amount-down"></i>
					</a></td>
					<td><a
						href="${pageContext.request.contextPath}/admin/categories?field=name">Name
							<i class="fas fa-sort-amount-down"></i>
					</a></td>
					<td><a
						href="${pageContext.request.contextPath}/admin/categories?field=description">DESCRIPTION
							<i class="fas fa-sort-amount-down"></i>
					</a></td>
					<td>ACTION</td>
				</tr>
			</thead>
			<tbody class="text-center">
				<c:forEach items="${ list.content }" var="category">
					<tr>
						<td>${ category.id }</td>
						<td>${ category.name }</td>
						<td>${ category.description }</td>
						<td><a
							href="${pageContext.request.contextPath}/admin/categories/edit/${category.id}"
							class="btn btn-info"><i class="fas fa-edit fa-lg"></i></a>&emsp;
							<a
							href="${pageContext.request.contextPath}/admin/categories/delete/${category.id}"
							class="btn btn-danger"
							onclick="return confirm('Are you sure you want to Remove?');"><i
								class="fas fa-trash fa-lg"></i></a>
					</tr>
				</c:forEach>
			</tbody>
		</table>


	<div class="d-flex justify-content-center">
		<nav aria-label="Page navigation example">
			<ul class="pagination">
				<c:if test="${list.number > 0}">
					<li class="page-item"><a class="page-link"
						href="${pageContext.request.contextPath}/admin/categories/?page=0">First</a></li>
				</c:if>


				<c:if test="${list.number > 0}">
					<li class="page-item"><a class="page-link"
						href="${pageContext.request.contextPath}/admin/categories/?page=${list.number - 1}">${list.number }</a></li>
				</c:if>


				<li class="page-item active" aria-current="page"><a
					class="page-link" href="#">${list.number + 1}<span
						class="visually-hidden">(current)</span></a></li>

				<c:if test="${list.number <list.totalPages -1}">
					<li class="page-item"><a class="page-link"
						href="${pageContext.request.contextPath}/admin/categories/?page=${list.number + 1}">${list.number +2}</a></li>
				</c:if>


				<c:if test="${list.number <list.totalPages -1}">
					<li class="page-item"><a class="page-link"
						href="${pageContext.request.contextPath}/admin/categories/?page=${list.totalPages -1}">Last</a></li>
				</c:if>

			</ul>
		</nav>
	</div>
</body>
</html>