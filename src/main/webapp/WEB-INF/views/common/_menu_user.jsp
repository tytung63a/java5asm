<nav class="navbar navbar-expand-lg navbar-light bg-light">
	<div class="container px-4 px-lg-5">
		<a class="navbar-brand" href="#!">Start Bootstrap</a>
		<button class="navbar-toggler" type="button" data-bs-toggle="collapse"
			data-bs-target="#navbarSupportedContent"
			aria-controls="navbarSupportedContent" aria-expanded="false"
			aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="navbarSupportedContent">
			<ul class="navbar-nav me-auto mb-2 mb-lg-0 ms-lg-4">
				<li class="nav-item"><a class="nav-link active"
					aria-current="page" href="/homepage">Home</a></li>
				<li class="nav-item"><a class="nav-link active"
					aria-current="page" href="/homepage">All Products</a></li>
			</ul>
			<form class="d-flex">
				<a class="btn btn-outline-dark" href="/shoppingcart/view">
					<i class="bi-cart-fill me-1"></i> Cart <span
						class="badge bg-dark text-white ms-1 rounded-pill">${count}</span>
				</a>
			</form>
		</div>
	</div>


	<form action="${pageContext.request.contextPath}/homepage/find"
		class="d-flex">
		<input name="name" class="form-control mr-sm-2" type="text"
			placeholder="Search">
			&ensp;
		<button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
	</form>

</nav>




