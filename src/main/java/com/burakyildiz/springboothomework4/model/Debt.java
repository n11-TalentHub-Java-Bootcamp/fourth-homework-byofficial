package com.burakyildiz.springboothomework4.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "debt")
public class Debt {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "main_debt", precision = 19, scale = 2)
    private BigDecimal mainDebt;

    @Column(name = "total_debt", precision = 19, scale = 2)
    private BigDecimal totalDebt;

    @Column(name = "debt_status")
    private DebtType status;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userId", foreignKey = @ForeignKey(name = "FK_DEBT_USER_ID"))
    private User userId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "toptDebtId", foreignKey = @ForeignKey(name = "FK_TOP_DEBT_TOP_ID"))
    private Debt topDebtId;


    @Column(name = "expiry_time")
    private LocalDateTime expiryDate;

    @Column(name = "created_time")
    private LocalDateTime createdDate;

}
