package com.burakyildiz.springboothomework4.mapper;

import com.burakyildiz.springboothomework4.dto.debt.CreateDebtDto;
import com.burakyildiz.springboothomework4.dto.debt.DebtListDto;
import com.burakyildiz.springboothomework4.dto.debt.DetailsDebtListDto;
import com.burakyildiz.springboothomework4.model.Debt;
import com.burakyildiz.springboothomework4.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface DebtMapper {
    DebtMapper INSTANCE = Mappers.getMapper(DebtMapper.class);

    @Mapping(source = "user.id", target = "userId.id")
    Debt convertUserToDebt(User user);


    @Mapping(source = "userId", target = "userId.id")
    Debt convertCreateDebtDtoToDebt(CreateDebtDto debtDto);


    @Mapping(source = "id", target = "id")
    @Mapping(source = "totalLateFeeAmount", target = "totalLateFeeAmount")
    @Mapping(source = "status", target = "status")
    @Mapping(source = "userId.username", target = "username")
    @Mapping(source = "userId.name", target = "name")
    List<DebtListDto> convertDebtToAllDebtListDto(List<Debt> debt);

    @Mapping(source = "id", target = "id")
    @Mapping(source = "topDebtId.id", target = "topDebtId")
    @Mapping(source = "totalLateFeeAmount", target = "totalLateFeeAmount")
    @Mapping(source = "status", target = "status")
    @Mapping(source = "userId.username", target = "username")
    @Mapping(source = "userId.name", target = "name")
    List<DetailsDebtListDto> convertDebtToTwoDatesBetweenDebtListDto(List<Debt> debt);

    @Mapping(source = "id", target = "id")
    @Mapping(source = "userId.username", target = "username")
    @Mapping(source = "userId.name", target = "name")
    DebtListDto convertDebtToDebtListDto(Debt debt);


    @Mapping(source = "id", target = "id")
    @Mapping(source = "topDebtId.id", target = "topDebtId")
    @Mapping(source = "userId.username", target = "username")
    @Mapping(source = "userId.name", target = "name")
    DetailsDebtListDto convertDebtToTwoDatesBetweenDebtDto(Debt debt);


}
