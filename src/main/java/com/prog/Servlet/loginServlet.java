package com.prog.Servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.prog.Dao.CustomerDao;
import com.prog.Dao.CustomerImpl;
import com.prog.bean.Customer;

@WebServlet("/loginRegister")
public class loginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public loginServlet()
	{
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CustomerDao cd = new CustomerImpl();
		String userName = request.getParameter("username");
		String password=request.getParameter("password1");
		String submitType=request.getParameter("submit");
		Customer c = new Customer();
		c = cd.getCustomer(userName, password);
		if(submitType.equals("login")&& c!=null && c.getName()!=null)
		{
			request.setAttribute("Message",c.getName());
			request.getRequestDispatcher("welcome.jsp").forward(request, response);
		}else if(submitType.equals("register"))
		{
			c = new Customer();
			c.setUsername(userName);
			c.setName(request.getParameter("name"));
			c.setPassword(password);
			cd.insertCustomer(c);
			request.setAttribute("successMessage","Registration done , Please login to continue");
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
		else
		{
			request.setAttribute("Message","Data not found,Click on Register...!!!");
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
	}

}
