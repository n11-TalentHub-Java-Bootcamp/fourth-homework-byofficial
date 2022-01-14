package com.burakyildiz.springboothomework4.repository;

import com.burakyildiz.springboothomework4.model.Debt;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IDebtRepository extends JpaRepository<Debt,Long> {
    @Query("select debt from Debt debt where debt.userId.id = :id and debt.totalDept > 0")
    List<Debt> findAllByUserId(Long id);
}
