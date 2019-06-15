package com.techames.repository;

import org.springframework.data.repository.CrudRepository;

import com.techames.entity.Task;

public interface TaskRepository extends CrudRepository<Task, Long> {

}
