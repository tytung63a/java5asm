<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<a class="text-center"> ${message} </a>
	<div class="col-8 offset-2">
		<div class="mt-4 row">
			<div class="col-2 d-flex justify-content-end">
				<a href="${pageContext.request.contextPath}/admin/categories/create"
					class="btn btn-primary"> CREATEPRODUCT </a>
			</div>
		</div>

		<div class="mt-5 table-responsive">
			<table class="table table-hover">
				<thead>
					<tr>
						<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; ID &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
						<td>NAME</td>
						<td>DESCIPTION</td>
						<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;ACTION</td>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${ list }" var="category">
						<tr>
							<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;${ category.id }</td>
							<td>${ category.name }</td>
							<td>${ category.description }</td>
							<td><a
								href="${pageContext.request.contextPath}/admin/categories/edit/${category.id}"
								class="btn btn-info">Edit</a> <a
								href="${pageContext.request.contextPath}/admin/categories/delete/${category.id}"
								class="btn btn-danger" onclick="confirmDelete();">Delete</a>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>

	<script>
		function confirmDelete() {
			alert("Bạn có muốn xóa không");
		}
		$(function() {
			$('.btn-danger').on('click', confirmDelete());
		});
	</script>
	
</body>
</html>