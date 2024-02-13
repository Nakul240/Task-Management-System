package com.ff.tms.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ff.tms.dao.EmployeeDAO;
import com.ff.tms.dao.TaskDao;
import com.ff.tms.entity.Employee;
import com.ff.tms.entity.Task;

@WebServlet("/employee")
public class EmployeeDashboard extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		HttpSession session = req.getSession();
		
		Employee employee = (Employee) session.getAttribute("currentEmployee");	
		
		List<Task> tasks = new EmployeeDAO().getAllTaskOfEmployee(employee);
		
		System.out.println(tasks);
		
		req.setAttribute("taskList", tasks);
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("employee.jsp");
		dispatcher.forward(req, resp);
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		int id = Integer.parseInt(req.getParameter("id"));
		TaskDao dao = new TaskDao();
		Task task = dao.findTask(id);
		dao.updateTaskStatus(task);
		resp.sendRedirect("employee");
	}

}
