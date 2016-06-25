package com.hsbc.deserved.well.model.task;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by rdors on 2016-06-25.
 */
@Entity
public class Task {

    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String taskStatus;
    private Integer points;
    private boolean mandatory;

    Task() {
    }

    public Task(String name, TaskStatus taskStatus, Integer points, boolean mandatory) {
        this.name = name;
        this.taskStatus = taskStatus.getValue();
        this.points = points;
        this.mandatory = mandatory;
    }

    public Task(Long id, String name, TaskStatus taskStatus, Integer points, boolean mandatory) {
        this.id = id;
        this.name = name;
        this.taskStatus = taskStatus.getValue();
        this.points = points;
        this.mandatory = mandatory;
    }

    public Task(Long id, String name, String taskStatus, Integer points, boolean mandatory) {
        this.id = id;
        this.name = name;
        this.taskStatus = taskStatus;
        this.points = points;
        this.mandatory = mandatory;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTaskStatus() {
        return taskStatus;
    }

    public void setTaskStatus(String taskStatus) {
        this.taskStatus = taskStatus;
    }

    public void setTaskStatusEnum(TaskStatus taskStatus) {
        this.taskStatus = taskStatus.getValue();
    }

    public Integer getPoints() {
        return points;
    }

    public void setPoints(Integer points) {
        this.points = points;
    }


    public boolean isMandatory() {
        return mandatory;
    }

    public void setMandatory(boolean mandatory) {
        this.mandatory = mandatory;
    }

    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", taskStatus='" + taskStatus + '\'' +
                ", points=" + points +
                '}';
    }
}
