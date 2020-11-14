package controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.user;
import model.usermodel;

/**
 * Servlet implementation class userservlet
 */
public class userservlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		
		usermodel umodel1=new usermodel();
		user user1=new user();
		user1.setUsername(username);
		user1.setPassword(password);
		user existUser = null;
		try {
			existUser = umodel1.login(user1);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(existUser == null)
		{
			request.setAttribute("msg", "”√ëÙ√˚ªÚ√‹¥aÂe’`");
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
		else {
			
			request.getSession().setAttribute("existUser", existUser);
			response.sendRedirect(request.getContextPath()+"/success.jsp");
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
