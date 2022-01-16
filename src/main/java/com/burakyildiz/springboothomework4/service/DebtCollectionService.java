package com.burakyildiz.springboothomework4.service;

import com.burakyildiz.springboothomework4.model.DebtCollection;
import com.burakyildiz.springboothomework4.model.DebtType;
import com.burakyildiz.springboothomework4.model.User;
import com.burakyildiz.springboothomework4.repository.IDebtCollectionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class DebtCollectionService implements IDebtCollectionService{

    @Autowired
    private IDebtCollectionRepository debtCollectionRepository;

    @Override
    public DebtCollection save(DebtCollection debtCollection){
        debtCollection.setCreatedDate(LocalDateTime.now());

        return debtCollectionRepository.save(debtCollection);
    }

    @Override
    public DebtCollection findById(Long id){
        Optional<DebtCollection> optional = debtCollectionRepository.findById(id);

        DebtCollection depDebtCollection = null;
        if (optional.isPresent()) {
            depDebtCollection = optional.get();
        }

        return depDebtCollection;
    }

    @Override
    public List<DebtCollection> findAll(){

        return debtCollectionRepository.findAll();
    }
}
