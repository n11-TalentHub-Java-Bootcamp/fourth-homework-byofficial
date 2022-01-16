package com.burakyildiz.springboothomework4.controller;

import com.burakyildiz.springboothomework4.dto.deptCollect.CreateDeptCollectionDto;
import com.burakyildiz.springboothomework4.mapper.DebtCollectionMapper;
import com.burakyildiz.springboothomework4.model.DebtCollection;
import com.burakyildiz.springboothomework4.service.IDebtCollectionService;
import com.burakyildiz.springboothomework4.service.IDebtService;
import com.burakyildiz.springboothomework4.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/collection")
public class DebtCollectionController {

    @Autowired
    private IDebtCollectionService debtCollectionService;

    @Autowired
    private IDebtService debtService;

    @Autowired
    private IUserService userService;

    @GetMapping("")
    public List<DebtCollection> findAll() {
        return debtCollectionService.findAll();
    }

    @PostMapping("")
    public ResponseEntity<?> save(@RequestBody CreateDeptCollectionDto deptCollectionDto) {
        ResponseEntity<String> result = null;


        DebtCollection debtCollection = DebtCollectionMapper.INSTANCE.convertCreateDebtCollectionDtoToDebtCollection(deptCollectionDto);
        debtCollectionService.save(debtCollection);

//        if (debt != null) {
//            if (debt.getTotalDept().doubleValue() > 0L) {
//                if (debt.getTotalDept().doubleValue() == debtCollection.getAmount().doubleValue()){
//                    debtCollectionService.save(debtCollection);
//                }else {
//                    System.out.println("Lütfen borcunuzun tamamını ödeyin!");
//                }
//            } else {
//                System.out.println("Borcunuz ödenmiş!");
//            }
//        } else {
//            System.out.println("Böyle bir borç kaydı yok");
//        }
//
//        debtCollectionService.save(debtCollection);
        result = new ResponseEntity<String>("Tahsilat yapıldı", HttpStatus.OK);

        return result;
    }

}
