package com.burakyildiz.springboothomework4.controller;

import com.burakyildiz.springboothomework4.dto.user.UserDto;
import com.burakyildiz.springboothomework4.mapper.UserMapper;
import com.burakyildiz.springboothomework4.model.User;
import com.burakyildiz.springboothomework4.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/users")
public class UserController {

    @Autowired
    private IUserService userService;

    //Sistemdeki tüm kullanıcıları listeler
    @GetMapping("")
    public ResponseEntity<?> findAll() {
        List<User> userList = userService.findAllUsers();
        List<UserDto> userDtoList = UserMapper.INSTANCE.convertAllListUserToUserDto(userList);

        return new ResponseEntity<>(
                userDtoList,
                HttpStatus.OK);
    }

    //Belirli {id} değerine sahip kullanıcının bilgisini verir
    @GetMapping("{id}")
    public ResponseEntity<?> findByUserId(@PathVariable Long id) {
        User user = userService.findById(id);

        UserDto userDto = UserMapper.INSTANCE.convertUserToUserDto(user);
        return new ResponseEntity<>(
                userDto,
                HttpStatus.OK);
    }

    //Belirtilen id değerine sahip kullanıcı silinir.
    @DeleteMapping("{id}")
    public ResponseEntity<?> deleteUser(@PathVariable Long id) {
        User user = userService.findById(id);
        userService.deleteById(id);
        return new ResponseEntity<>(
                HttpStatus.NO_CONTENT
        );
    }


/*

    //Kullanıcı bilgilerini günceller
    @PutMapping("")
    public ResponseEntity<?> updateUser(@RequestBody UpdateUserDto updateUserDto) {
        ResponseEntity<?> result = null;

        User user = UserMapper.INSTANCE.convertUpdateUserDtoToUser(updateUserDto);
        if (userService.findByUsername(user.getUsername()).isPresent()) {
            userService.updateUser(user);
            result = new ResponseEntity<>(user, HttpStatus.OK);
        }
        return result;
    }
*/


}
