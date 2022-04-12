package Controllers;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Date;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder.In;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.beanutils.BeanUtils;
import com.sun.xml.bind.v2.model.core.ID;

import javax.servlet.http.Part;

import Dao.CategoryDaolmpl;
import Dao.ColorDaolmpl;
import Dao.ProductDaolmpl;
import Dao.SizeDaolmpl;
import Entities.Category;
import Entities.Color;
import Entities.Product;
import Entities.Size;
import Untils.CheckFormat;

/**
 * Servlet implementation class ProductServlet
 */
@MultipartConfig
@WebServlet({ "/products/index" , "/products/create" , "/products/update" , "/products/edit" , "/products/delete"})
public class ProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ProductDaolmpl productDaolmpl ;
	ColorDaolmpl colorDaolmpl ;
	SizeDaolmpl sizeDaolmpl ;
	CategoryDaolmpl categoryDaolmpl ;
       
    public ProductServlet() {
        super();
        this.productDaolmpl = new ProductDaolmpl();
        this.colorDaolmpl = new ColorDaolmpl() ;
        this.sizeDaolmpl = new SizeDaolmpl() ;
        this.categoryDaolmpl = new CategoryDaolmpl() ;
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		String uri = request.getRequestURI() ;
		
		if( uri.contains("index")) {
			this.index(request, response);
		}else if( uri.contains("delete") ) {
			this.delete(request, response);
		} else if( uri.contains("edit")) {
			this.edit( request , response ) ;
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		String uri = request.getRequestURI() ;
		
		if( uri.contains("create")) {
			this.create(request, response);
		}else if( uri.contains("update")) {
			this.update(request, response);
		}
	}
	
	private void index(  HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		List<Product> listProduct = this.productDaolmpl.findAll() ; 
    	List<Color> listColors = this.colorDaolmpl.findAll();
    	List<Size> listSizes = this.sizeDaolmpl.findAll() ;
    	List<Category> listCategory = this.categoryDaolmpl.findAll() ;
    	
    	request.setAttribute( "listCategory", listCategory);
    	request.setAttribute( "listColor", listColors);
    	request.setAttribute( "listSize", listSizes);
    	request.setAttribute( "listProduct", listProduct);
    	request.setAttribute( "view", "/views/manage/product/create.jsp");
    	request.getRequestDispatcher("/views/layout.jsp").forward(request, response) ;
	}
	
	private void update( HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession() ;
		int checkMessage =  0 ;
		Date date = new Date();
		int id = Integer.parseInt(request.getParameter("id"));
		Product oldProduct = this.productDaolmpl.findById(id);
		Product newProduct = new Product();
		try {
			
		    BeanUtils.populate(newProduct, request.getParameterMap() );
			
		    if( CheckFormat.checkEmpty(newProduct.getName()) ) {
				checkMessage = 1 ;  
				session.setAttribute("ValidateProductName", "Hãy điền tên sản phẩm" );
			}
			
			 if (  CheckFormat.checkSoAm( newProduct.getQuantity()) == false) {
				checkMessage = 1 ;  
				session.setAttribute("ValidateProductQuantity", "Số lượng của sản phẩm không thể âm" );
			}
			
			if( CheckFormat.checkSoAm( (int) newProduct.getPrice() )  == false) {
				checkMessage = 1 ;  
				session.setAttribute("ValidateProductPrice", "Giá của sản phẩm không thể âm" );
			}
		    
			if( checkMessage == 0 ) {
				Color color = this.colorDaolmpl.findById(Integer.parseInt(request.getParameter("color_id")));
				Size size = this.sizeDaolmpl.findById(Integer.parseInt(request.getParameter("size_id")));
				Category category = this.categoryDaolmpl
						.findById(Integer.parseInt(request.getParameter("category_id")));

				newProduct.setCreateAt(oldProduct.getCreateAt());
				newProduct.setUpdateAt(date);
				newProduct.setCategory(category);
				newProduct.setImage(oldProduct.getImage());
				newProduct.setColor(color);
				newProduct.setSize(size);
				this.productDaolmpl.update(newProduct);
				session.setAttribute( "successProduct" , "Cập nhập thành công");
				response.sendRedirect("/PH13751_LeMinhThuy_Assignment/products/index") ;
			}else {
				session.setAttribute( "errorProduct" , "Cập nhập thất bại");
				response.sendRedirect("/PH13751_LeMinhThuy_Assignment/products/edit?id=" + newProduct.getId()) ;
			}

		} catch (Exception e) {
			e.printStackTrace();
			session.setAttribute( "errorProduct" , "Cập nhập thất bại");
			response.sendRedirect("/PH13751_LeMinhThuy_Assignment/products/edit?id=" + newProduct.getId()) ;
		}
		
	}
	
	private void edit( HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id =  Integer.parseInt( request.getParameter("id") ) ;
		Product product = this.productDaolmpl.findById(id) ;
		List<Product> listProduct = this.productDaolmpl.findAll() ; 
    	List<Color> listColors = this.colorDaolmpl.findAll();
    	List<Size> listSizes = this.sizeDaolmpl.findAll() ;
    	List<Category> listCategory = this.categoryDaolmpl.findAll() ;
    	
    	request.setAttribute("product", product);
    	request.setAttribute( "listCategory", listCategory);
    	request.setAttribute( "listColor", listColors);
    	request.setAttribute( "listSize", listSizes);
    	request.setAttribute( "listProduct", listProduct);
    	request.setAttribute( "view", "/views/manage/product/edit.jsp");
    	request.getRequestDispatcher("/views/layout.jsp").forward(request, response) ;
	}
	
	private void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			Integer id = Integer.parseInt( request.getParameter("id"))  ;
			this.productDaolmpl.delete(id);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		response.sendRedirect("/PH13751_LeMinhThuy_Assignment/products/index") ;
	}

	private void create(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession() ;
		int checkMessage = 0 ;
		try {
			Date date = new Date();
			Part partImage = request.getPart("image");
			
			Product product = new Product();
			BeanUtils.populate(product, request.getParameterMap());
			
			System.out.println(product.getPrice() + 1);
			System.out.println(product.getQuantity() );
			
			if( CheckFormat.checkEmpty(product.getName()) ) {
				checkMessage = 1 ;  
				session.setAttribute("ValidateProductName", "Hãy điền tên sản phẩm" );
			}
			
			 if (  CheckFormat.checkSoAm(   product.getQuantity()) == false) {
				checkMessage = 1 ;  
				session.setAttribute("ValidateProductQuantity", "Số lượng của sản phẩm không thể âm" );
			}
			
			if( CheckFormat.checkSoAm( (int) product.getPrice() )  == false) {
				checkMessage = 1 ;  
				session.setAttribute("ValidateProductPrice", "Giá của sản phẩm không thể âm" );
			}
			
			if( checkMessage == 0 ) {
				String realPath = request.getServletContext().getRealPath("/images") ;
				String nameImage = Path.of( partImage.getSubmittedFileName()).getFileName().toString() ;
				
				if( !Files.exists( Path.of(realPath) )) {
					Files.createDirectory( Path.of(realPath) );
				}
				
				partImage.write( realPath + "/" + nameImage) ;
				Color color = this.colorDaolmpl.findById( Integer.parseInt( request.getParameter( "color_id") ) );
				Size size = this.sizeDaolmpl.findById( Integer.parseInt( request.getParameter( "size_id") ) );
				Category category = this.categoryDaolmpl.findById( Integer.parseInt( request.getParameter("category_id" ) ) );
				
				product.setCreateAt(date) ;
				product.setCategory(category);
				product.setImage(nameImage);
				product.setSize(size);
				product.setColor(color) ;
				this.productDaolmpl.create(product);
				session.setAttribute( "successProduct", "Thêm mới thành công");
			}else {
				session.setAttribute( "errorProduct", "Thêm mới thất bại");
			}
		} catch (Exception e) {
			session.setAttribute( "errorProduct", "Thêm mới thất bại");
			e.printStackTrace();
		}
		response.sendRedirect("/PH13751_LeMinhThuy_Assignment/products/index") ;
	}
}
