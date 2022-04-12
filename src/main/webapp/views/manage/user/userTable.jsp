<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>

<div>
	<table class="table table-hover">
		<tr>
		    <th>STT</th>
			<th>Họ và tên</th>
			<th>Giới tính</th>
			<th>Địa chỉ</th>
			<th>Số điện thoại</th>
			<th>Email</th>
			<th>Admin</th>
			<th colspan="2">Thao Tác</th>
		</tr>

		<c:forEach var="user" items="${listUser}" varStatus="loop">
			<tr>
			    <td>${loop.index + 1}</td>
				<td>${user.fullName}</td>
				<td>${user.gender == 1 ? 'Nam' : 'Nữ'}</td>
				<td>${user.address}</td>
				<td>${user.phoneNumber}</td>
				<td>${user.email}</td>
				<td>${user.role == 1 ? 'Quản lý' : 'Người dùng'}</td>
				<td><a
					href="/PH13751_LeMinhThuy_Assignment/users/edit?id=${user.id}"
					class="btn btn-warning">Cập nhập</a></td>
				<td><button class="btn btn-danger" data-bs-toggle="modal"
						data-bs-target="#exampleModal${user.id}">Xóa</button></td>
			</tr>
			<!-- Modal -->
			<div class="modal fade" id="exampleModal${user.id}" tabindex="-1"
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
								href="/PH13751_LeMinhThuy_Assignment/users/delete?id=${user.id}">
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
