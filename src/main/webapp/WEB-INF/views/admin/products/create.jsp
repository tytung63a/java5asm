<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<style>
.error {
	color: red;
}
</style>
<div class="row">
	<div class="col-12">
		<div class="col-6 offset-3">
			<form:form method="post"
				action="${pageContext.request.contextPath}/admin/products/create"
				enctype="multipart/form-data" modelAttribute="productForm">
				<div class="mt-3">
					Form Create Product
				</div>
				<div class="mt-3">
					<label class="form-label">Name</label>
					<form:input type="text" class="form-control" path="name" />
					<span><form:errors path="name" cssClass="error" /></span>
				</div>
				<div class="mt-3">
					<label class="form-label">Image</label>
					<form:input type="file" class="form-control" path="image" />
					<span><form:errors path="image" cssClass="error" /></span>
				</div>
				<div class="mt-3">
					<label class="form-label">Price</label>
					<form:input type="number" class="form-control" path="price" />
					<span><form:errors path="price" cssClass="error" /></span>
				</div>
				
				<div class="mt-3">
					<label class="form-label">Quantity</label>
					<form:input type="number" class="form-control" path="quantity" />
					<span><form:errors path="price" cssClass="error" /></span>
				</div>
			
				<div class="mt-3">
					<label class="form-label">Date Create(Year/Month/Day)</label>
					<form:input type="date" class="form-control" path="createDate" min="1997-01-01" max="2030-12-31" />
					<span><form:errors path="createDate" cssClass="error" /></span>
				</div>
				
				<div class="mt-3">
					<label class="form-label">Available</label>
					<form:select class="form-select" path="available" items="${listAvailable}"/>
				</div>
				
				<div class="mt-3">
					<button type="submit" class="btn btn-primary mb-3">Submit
					</button>
				</div>
			</form:form>
		</div>
	</div>
</div>