package com.burakyildiz.springboothomework4.controller;

import com.burakyildiz.springboothomework4.dto.dept.AllDebtListDto;
import com.burakyildiz.springboothomework4.dto.dept.CreateDebtDto;
import com.burakyildiz.springboothomework4.mapper.DebtMapper;
import com.burakyildiz.springboothomework4.model.Debt;

import com.burakyildiz.springboothomework4.service.IDebtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/debt")
public class DebtController {

    @Autowired
    private IDebtService debtService;

    @GetMapping("")
    public List<AllDebtListDto> findAll() {

        List<Debt> debtList = debtService.findAll();

        List<AllDebtListDto> debtListDto = DebtMapper.INSTANCE.convertDebtToAllDeptListDto(debtList);
        return debtListDto;
    }

    //3.e
    @GetMapping("/user/{id}")
    public List<Debt> findAllByUserId(@PathVariable Long id) {
        List<Debt> deptAllUser = debtService.findAllByUserId(id);

        return deptAllUser;
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
