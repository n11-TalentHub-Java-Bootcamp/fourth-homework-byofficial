package com.burakyildiz.springboothomework4.controller;

import com.burakyildiz.springboothomework4.model.Debt;

import com.burakyildiz.springboothomework4.model.User;
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
    public List<Debt> findAll() {
        List<Debt> debtList = debtService.findAll();

        return debtList;
    }

    //3.e
    @GetMapping("/user/{id}")
    public List<Debt> findAllByUserId(@PathVariable Long id) {
        List<Debt> deptAllUser = debtService.findAllByUserId(id);

        return deptAllUser;
    }

    @PutMapping("")
    public ResponseEntity<?> saveDebt(@RequestBody Debt debt) {
        ResponseEntity<String> result = null;


            debtService.saveDebt(debt);
            result = new ResponseEntity<String>("Borç Eklendi!", HttpStatus.OK);

        return result;
    }
}
