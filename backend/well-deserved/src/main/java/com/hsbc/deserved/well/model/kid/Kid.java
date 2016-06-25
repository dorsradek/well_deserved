package com.hsbc.deserved.well.model.kid;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by rdors on 2016-06-25.
 */
@Entity
public class Kid {

    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private Integer points;
    private Integer waitingPoints;

    Kid() {
    }

    public Kid(String name, Integer points, Integer waitingPoints) {
        this.name = name;
        this.points = points;
        this.waitingPoints = waitingPoints;
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

    public Integer getPoints() {
        return points;
    }

    public void setPoints(Integer points) {
        this.points = points;
    }

    public Integer getWaitingPoints() {
        return waitingPoints;
    }

    public void setWaitingPoints(Integer waitingPoints) {
        this.waitingPoints = waitingPoints;
    }

    @Override
    public String toString() {
        return "Kid{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", points=" + points +
                '}';
    }
}
