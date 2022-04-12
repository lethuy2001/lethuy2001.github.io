<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>

<div class="row">
	<div class="col p-0">
		<div class="card text-dark ">
			<img src="/PH13751_LeMinhThuy_Assignment/images/slider_1.jpg"
				class="card-img" alt="...">
			<div class="card-img-overlay">
				<div class="container">
					<div class="row mt-5">
						<div class="col-6 mt-5">
							<div class="card-text fs-5">SPRING / SUMMER COLLECTION 2017</div>
							<div class="card-text fw-bolder" style="font-size: 65px">Get
								up to 30% Off</div>
							<div class="card-text fw-bolder" style="font-size: 65px">New
								Arrivals</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>

<div class="row mt-5">
	<div class="col-12">
		<div class="container">
			<div class="row text-center">
				<div class="col-12  fw-bold fs-1">
					<div>FROM THE BLOG</div>
				</div>
				<div class="col-12">
					<span class="placeholder placeholder-xs bg-danger"
						style="width: 7%;"></span>
				</div>
			</div>
		</div>
	</div>
	<div class="col-12 mt-4">
		<ul class="list-group list-group-horizontal justify-content-center">
			<a href="/PH13751_LeMinhThuy_Assignment/Homes/index" class="list-group-item ">Tất cả</a>
			<c:forEach var="category" items="${listCategory}">
			    <a href="/PH13751_LeMinhThuy_Assignment/Homes/showProduct?id=${category.id}" class="list-group-item ">${category.name}</a>
			</c:forEach>
		</ul>
	</div>
</div>

<div class="row">
	<div class="col">
		<div class="container">
			<div class="row mt-5">
				<c:forEach var="product" items="${listProduct}">
					<div class="col-3 mb-3">
						<div class="card text-center" style="width: 18rem;">
							<img src="/PH13751_LeMinhThuy_Assignment/images/${product.image}"
								class="card-img-top" alt="...">
							<div class="card-body">
								<h5 class="card-text mt-2">${product.name}</h5>
								<p class="card-text mt-2 text-danger fw-bold">$${product.price}</p>

							</div>
							<div class="card-footer text-muted p-0">
								<a href="/PH13751_LeMinhThuy_Assignment/Homes/showDetailProduct?id=${product.id}" class="btn btn-primary form-control">Thêm vào
									giỏ hàng</a>
							</div>
						</div>
					</div>
				</c:forEach>

			</div>
		</div>
	</div>

</div>


<div class="row mt-5 ">
	<div class="col">
		<div class="container">
			<div class="row bg-light p-3">
				<div class="col-3 d-flex">
					<div class="fs-2 me-3 text-danger">
						<i class="fas fa-truck"></i>
					</div>
					<div>
						<div class="fw-bold">FREE SHIPPING</div>
						<div>Suffered Alteration in Some Form</div>
					</div>
				</div>

				<div class="col-3 d-flex">
					<div class="fs-2 me-3 text-danger">
						<i class="far fa-money-bill-alt"></i>
					</div>
					<div>
						<div class="fw-bold">CACH ON DELIVERY</div>
						<div>The Internet Tend To Repeat</div>
					</div>
				</div>

				<div class="col-3 d-flex">
					<div class="fs-2 me-3 text-danger">
						<i class="fas fa-undo-alt"></i>
					</div>
					<div>
						<div class="fw-bold">45 DAYS RETURN</div>
						<div>Making it Look Like Readable</div>
					</div>
				</div>

				<div class="col-3 d-flex">
					<div class="fs-2 me-3 text-danger">
						<i class="far fa-clock"></i>
					</div>
					<div>
						<div class="fw-bold">OPENING ALL WEEK</div>
						<div>8AM - 09PM</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>

<div class="row mt-5">
	<div class="col">
		<div class="container">
			<div class="row text-center">
				<div class="col-12  fw-bold fs-1">
					<div>FROM THE BLOG</div>
				</div>
				<div class="col-12">
					<span class="placeholder placeholder-xs bg-success"
						style="width: 7%;"></span>
				</div>
			</div>
			<div class="row mt-5">
				<div class="card col-4 border-0">
					<img src="/PH13751_LeMinhThuy_Assignment/images/blog_1.jpg"
						class="card-img-top" alt="...">
					<div class="card-body p-0 mt-3 ">
						<div class="fs-5 opacity-50">
							<i class="far fa-calendar-alt"></i> May 4,2019 <span class="ms-3">
								<i class="far fa-comment"></i> 4
							</span>
						</div>
						<div class="mt-2">
							<a class="fw-bold fs-4 text-decoration-none text-dark" href="#">Here
								are the trends I see coming this fall</a>
						</div>
					</div>
				</div>

				<div class="card col-4 border-0">
					<img src="/PH13751_LeMinhThuy_Assignment/images/blog_2.jpg"
						class="card-img-top" alt="...">
					<div class="card-body p-0 mt-3 ">
						<div class="fs-5 opacity-50">
							<i class="far fa-calendar-alt"></i> May 4,2019 <span class="ms-3">
								<i class="far fa-comment"></i> 4
							</span>
						</div>
						<div class="mt-2">
							<a class="fw-bold fs-4 text-decoration-none text-dark" href="#">Here
								are the trends I see coming this fall</a>
						</div>
					</div>
				</div>

				<div class="card col-4 border-0">
					<img src="/PH13751_LeMinhThuy_Assignment/images/blog_3.jpg"
						class="card-img-top" alt="...">
					<div class="card-body p-0 mt-3 ">
						<div class="fs-5 opacity-50">
							<i class="far fa-calendar-alt"></i> May 4,2019 <span class="ms-3">
								<i class="far fa-comment"></i> 4
							</span>
						</div>
						<div class="mt-2">
							<a class="fw-bold fs-4 text-decoration-none text-dark" href="#">Here
								are the trends I see coming this fall</a>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>
