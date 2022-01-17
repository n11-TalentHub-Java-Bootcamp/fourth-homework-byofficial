package com.burakyildiz.springboothomework4.service;

import com.burakyildiz.springboothomework4.model.*;
import com.burakyildiz.springboothomework4.repository.IDebtCollectionRepository;
import com.burakyildiz.springboothomework4.repository.IDebtRepository;
import org.apache.tomcat.jni.Local;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.Period;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class DebtCollectionService implements IDebtCollectionService {

    @Autowired
    private IDebtCollectionRepository debtCollectionRepository;

    @Autowired
    private IDebtRepository debtRepository;

    @Override
    public DebtCollection save(DebtCollection debtCollection) {
        Optional<Debt> optional = debtRepository.findById(debtCollection.getDebtId().getId());//Tahsilatın bağlı olduğu borç
        Debt debt = null;
        if (optional.isPresent()) {
            debt = optional.get();
        }

        final LocalDateTime DEPT_TYPE_DATE = LocalDateTime.parse("2018-01-01T00:00:00"); //Gecikme Zammı için sabit tarih
        LocalDateTime dateNow = LocalDateTime.now(); //Şuan ki tahsilat zamanı
        LocalDateTime expiryDate = debt.getExpiryDate(); //Borcun vade tarihi
        LocalDateTime createdDate = debt.getCreatedDate(); //Borcun yapıldığı tarih

        Period period = Period.between(dateNow.toLocalDate(), expiryDate.toLocalDate()); //Vade tarihi durumu
        int compareDate = ((period.getYears() * 365) + (period.getMonths() * 12) + period.getDays()) * (-1); //Vade tarihi kaç gün geçmiş
        double rateDateAmount = 0.0; //Gecikme zammı miktarı (TL)
        double constRate;
        if (compareDate > 0) {//vade tarihi geçmiş
            //Borç tarihleri 2018 den sonra olan borçlar 2 oranı ile çarpılır
            if (createdDate.compareTo(DEPT_TYPE_DATE) > 0) {
                constRate = ConstRate.RATE_2;
                saveDebtCollection(expiryDate,dateNow,rateDateAmount,constRate,debt);
            }else { //Borç tarihleri 2018 den önce olan borçlar 1.5 oranı ile çarpılır
                constRate = ConstRate.RATE_1_5;
                saveDebtCollection(expiryDate,dateNow,rateDateAmount,constRate,debt);
            }

        } else if (compareDate < 0) {//vade tarihi henüz dolmamış
            debt.setTotalDept(BigDecimal.valueOf(0L));
            debtRepository.save(debt);


        } else {//aynı gün

        }


        debtCollection.setCreatedDate(dateNow);
        return debtCollectionRepository.save(debtCollection);
    }

    @Override
    public DebtCollection findById(Long id) {
        Optional<DebtCollection> optional = debtCollectionRepository.findById(id);

        DebtCollection depDebtCollection = null;
        if (optional.isPresent()) {
            depDebtCollection = optional.get();
        }

        return depDebtCollection;
    }

    @Override
    public List<DebtCollection> findAll() {

        return debtCollectionRepository.findAll();
    }


    public void saveDebtCollection(LocalDateTime expiryDate, LocalDateTime dateNow, Double rateDateAmount, Double constRate, Debt debt){


        //Gecikme zammı hesaplanıyor
        //Tahsilat tarihi ile vade tarihi arasından kaç gün geçmiş
        Period periodRate = Period.between(expiryDate.toLocalDate(), dateNow.toLocalDate());
        rateDateAmount = Math.floor(
                (periodRate.getYears() * 365) +
                        (periodRate.getMonths() * 12) +
                        (periodRate.getDays()) *
                                (constRate));

        //Veritabanına gecikme zammı ile ilgili bir borç kaydı eklenir
        Debt debtLateFee = new Debt();
        debtLateFee.setMainDept(BigDecimal.valueOf(rateDateAmount)); //Ana Borç
        debtLateFee.setTotalDept(BigDecimal.valueOf(0L)); //Kalan Borç
        debtLateFee.setStatus(DebtType.LATE_FEE); // Gecikme Zammı Borcu
        debtLateFee.setCreatedDate(dateNow); // Oluşturulma Tarihi
        debtLateFee.setUserId(debt.getUserId()); // Kullanıcı Id
        debtLateFee.setTopDebtId(debt); //Bağlı bulunduğu borç Id
        debtRepository.save(debtLateFee);


        //Normal Borcun tahsilatı yapılır
        debt.setTotalDept(BigDecimal.valueOf(0L));
        debtRepository.save(debt);

//        //Gecikme Zammı Tahsilatı Yapılır
//        DebtCollection debtLateFeeCollection = new DebtCollection();
//        debtLateFeeCollection.setCreatedDate(dateNow);
//        debtLateFeeCollection.setDebtId(debt);
//        debtLateFeeCollection.setAmount(BigDecimal.valueOf(rateDateAmount));
//        debtCollectionRepository.save(debtLateFeeCollection);

    }
}
