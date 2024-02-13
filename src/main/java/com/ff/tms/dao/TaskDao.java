package com.ff.tms.dao;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import com.ff.tms.entity.Task;
import com.ff.tms.helper.HibernateConnectionFactory;

public class TaskDao {

	private static EntityManagerFactory factory = HibernateConnectionFactory.getFactory();
	private static EntityManager manager = factory.createEntityManager();
	private static EntityTransaction transaction = manager.getTransaction();

	public Task saveTask(Task task) {

		transaction.begin();
		manager.persist(task);
		transaction.commit();
		return task;
	}
	
	public Task findTask(int id) {
		Task task = manager.find(Task.class, id);
		return task;
	}

	public List<Task> getAllList() {

		String qlString = "Select t from Task t";
		Query query = manager.createQuery(qlString);
		List<Task> tasks = query.getResultList();

		return tasks;
	}
	
	public Task updateTaskStatus(Task task) {
		task.setStatus("completed");
		LocalDateTime now = LocalDateTime.now();
		task.setCompletedDateTime(now);
		transaction.begin();
		manager.merge(task);
		transaction.commit();
		
		return task;
	}
}
