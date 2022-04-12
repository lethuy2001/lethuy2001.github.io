<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
	
<div class="container mt-5">
	<c:if test="${ !empty sessionScope.successCategory}">
		<p class="alert alert-success">${sessionScope.successCategory}</p>
		<c:remove var="successCategory" scope="session" />
	</c:if>
	
	<c:if test="${ !empty sessionScope.successCategoryEdit}">
		<p class="alert alert-success">${sessionScope.successCategoryEdit}</p>
		<c:remove var="successCategoryEdit" scope="session" />
	</c:if>

	<c:if test="${ !empty sessionScope.errorCategory}">
		<p class="alert alert-danger">${sessionScope.errorCategory}</p>
		<c:remove var="errorCategory" scope="session" />
	</c:if>


	<form
		action="/PH13751_LeMinhThuy_Assignment/categories/create?id=${sessionScope.user.id}"
		method="post" class="row">

		<div class="col-2 mt-5"></div>
		<div class="col-4 mt-5">
			<label>Tên danh mục:</label> <input type="text" class="form-control"
				name="name">
			<c:if test="${ !empty sessionScope.ValidateCategoryName}">
				<p class="text-danger">${sessionScope.ValidateCategoryName}</p>
				<c:remove var="ValidateCategoryName" scope="session" />
			</c:if>

			<button class="btn btn-primary mt-3">Thêm mới</button>
		</div>

		<div class="col-4 mt-5">
			<jsp:include page="/views/manage/category/categoryTable.jsp"></jsp:include>
		</div>
		<div class="col-2 mt-5"></div>
	</form>
</div>