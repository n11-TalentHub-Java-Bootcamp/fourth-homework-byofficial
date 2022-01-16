package com.burakyildiz.springboothomework4.dto.dept;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class DebtListDto {
    private BigDecimal mainDept;
    private BigDecimal totalDept;
    private LocalDateTime expiryDate;
    private String username;
    private String name;

}
