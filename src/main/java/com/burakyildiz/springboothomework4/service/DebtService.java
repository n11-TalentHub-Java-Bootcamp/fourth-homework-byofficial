package com.burakyildiz.springboothomework4.service;

import com.burakyildiz.springboothomework4.model.Debt;

import com.burakyildiz.springboothomework4.model.DebtType;
import com.burakyildiz.springboothomework4.model.User;
import com.burakyildiz.springboothomework4.repository.IDebtRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class DebtService implements IDebtService {

    @Autowired
    private IDebtRepository debtRepository;

    @Override
    public List<Debt> findAll() {
        return debtRepository.findAll();
    }

    @Override
    public List<Debt> findAllByUserId(Long id) {
        return debtRepository.findAllByUserId(id);
    }


    @Override
    public Debt saveDebt(Debt debt) {
        debt.setTotalDept(debt.getMainDept());
        debt.setStatus(DebtType.NORMAL);
        debt.setCreatedDate(LocalDateTime.now());
        return debtRepository.save(debt);
    }

    @Override
    public void deleteById(Long id) {
        debtRepository.deleteById(id);
    }

    @Override
    public Debt findById(Long id) {

        Optional<Debt> optional = debtRepository.findById(id);

        Debt debt = null;
        if (optional.isPresent()) {
            debt = optional.get();
        }

        return debt;
    }

}
