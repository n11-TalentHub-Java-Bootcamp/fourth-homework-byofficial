package com.burakyildiz.springboothomework4.controller;

import com.burakyildiz.springboothomework4.model.User;
import com.burakyildiz.springboothomework4.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/user")
public class UserController {

    @Autowired
    private IUserService userService;

    @GetMapping("")
    public List<User> findAll() {
        List<User> userList = userService.findAllUsers();

        return userList;
    }

    @GetMapping("{id}")
    public User findByUserId(@PathVariable Long id) {
        User user = userService.findById(id);

        return user;
    }


    @DeleteMapping("{id}")
    public void deleteUser(@PathVariable Long id) {
        ResponseEntity<String> result = null;
        User user = userService.findById(id);
        userService.deleteById(id);

    }

    @PutMapping("")
    public ResponseEntity<?> updateUser(@RequestBody User user) {
        ResponseEntity<String> result = null;

        if (userService.findByUsername(user.getUsername()).isPresent()) {
            userService.updateUser(user);
            result = new ResponseEntity<String>("Kullanıcı bilgileri güncellendi!", HttpStatus.OK);
        }
        return result;
    }


}
