package com.hsbc.deserved.well.service;

import com.hsbc.deserved.well.model.kid.Kid;
import com.hsbc.deserved.well.model.wish.Wish;
import com.hsbc.deserved.well.model.wish.WishStatus;
import com.hsbc.deserved.well.repository.KidRepository;
import com.hsbc.deserved.well.repository.WishRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by rdors on 2016-06-25.
 */
@Service
public class WishService implements IWishService {

    private WishRepository wishRepository;
    private KidRepository kidRepository;

    @Autowired
    public WishService(WishRepository wishRepository, KidRepository kidRepository) {
        this.wishRepository = wishRepository;
        this.kidRepository = kidRepository;
    }

    @Override
    public List<Wish> findAll() {
        return wishRepository.findAll();
    }

    @Override
    public void create(Wish wish) {
        wish.setWishStatusEnum(WishStatus.ADDED);
        wishRepository.save(wish);
    }

    @Override
    public void addPoints(Wish wish) {
        Wish wishDb = wishRepository.findOne(wish.getId());
        wishDb.setPoints(wish.getPoints());
        wishDb.setWishStatusEnum(WishStatus.PRICED);
        wishRepository.save(wishDb);
    }

    @Override
    public void request(Wish wish) {
        Wish wishDb = wishRepository.findOne(wish.getId());
        Kid kidDb = kidRepository.findAll().get(0);
        if (kidDb.getPoints() >= wishDb.getPoints()) {
            wishDb.setWishStatusEnum(WishStatus.WAITING_TO_BUY);
            wishRepository.save(wishDb);

            kidDb.setPoints(kidDb.getPoints() - wishDb.getPoints());
            kidRepository.save(kidDb);
        }
    }

    @Override
    public void buy(Wish wish) {
        Wish wishDb = wishRepository.findOne(wish.getId());
        wishDb.setWishStatusEnum(WishStatus.BOUGHT);
        wishRepository.save(wishDb);
    }
}
