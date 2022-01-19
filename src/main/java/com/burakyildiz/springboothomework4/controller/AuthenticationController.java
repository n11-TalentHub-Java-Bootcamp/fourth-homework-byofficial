package com.burakyildiz.springboothomework4.controller;

import com.burakyildiz.springboothomework4.dto.user.CreateUserDto;
import com.burakyildiz.springboothomework4.dto.user.LoginDto;
import com.burakyildiz.springboothomework4.mapper.AuthenticationMapper;
import com.burakyildiz.springboothomework4.model.User;
import com.burakyildiz.springboothomework4.service.IAuthenticationService;
import com.burakyildiz.springboothomework4.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/auth")//pre-path
public class AuthenticationController {
    @Autowired
    private IAuthenticationService authenticationService;

    @Autowired
    private IUserService userService;

    //1.a Kullanıcı kaydeden servis yazın
    @PostMapping("sign-up") //api/auth/sign-up
    public ResponseEntity<?> signUp(@RequestBody CreateUserDto userDto) {
        User user = AuthenticationMapper.INSTANCE.convertCreateUserDtoToUser(userDto);

        if (userService.findByUsername(user.getUsername()).isPresent()) {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
        return new ResponseEntity<>(
                userService.saveUser(user),
                HttpStatus.CREATED);
    }

    //Kullanıcı girişi
    @PostMapping("sign-in")//api/auth/sign-in
    public ResponseEntity<?> signIn(@RequestBody LoginDto loginDto) {
        User user = AuthenticationMapper.INSTANCE.convertLoginDtoToUser(loginDto);
        return new ResponseEntity<>(authenticationService.signInAndReturnJWT(user), HttpStatus.OK);
    }
}
