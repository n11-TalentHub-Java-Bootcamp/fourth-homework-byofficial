package com.burakyildiz.springboothomework4.repository;

import com.burakyildiz.springboothomework4.model.Debt;
import com.burakyildiz.springboothomework4.model.DebtType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

public interface IDebtRepository extends JpaRepository<Debt, Long> {

    //3.d Belirtilen tarihler arasında oluşturulan borçlar listelenebilmelidir.
    //@Query("select debt from Debt debt where debt.createdDate BETWEEN :startDate AND  :endDate")
    List<Debt> findAllByCreatedDateBetween(LocalDateTime startDate, LocalDateTime endDate);


    //3.e Bir kullanıcının tüm borçları listenelebilmelidir. (Borç tutarı sıfırdan büyük olanlar
    @Query("select debt from Debt debt where debt.userId.id = :id and debt.totalDebt > 0")
    List<Debt> findAllByUserId(Long id);

    //3.f Bir kullanıcının vadesi geçmiş borçları listenelebilmelidir. (Borç tutarı sıfırdan büyük olanlar)
    @Query("select debt from Debt debt where debt.expiryDate < :expiryDate and debt.userId.id = :userId and debt.totalDebt > :totalDebt")
    List<Debt> findAllByExpiryDateLessThanAndUserIdAndTotalDebtGreaterThan(LocalDateTime expiryDate, Long userId, BigDecimal totalDebt);

    //3.g Bir kullanıcının toplam borç tutarını dönen bir servis olmaldıır.
    @Query("select sum(debt.mainDebt)  from Debt debt where debt.userId.id = :userId and debt.totalDebt > 0")
    BigDecimal findAllByTotalMainDebt(Long userId);

    //3.h Bir kullanıcının vadesi geçmiş toplam borç tutarını dönen bir servis olmaldıır.
    @Query("select sum(debt.mainDebt)  from Debt debt where debt.expiryDate < :expiryDate and  debt.userId.id = :userId and debt.totalDebt > 0")
    BigDecimal findAllByExpiryDateLessThanAndTotalMainDebt(LocalDateTime expiryDate, Long userId);

    //4.d Kullanıcının ödediği gecikme zammı listelenebilmelidir
    @Query("select " +
            "debt from Debt debt " +
            "left join DebtCollection debtCollection on debt.id = debtCollection.debtId.id " +
            "left join User user on user.id = debt.userId.id " +
            "where debt.userId.id = :id and " +
            "debt.status = :status and " +
            "debt.totalDebt = 0")
    List<Debt> findAllByTotalDebtId_Status(Long id, DebtType status);

}
