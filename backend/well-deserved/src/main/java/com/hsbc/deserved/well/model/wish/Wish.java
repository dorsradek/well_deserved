package com.hsbc.deserved.well.model.wish;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by rdors on 2016-06-25.
 */
@Entity
public class Wish {

    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String description;
    private Integer points;
    private String wishStatus;

    Wish() {
    }

    public Wish(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public Wish(String name, String description, Integer points, String wishStatus) {
        this.name = name;
        this.description = description;
        this.points = points;
        this.wishStatus = wishStatus;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getPoints() {
        return points;
    }

    public void setPoints(Integer points) {
        this.points = points;
    }

    public String getWishStatus() {
        return wishStatus;
    }

    public void setWishStatus(String wishStatus) {
        this.wishStatus = wishStatus;
    }

    public void setWishStatusEnum(WishStatus wishStatus) {
        this.wishStatus = wishStatus.getValue();
    }
}
