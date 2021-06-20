<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Đăng Ký</title>
<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css" />
	<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
	<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<!------ Include the above in your HEAD tag ---------->
<style>
.error {
	color: red;
	}
h5 {
	color : green;
}

</style>
</head>
<body>
	<section class="testimonial py-5" id="testimonial">
	    <div class="container">
	        <div class="row ">
	            <div class="col-md-4 py-5 bg-primary text-white text-center ">
	                <div class=" ">
	                    <div class="card-body">
	                        <img src="http://www.ansonika.com/mavia/img/registration_bg.svg" style="width:30%">
	                        <h2 class="py-3">Registration</h2>
	                        <p>Khong Co Gi De Viet</p>
	                    </div>
	                </div>
	            </div>
	            <div class="col-md-8 py-5 border">
	                <h4 class="pb-4">REGISTER ACCOUNT NEW</h4>
	                <h5>${ message}</h5>
	                <form:form method="post" action="${pageContext.request.contextPath}/register" modelAttribute="registerForm" enctype="multipart/form-data" >
	                
	                    <div class="form-row">
	                        <div class="form-group col-md-6">
	                          <form:input placeholder="User Name" class="form-control" type="text" path="username"/>
	                          <span><form:errors path="username" cssClass="error" /></span>
	                        </div>
	                        <div class="form-group col-md-6">
	                          <form:input type="text" class="form-control" placeholder="Full Name" path="fullname"/>
	                          <span><form:errors path="fullname" cssClass="error" /></span>
	                        </div>
	                    </div>
	                    
	                    <div class="form-row">
	                        <div class="form-group col-md-6">
	                          <form:input placeholder="Email" class="form-control" type="email" path="email"/>
	                          <span><form:errors path="email" cssClass="error" /></span>
	                        </div>
	                        <div class="form-group col-md-6">
	                          <form:input type="password" class="form-control" placeholder="Password" path="password"/>
	                          <span><form:errors path="password" cssClass="error" /></span>
	                        </div>
	                    </div>
	                    
	                    <div class="form-row">
	                        <div class="form-group col-md-6">
	                          <form:input class="form-control" type="file" placeholder="Photo" path="photo"/>
	                        </div>
	                    </div>
	                    
	                    <div class="form-row">
	                        <div class="form-group">
	                            <div class="form-group">
	                                <div class="form-check">
	                                  &ensp;<input class="form-check-input" type="checkbox" value="" id="invalidCheck2" required>
	                                  <label class="form-check-label" for="invalidCheck2">
	                                    <small>By clicking Submit, you agree to our Terms & Conditions, Visitor Agreement and Privacy Policy.</small>
	                                  </label>
	                                </div>
	                              </div>
	                    
	                          </div>
	                    </div>
	                    
	                    <div class="form-row">
	                        &ensp;<button type="submit" class="btn btn-primary">Register</button>
	                        &emsp;&emsp;
	                        <a href="${pageContext.request.contextPath}/login" class="btn btn-success">Login</a>
	                        
	                    </div>
	                    
	                </form:form>
	                
	            </div>
	        </div>
	    </div>
	</section>

</body>
</html>