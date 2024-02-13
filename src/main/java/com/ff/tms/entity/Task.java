package com.ff.tms.entity;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

import org.hibernate.annotations.CreationTimestamp;

@Entity
public class Task {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "task_id")
	@SequenceGenerator(name = "task_id", allocationSize = 10, initialValue = 11)
	private int id;
	private String description;
	private String status;
	@CreationTimestamp
	private LocalDateTime createdDateTime;
	private LocalDateTime completedDateTime;

	@ManyToOne
	@JoinColumn(name = "employee_id")
	private Employee employee;

	public int getId() {
		return id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public LocalDateTime getCreatedDateTime() {
		return createdDateTime;
	}

	public LocalDateTime getCompletedDateTime() {
		return completedDateTime;
	}

	public void setCompletedDateTime(LocalDateTime completedDateTime) {
		this.completedDateTime = completedDateTime;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	@Override
	public String toString() {
		return "\nTask [id=" + id + ", description=" + description + ", status=" + status + ", createdDateTime="
				+ createdDateTime + ", completedDateTime=" + completedDateTime + ", employee=" + employee + "]";
	}
	
	

}
