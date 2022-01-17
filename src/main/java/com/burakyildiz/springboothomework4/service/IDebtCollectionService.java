package com.burakyildiz.springboothomework4.service;

import com.burakyildiz.springboothomework4.model.DebtCollection;
import com.burakyildiz.springboothomework4.model.DebtType;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

public interface IDebtCollectionService {
    //4.b Belirtilen tarihler arasında yapılan tahsilatlar listelenebilmelidir.
    List<DebtCollection> findAllByCreatedDateBetween(LocalDateTime startDate, LocalDateTime endDate);

    //4.c Kullanıcının tüm tahsilatları listelenebilmelidir.
    List<DebtCollection> findAllByUserId(Long id);

    //4.d.2 Kullanıcının ödediği toplam gecikme zammı miktarı
    BigDecimal findAllByTotalDebtId_StatusAmount(Long id, DebtType status);

    DebtCollection save(DebtCollection debtCollection);

    //4.d Kullanıcının ödediği gecikme zammı listelenebilmelidir
    List<DebtCollection> findAllByTotalDebtId_Status(Long id, DebtType status);

    DebtCollection findById(Long id);

    List<DebtCollection> findAll();
}
