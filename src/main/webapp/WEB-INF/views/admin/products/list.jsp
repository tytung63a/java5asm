<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<p>${message}</p>
<style>
.thumb1 { 
  background: url(blah.jpg) 50% 50% no-repeat; /* 50% 50% centers image in div */
  width: 50px;
  height: 50px;
}

</style>

<table class="table table-hover">
<div class="mt-2 row">
			<div class="col-2 d-flex justify-content-end">
				<a href="${pageContext.request.contextPath}/admin/products/create"
					class="btn btn-primary"> CREATEPRODUCT </a>
			</div>
		</div>

	<thead>
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

	<tbody>
		<c:forEach var="product" items="${list}">
			<tr>
				<td>${product.id}</td>
				<td>${product.name}</td>
				<td>${product.price}</td>
				<td>${product.quantity}</td>
				<td><img src="/images/${ product.image }" class="thumb1" ></td>
				<td>${product.available}</td>
				<td>${product.category.name}</td>
				<td>${product.createDate}</td>
				<td>
					<a href="${pageContext.request.contextPath}/admin/products/edit/${product.id}"
					class="btn btn-info">Edit</a>&emsp;
					<a href="${pageContext.request.contextPath}/admin/products/delete/${product.id}"
					class="btn btn-danger" onclick="return confirm('Are you sure you want to Remove?');">Delete</a>
				</td>
			</tr>
		</c:forEach>
	</tbody>

</table>


