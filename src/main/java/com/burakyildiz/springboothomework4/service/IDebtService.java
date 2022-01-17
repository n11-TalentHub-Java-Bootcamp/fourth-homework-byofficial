package com.burakyildiz.springboothomework4.service;

import com.burakyildiz.springboothomework4.dto.dept.TwoDatesBetweenDeptListDto;
import com.burakyildiz.springboothomework4.model.Debt;
import com.burakyildiz.springboothomework4.model.User;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

public interface IDebtService {
    List<Debt> findAll();

    List<Debt> findAllByUserId(Long id);

    List<Debt> findAllByCreatedDateBetween(LocalDateTime startDate, LocalDateTime endDate);

    //3.f Bir kullanıcının vadesi geçmiş borçları listenelebilmelidir. (Borç tutarı sıfırdan büyük olanlar)
    List<Debt> findAllByExpiryDateLessThanAndUserIdAndTotalDeptGreaterThan(LocalDateTime dateNow, Long userId, BigDecimal totalDept);

    //3.g Bir kullanıcının toplam borç tutarını dönen bir servis olmaldıır.
    BigDecimal findAllByTotalMainDept(Long userId);

    //3.h Bir kullanıcının vadesi geçmiş toplam borç tutarını dönen bir servis olmaldıır.
    BigDecimal findAllByExpiryDateLessThanAndTotalMainDept(LocalDateTime expiryDate, Long userId);

    Debt saveDebt(Debt debt);

    void deleteById(Long id);

    Debt findById(Long id);
}
