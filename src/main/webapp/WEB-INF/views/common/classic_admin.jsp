<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>

<!DOCTYPE html>
<html lang="en">
	<head>
	<meta charset="utf-8">
	<title><tiles:insertAttribute name="title" /></title>
									
									<script
										src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"></script>
									<script
										src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>
									<!-- Font Awesome -->
									<link
										href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.1/css/all.min.css"
										rel="stylesheet" />
									<!-- Google Fonts -->
									<link
										href="https://fonts.googleapis.com/css?family=Roboto:300,400,500,700&display=swap"
										rel="stylesheet" />
									<!-- MDB -->
									<link
										href="https://cdnjs.cloudflare.com/ajax/libs/mdb-ui-kit/3.3.0/mdb.min.css"
										rel="stylesheet" />
									<!-- MDB -->
									<script type="text/javascript"
										src="https://cdnjs.cloudflare.com/ajax/libs/mdb-ui-kit/3.3.0/mdb.min.js"></script>
	</head>
	<body>
		<div class="row">
			<tiles:insertAttribute name="menu" />
		</div>
		
		<div class="row">
				<tiles:insertAttribute name="body" />
		</div>
		
		<div>
			<tiles:insertAttribute name="footer" />
		</div>
	</body>

</html>