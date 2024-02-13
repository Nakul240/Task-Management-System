package com.ff.tms.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import com.ff.tms.entity.Employee;
import com.ff.tms.entity.Task;
import com.ff.tms.helper.HibernateConnectionFactory;

public class EmployeeDAO {
	private static EntityManagerFactory factory = HibernateConnectionFactory.getFactory();
	private static EntityManager manager = factory.createEntityManager();
	private static EntityTransaction transaction = manager.getTransaction();

	public Employee saveEmployeeInfo(Employee employee) {

		transaction.begin();
		manager.persist(employee);
		transaction.commit();

		return employee;
	}

	public Employee getEmployeeByEmailAndPassword(String email, String password) {
		String qlString = "Select e from Employee e where email = ?1 AND password = ?2";
		Query query = manager.createQuery(qlString);
		query.setParameter(1, email);
		query.setParameter(2, password);
		List resultList = query.getResultList();
		Employee employee = null;
		if (resultList != null && !(resultList.isEmpty())) {
			employee = (Employee) resultList.get(0);
		}

		return employee;

	}

	public List<Employee> getAllEmployees() {

		String qlString = "Select e from Employee e";
		Query query = manager.createQuery(qlString);
		List employees = query.getResultList();
		return employees;
	}
	
	public Employee findEmployee(int id) {
		Employee employee = manager.find(Employee.class, id);
		return employee;
	}
	
	public List<Task> getAllTaskOfEmployee(Employee employee){
		
		String query = "Select t from Task t where t.employee = ?1";
		
		Query q = manager.createQuery(query);
		q.setParameter(1, employee);
		
		List<Task> resultList = q.getResultList();
		
		return resultList;
	}

}
