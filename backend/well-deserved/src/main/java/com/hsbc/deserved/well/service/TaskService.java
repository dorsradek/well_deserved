package com.hsbc.deserved.well.service;

import com.hsbc.deserved.well.model.kid.Kid;
import com.hsbc.deserved.well.model.task.Task;
import com.hsbc.deserved.well.model.task.TaskStatus;
import com.hsbc.deserved.well.repository.KidRepository;
import com.hsbc.deserved.well.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by rdors on 2016-06-25.
 */
@Service
public class TaskService implements ITaskService {

    private TaskRepository taskRepository;
    private KidRepository kidRepository;

    @Autowired
    public TaskService(KidRepository kidRepository, TaskRepository taskRepository) {
        this.kidRepository = kidRepository;
        this.taskRepository = taskRepository;
    }

    @Override
    public List<Task> findAll() {
        return taskRepository.findAll().stream().filter(t -> !t.getTaskStatus().equals(TaskStatus.VERIFIED)).collect(Collectors.toList());
    }

    @Override
    public Task create(Task task) {
        task.setTaskStatusEnum(TaskStatus.TODO);
        return taskRepository.save(task);
    }

    @Override
    public Task verify(Task task) {
        Task taskDb = taskRepository.findOne(task.getId());
        taskDb.setTaskStatusEnum(TaskStatus.VERIFIED);

        Kid kid = kidRepository.findAll().get(0);

        long tasksMandatoryAndNotFinised = taskRepository.findAll().stream()
                .filter(t -> !t.getTaskStatus().equals(TaskStatus.VERIFIED.toString()) && t.getPoints().intValue() == 0)
                .count();

        if (tasksMandatoryAndNotFinised == 0) {
            kid.setPoints(kid.getPoints() + kid.getWaitingPoints() + taskDb.getPoints());
            kid.setWaitingPoints(0);
        } else {
            kid.setWaitingPoints(kid.getWaitingPoints() + taskDb.getPoints());
        }

        kidRepository.save(kid);

        return taskRepository.save(taskDb);
    }

    @Override
    public Task done(Task task) {
        Task dbTask = taskRepository.findOne(task.getId());
        dbTask.setTaskStatusEnum(TaskStatus.DONE);
        return taskRepository.save(dbTask);
    }


    private void addPoints(Task task) {
    }

}
