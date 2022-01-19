package com.burakyildiz.springboothomework4.dto.user;

import lombok.Data;

@Data
public class UpdateUserDto {
    private Long id;
    private String name;
    private String username;
    private String password;
}
