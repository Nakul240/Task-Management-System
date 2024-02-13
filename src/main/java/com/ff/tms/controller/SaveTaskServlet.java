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
import com.ff.tms.dao.TaskDao;
import com.ff.tms.entity.Employee;
import com.ff.tms.entity.Task;

@WebServlet("/savetask")
public class SaveTaskServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String description = req.getParameter("description");
		int employeeId = Integer.parseInt(req.getParameter("getEmployee"));
		String status = req.getParameter("status");

		EmployeeDAO dao = new EmployeeDAO();
		Employee employee = dao.findEmployee(employeeId);
		
		Task task = new Task();
		task.setDescription(description);
		task.setEmployee(employee);
		task.setStatus(status);
		
		TaskDao taskDao = new TaskDao();
		taskDao.saveTask(task);
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("display.jsp");
		req.setAttribute("message", "Task Created Successfully");
		dispatcher.include(req, resp);
	}
}
