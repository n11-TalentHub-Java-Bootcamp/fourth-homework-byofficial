package com.burakyildiz.springboothomework4.dto.debtCollect;

import com.burakyildiz.springboothomework4.model.DebtType;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class DebtCollectionLateFeeDto {

    private BigDecimal mainDebt;
    private BigDecimal totalDebt;
    private DebtType status;

    private String username;
    private String name;

    private LocalDateTime createdDate;
}
