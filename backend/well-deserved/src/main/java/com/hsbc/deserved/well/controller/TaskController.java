package com.hsbc.deserved.well.controller;

import com.hsbc.deserved.well.model.task.Task;
import com.hsbc.deserved.well.service.IKidService;
import com.hsbc.deserved.well.service.ITaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by rdors on 2016-06-25.
 */
@RestController
@RequestMapping("/tasks")
@CrossOrigin(origins = "*")
public class TaskController {

    private ITaskService taskService;
    private IKidService kidService;

    @Autowired
    public TaskController(ITaskService taskService, IKidService kidService) {
        this.taskService = taskService;
        this.kidService = kidService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<Task> getTasks() {
        return taskService.findAll();
    }

    @RequestMapping(path = "/create", method = RequestMethod.POST)
    public Task create(@RequestBody Task task) {
        return taskService.create(task);
    }

    @RequestMapping(path = "/done", method = RequestMethod.POST)
    public Task done(@RequestBody Task task) {
        return taskService.done(task);
    }

    @RequestMapping(path = "/verify", method = RequestMethod.POST)
    public Task verify(@RequestBody Task task) {
        return taskService.verify(task);
    }
}
