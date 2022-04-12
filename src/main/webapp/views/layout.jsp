<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Color shop</title>
<link rel="stylesheet"
	href="/PH13751_LeMinhThuy_Assignment/css/bootstrap.min.css" />
<link rel="stylesheet"
	href="/PH13751_LeMinhThuy_Assignment/fontawesome/fontawesome/css/all.min.css">
</head>
<body>
	<div class="container-fluid">
		<div class="row"
			style="position: fixed; z-index: 1; top: 0; right: 0; left: 0">
			<div class="col bg-light">
				<div class="container">
					<div class="row p-3">
						<div class="col-3">
							<span class="fs-3 fw-bolder">COLOR<span
								class="text-danger">SHOP</span>
							</span>
						</div>
						<div class="col-7 d-flex flex-row-reverse">
							<nav class="navbar navbar-expand-lg navbar-light">
								<div class="container-fluid">
									<button class="navbar-toggler" type="button"
										data-bs-toggle="collapse" data-bs-target="#navbarNavDropdown"
										aria-controls="navbarNavDropdown" aria-expanded="false"
										aria-label="Toggle navigation">
										<span class="navbar-toggler-icon"></span>
									</button>
									<div class="collapse navbar-collapse" id="navbarNavDropdown">
										<ul class="navbar-nav">
											<li class="nav-item"><a class="nav-link ms-3"
												aria-current="page"
												href="/PH13751_LeMinhThuy_Assignment/Homes/index"> <i
													class="fas fa-home"></i> Trang chủ
											</a></li>
											<li class="nav-item"><a class="nav-link ms-3" href="#">Sản
													phẩm</a></li>
											<li class="nav-item"><a class="nav-link ms-3" href="#">Giới
													thiệu</a></li>
											<li class="nav-item"><a class="nav-link ms-3" href="#">Liên
													hệ</a></li>

											<li class="nav-item dropdown ms-4"><a
												class="nav-link dropdown-toggle" href="#"
												id="navbarScrollingDropdown" role="button"
												data-bs-toggle="dropdown" aria-expanded="false">
													${sessionScope.user.fullName} </a>
												<ul class="dropdown-menu"
													aria-labelledby="navbarScrollingDropdown">
													<c:if test="${ sessionScope.user.role == 1 }">
														<li><a class="dropdown-item"
															href="/PH13751_LeMinhThuy_Assignment/users/index">Quản
																lý người dùng</a></li>
														<li><a class="dropdown-item"
															href="/PH13751_LeMinhThuy_Assignment/categories/index">Quản
																lý danh mục</a></li>
														<li><a class="dropdown-item"
															href="/PH13751_LeMinhThuy_Assignment/products/index">Quản
																lý sản phẩm</a></li>
													</c:if>
													<li><a class="dropdown-item"
														href="/PH13751_LeMinhThuy_Assignment/Homes/logout">Đăng
															xuất</a></li>
												</ul></li>
										</ul>
									</div>
								</div>
							</nav>
						</div>

						<div class="col-2 text-center p-3 fs-5 ">
							<span class=""> <a class="text-dark" href="#"
								style="text-decoration: none;"> <i class="fas fa-search"></i>
							</a>
							</span> <span class="ms-3"> <a href="#" class="text-dark"
								style="text-decoration: none;" data-bs-toggle="offcanvas"
								data-bs-target="#offcanvasRight" aria-controls="offcanvasRight">
									<i class="fas fa-shopping-cart"></i>
							</a>
							</span>
						</div>

					</div>
				</div>
			</div>
		</div>

		<div class="row p-5">
			<jsp:include page="${view}"></jsp:include>
		</div>

		<div class="row mt-5">
			<div class="col bg-light">
				<div class="container">
					<div class="row ">
						<div class="col-6 p-3">
							<div class="fs-4">Newsletter</div>
							<div>Subscribe to our newsletter and get 20% off your first
								purchase</div>
						</div>
						<form action="" class="col-6 p-3">
							<div class="input-group d-flex flex-row-reverse">
								<button class="input-group-text bg-primary" id="basic-addon2">SUBCRISE</button>
								<input type="text" class="border-0 p-3" required="required"
									placeholder="Email" aria-label="Recipient's username"
									aria-describedby="basic-addon2" style="width: 300px">
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>

		<div class="row mt-5 mb-5">
			<div class="col">
				<div class="container">
					<div class="row">
						<div class="col-6">
							<span class="me-4">Blog</span> <span class="me-4">FAQs</span> <span>Contact
								us</span>
						</div>
						<div class="col-6 d-flex flex-row-reverse">
							<span> <a href="#" class="text-dark text-decoration-none ">
									<i class="fab fa-pinterest"></i>
							</a>
							</span> <span> <a href="#"
								class="text-dark text-decoration-none me-3"><i
									class="fab fa-skype"></i></a>
							</span> <span> <a href="#"
								class="text-dark text-decoration-none me-3"><i
									class="fab fa-instagram"></i></a>
							</span> <span> <a href="#"
								class="text-dark text-decoration-none me-3"><i
									class="fab fa-twitter"></i></a>
							</span> <span> <a href="#"
								class="text-dark text-decoration-none me-3"><i
									class="fab fa-facebook-f"></i></a>
							</span>
						</div>
					</div>
				</div>
			</div>
			<div class="offcanvas offcanvas-end" tabindex="-1"
				id="offcanvasRight" aria-labelledby="offcanvasRightLabel">
				<div class="offcanvas-header mt-4">
					<h5 id="offcanvasRightLabel" class="fs-3">Giỏ hàng</h5>
					<button type="button" class="btn-close text-reset"
						data-bs-dismiss="offcanvas" aria-label="Close"></button>
				</div>
				<div class="offcanvas-body">
				      <div class="container">
				           <div class="row">
							<c:forEach var="cart" items="${listCarts}">
							    <img class="img-fluid col-4 bg-light" alt="" src="/PH13751_LeMinhThuy_Assignment/images/${cart.product.image}">
							    <div class="col-8">
							         <div>${cart.product.name}</div>
							         <div class="mt-1">${cart.quantity}</div>
							         <div class="mt-1 text-danger">$${cart.price }</div>
							    </div>
							</c:forEach>
						</div>
				      </div>
				</div>
				
				<div class="mb-5 ms-3">
				      <a href="#" class="btn btn-primary">Xem giỏ hàng</a>
				</div>
			</div>
		</div>
	</div>




	<script src="/PH13751_LeMinhThuy_Assignment/js/jquery.min.js"></script>
	<script src="/PH13751_LeMinhThuy_Assignment/js/popper.min.js"></script>
	<script src="/PH13751_LeMinhThuy_Assignment/js/bootstrap.min.js"></script>
	<script src="/PH13751_LeMinhThuy_Assignment/js/mainJS.js"></script>
</body>
</html>