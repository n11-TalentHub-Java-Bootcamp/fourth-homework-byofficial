package com.burakyildiz.springboothomework4.service;

import com.burakyildiz.springboothomework4.model.ConstRate;
import com.burakyildiz.springboothomework4.model.Debt;
import com.burakyildiz.springboothomework4.model.DebtType;
import com.burakyildiz.springboothomework4.repository.IDebtRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.Period;
import java.util.List;
import java.util.Optional;

@Service
public class DebtService implements IDebtService {

    private static final LocalDateTime DEBT_TYPE_DATE = LocalDateTime.parse("2018-01-01T00:00:00"); //Gecikme Zammı için sabit tarih

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
    public List<Debt> findAllByCreatedDateBetween(LocalDateTime startDate, LocalDateTime endDate) {
        return debtRepository.findAllByCreatedDateBetween(startDate, endDate);
    }

    //3.f Bir kullanıcının vadesi geçmiş borçları listenelebilmelidir. (Borç tutarı sıfırdan büyük olanlar)
    @Override
    public List<Debt> findAllByExpiryDateLessThanAndUserIdAndTotalDebtGreaterThan(LocalDateTime dateNow, Long userId, BigDecimal totalDebt) {
        return debtRepository.findAllByExpiryDateLessThanAndUserIdAndTotalDebtGreaterThan(dateNow, userId, totalDebt);

    }

    //3.g Bir kullanıcının toplam borç tutarını dönen bir servis olmaldıır.
    @Override
    public BigDecimal findAllByTotalMainDebt(Long userId) {

        //Toplam Ana Borç + (Varsa)Gecikme zammı
        return debtRepository.findAllByTotalMainDebt(userId).add(totalLateFeeAmount(userId));
    }

    //3.h Bir kullanıcının vadesi geçmiş toplam borç tutarını dönen bir servis olmaldıır.
    @Override
    public BigDecimal findAllByExpiryDateLessThanAndTotalMainDebt(LocalDateTime expiryDate, Long userId) {

        //Toplam Vadesi Geçen Borç + Gecikme zammı
        return debtRepository.findAllByExpiryDateLessThanAndTotalMainDebt(expiryDate, userId).add(totalLateFeeAmount(userId));
    }

    //3.i Bir kullanıcının anlık gecikme zammı tutarını dönen bir servis olmalıdır.
    @Override
    public BigDecimal findAllByTotalDebtStatus(Long userId) {
        return totalLateFeeAmount(userId);
    }

    @Override
    public Debt saveDebt(Debt debt) {
        debt.setTopDebtId(null);
        debt.setTotalDebt(debt.getMainDebt());
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

    public BigDecimal totalLateFeeAmount(Long userId) {
        BigDecimal rateDateAmount = new BigDecimal(0L);//Gecikme zammı miktarı (TL)
        List<Debt> debtList = debtRepository.findAllByUserId(userId);

        for (Debt debt : debtList) {
            LocalDateTime dateNow = LocalDateTime.now(); //Şuan ki zaman
            LocalDateTime expiryDate = debt.getExpiryDate(); //Borcun vade tarihi
            LocalDateTime createdDate = debt.getCreatedDate(); //Borcun yapıldığı tarih
            Period period = Period.between(dateNow.toLocalDate(), expiryDate.toLocalDate()); //Vade tarihi durumu
            int compareDate = ((period.getYears() * 365) + (period.getMonths() * 12) + period.getDays()) * (-1); //Vade tarihi kaç gün geçmiş

            double constRate;
            if (compareDate > 0) {//vade tarihi geçmiş
                //Borç tarihleri 2018 den sonra olan borçlar 2 oranı ile çarpılır
                if (createdDate.compareTo(DEBT_TYPE_DATE) > 0) {
                    constRate = ConstRate.RATE_2;
                    Period periodRate = Period.between(expiryDate.toLocalDate(), dateNow.toLocalDate());
                    rateDateAmount = rateDateAmount.add(new BigDecimal(Math.floor(
                            (periodRate.getYears() * 365) +
                                    (periodRate.getMonths() * 12) +
                                    (periodRate.getDays()) *
                                            (constRate))));
                } else { //Borç tarihleri 2018 den önce olan borçlar 1.5 oranı ile çarpılır
                    constRate = ConstRate.RATE_1_5;
                    Period periodRate = Period.between(expiryDate.toLocalDate(), dateNow.toLocalDate());
                    rateDateAmount = rateDateAmount.add(new BigDecimal(Math.floor(
                            (periodRate.getYears() * 365) +
                                    (periodRate.getMonths() * 12) +
                                    (periodRate.getDays()) *
                                            (constRate))));
                }

            }
        }
        return rateDateAmount;
    }
}
