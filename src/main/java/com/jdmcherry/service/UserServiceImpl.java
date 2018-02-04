package com.jdmcherry.service;

import com.google.common.collect.Lists;
import com.jdmcherry.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserServiceImpl {

    @Autowired
    private UserService userService;

    public List<User> findAll() {
        return Lists.newArrayList(userService.findAll());
    }

    public User findById(int id) {
        return userService.findOne(id);
    }

}
