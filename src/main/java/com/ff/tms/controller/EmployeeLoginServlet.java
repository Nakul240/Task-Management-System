package com.ff.tms.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ff.tms.dao.EmployeeDAO;
import com.ff.tms.entity.Employee;

@WebServlet("/login")
public class EmployeeLoginServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String email = req.getParameter("email");
		String password = req.getParameter("password");

		EmployeeDAO dao = new EmployeeDAO();
		Employee employee = dao.getEmployeeByEmailAndPassword(email, password);
		if (employee != null ) {
			String role = employee.getRole();
			if(role.equals("manager")) {
				resp.sendRedirect("manager.jsp");
			}
			else {
				HttpSession session = req.getSession();
				session.setAttribute("currentEmployee", employee);
				resp.sendRedirect("employee");
			}
		} else {
			String msg = "Oops! email or password wrong , Please check again";
			req.setAttribute("message", msg);
			RequestDispatcher dispatcher = req.getRequestDispatcher("display.jsp");
			dispatcher.include(req, resp);
		}

	}
}
