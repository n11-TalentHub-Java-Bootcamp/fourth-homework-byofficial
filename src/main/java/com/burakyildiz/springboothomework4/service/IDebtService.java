package com.burakyildiz.springboothomework4.service;

import com.burakyildiz.springboothomework4.model.Debt;
import com.burakyildiz.springboothomework4.model.User;

import java.util.List;

public interface IDebtService {
    List<Debt> findAll();

    Debt saveDebt(Debt debt);

    void deleteById(Long id);

    Debt findById(Long id);
}
