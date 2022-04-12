<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<div class="container bg-light shadow bg-body rounded">
	<form action="/PH13751_LeMinhThuy_Assignment/LoginServlet" method="post"
		class="row mt-5">
		<div class="col-12 mt-5 text-center">
		     <h1>ĐĂNG NHẬP</h1>
		</div>
		
		<div class="col-12 mt-3">
			<label>Tài khoản:</label> <input type="email" name="email" required="required"
				class="form-control">
		</div>

		<div class="col-12 mt-3">
			<label>Mật khẩu:</label> <input type="password" name="password" required="required"
				class="form-control">
		</div>

        <div class="col-5 mt-4 ">
			<input type="checkbox" value="true"> Nhớ mật khẩu 
		</div>
		
		<div class="col-4 mt-4" >
			<button class="form-control btn btn-primary" > Đăng nhập</button>
		</div>
		
		<div class="col-3 mt-4">
			<button type="reset" class="form-control btn btn-info" >Làm mới</button>
		</div>
	</form>
	
	
	<div class="row mt-4 pb-5">
	     <div class="col-12 d-flex flex-row-reverse">
	           <a class="text-decoration-none text-dark" href="/PH13751_LeMinhThuy_Assignment/Login/showRegister">Đăng ký ?</a>
	     </div>
	</div>
</div>