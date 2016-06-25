package com.hsbc.deserved.well.controller;

import com.hsbc.deserved.well.model.kid.Kid;
import com.hsbc.deserved.well.service.IKidService;
import com.hsbc.deserved.well.service.ITaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by rdors on 2016-06-25.
 */
@RestController
@RequestMapping("/kids")
@CrossOrigin(origins = "*")
public class KidController {

    private ITaskService taskService;
    private IKidService kidService;

    @Autowired
    public KidController(ITaskService taskService, IKidService kidService) {
        this.taskService = taskService;
        this.kidService = kidService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<Kid> getKids() {
        return kidService.findAll();
    }

    @RequestMapping(path="/kid", method = RequestMethod.GET)
    public Kid getKid() {
        return kidService.findAll().get(0);
    }

    @RequestMapping(path = "/create", method = RequestMethod.POST)
    public Kid create(@RequestBody Kid kid) {
        return kidService.create(kid);
    }

    @RequestMapping(path = "/points", method = RequestMethod.GET)
    public Integer getPoints() {
        return kidService.findAll().get(0).getPoints();
    }


}
