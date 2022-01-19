package com.burakyildiz.springboothomework4.service;

import com.burakyildiz.springboothomework4.model.Debt;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

public interface IDebtService {
    List<Debt> findAll();

    List<Debt> findAllByUserId(Long id);

    List<Debt> findAllByCreatedDateBetween(LocalDateTime startDate, LocalDateTime endDate);

    //3.f Bir kullanıcının vadesi geçmiş borçları listenelebilmelidir. (Borç tutarı sıfırdan büyük olanlar)
    List<Debt> findAllByExpiryDateLessThanAndUserIdAndTotalDebtGreaterThan(LocalDateTime dateNow, Long userId, BigDecimal totalDebt);

    //3.g Bir kullanıcının toplam borç tutarını dönen bir servis olmaldıır.
    BigDecimal findAllByTotalMainDebt(Long userId);

    //3.h Bir kullanıcının vadesi geçmiş toplam borç tutarını dönen bir servis olmaldıır.
    BigDecimal findAllByExpiryDateLessThanAndTotalMainDebt(LocalDateTime expiryDate, Long userId);

    //3.i Bir kullanıcının anlık gecikme zammı tutarını dönen bir servis olmalıdır.
    BigDecimal findAllByTotalDebtStatus(Long userId);

    Debt saveDebt(Debt debt);

    void deleteById(Long id);

    Debt findById(Long id);
}
