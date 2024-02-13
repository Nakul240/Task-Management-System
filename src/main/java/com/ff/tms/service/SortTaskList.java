package com.ff.tms.service;

import java.util.Collections;
import java.util.List;

import com.ff.tms.entity.Task;

public class SortTaskList {

	public static List<Task> sortTasksBasedOnStatus(List<Task> tasks){
		
		Collections.sort(tasks, (task1, task2) -> task1.getStatus().compareTo(task2.getStatus()));
		return tasks;
	}
}
