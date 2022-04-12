<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="fmt" %>   

<div>
    <table class="table table-hover">
         <tr>
             <th>STT</th>
             <th>Tên sản phẩm</th>
             <th>Giá</th>
             <th>Số lượng</th>
             <th>Màu sắc</th>
             <th>Kích thước</th>
             <th>Thời gian tạo</th>
             <th>Thời gian cập nhập</th>
             <th>Ảnh</th>
             <th colspan="2" >Thao tác</th>
         </tr>
         
         <c:forEach var="product" items="${listProduct}" varStatus="loop">
             <tr class="align-middle">
                 <td>${loop.index + 1}</td>
                 <td>${product.name}</td>
                 <td>${product.price}</td>
                 <td>${product.quantity}</td>
                 <td>${product.color.name}</td>
                 <td>${product.size.name}</td>
                 <td> <fmt:formatDate value="${product.createAt}"  pattern="dd-MM-yyyy"/> </td>
                 <td> <fmt:formatDate value="${product.updateAt}"  pattern="dd-MM-yyyy"/> </td>
                 <td> <img alt="" src="/PH13751_LeMinhThuy_Assignment/images/${product.image}" style="width: 50px;" >  </td>
                 <td> <a href="/PH13751_LeMinhThuy_Assignment/products/edit?id=${product.id}" class="btn btn-warning">Cập nhập</a> </td>
                 <td><button class="btn btn-danger" data-bs-toggle="modal"
						data-bs-target="#exampleModal${product.id}">Xóa</button></td>
             </tr>
             
             <!-- Modal -->
			<div class="modal fade" id="exampleModal${product.id}" tabindex="-1"
				aria-labelledby="exampleModalLabel" aria-hidden="true">
				<div class="modal-dialog">
					<div class="modal-content">
						<div class="modal-header">
							<h5 class="modal-title" id="exampleModalLabel">Bạn có muốn
								xóa người dùng không?</h5>
							<button type="button" class="btn-close" data-bs-dismiss="modal"
								aria-label="Close"></button>
						</div>
						<div class="modal-footer">
							<a class="btn btn-primary"
								href="/PH13751_LeMinhThuy_Assignment/products/delete?id=${product.id}">
								Có</a>
							<button type="button" class="btn btn-secondary"
								data-bs-dismiss="modal">Không</button>
						</div>
					</div>
				</div>
			</div>
         </c:forEach>
    </table>
</div>
    