package com.burakyildiz.springboothomework4.controller;

import com.burakyildiz.springboothomework4.dto.dept.DebtListDto;
import com.burakyildiz.springboothomework4.dto.dept.TwoDatesBetweenDeptListDto;
import com.burakyildiz.springboothomework4.dto.deptCollect.CreateDeptCollectionDto;
import com.burakyildiz.springboothomework4.dto.deptCollect.DebtCollectionListDto;
import com.burakyildiz.springboothomework4.dto.deptCollect.TwoDatesBetweenDeptCollectionListDto;
import com.burakyildiz.springboothomework4.mapper.DebtCollectionMapper;
import com.burakyildiz.springboothomework4.mapper.DebtMapper;
import com.burakyildiz.springboothomework4.model.Debt;
import com.burakyildiz.springboothomework4.model.DebtCollection;
import com.burakyildiz.springboothomework4.model.DebtType;
import com.burakyildiz.springboothomework4.service.IDebtCollectionService;
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

    //4.b
    //[GET] https://localhost:8080/api/collection/date/between?s={param1}&e={param2}
    @GetMapping("/date/between")
    public List<TwoDatesBetweenDeptCollectionListDto> findAllByCreatedDateBetween(@RequestParam(value = "s", required = false) String s,
                                                                        @RequestParam(value = "e", required = false) String e) {

        LocalDateTime startDate = LocalDate.parse(s).atTime(LocalTime.now());
        LocalDateTime endDate = LocalDate.parse(e).atTime(LocalTime.now());
        List<DebtCollection> debtList = debtCollectionService.findAllByCreatedDateBetween(startDate, endDate);

        List<TwoDatesBetweenDeptCollectionListDto> debtListDto = DebtCollectionMapper.INSTANCE.convertDebtCollectionToTwoDatesBetweenDeptCollectionListDto(debtList);

        return debtListDto;
    }

    //4.c
    @GetMapping("/user/{id}")
    public List<DebtCollectionListDto> findAllByUserId(@PathVariable Long id) {
        List<DebtCollection> deptAllUser = debtCollectionService.findAllByUserId(id);

        List<DebtCollectionListDto> debtListDto = DebtCollectionMapper.INSTANCE.convertDebtCollectionToAllDeptCollectionListDto(deptAllUser);

        return debtListDto;
    }


    //4.d
    @GetMapping("/user/{id}/latefee")
    public List<DebtCollectionListDto> findAllByTotalDebtId_Status(@PathVariable Long id) {
        List<DebtCollection> deptAllUser = debtCollectionService.findAllByTotalDebtId_Status(id, DebtType.LATE_FEE);

        List<DebtCollectionListDto> debtListDto = DebtCollectionMapper.INSTANCE.convertDebtCollectionToAllDeptCollectionListDto(deptAllUser);

        return debtListDto;
    }

    //4.d.2
    @GetMapping("/user/{id}/latefee/total")
    public BigDecimal findAllByTotalDebtId_StatusAmount(@PathVariable Long id) {

        return debtCollectionService.findAllByTotalDebtId_StatusAmount(id, DebtType.LATE_FEE);
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
