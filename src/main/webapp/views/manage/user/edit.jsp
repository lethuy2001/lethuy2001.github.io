<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<div class="container mt-5">
	<c:if test="${ !empty sessionScope.errorUserEdit }">
		<p class="alert alert-danger">${sessionScope.errorUserEdit}</p>
		<c:remove var="errorUserEdit" scope="session" />
	</c:if>
	
	
    <form action="/PH13751_LeMinhThuy_Assignment/users/update?id=${user.id}" method="post" class="row mt-3">
        <div class="col-4 mt-4">
             <label for="">Họ và tên:</label>
             <input type="text" class="form-control" name="fullName"  value="${user.fullName}">
             <c:if test="${ !empty sessionScope.ValidateFullName }">
				<p class="text-danger">${sessionScope.ValidateFullName}</p>
				<c:remove var="ValidateFullName" scope="session" />
			</c:if> 
        </div>
        
        <div class="col-4 mt-4">
             <label for="">Địa chỉ:</label>
             <input type="text" class="form-control" name="address"  value="${user.address}"> 
             <c:if test="${ !empty sessionScope.ValidateAddress }">
				<p class="text-danger">${sessionScope.ValidateAddress}</p>
				<c:remove var="ValidateAddress" scope="session" />
			</c:if>
        </div>
        
        <div class="col-4 mt-4">
             <label for="">Email:</label>
             <input type="email" class="form-control" name="email"  value="${user.email}"> 
             <c:if test="${ !empty sessionScope.ValidateEmail }">
				<p class="text-danger">${sessionScope.ValidateEmail}</p>
				<c:remove var="ValidateEmail" scope="session" />
			</c:if>
        </div>
        
        
        <div class="col-4 mt-4">
             <label for="">Số điện thoại:</label>
             <input type="text" class="form-control" name="phoneNumber" value="${user.phoneNumber}"> 
             <c:if test="${ !empty sessionScope.ValidatePhoneNumber }">
				<p class="text-danger">${sessionScope.ValidatePhoneNumber}</p>
				<c:remove var="ValidatePhoneNumber" scope="session" />
			</c:if>
        </div>
        <div class="col-4 mt-4">
             
        </div>
        <div class="col-4 mt-4">
        
        </div>
        
        <div class="col-4 mt-4">
             <label for="" class="me-2">Giới tính:</label>
             <input type="radio" name="gender" ${user.gender == 1 ? 'checked' : '' }  value="1" > Nam
             <input type="radio" name="gender" ${user.gender == 2 ? 'checked' : '' }  value="2"> Nữ
        </div>
        
        <div class="col-4 mt-4">
             <label for="">Quyền:</label>
             <input type="radio" name="role" ${user.role == 1 ? 'checked' : '' }  value="1"> Admin
             <input type="radio" name="role" ${user.role == 2 ? 'checked' : '' } value="2"> User
        </div>
        
        <div class="col-12 mt-5">
             <button class="btn btn-warning"> Cập nhập</button>
             <button type="reset" class="btn btn-info">Làm mới</button>
        </div>
    </form>
    
    <div class="row mt-5">
        <jsp:include page="/views/manage/user/userTable.jsp"></jsp:include>
    </div>
</div>