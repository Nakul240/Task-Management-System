package com.ff.tms.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ff.tms.dao.EmployeeDAO;
import com.ff.tms.entity.Employee;

@WebServlet(value="/register")
public class EmployeeResgisterServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String username = req.getParameter("user_name");
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		String role = req.getParameter("role");
		String designation = req.getParameter("designation");
		double salary = Double.parseDouble(req.getParameter("salary"));

		Employee employee = new Employee();
		employee.setName(username);
		employee.setEmail(email);
		employee.setPassword(password);
		employee.setDesignation(designation);
		employee.setRole(role);
		employee.setSalary(salary);
		EmployeeDAO dao = new EmployeeDAO();
		
		dao.saveEmployeeInfo(employee);
		
		String msg = "Registration Successful";
		req.setAttribute("message", msg);
		RequestDispatcher dispatcher = req.getRequestDispatcher("display.jsp");
		dispatcher.include(req, resp);

		
	}
}
