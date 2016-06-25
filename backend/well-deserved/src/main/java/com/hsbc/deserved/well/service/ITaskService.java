package com.hsbc.deserved.well.service;

import com.hsbc.deserved.well.model.task.Task;

import java.util.List;

/**
 * Created by rdors on 2016-06-25.
 */
public interface ITaskService {
    List<Task> findAll();

    Task create(Task task);

    Task verify(Task task);

    Task done(Task task);
}
