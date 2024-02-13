package com.ff.tms.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ff.tms.dao.TaskDao;
import com.ff.tms.entity.Task;
import com.ff.tms.service.SortTaskList;

@WebServlet(value = "/viewtask")
public class ViewTaskServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		TaskDao dao = new TaskDao();
		List<Task> tasks = dao.getAllList();
		List<Task> sortedTasks = SortTaskList.sortTasksBasedOnStatus(tasks);
		req.setAttribute("tasks", sortedTasks);
		RequestDispatcher dispatcher = req.getRequestDispatcher("viewTasks.jsp");
		dispatcher.forward(req, resp);
	}
}
