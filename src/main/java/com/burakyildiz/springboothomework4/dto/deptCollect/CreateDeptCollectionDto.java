package com.burakyildiz.springboothomework4.dto.deptCollect;

import com.burakyildiz.springboothomework4.model.Debt;
import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class CreateDeptCollectionDto {

    private BigDecimal amount;
    private Long debtId;

}
