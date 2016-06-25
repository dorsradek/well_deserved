package com.hsbc.deserved.well;

import com.hsbc.deserved.well.model.kid.Kid;
import com.hsbc.deserved.well.model.task.Task;
import com.hsbc.deserved.well.model.task.TaskStatus;
import com.hsbc.deserved.well.model.wish.Wish;
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

        Kid kid = new Kid("Antek", 0);
        this.kidService.create(kid);

        Task task = new Task("lekcje", TaskStatus.TODO, 4, true);
        this.taskService.create(task);
        task = new Task("sprzątanie", TaskStatus.DONE, 2, false);
        this.taskService.create(task);
        task = new Task("obiad", TaskStatus.VERIFIED, 6,false);
        this.taskService.create(task);
        task = new Task("coś tam", TaskStatus.TODO, 1,false);
        this.taskService.create(task);

        Wish wish = new Wish("laptop", "just because");
        wishService.create(wish);
        wish = new Wish("smartphone", "just because");
        wishService.create(wish);
        wish = new Wish("laptop", "just because");
        wishService.create(wish);

    }
}