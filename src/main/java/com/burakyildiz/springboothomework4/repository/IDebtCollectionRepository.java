package com.burakyildiz.springboothomework4.repository;

import com.burakyildiz.springboothomework4.model.DebtCollection;
import com.burakyildiz.springboothomework4.model.DebtType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

public interface IDebtCollectionRepository extends JpaRepository<DebtCollection, Long> {
    //4.b Belirtilen tarihler arasında yapılan tahsilatlar listelenebilmelidir.
    List<DebtCollection> findAllByCreatedDateBetween(LocalDateTime startDate, LocalDateTime endDate);

    //4.c Kullanıcının tüm tahsilatları listelenebilmelidir.
    @Query("select debtCollection from DebtCollection debtCollection where debtCollection.debtId.userId.id = :id")
    List<DebtCollection> findAllByUserId(Long id);


    //4.d.2 Kullanıcının ödediği toplam gecikme zammı miktarı
    @Query("select sum(debtCollection.debtId.mainDebt) from DebtCollection debtCollection where debtCollection.debtId.userId.id = :id and debtCollection.debtId.status = :status")
    BigDecimal findAllByTotalDebtId_StatusAmount(Long id, DebtType status);
}
