package com.burakyildiz.springboothomework4.service;

import com.burakyildiz.springboothomework4.model.DebtCollection;

import java.util.List;

public interface IDebtCollectionService {
    DebtCollection save(DebtCollection debtCollection);

    DebtCollection findById(Long id);

    List<DebtCollection> findAll();
}
