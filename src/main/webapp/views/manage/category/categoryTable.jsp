<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>

<div>
	<table class="table table-hover">
		<tr>
			<th>STT</th>
			<th>Tên danh mục</th>
			<th colspan="2">Thao tác</th>
		</tr>

		<c:forEach var="category" items="${listCategory}" varStatus="loop">
			<tr>
				<td>${loop.index + 1}</td>
				<td>${category.name}</td>
				<td><a
					href="/PH13751_LeMinhThuy_Assignment/categories/edit?id=${category.id}"
					class="btn btn-warning">Cập nhật</a></td>
			    <td><button type="button" class="btn btn-danger" data-bs-toggle="modal"
					data-bs-target="#exampleModal${category.id}">Xóa</button></td>  		
				
			</tr>
			<!-- Modal -->
			<div class="modal fade" id="exampleModal${category.id}" tabindex="-1"
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
								href="/PH13751_LeMinhThuy_Assignment/categories/delete?id=${category.id}">
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
