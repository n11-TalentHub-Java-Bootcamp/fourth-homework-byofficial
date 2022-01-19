package com.burakyildiz.springboothomework4.dto.debtCollect;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class CreateDebtCollectionDto {

    private BigDecimal amount;
    private Long debtId;

}
