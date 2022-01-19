package com.burakyildiz.springboothomework4.dto.debt;

import com.burakyildiz.springboothomework4.model.DebtType;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class DebtListDto {
    private Long id;
    private BigDecimal mainDebt;
    private BigDecimal totalDebt;
    private DebtType status;

    private String username;
    private String name;

    private LocalDateTime expiryDate;
    private LocalDateTime createdDate;

}
