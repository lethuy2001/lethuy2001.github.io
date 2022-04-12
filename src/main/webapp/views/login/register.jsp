<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<div class="container bg-light shadow bg-body rounded">
    <form class="row mt-5" action="" method="get">
        <div class="col-12 mt-5 text-center">
             <h1>ĐĂNG KÍ</h1>
        </div>
        
        <div class="col-12 mt-3">
             <label>Họ và tên:</label>
             <input type="text" name="fullName" class="form-control" required="required">
        </div>
        
        <div class="col-12 mt-3">
             <label>Giới tính:</label>
             <input type="radio" name="gender" value="1" checked="checked"> Nam
             <input type="radio" name="gender" class="me-2" value="2"> Nữ
        </div>
        
        <div class="col-12 mt-3">
             <label>Địa chỉ:</label>
             <input type="text" name="address" class="form-control" required="required">
        </div>
        
        <div class="col-12 mt-3">
             <label>Email:</label>
             <input type="email" name="email" class="form-control">
        </div>
        
        <div class="col-12 mt-3">
             <label>Số điện thoại:</label>
             <input type="text" name="phoneNumber" class="form-control">
        </div>
        
        <div class="col-6 mt-4">
             <button class="btn btn-primary form-control">Đăng kí</button>
        </div>
        
        <div class="col-6 mt-4">
             <button type="reset" class="btn btn-info form-control">Làm mới</button>
        </div>
    </form>
    
    <div class="row mt-4 pb-4">
         <div class="col d-flex flex-row-reverse">
               <a href="/PH13751_LeMinhThuy_Assignment/Login/showLogin" class="text-decoration-none text-dark">Đăng nhập</a>
         </div>
    </div>
</div>