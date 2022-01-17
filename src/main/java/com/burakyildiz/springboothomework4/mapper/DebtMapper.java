package com.burakyildiz.springboothomework4.mapper;

import com.burakyildiz.springboothomework4.dto.dept.DebtListDto;
import com.burakyildiz.springboothomework4.dto.dept.CreateDebtDto;
import com.burakyildiz.springboothomework4.dto.dept.TwoDatesBetweenDeptListDto;
import com.burakyildiz.springboothomework4.model.Debt;
import com.burakyildiz.springboothomework4.model.User;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE,componentModel = "spring")

public interface DebtMapper {
    DebtMapper INSTANCE = Mappers.getMapper(DebtMapper.class);

    @Mapping(source = "user.id", target = "userId.id")
    Debt convertUserToDebt(User user);


    @Mapping(source = "userId", target = "userId.id")
    Debt convertCreateDebtDtoToDebt(CreateDebtDto debtDto);


    @Mapping(source = "totalDept", target= "totalDept")
    @Mapping(source = "status", target= "status")
    @Mapping(source = "userId.username", target= "username")
    @Mapping(source = "userId.name", target= "name")
    List<DebtListDto> convertDebtToAllDeptListDto(List<Debt> debt);

    @Mapping(source = "id", target= "id")
    @Mapping(source = "topDebtId.id", target= "topDebtId")
    @Mapping(source = "totalDept", target= "totalDept")
    @Mapping(source = "status", target= "status")
    @Mapping(source = "userId.username", target= "username")
    @Mapping(source = "userId.name", target= "name")
    List<TwoDatesBetweenDeptListDto> convertDebtToTwoDatesBetweenDeptListDto(List<Debt> debt);


    @Mapping(source = "userId.username", target= "username")
    @Mapping(source = "userId.name", target= "name")
    DebtListDto convertDebtToDebtListDto(Debt debt);


    @Mapping(source = "id", target= "id")
    @Mapping(source = "topDebtId.id", target= "topDebtId")
    @Mapping(source = "userId.username", target= "username")
    @Mapping(source = "userId.name", target= "name")
    TwoDatesBetweenDeptListDto convertDebtToTwoDatesBetweenDeptDto(Debt debt);


}
