package com.hsbc.deserved.well.service;

import com.hsbc.deserved.well.model.kid.Kid;
import com.hsbc.deserved.well.model.task.Task;
import com.hsbc.deserved.well.model.wish.Wish;
import com.hsbc.deserved.well.repository.KidRepository;
import com.hsbc.deserved.well.repository.TaskRepository;
import com.hsbc.deserved.well.repository.WishRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by rdors on 2016-06-25.
 */
@Service
public class KidService implements IKidService {

    private KidRepository kidRepository;
    private TaskRepository taskRepository;
    private WishRepository wishRepository;

    @Autowired
    public KidService(KidRepository kidRepository, TaskRepository taskRepository, WishRepository wishRepository) {
        this.kidRepository = kidRepository;
        this.taskRepository = taskRepository;
        this.wishRepository = wishRepository;
    }

    @Override
    public List<Kid> findAll() {
        return kidRepository.findAll();
    }


    @Override
    public Kid create(Kid kid) {
        return kidRepository.save(kid);
    }

}
