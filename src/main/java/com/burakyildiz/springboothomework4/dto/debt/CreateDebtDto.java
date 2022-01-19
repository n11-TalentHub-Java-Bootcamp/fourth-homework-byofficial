package com.burakyildiz.springboothomework4.dto.debt;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class CreateDebtDto {
    private BigDecimal mainDebt;
    private Long userId;
    private LocalDateTime expiryDate;
}
