package com.burakyildiz.springboothomework4.dto;

import lombok.Data;

import javax.persistence.Column;
import java.time.LocalDateTime;

@Data
public class UserDto {
    private Long id;
    private String username;
    private String password;
    private String name;
    private LocalDateTime createTime;
}
