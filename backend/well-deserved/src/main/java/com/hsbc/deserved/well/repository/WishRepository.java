package com.hsbc.deserved.well.repository;

import com.hsbc.deserved.well.model.wish.Wish;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by rdors on 2016-06-25.
 */
public interface WishRepository extends JpaRepository<Wish, Long> {
}
