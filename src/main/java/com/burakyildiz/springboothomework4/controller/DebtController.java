package com.burakyildiz.springboothomework4.controller;

import com.burakyildiz.springboothomework4.dto.dept.DebtListDto;
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
    public List<DebtListDto> findAll() {
        List<Debt> debtList = debtService.findAll();
        List<DebtListDto> debtListDto = DebtMapper.INSTANCE.convertDebtToAllDeptListDto(debtList);

        return debtListDto;
    }

    //3.e
    @GetMapping("/user/{id}")
    public List<DebtListDto> findAllByUserId(@PathVariable Long id) {
        List<Debt> deptAllUser = debtService.findAllByUserId(id);

        List<DebtListDto> debtListDto = DebtMapper.INSTANCE.convertDebtToAllDeptListDto(deptAllUser);

        return debtListDto;
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
