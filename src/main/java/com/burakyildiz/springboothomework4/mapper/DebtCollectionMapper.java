package com.burakyildiz.springboothomework4.mapper;

import com.burakyildiz.springboothomework4.dto.dept.DebtListDto;
import com.burakyildiz.springboothomework4.dto.dept.TwoDatesBetweenDeptListDto;
import com.burakyildiz.springboothomework4.dto.deptCollect.CreateDeptCollectionDto;
import com.burakyildiz.springboothomework4.dto.deptCollect.DebtCollectionListDto;
import com.burakyildiz.springboothomework4.dto.deptCollect.TwoDatesBetweenDeptCollectionListDto;
import com.burakyildiz.springboothomework4.model.Debt;
import com.burakyildiz.springboothomework4.model.DebtCollection;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE,componentModel = "spring")
public interface DebtCollectionMapper {
    DebtCollectionMapper INSTANCE = Mappers.getMapper(DebtCollectionMapper.class);

    @Mapping(source = "debtId", target = "debtId.id")
    DebtCollection convertCreateDebtCollectionDtoToDebtCollection(CreateDeptCollectionDto deptCollectionDto);


    /**
     * All List Mapper
     */
    @Mapping(source = "debtId.mainDept", target= "mainDept")
    @Mapping(source = "debtId.totalDept", target= "totalDept")
    @Mapping(source = "debtId.status", target= "status")
    @Mapping(source = "debtId.userId.username", target= "username")
    @Mapping(source = "debtId.userId.name", target= "name")
    @Mapping(source = "debtId.expiryDate", target= "expiryDate")
    List<TwoDatesBetweenDeptCollectionListDto> convertDebtCollectionToTwoDatesBetweenDeptCollectionListDto(List<DebtCollection> debt);


    @Mapping(source = "debtId.mainDept", target= "mainDept")
    @Mapping(source = "debtId.totalDept", target= "totalDept")
    @Mapping(source = "debtId.status", target= "status")
    @Mapping(source = "debtId.userId.username", target= "username")
    @Mapping(source = "debtId.userId.name", target= "name")
    @Mapping(source = "debtId.expiryDate", target= "expiryDate")
    List<DebtCollectionListDto> convertDebtCollectionToAllDeptCollectionListDto(List<DebtCollection> debt);

    /**
     * All Single Mapper
     */
    @Mapping(source = "debtId.mainDept", target= "mainDept")
    @Mapping(source = "debtId.totalDept", target= "totalDept")
    @Mapping(source = "debtId.status", target= "status")
    @Mapping(source = "debtId.userId.username", target= "username")
    @Mapping(source = "debtId.userId.name", target= "name")
    @Mapping(source = "debtId.expiryDate", target= "expiryDate")
    TwoDatesBetweenDeptCollectionListDto convertDebtCollectionToTwoDatesBetweenDeptCollectionDto(DebtCollection debt);

    @Mapping(source = "debtId.mainDept", target= "mainDept")
    @Mapping(source = "debtId.totalDept", target= "totalDept")
    @Mapping(source = "debtId.status", target= "status")
    @Mapping(source = "debtId.userId.username", target= "username")
    @Mapping(source = "debtId.userId.name", target= "name")
    @Mapping(source = "debtId.expiryDate", target= "expiryDate")
    DebtCollectionListDto convertDebtCollectionToDebtCollectionListDto(DebtCollection debt);

}
