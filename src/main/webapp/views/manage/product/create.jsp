<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>

<div class="container mt-5">
	<c:if test="${ !empty sessionScope.successProduct }">
		<p class="alert alert-success">${sessionScope.successProduct}</p>
		<c:remove var="successProduct" scope="session" />
	</c:if>

	<c:if test="${ !empty sessionScope.errorProduct }">
		<p class="alert alert-danger">${sessionScope.errorProduct}</p>
		<c:remove var="errorProduct" scope="session" />
	</c:if>


	<form action="/PH13751_LeMinhThuy_Assignment/products/create"
		method="post" class="row mt-5" enctype="multipart/form-data">
		<div class="col-4">
			<label>Danh mục</label> <select class="form-select"
				name="category_id">
				<c:forEach var="category" items="${listCategory}">
					<option value="${category.id}">${category.name}</option>
				</c:forEach>
			</select>
		</div>

		<div class="col-4">
			<label>Tên sản phẩm:</label> <input type="text" class="form-control"
				name="name">
			<c:if test="${ !empty sessionScope.ValidateProductName }">
				<p class="text-danger">${sessionScope.ValidateProductName}</p>
				<c:remove var="ValidateProductName" scope="session" />
			</c:if>
		</div>

		<div class="col-4">
			<label>Giá tiền:</label> <input type="text" class="form-control"
				name="price">
			<c:if test="${ !empty sessionScope.ValidateProductQuantity }">
				<p class="text-danger">${sessionScope.ValidateProductQuantity}</p>
				<c:remove var="ValidateProductQuantity" scope="session" />
			</c:if>	
		</div>

		<div class="col-4 mt-3">
			<label>Số lượng:</label> <input type="text" class="form-control"
				name="quantity">
			<c:if test="${ !empty sessionScope.ValidateProductPrice }">
				<p class="text-danger">${sessionScope.ValidateProductPrice}</p>
				<c:remove var="ValidateProductPrice" scope="session" />
			</c:if>	
		</div>

		<div class="col-4 mt-3">
			<label>Ảnh sản phẩm:</label> <input type="file" class="form-control"
				name="image">
		</div>

		<div class="col-4 mt-3">
			<label>Màu sắc:</label> <select class="form-select" name="color_id">
				<c:forEach var="color" items="${listColor}">
					<option value="${color.id}">${color.name}</option>
				</c:forEach>
			</select>
		</div>

		<div class="col-4 mt-3">
			<label>Kích cỡ</label> <select class="form-select" name="size_id">
				<c:forEach var="size" items="${listSize}">
					<option value="${size.id}">${size.name}</option>
				</c:forEach>
			</select>
		</div>

		<div class="col-12 mt-4">
			<button class="btn btn-primary">Thêm mới</button>
		</div>

	</form>

	<div class="row mt-5">
		<jsp:include page="/views/manage/product/productTable.jsp"></jsp:include>
	</div>
</div>