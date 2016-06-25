package com.hsbc.deserved.well.service;

import com.hsbc.deserved.well.model.kid.Kid;

import java.util.List;

/**
 * Created by rdors on 2016-06-25.
 */
public interface IKidService {

    Kid create(Kid kid);

    List<Kid> findAll();
}
