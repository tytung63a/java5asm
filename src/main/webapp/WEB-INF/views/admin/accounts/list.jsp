<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
</style>
</head>
	<div>
		<br>
		<div class="col-2 d-flex justify-content-end">
			<a href="${pageContext.request.contextPath}/admin/accounts/create"
				class="btn btn-primary"> CREATE ACCOUNT </a>
		</div>
		<br>

		<div class="message">${message}</div>
		<table class="table table-hover">
			<thead class="text-center">
				<tr>
					<th><a
						href="${pageContext.request.contextPath}/admin/accounts?field=username">USER NAME
							<i class="fas fa-sort-amount-down"></i>
					</a></th>
					<th><a
						href="${pageContext.request.contextPath}/admin/accounts?field=password">PASSWORD
							<i class="fas fa-sort-amount-down"></i>
					</a></th>
					<th><a
						href="${pageContext.request.contextPath}/admin/accounts?field=email">EMAIL
							<i class="fas fa-sort-amount-down"></i>
					</a></th>
					<th><a
						href="${pageContext.request.contextPath}/admin/accounts?field=fullname">FULLNAME
							<i class="fas fa-sort-amount-down"></i>
					</a></th>
					<th><a
						href="${pageContext.request.contextPath}/admin/accounts?field=photo">PHOTO
							<i class="fas fa-sort-amount-down"></i>
					</a></th>
					<th><a
						href="${pageContext.request.contextPath}/admin/accounts?field=activated">ACTIVATED
							<i class="fas fa-sort-amount-down"></i>
					</a></th>
					<th><a
						href="${pageContext.request.contextPath}/admin/accounts?field=admin">ADMIN
							<i class="fas fa-sort-amount-down"></i>
					</a></th>
					<th>ACTION</th>
				</tr>
			</thead>

			<tbody class="text-center">
				<c:forEach var="account" items="${list.content}">
					<tr>
						<td>${account.username}</td>
						<td>${account.password}</td>
						<td>${account.email}</td>
						<td>${account.fullname}</td>
						<td><img src="/images/${ account.photo }" class="thumb1"></td>
						<td>${account.activated}</td>
						<td>${account.admin}</td>
						<td><a
							href="${pageContext.request.contextPath}/admin/accounts/edit/${account.username}"
							class="btn btn-info"><i class="fas fa-edit fa-lg"></i></a> &emsp;
							 <a
							href="${pageContext.request.contextPath}/admin/accounts/delete/${account.username}"
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
						href="${pageContext.request.contextPath}/admin/accounts/?page=0">First</a></li>
				</c:if>


				<c:if test="${list.number > 0}">
					<li class="page-item"><a class="page-link"
						href="${pageContext.request.contextPath}/admin/accounts/?page=${list.number - 1}">${list.number }</a></li>
				</c:if>


				<li class="page-item active" aria-current="page"><a
					class="page-link" href="#">${list.number + 1}<span
						class="visually-hidden">(current)</span></a></li>

				<c:if test="${list.number <list.totalPages -1}">
					<li class="page-item"><a class="page-link"
						href="${pageContext.request.contextPath}/admin/accounts/?page=${list.number + 1}">${list.number +2}</a></li>
				</c:if>


				<c:if test="${list.number <list.totalPages -1}">
					<li class="page-item"><a class="page-link"
						href="${pageContext.request.contextPath}/admin/accounts/?page=${list.totalPages -1}">Last</a></li>
				</c:if>

			</ul>
		</nav>
		</div>
