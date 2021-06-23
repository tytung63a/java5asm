<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>JSP Page</title>

</head>
<body>
	<br>
	<div class="d-flex justify-content-center">
		<div class="container">
			<h2>List Products</h2>
			<div class="rows">
				<div class="col-sm-9">
					<table class="table table-bordered">
						<thead>
							<tr>
								<th>ID</th>
								<th>Tên Hàng</th>
								<th>Giá</th>
								<th>Số Lượng</th>
								<th>Tổng Tiền</th>
								<th>Hành Động</th>
							</tr>
						</thead>
						<tbody>

							<c:forEach var="item" items="${list}">
								<form action="/shoppingcart/update" method="get">
									<input type="hidden" name="id" value="${item.producID}" />
									<tr>
										<td>${item.producID }</td>
										<td>${item.name }</td>
										<td>${item.price}</td>
										<td><input name="qty" value="${item.qty}"
											onblur="this.form.submit()" style="width: 50px;"></td>
										<td>${item.price*item.qty}</td>
										<td><a class="btn btn-primary btn-sm"
											href="/shoppingcart/delete/${item.producID }"
											onclick="return confirm('Are you sure you want to Remove?');">
												Xóa</a></td>
									</tr>
								</form>
							</c:forEach>


						</tbody>
					</table>
					<p>Tổng Tiền : ${amount} VNĐ</p>
					<hr />
					<a class="btn btn-primary btn-sm" href="/shoppingcart/clear"
						onclick="return confirm('Are you sure you want to Remove?');">
						Xóa Tất Cả</a> <a class="btn btn-primary btn-sm" href="/homepage">Mua
						Thêm</a>
				</div>
			</div>
		</div>
	</div>
	<br>
	<br>
</body>
</html>