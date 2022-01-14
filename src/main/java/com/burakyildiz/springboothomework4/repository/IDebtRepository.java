package com.burakyildiz.springboothomework4.repository;

import com.burakyildiz.springboothomework4.model.Debt;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IDebtRepository extends JpaRepository<Debt,Long> {
}
