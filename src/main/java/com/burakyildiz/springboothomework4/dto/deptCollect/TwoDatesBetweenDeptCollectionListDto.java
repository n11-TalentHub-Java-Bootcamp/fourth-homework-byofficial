package com.burakyildiz.springboothomework4.dto.deptCollect;

import com.burakyildiz.springboothomework4.model.DebtType;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class TwoDatesBetweenDeptCollectionListDto {
    private Long id;
    private Long topDebtId;
    private BigDecimal mainDept;
    private BigDecimal totalDept;
    private DebtType status;

    private String username;
    private String name;


    private LocalDateTime expiryDate;
    private LocalDateTime createdDate;
}
