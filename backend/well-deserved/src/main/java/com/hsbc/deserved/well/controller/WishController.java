package com.hsbc.deserved.well.controller;

import com.hsbc.deserved.well.model.wish.Wish;
import com.hsbc.deserved.well.service.IWishService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by rdors on 2016-06-25.
 */
@RestController
@RequestMapping("/wishes")
@CrossOrigin(origins = "*")
public class WishController {

    private IWishService wishService;

    @Autowired
    public WishController(IWishService wishService) {
        this.wishService = wishService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<Wish> getWishes() {
        return wishService.findAll();
    }

    @RequestMapping(path="/create", method = RequestMethod.POST)
    public void create(@RequestBody Wish wish) {
        wishService.create(wish);
    }

    @RequestMapping(path="/addPoints", method = RequestMethod.POST)
    public void addPoints(@RequestBody Wish wish) {
        wishService.addPoints(wish);
    }

    @RequestMapping(path="/request", method = RequestMethod.POST)
    public void request(@RequestBody Wish wish) {
        wishService.request(wish);
    }


    @RequestMapping(path="/buy", method = RequestMethod.POST)
    public void buy(@RequestBody Wish wish) {
        wishService.buy(wish);
    }
}
