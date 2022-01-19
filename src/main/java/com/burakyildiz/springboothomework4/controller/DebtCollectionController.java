package com.burakyildiz.springboothomework4.controller;

import com.burakyildiz.springboothomework4.dto.debtCollect.CreateDebtCollectionDto;
import com.burakyildiz.springboothomework4.dto.debtCollect.DebtCollectionLateFeeDto;
import com.burakyildiz.springboothomework4.dto.debtCollect.DebtCollectionListDto;
import com.burakyildiz.springboothomework4.dto.debtCollect.TwoDatesBetweenDebtCollectionListDto;
import com.burakyildiz.springboothomework4.mapper.DebtCollectionMapper;
import com.burakyildiz.springboothomework4.model.Debt;
import com.burakyildiz.springboothomework4.model.DebtCollection;
import com.burakyildiz.springboothomework4.model.DebtType;
import com.burakyildiz.springboothomework4.service.IDebtCollectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

@RestController
@RequestMapping("/api/collections")
public class DebtCollectionController {

    @Autowired
    private IDebtCollectionService debtCollectionService;


    //Tüm tahsilatlar listelenir
    @GetMapping("")
    public ResponseEntity<?> findAll() {
      List<DebtCollectionListDto> debtCollectionList =  DebtCollectionMapper.INSTANCE.convertDebtCollectionToAllDebtCollectionListDto(debtCollectionService.findAll());
        return new ResponseEntity<>(
                debtCollectionList,
                HttpStatus.OK);
    }

    //4.a  Tahsilat yapan servis yazınız
    @PostMapping("")
    public ResponseEntity<?> save(@RequestBody CreateDebtCollectionDto debtCollectionDto) {
        ResponseEntity<String> result = null;
        DebtCollection debtCollection = DebtCollectionMapper.INSTANCE.convertCreateDebtCollectionDtoToDebtCollection(debtCollectionDto);
        debtCollectionService.save(debtCollection);
        result = new ResponseEntity<String>("Tahsilat yapıldı", HttpStatus.OK);

        return result;
    }



    //4.b Belirtilen tarihler arasında yapılan tahsilatlar listelenebilmelidir
    //[GET] https://localhost:8080/api/collection/date/between?s={start_date}&e={end_date}
    //example-> /api/collections/date/between?s=2022-01-15&e=2022-01-20
    @GetMapping("/date/between")
    public ResponseEntity<?> findAllByCreatedDateBetween(@RequestParam(value = "s", required = false) String s,
                                                                        @RequestParam(value = "e", required = false) String e) {

        LocalDateTime startDate = LocalDate.parse(s).atTime(LocalTime.now());
        LocalDateTime endDate = LocalDate.parse(e).atTime(LocalTime.now());
        List<DebtCollection> debtList = debtCollectionService.findAllByCreatedDateBetween(startDate, endDate);

        List<TwoDatesBetweenDebtCollectionListDto> debtListDto = DebtCollectionMapper.INSTANCE.convertDebtCollectionToTwoDatesBetweenDebtCollectionListDto(debtList);

        return  new ResponseEntity<>(
                debtListDto,
                HttpStatus.OK);
    }

    //4.c Kullanıcının tüm tahsilatları listelenebilmelidir.
    @GetMapping("/user/{id}")
    public ResponseEntity<?> findAllByUserId(@PathVariable Long id) {
        List<DebtCollection> debtAllUser = debtCollectionService.findAllByUserId(id);

        List<DebtCollectionListDto> debtListDto = DebtCollectionMapper.INSTANCE.convertDebtCollectionToAllDebtCollectionListDto(debtAllUser);

        return new ResponseEntity<>(
                debtListDto,
                HttpStatus.OK);
    }


    //4.d Kullanıcının ödediği toplam gecikme zammı listelenebilmelidir
    @GetMapping("/user/{id}/latefee")
    public ResponseEntity<?> findAllByTotalDebtId_Status(@PathVariable Long id) {
        List<Debt> debtAllUser = debtCollectionService.findAllByTotalDebtId_Status(id, DebtType.LATE_FEE);

        List<DebtCollectionLateFeeDto> debtListDto = DebtCollectionMapper.INSTANCE.convertDebtToDebtCollectionList(debtAllUser);

        return new ResponseEntity<>(
                debtListDto,
                HttpStatus.OK);
    }

    //4.d.2 Kullanıcının ödediği toplam gecikme zammı
    @GetMapping("/user/{id}/total/latefee")
    public ResponseEntity<?> findAllByTotalDebtId_StatusAmount(@PathVariable Long id) {

        return new ResponseEntity<>(
                debtCollectionService.findAllByTotalDebtId_StatusAmount(id, DebtType.LATE_FEE),
                HttpStatus.OK);
    }



}
