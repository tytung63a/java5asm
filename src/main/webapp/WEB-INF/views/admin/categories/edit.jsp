<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
				action="${pageContext.request.contextPath}/admin/categories/edit/${categoryForm.id}" modelAttribute="categoryForm">
				<div class="mt-3">
					Form Edit Category
				</div>
				
				<div class="mt-3">
					<label class="form-label">ID</label>
					<input type="text" disabled="disabled" class="form-control" value="${categoryForm.id }" name="id"/>
					
				</div>
				
				<div class="mt-3">
					<label class="form-label">Name</label>
					<form:input type="text" class="form-control" path="name"/>
					<span><form:errors path="name" cssClass="error" /></span>
				</div>
				
				<div class="mt-3">
					<label class="form-label">Description</label>
					<form:input type="text" class="form-control" path="description" />
					<span><form:errors path="description" cssClass="error" /></span>
				</div>
				
				<div class="mt-3">
					<button type="submit" class="btn btn-primary mb-3">Submit
					</button>
				</div>

			</form:form>
		</div>
	</div>
</div>