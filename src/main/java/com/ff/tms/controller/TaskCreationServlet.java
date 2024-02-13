package com.ff.tms.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ff.tms.dao.EmployeeDAO;
import com.ff.tms.entity.Employee;

@WebServlet(value = "/taskcreation")
public class TaskCreationServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		EmployeeDAO dao = new EmployeeDAO();
		List<Employee> employees = dao.getAllEmployees();
		req.setAttribute("list", employees);
		RequestDispatcher dispatcher = req.getRequestDispatcher("createTask.jsp");
		dispatcher.forward(req, resp);
	
	}
}
