package Controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.tomcat.util.http.fileupload.InvalidFileNameException;

import com.sun.xml.bind.v2.model.core.ID;

import Dao.CartDaolmpl;
import Dao.CategoryDaolmpl;
import Dao.ColorDaolmpl;
import Dao.ProductDaolmpl;
import Dao.SizeDaolmpl;
import Dao.UserDaoImpl;
import Entities.Cart;
import Entities.Category;
import Entities.Color;
import Entities.Product;
import Entities.Size;
import Entities.User;

/**
 * Servlet implementation class HomeServlet
 */

@WebServlet({ "/Homes/index", "/Homes/logout", "/Homes/showProduct" , "/Homes/card" , "/Homes/showDetailProduct" , "/Homes/AddCart"} )
public class HomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	UserDaoImpl userDaoImpl;
	ProductDaolmpl productDaolmpl;
	CategoryDaolmpl categoryDaolmpl;
	CartDaolmpl cartDaolmpl ;

	public HomeServlet() {
		super();
		userDaoImpl = new UserDaoImpl();
		productDaolmpl = new ProductDaolmpl();
		categoryDaolmpl = new CategoryDaolmpl();
		cartDaolmpl = new CartDaolmpl() ;
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String uri = request.getRequestURI();

		if (uri.contains("index")) {
			this.index(request, response);
		} else if (uri.contains("logout")) {
			this.logout(request, response);
		} else if (uri.contains("showProduct")) {
			this.showProduct(request, response);
		} else if ( uri.contains("showDetailProduct")) {
			this.showDetailProduct(request, response);
		} else if ( uri.contains("AddCart") ) {
			this.AddCart(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}
	
	private void AddCart(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession() ;
	
		
		int id = Integer.parseInt( request.getParameter("id") );
		Cart cart = new Cart();
		Product product = this.productDaolmpl.findById(id);
		User user = (User) session.getAttribute("user");
		int quantity = Integer.parseInt( request.getParameter("quantityPro") );
		
		cart.setQuantity(quantity);
		cart.setProduct(product);
		cart.setUser(user);
		cart.setPrice( product.getPrice() );
		
		
		try {
			this.cartDaolmpl.create(cart);
		} catch (Exception e) {
		}
		response.sendRedirect("/PH13751_LeMinhThuy_Assignment/Homes/index");
	}
	
	private void showDetailProduct(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	    int id  = Integer.parseInt(request.getParameter("id")) ;
		Product product = this.productDaolmpl.findById(id) ;
		
		request.setAttribute( "detailProduct", product);
		request.setAttribute("view", "/views/main/detailProduct.jsp");
		request.getRequestDispatcher("/views/layout.jsp").forward(request, response);
	}

	private void showProduct(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		List<Product> listProducts = this.productDaolmpl.findMany(id);
		List<Category> lisCategories = this.categoryDaolmpl.findAll();
		
		request.setAttribute("listCategory", lisCategories);
		request.setAttribute("listProduct", listProducts);
		request.setAttribute("view", "/views/main/home.jsp");
		request.getRequestDispatcher("/views/layout.jsp").forward(request, response);
	}

	private void logout(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		User user = new User();
		request.setAttribute("user", user);
		response.sendRedirect("/PH13751_LeMinhThuy_Assignment/Login/showLogin");
	}

	private void index(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		
		User user = (User) session.getAttribute("user") ;
		
		List<Product> listProduct = this.productDaolmpl.findAll();
		List<Category> lisCategories = this.categoryDaolmpl.findAll();
		List<Cart> listCarts = this.cartDaolmpl.findAll( user.getId() );

		request.setAttribute("listCarts", listCarts);
		request.setAttribute("listCategory", lisCategories);
		request.setAttribute("listProduct", listProduct);
		request.setAttribute("view", "/views/main/home.jsp");
		request.getRequestDispatcher("/views/layout.jsp").forward(request, response);
	}
}
