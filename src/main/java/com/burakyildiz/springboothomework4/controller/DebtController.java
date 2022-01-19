package com.burakyildiz.springboothomework4.controller;

import com.burakyildiz.springboothomework4.dto.debt.CreateDebtDto;
import com.burakyildiz.springboothomework4.dto.debt.DebtListDto;
import com.burakyildiz.springboothomework4.dto.debt.DetailsDebtListDto;
import com.burakyildiz.springboothomework4.mapper.DebtMapper;
import com.burakyildiz.springboothomework4.model.Debt;
import com.burakyildiz.springboothomework4.service.IDebtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

@RestController
@RequestMapping("/api/debts")
public class DebtController {

    @Autowired
    private IDebtService debtService;

    //Sistemde kayıtlı olan tüm borçlar listelenir.
    @GetMapping("")
    public ResponseEntity<?> findAll() {
        List<Debt> debtList = debtService.findAll();
        List<DebtListDto> debtListDto = DebtMapper.INSTANCE.convertDebtToAllDebtListDto(debtList);

        return new ResponseEntity<>(
                debtListDto,
                HttpStatus.OK);
    }

    //3.a Borç kaydeden, (sadece normal borçlar)
    @PostMapping("")
    public ResponseEntity<?> saveDebt(@RequestBody CreateDebtDto debtDto) {
        ResponseEntity<String> result = null;
        Debt debt = DebtMapper.INSTANCE.convertCreateDebtDtoToDebt(debtDto);
        debtService.saveDebt(debt);
        result = new ResponseEntity<String>("Borç Eklendi!", HttpStatus.CREATED);

        return result;
    }

    //3.d Belirtilen tarihler arasında oluşturulan borçlar listelenebilmelidir.
    //[GET] https://localhost:8080/api/debts/date/between?s={start_date}&e={end_date}
    //example-> /api/debts/date/between?s=2022-01-15&e=2022-01-20
    @GetMapping("/date/between")
    public ResponseEntity<?> findAllByCreatedDateBetween(@RequestParam(value = "s", required = true) String s,
                                                         @RequestParam(value = "e", required = true) String e) {

        //Parametre olarak gönderilen başlangıç tarihi LocalDateTime nesnesine parse ediliyor.
        LocalDateTime startDate = LocalDate.parse(s).atTime(LocalTime.now());

        //Parametre olarak gönderilen bitiş tarihi LocalDateTime nesnesine parse ediliyor.
        LocalDateTime endDate = LocalDate.parse(e).atTime(LocalTime.now());

        //Başlangıç ve bitiş tarihleri arasındaki tüm borçlar getiriliyor.
        List<Debt> debtList = debtService.findAllByCreatedDateBetween(startDate, endDate);

        List<DetailsDebtListDto> debtListDto = DebtMapper.INSTANCE.convertDebtToTwoDatesBetweenDebtListDto(debtList);

        return new ResponseEntity<>(
                debtListDto,
                HttpStatus.OK);
    }

    //3.e  Bir kullanıcının tüm borçları listenelebilmelidir. (Borç tutarı sıfırdan büyük olanlar)
    @GetMapping("/user/{id}")
    public ResponseEntity<?> findAllByUserId(@PathVariable Long id) {
        List<Debt> debtAllUser = debtService.findAllByUserId(id);

        List<DebtListDto> debtListDto = DebtMapper.INSTANCE.convertDebtToAllDebtListDto(debtAllUser);

        return new ResponseEntity<>(
                debtListDto,
                HttpStatus.OK);
    }

    //3.f Bir kullanıcının vadesi geçmiş borçları listenelebilmelidir.
    @GetMapping("/user/{id}/expiry")
    public ResponseEntity<?> findAllByExpiryDateBetweenAndUserIdAndTotalDebtGreaterThan(@PathVariable Long id) {
        List<Debt> debtAllUser = debtService.findAllByExpiryDateLessThanAndUserIdAndTotalDebtGreaterThan(LocalDateTime.now(), id, BigDecimal.valueOf(0L));
        List<DetailsDebtListDto> debtListDto = DebtMapper.INSTANCE.convertDebtToTwoDatesBetweenDebtListDto(debtAllUser);

        return new ResponseEntity<>(
                debtListDto,
                HttpStatus.OK);
    }

    //3.g Bir kullanıcının toplam borç tutarını dönen bir servis olmalıdır.
    @GetMapping("/user/{id}/total/debt")
    public ResponseEntity<?> findAllByTotalMainDebt(@PathVariable Long id) {

        return new ResponseEntity<>(
                debtService.findAllByTotalMainDebt(id),
                HttpStatus.OK);
    }

    //3.h Bir kullanıcının vadesi geçmiş toplam borç tutarını dönen bir servis olmalıdır.
    @GetMapping("/user/{id}/total/expiry")
    public ResponseEntity<?> findAllByExpiryDateLessThanAndTotalMainDebt(@PathVariable Long id) {

        return new ResponseEntity<>(
                debtService.findAllByExpiryDateLessThanAndTotalMainDebt(LocalDateTime.now(), id),
                HttpStatus.OK);
    }

    //3.i Bir kullanıcının anlık gecikme zammı tutarını dönen bir servis olmalıdır.
    @GetMapping("/user/{id}/total/latefee")
    public ResponseEntity<?> findAllByTotalDebtStatus(@PathVariable Long id) {

        return new ResponseEntity<>(
                debtService.findAllByTotalDebtStatus(id),
                HttpStatus.OK);
    }


}
