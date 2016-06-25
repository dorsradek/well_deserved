package com.hsbc.deserved.well.service;

import com.hsbc.deserved.well.model.wish.Wish;

import java.util.List;

/**
 * Created by rdors on 2016-06-25.
 */
public interface IWishService {

    List<Wish> findAll();

    void create(Wish wish);

    void addPoints(Wish wish);

    void request(Wish wish);

    void buy(Wish wish);
}
