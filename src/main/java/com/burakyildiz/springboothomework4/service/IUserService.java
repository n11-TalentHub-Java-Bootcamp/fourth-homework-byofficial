package com.burakyildiz.springboothomework4.service;

import com.burakyildiz.springboothomework4.model.User;

import java.util.List;
import java.util.Optional;

public interface IUserService
{
    User saveUser(User user);

    Optional<User> findBUsername(String username);

    List<User> findAllUsers();
}

