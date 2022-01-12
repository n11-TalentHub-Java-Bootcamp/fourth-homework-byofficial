package com.burakyildiz.springboothomework4.service;

import com.burakyildiz.springboothomework4.model.User;

public interface IAuthenticationService
{
    String signInAndReturnJWT(User signInRequest);
}
