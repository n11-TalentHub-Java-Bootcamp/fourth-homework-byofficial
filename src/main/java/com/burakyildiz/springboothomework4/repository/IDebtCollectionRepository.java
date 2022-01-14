package com.burakyildiz.springboothomework4.repository;

import com.burakyildiz.springboothomework4.model.DebtCollection;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IDebtCollectionRepository extends JpaRepository<DebtCollection, Long> {
}
