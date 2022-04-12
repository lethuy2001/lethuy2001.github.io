<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<div class="col-12 mt-5">

	<div class="container">
		<div class="row g-0">
			<div class="col-2"></div>
			<div class="col-4">
				<img
					src="/PH13751_LeMinhThuy_Assignment/images/${detailProduct.image}"
					class="img-fluid rounded-start" style="width: 500px" alt="...">
			</div>
			<div class="col-4">
				<div class="card-body mt-5">
					<h5 class="card-title fs-1">${detailProduct.name}</h5>
					<p class="card-text fw-bold">${detailProduct.price}</p>
					<p class="card-text">
					<div class="container mt-5">
						<div class="row">
							<button id="nextProduct" onclick="preProduct()" class="ms-3 col-1 border-1 bg-light">-</button>
							<div class="col-2 p-0">
								<input class="form-control" type="text" value="1" id="numberProduct" name="quantityPro">
							</div>
							<button id="prvProduct" class="col-1 border-1" onclick="nextProduct()">+</button>
						</div>
					</div>
					</p>
					<a href="/PH13751_LeMinhThuy_Assignment/Homes/AddCart?id=${detailProduct.id}" class="mt-3 btn btn-primary">Thêm vào giỏ hàng</a>
				</div>
			</div>
		</div>
	</div>

</div>
