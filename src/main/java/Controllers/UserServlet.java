package Controllers;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.beanutils.BeanUtils;
import Dao.UserDaoImpl;
import Entities.User;
import Untils.CheckFormat;
import Untils.EncryptUntil;

/**
 * Servlet implementation class UserServlet
 */
@WebServlet({ "/users/index", "/users/create", "/users/edit", "/users/update", "/users/delete", })
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserDaoImpl userDaoImpl;

	public UserServlet() {
		super();
		userDaoImpl = new UserDaoImpl();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		String uri = request.getRequestURI();

		if (uri.contains("index")) {
			this.index(request, response);
		} else if (uri.contains("edit")) {
			this.edit(request, response);
		} else if (uri.contains("delete")) {
			this.delete(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String uri = request.getRequestURI();
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");

		if (uri.contains("create")) {
			this.create(request, response);
		} else if (uri.contains("update")) {
			this.update(request, response);
		}
	}

	private void index(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<User> listUser = this.userDaoImpl.findAll();

		request.setAttribute("listUser", listUser);
		request.setAttribute("view", "/views/manage/user/create.jsp");
		request.getRequestDispatcher("/views/layout.jsp").forward(request, response);
	}

	public void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession() ;
		try {
			int id = Integer.parseInt(request.getParameter("id"));
			this.userDaoImpl.delete(id);
			session.setAttribute("successUser", "Cập nhập thành công");
		} catch (Exception e) {
			e.printStackTrace();
			session.setAttribute("errorUser", "Cập nhập thất bại");
		}
		response.sendRedirect("/PH13751_LeMinhThuy_Assignment/users/index");
	}

	public void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		User user = this.userDaoImpl.findById(Integer.parseInt(request.getParameter("id")));
		List<User> listUser = this.userDaoImpl.findAll();

		request.setAttribute("listUser", listUser);
		request.setAttribute("user", user);
		request.setAttribute("view", "/views/manage/user/edit.jsp");
		request.getRequestDispatcher("/views/layout.jsp").forward(request, response);
	}

	public void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int checkMessage = 0;
		HttpSession session = request.getSession();
		try {
			User userOld = this.userDaoImpl.findById(Integer.parseInt(request.getParameter("id")));
			User user = new User();
			BeanUtils.populate(user, request.getParameterMap());

			if (CheckFormat.checkEmpty(user.getFullName())) {
				checkMessage = 1;
				session.setAttribute("ValidateFullName", "Hãy nhập đầy đủ họ tên");
			}

			if (CheckFormat.checkEmpty(user.getAddress())) {
				checkMessage = 1;
				session.setAttribute("ValidateAddress", "Hãy nhập địa chỉ");
			}

			if (CheckFormat.checkEmpty(user.getEmail())) {
				checkMessage = 1;
				session.setAttribute("ValidateEmail", "Vui lòng không để trống");
			} else if (!CheckFormat.checkEmail(user.getEmail())) {
				checkMessage = 1;
				session.setAttribute("ValidateEmail", "Email sai định dạng");
			}

			if (CheckFormat.checkEmpty(user.getPhoneNumber())) {
				checkMessage = 1;
				session.setAttribute("ValidatePhoneNumber", "Hãy nhâp số điện thoại");
			} else if (!CheckFormat.checkPhoneNumber(user.getPhoneNumber())) {
				checkMessage = 1;
				session.setAttribute("ValidatePhoneNumber", "Số điện thoại sai định dạng");
			}

			if (checkMessage == 0) {
				user.setPassword(userOld.getPassword());
				this.userDaoImpl.update(user);
				session.setAttribute("successUserEdit", "Cập nhập thành công");
				response.sendRedirect("/PH13751_LeMinhThuy_Assignment/users/index");
			} else {
				session.setAttribute("errorUserEdit", "Cập nhập thất bại");
				response.sendRedirect("/PH13751_LeMinhThuy_Assignment/users/edit?id=" + userOld.getId());
			}

		} catch (Exception e) {
			session.setAttribute("errorUserEdit", "Cập nhập thất bại");
			e.printStackTrace();
			response.sendRedirect("/PH13751_LeMinhThuy_Assignment/users/edit");
		}
		
	}

	private void create(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		int checkMessage = 0;
		try {
			User user = new User();
			BeanUtils.populate(user, request.getParameterMap());

			if (CheckFormat.checkEmpty(user.getFullName())) {
				checkMessage = 1;
				session.setAttribute("ValidateFullName", "Hãy nhập đầy đủ họ tên");
			}

			if (CheckFormat.checkEmpty(user.getAddress())) {
				checkMessage = 1;
				session.setAttribute("ValidateAddress", "Hãy nhập địa chỉ");
			}

			if (CheckFormat.checkEmpty(user.getEmail())) {
				checkMessage = 1;
				session.setAttribute("ValidateEmail", "Vui lòng không để trống");
			} else if (!CheckFormat.checkEmail(user.getEmail())) {
				checkMessage = 1;
				session.setAttribute("ValidateEmail", "Email sai định dạng");
			}

			if (CheckFormat.checkEmpty(user.getPassword())) {
				checkMessage = 1;
				session.setAttribute("ValidatePassword", "Hãy nhập mật khẩu");
			}

			if (CheckFormat.checkEmpty(user.getPhoneNumber())) {
				checkMessage = 1;
				session.setAttribute("ValidatePhoneNumber", "Hãy nhâp số điện thoại");
			} else if (!CheckFormat.checkPhoneNumber(user.getPhoneNumber())) {
				checkMessage = 1;
				session.setAttribute("ValidatePhoneNumber", "Số điện thoại sai định dạng");
			}

			if (checkMessage == 0) {
				user.setPassword(EncryptUntil.encry(request.getParameter("password")));
				userDaoImpl.create(user);
				session.setAttribute("successUser", "Thêm mới thành công");
			} else {
				session.setAttribute("errorUser", "Thêm mới thất bại");
			}

		} catch (Exception e) {
			e.printStackTrace();
			session.setAttribute("errorUser", "Thêm mới thất bại");
		}
		response.sendRedirect("/PH13751_LeMinhThuy_Assignment/users/index");
	}

}
