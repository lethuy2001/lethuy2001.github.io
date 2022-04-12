<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>

<div class="container mt-5">
	<c:if test="${ !empty sessionScope.errorCategoryEdit}">
		<p class="alert alert-danger">${sessionScope.errorCategoryEdit}</p>
		<c:remove var="errorCategoryEdit" scope="session" />
	</c:if>

	<form
		action="/PH13751_LeMinhThuy_Assignment/categories/update?id=${category.id}"
		method="post" class="row">
		<div class="col-2 mt-4"></div>
		<div class="col-4 mt-4">
			<label>Tên danh mục:</label> <input type="text" class="form-control"
				name="name" value="${category.name}">
			<c:if test="${ !empty sessionScope.ValidateCategoryName}">
				<p class="text-danger">${sessionScope.ValidateCategoryName}</p>
				<c:remove var="ValidateCategoryName" scope="session" />
			</c:if>
			<button class="btn btn-warning mt-3">Cập nhật</button>
		</div>

		<div class="col-4 mt-4">
			<jsp:include page="/views/manage/category/categoryTable.jsp"></jsp:include>
		</div>

	</form>
</div>