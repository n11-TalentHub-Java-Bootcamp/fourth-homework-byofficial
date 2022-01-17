package com.burakyildiz.springboothomework4.controller;

import com.burakyildiz.springboothomework4.dto.dept.DebtListDto;
import com.burakyildiz.springboothomework4.dto.dept.CreateDebtDto;
import com.burakyildiz.springboothomework4.dto.dept.TwoDatesBetweenDeptListDto;
import com.burakyildiz.springboothomework4.mapper.DebtMapper;
import com.burakyildiz.springboothomework4.model.Debt;

import com.burakyildiz.springboothomework4.service.IDebtService;
import com.burakyildiz.springboothomework4.service.IUserService;
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
@RequestMapping("/api/debt")
public class DebtController {

    @Autowired
    private IDebtService debtService;

    @Autowired
    private IUserService userService;

    @GetMapping("")
    public List<DebtListDto> findAll() {
        List<Debt> debtList = debtService.findAll();
        List<DebtListDto> debtListDto = DebtMapper.INSTANCE.convertDebtToAllDeptListDto(debtList);

        return debtListDto;
    }

    //3.d
    //[GET] https://localhost:8080/api/debt/date/between?s={param1}&e={param2}
    @GetMapping("/date/between")
    public List<TwoDatesBetweenDeptListDto> findAllByCreatedDateBetween(@RequestParam(value = "s", required = false) String s,
                                                                        @RequestParam(value = "e", required = false) String e) {

        LocalDateTime startDate = LocalDate.parse(s).atTime(LocalTime.now());
        LocalDateTime endDate = LocalDate.parse(e).atTime(LocalTime.now());
        List<Debt> debtList = debtService.findAllByCreatedDateBetween(startDate, endDate);

        List<TwoDatesBetweenDeptListDto> debtListDto = DebtMapper.INSTANCE.convertDebtToTwoDatesBetweenDeptListDto(debtList);

        System.out.println("test");
        return debtListDto;
    }

    //3.e
    @GetMapping("/user/{id}")
    public List<DebtListDto> findAllByUserId(@PathVariable Long id) {
        List<Debt> deptAllUser = debtService.findAllByUserId(id);

        List<DebtListDto> debtListDto = DebtMapper.INSTANCE.convertDebtToAllDeptListDto(deptAllUser);

        return debtListDto;
    }

    //3.f
    @GetMapping("/user/{id}/expiry")
    public List<TwoDatesBetweenDeptListDto> findAllByExpiryDateBetweenAndUserIdAndTotalDeptGreaterThan(@PathVariable Long id) {

        List<Debt> deptAllUser = debtService.findAllByExpiryDateLessThanAndUserIdAndTotalDeptGreaterThan(LocalDateTime.now(),id, BigDecimal.valueOf(0L));

        List<TwoDatesBetweenDeptListDto> debtListDto = DebtMapper.INSTANCE.convertDebtToTwoDatesBetweenDeptListDto(deptAllUser);


        return debtListDto;
    }

    //3.g
    @GetMapping("/user/{id}/totaldept")
    public BigDecimal findAllByTotalMainDept(@PathVariable Long id){

      return debtService.findAllByTotalMainDept(id);
    }

    //3.h
    @GetMapping("/user/{id}/totalexpiry")
    public BigDecimal findAllByExpiryDateLessThanAndTotalMainDept(@PathVariable Long id){

        return debtService.findAllByExpiryDateLessThanAndTotalMainDept(LocalDateTime.now(), id);
    }


    @PostMapping("")
    public ResponseEntity<?> saveDebt(@RequestBody CreateDebtDto debtDto) {
        ResponseEntity<String> result = null;

        Debt debt = DebtMapper.INSTANCE.convertCreateDebtDtoToDebt(debtDto);

        debtService.saveDebt(debt);
        result = new ResponseEntity<String>("Borç Eklendi!", HttpStatus.OK);

        return result;
    }
}
