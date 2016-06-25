package com.hsbc.deserved.well;

import com.hsbc.deserved.well.model.kid.Kid;
import com.hsbc.deserved.well.model.task.Task;
import com.hsbc.deserved.well.model.task.TaskStatus;
import com.hsbc.deserved.well.model.wish.Wish;
import com.hsbc.deserved.well.model.wish.WishStatus;
import com.hsbc.deserved.well.service.KidService;
import com.hsbc.deserved.well.service.TaskService;
import com.hsbc.deserved.well.service.WishService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;


@SpringBootApplication
public class WellDeservedApplication {

    public static void main(String[] args) {
        SpringApplication.run(WellDeservedApplication.class, args);
    }
}

@Component
class CLR implements CommandLineRunner {

    private TaskService taskService;
    private KidService kidService;
    private WishService wishService;

    @Autowired
    public CLR(TaskService taskService, KidService kidService, WishService wishService) {
        this.taskService = taskService;
        this.kidService = kidService;
        this.wishService = wishService;
    }

    @Override
    public void run(String... strings) throws Exception {

        Kid kid = new Kid("Antek", 999999, 6);
        this.kidService.create(kid);

        Task task = new Task("do homework", TaskStatus.TODO, 0);
        this.taskService.create(task);
        task = new Task("sprzątanie", TaskStatus.DONE, 6);
        this.taskService.create(task);
        taskService.done(task);
        task = new Task("sprzątanie", TaskStatus.TODO, 8);
        this.taskService.create(task);
        task = new Task("obiad", TaskStatus.VERIFIED, 0);
        this.taskService.create(task);
        taskService.verify(task);
        task = new Task("coś tam", TaskStatus.TODO, 9);
        this.taskService.create(task);

        Wish wish = new Wish("laptop", "just because", 40, WishStatus.PRICED);
        wishService.create(wish);
        wishService.addPoints(wish);
        wish = new Wish("smartphone", "just because", 12, WishStatus.WAITING_TO_BUY);
        wishService.create(wish);
        wishService.addPoints(wish);
        wishService.request(wish);
        wish = new Wish("laptop", "just because", 100, WishStatus.BOUGHT);
        wishService.create(wish);
        wishService.addPoints(wish);
        wishService.request(wish);
        wishService.buy(wish);

        kid.setPoints(30);
        this.kidService.create(kid);

    }
}