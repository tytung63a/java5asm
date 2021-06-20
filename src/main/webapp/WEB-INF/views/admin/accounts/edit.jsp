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
				action="${pageContext.request.contextPath}/admin/accounts/edit/${usernameValue }"
				enctype="multipart/form-data" modelAttribute="accountForm">
				<div class="mt-3">
					Form Edit Account
				</div>
				<div class="mt-3">
					<label class="form-label">UserName</label>
					<input type="text" value="${usernameValue}" disabled class="form-control" name="username" />
				</div>
				
				<div class="mt-3">
					<label class="form-label">PassWord</label>
					<form:input type="password" class="form-control" path="password" />
					<span><form:errors path="password" cssClass="error" /></span>
				</div>
				
				<div class="mt-3">
					<label class="form-label">Email</label>
					<form:input type="email" class="form-control" path="email" />
					<span><form:errors path="email" cssClass="error" /></span>
				</div>
				
				<div class="mt-3">
					<label class="form-label">FullName</label>
					<form:input type="text" class="form-control" path="fullname" />
					<span><form:errors path="fullname" cssClass="error" /></span>
				</div>
				
				<div class="mt-3">
					<label class="form-label">Photo</label>
					<form:input type="file" class="form-control" path="photo" />
					<span><form:errors path="photo" cssClass="error" /></span>
				</div>
				
				
				<div class="mt-3">
					<label class="form-label">Active</label>
					<form:select class="form-select" path="activated" items="${listSelect}"/>
				</div>
				
				<div class="mt-3">
					<label class="form-label">Admin</label>
					<form:select class="form-select" path="admin" items="${listSelect}"/>
				</div>
				
				<div class="mt-3">
					<button type="submit" class="btn btn-primary mb-3">Submit
					</button>
				</div>
			</form:form>
		</div>
	</div>
</div>