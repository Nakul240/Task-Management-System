package com.ff.tms.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ff.tms.dao.TaskDao;
import com.ff.tms.entity.Task;

@WebServlet("/taskCompleted")
public class TaskCompleteServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		int id = Integer.parseInt(req.getParameter("id"));
		TaskDao dao = new TaskDao();
		Task task = dao.findTask(id);
		dao.updateTaskStatus(task);
		resp.sendRedirect("employee");
	}
}
