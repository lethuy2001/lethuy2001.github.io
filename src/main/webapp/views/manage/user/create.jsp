<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>

<div class="container mt-5">
	<c:if test="${ !empty sessionScope.successUser }">
		<p class="alert alert-success">${sessionScope.successUser}</p>
		<c:remove var="successUser" scope="session" />
	</c:if>
	
	<c:if test="${ !empty sessionScope.successUserEdit }">
		<p class="alert alert-success">${sessionScope.successUserEdit}</p>
		<c:remove var="successUserEdit" scope="session" />
	</c:if>
	
	<c:if test="${ !empty sessionScope.errorUser }">
		<p class="alert alert-danger">${sessionScope.errorUser}</p>
		<c:remove var="errorUser" scope="session" />
	</c:if>
	
	<form action="/PH13751_LeMinhThuy_Assignment//users/create"
		method="post" class="row mt-3">
		<div class="col-4 mt-4">
			<label for="">Họ và tên:</label> <input type="text"
				class="form-control" name="fullName">
			<c:if test="${ !empty sessionScope.ValidateFullName }">
				<p class="text-danger">${sessionScope.ValidateFullName}</p>
				<c:remove var="ValidateFullName" scope="session" />
			</c:if>
		</div>

		<div class="col-4 mt-4">
			<label for="">Địa chỉ:</label> <input type="text"
				class="form-control" name="address">
			<c:if test="${ !empty sessionScope.ValidateAddress }">
				<p class="text-danger">${sessionScope.ValidateAddress}</p>
				<c:remove var="ValidateAddress" scope="session" />
			</c:if>
		</div>

		<div class="col-4 mt-4">
			<label for="">Email:</label> <input type="email" class="form-control"
				name="email">
			<c:if test="${ !empty sessionScope.ValidateEmail }">
				<p class="text-danger">${sessionScope.ValidateEmail}</p>
				<c:remove var="ValidateEmail" scope="session" />
			</c:if>
		</div>

		<div class="col-4 mt-4">
			<label for="">Password:</label> <input type="text"
				class="form-control" name="password">
			<c:if test="${ !empty sessionScope.ValidatePassword }">
				<p class="text-danger">${sessionScope.ValidatePassword}</p>
				<c:remove var="ValidatePassword" scope="session" />
			</c:if>
		</div>

		<div class="col-4 mt-4">
			<label for="">Số điện thoại:</label> <input type="text"
				class="form-control" name="phoneNumber">
			<c:if test="${ !empty sessionScope.ValidatePhoneNumber }">
				<p class="text-danger">${sessionScope.ValidatePhoneNumber}</p>
				<c:remove var="ValidatePhoneNumber" scope="session" />
			</c:if>
		</div>

		<div class="col-4 mt-4"></div>

		<div class="col-4 mt-4">
			<label for="" class="me-2">Giới tính:</label> <input type="radio"
				name="gender" checked="checked" value="1"> Nam <input
				type="radio" name="gender" value="2"> Nữ
		</div>

		<div class="col-4 mt-4">
			<label for="">Quyền:</label> <input type="radio" name="role"
				checked="checked" value="1"> Admin <input type="radio"
				name="role" value="2"> User
		</div>

		<div class="col-12 mt-5">
			<button class="btn btn-primary">Thêm mới</button>
			<button type="reset" class="btn btn-info">Làm mới</button>
		</div>
	</form>

	<div class="row mt-5">
		<jsp:include page="/views/manage/user/userTable.jsp"></jsp:include>
	</div>
</div>