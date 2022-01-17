package com.burakyildiz.springboothomework4.repository;

import com.burakyildiz.springboothomework4.dto.dept.TwoDatesBetweenDeptListDto;
import com.burakyildiz.springboothomework4.model.Debt;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

public interface IDebtRepository extends JpaRepository<Debt,Long> {

    //3.d Belirtilen tarihler arasında oluşturulan borçlar listelenebilmelidir.
    //@Query("select debt from Debt debt where debt.createdDate BETWEEN :startDate AND  :endDate")
    List<Debt> findAllByCreatedDateBetween(LocalDateTime startDate, LocalDateTime endDate);


    //3.e Bir kullanıcının tüm borçları listenelebilmelidir. (Borç tutarı sıfırdan büyük olanlar
    @Query("select debt from Debt debt where debt.userId.id = :id and debt.totalDept > 0")
    List<Debt> findAllByUserId(Long id);

    //3.f Bir kullanıcının vadesi geçmiş borçları listenelebilmelidir. (Borç tutarı sıfırdan büyük olanlar)
    @Query("select debt from Debt debt where debt.expiryDate < :expiryDate and debt.userId.id = :userId and debt.totalDept > :totalDept")
    List<Debt> findAllByExpiryDateLessThanAndUserIdAndTotalDeptGreaterThan(LocalDateTime expiryDate,Long userId, BigDecimal totalDept);

    //3.g Bir kullanıcının toplam borç tutarını dönen bir servis olmaldıır.
    @Query("select sum(debt.mainDept)  from Debt debt where debt.userId.id = :userId and debt.totalDept > 0")
    BigDecimal findAllByTotalMainDept(Long userId);

    //3.h Bir kullanıcının vadesi geçmiş toplam borç tutarını dönen bir servis olmaldıır.
    @Query("select sum(debt.mainDept)  from Debt debt where debt.expiryDate < :expiryDate and  debt.userId.id = :userId and debt.totalDept > 0")
    BigDecimal findAllByExpiryDateLessThanAndTotalMainDept(LocalDateTime expiryDate,Long userId);

   // @Query("select debt from Debt debt where debt.expiryDate < :expiryDate and debt.userId.id = :id and debt.totalDept > 0")
  // @Query("select debt  from Debt debt where debt.expiryDate < :expiryDate and debt.userId.id = :userId and debt.totalDept > 0")
  // BigDecimal findAllByTotalDeptStatus(LocalDateTime expiryDate,Long userId);
}
