package com.burakyildiz.springboothomework4.dto.user;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class UserDto {
    private Long id;
    private String name;
    private String username;
    private String password;
    private LocalDateTime createTime;
}
