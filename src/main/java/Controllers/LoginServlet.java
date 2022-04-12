package Controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Dao.UserDaoImpl;
import Entities.User;
import Untils.EncryptUntil;


@WebServlet({"/Login/showLogin" ,"/Login/showRegister" , "/LoginServlet" , "/RegisterServlet"} )
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    UserDaoImpl userDaoImpl ;

    public LoginServlet() {
        super();
        userDaoImpl = new UserDaoImpl();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    String uri = request.getRequestURI() ;
	    
	    if( uri.contains("showLogin") ) {
	    	this.showLogin( request ,response ) ;
	    }else if( uri.contains("showRegister")) {
	    	this.showRegister( request , response );
	    }
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uri = request.getRequestURI() ;
		
		if( uri.contains("LoginServlet")) {
			this.login( request , response );
		} else if ( uri.contains("RegisterServlet")) {
			
		}
		
	}
	
	public void login( HttpServletRequest request , HttpServletResponse response ) throws ServletException, IOException {
		HttpSession session = request.getSession() ;
		String emailString = request.getParameter("email") ;
		String passwordString = request.getParameter("password");
		User user = this.userDaoImpl.findByEmail( emailString ) ;
		boolean check = EncryptUntil.check( passwordString , user.getPassword() );
		if( check == true ) {
			session.setAttribute("success", "Đăng nhập thành công" );
			session.setAttribute( "user", user);
			response.sendRedirect("/PH13751_LeMinhThuy_Assignment/Homes/index");
		}else {
			session.setAttribute("error", "Đăng nhập thất bại" );
			response.sendRedirect("/PH13751_LeMinhThuy_Assignment/Login/showLogin");
		}
	}

	public void showLogin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute( "loginLayout", "/views/login/loginUser.jsp");
		request.getRequestDispatcher("/views/LayoutLogin.jsp").forward(request, response) ;
	}
	
	public void showRegister(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute( "loginLayout", "/views/login/register.jsp");
		request.getRequestDispatcher("/views/LayoutLogin.jsp").forward(request, response) ;
	}
}
