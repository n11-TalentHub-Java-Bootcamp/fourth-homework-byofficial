package com.burakyildiz.springboothomework4.service;

import com.burakyildiz.springboothomework4.model.User;

import java.util.List;
import java.util.Optional;

public interface IUserService {
    User saveUser(User user);

    User updateUser(User user);

    void delete(User user);

    void deleteById(Long id);

    User findById(Long id);

    Optional<User> findByUsername(String username);

    List<User> findAllUsers();
}

