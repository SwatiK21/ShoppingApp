package com.user;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.database.UserDao;

/**
 * Servlet implementation class UserRegistration
 */
@WebServlet(name = "UserRegister", urlPatterns = { "/user" })
public class UserRegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserRegistrationServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String name = request.getParameter("name");
		String phoneNumber = request.getParameter("phoneNumber");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		
		User user = new User(0,name,email,password,phoneNumber);
		UserDao.register(user);
		response.getWriter().append("Thank you for registering.  <br><br>");
		response.getWriter().append("Here is the info we got : <br><br>");
		
		response.getWriter().append("Name : " + name + "<br>");
		response.getWriter().append("phone no : " + phoneNumber + "<br>");
		response.getWriter().append("email : " + email);
		
		String destination = "login.html";
		 
		RequestDispatcher dispatcher = request.getRequestDispatcher(destination);
		dispatcher.forward(request, response);
		
	}

	
}
