package com.burakyildiz.springboothomework4.dto.dept;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class CreateDebtDto {
    private BigDecimal mainDept;
    private Long userId;
    private LocalDateTime expiryDate;
}
