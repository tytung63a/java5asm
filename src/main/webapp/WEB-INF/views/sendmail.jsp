<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="sendmail" method="post">
		Message : ${message} <br><br>
		Email nhan : <input name="emailnhan"> <br><br>
		Tieu de : <input name="tieude"> <br><br>
		Noi Dung : <input name="noidung"> <br><br>
		<button type="submit"> Send </button> <br><br>
	</form>
</body>
</html>