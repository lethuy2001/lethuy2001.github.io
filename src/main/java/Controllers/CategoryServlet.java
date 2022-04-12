package Controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.beanutils.BeanUtils;

import com.sun.xml.bind.v2.runtime.output.IndentingUTF8XmlOutput;

import Dao.CategoryDaolmpl;
import Dao.UserDaoImpl;
import Entities.Category;
import Entities.User;
import Untils.CheckFormat;

/**
 * Servlet implementation class CategoryServlet
 */
@WebServlet({ "/categories/index", "/categories/create", "/categories/edit", "/categories/delete",
		"/categories/update", })
public class CategoryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	CategoryDaolmpl categoryDaolmpl;
	UserDaoImpl userDaoImpl;

	public CategoryServlet() {
		super();
		categoryDaolmpl = new CategoryDaolmpl();
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
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		String uri = request.getRequestURI();

		if (uri.contains("create")) {
			this.create(request, response);
		} else if (uri.contains("update")) {
			this.update(request, response);
		}

	}

	private void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			int id = Integer.parseInt(request.getParameter("id"));
			this.categoryDaolmpl.delete(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		response.sendRedirect("/PH13751_LeMinhThuy_Assignment/categories/index");
	}

	private void index(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Category> listCategories = this.categoryDaolmpl.findAll();

		request.setAttribute("listCategory", listCategories);
		request.setAttribute("view", "/views/manage/category/create.jsp");
		request.getRequestDispatcher("/views/layout.jsp").forward(request, response);
	}

	private void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		Category category = this.categoryDaolmpl.findById(id);
		List<Category> listCategories = this.categoryDaolmpl.findAll();

		request.setAttribute("listCategory", listCategories);
		request.setAttribute("category", category);
		request.setAttribute("view", "/views/manage/category/edit.jsp");
		request.getRequestDispatcher("/views/layout.jsp").forward(request, response);
	}

	private void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		int checkMessage = 0;
		int id = Integer.parseInt(request.getParameter("id"));
		Category Oldcategory = this.categoryDaolmpl.findById(id);
		Category category = new Category();
		
		try {
			BeanUtils.populate(category, request.getParameterMap());
			category.setUser(Oldcategory.getUser());
			if (CheckFormat.checkEmpty(category.getName())) {
				checkMessage = 1;
				session.setAttribute("ValidateCategoryName", "Hãy điền tên danh mục");
			}

			if (checkMessage == 0) {
				this.categoryDaolmpl.update(category);
				session.setAttribute("successCategoryEdit", "Cập nhập thành công");
				response.sendRedirect("/PH13751_LeMinhThuy_Assignment/categories/index");
			} else {
				session.setAttribute("errorCategoryEdit", "Cập nhập thất bại");
				response.sendRedirect("/PH13751_LeMinhThuy_Assignment/categories/edit?id=" + category.getId());
			}

		} catch (Exception e) {
			session.setAttribute("errorCategoryEdit", "Cập nhập thất bại");
			e.printStackTrace();
			response.sendRedirect("/PH13751_LeMinhThuy_Assignment/categories/edit?id=" + category.getId());
		}
	}

	private void create(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		int checkMessage = 0;
		try {
			int id = Integer.parseInt(request.getParameter("id"));
			User user = this.userDaoImpl.findById(id);
			Category category = new Category();
			category.setName( request.getParameter("name") );
			category.setUser(user);
			category.setStatus(0);

			if (CheckFormat.checkEmpty(category.getName())) {
				checkMessage = 1;
				session.setAttribute("ValidateCategoryName", "Hãy điền tên danh mục");
			}

			if (checkMessage == 0) {
				this.categoryDaolmpl.create(category);
				session.setAttribute("successCategory", "Thêm mới thành công");
			} else {
				session.setAttribute("errorCategory", "Thêm mới thất bại");
			}

		} catch (Exception e) {
			e.printStackTrace();
			session.setAttribute("errorCategory", "Thêm mới thất bại");
		}
		response.sendRedirect("/PH13751_LeMinhThuy_Assignment/categories/index");
	}
}
