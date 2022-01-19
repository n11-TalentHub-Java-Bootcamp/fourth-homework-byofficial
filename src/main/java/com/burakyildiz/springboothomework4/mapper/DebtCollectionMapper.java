package com.burakyildiz.springboothomework4.mapper;

import com.burakyildiz.springboothomework4.dto.debtCollect.CreateDebtCollectionDto;
import com.burakyildiz.springboothomework4.dto.debtCollect.DebtCollectionLateFeeDto;
import com.burakyildiz.springboothomework4.dto.debtCollect.DebtCollectionListDto;
import com.burakyildiz.springboothomework4.dto.debtCollect.TwoDatesBetweenDebtCollectionListDto;
import com.burakyildiz.springboothomework4.model.Debt;
import com.burakyildiz.springboothomework4.model.DebtCollection;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface DebtCollectionMapper {
    DebtCollectionMapper INSTANCE = Mappers.getMapper(DebtCollectionMapper.class);

    @Mapping(source = "debtId", target = "debtId.id")
    DebtCollection convertCreateDebtCollectionDtoToDebtCollection(CreateDebtCollectionDto debtCollectionDto);


    /**
     * All List Mapper
     */
    @Mapping(source = "debtId.mainDebt", target = "mainDebt")
    @Mapping(source = "debtId.totalDebt", target = "totalDebt")
    @Mapping(source = "debtId.status", target = "status")
    @Mapping(source = "debtId.userId.username", target = "username")
    @Mapping(source = "debtId.userId.name", target = "name")
    @Mapping(source = "debtId.expiryDate", target = "expiryDate")
    List<TwoDatesBetweenDebtCollectionListDto> convertDebtCollectionToTwoDatesBetweenDebtCollectionListDto(List<DebtCollection> debt);


    @Mapping(source = "debtId.mainDebt", target = "mainDebt")
    @Mapping(source = "debtId.totalDebt", target = "totalDebt")
    @Mapping(source = "debtId.status", target = "status")
    @Mapping(source = "debtId.userId.username", target = "username")
    @Mapping(source = "debtId.userId.name", target = "name")
    @Mapping(source = "debtId.expiryDate", target = "expiryDate")
    List<DebtCollectionListDto> convertDebtCollectionToAllDebtCollectionListDto(List<DebtCollection> debt);

    @Mapping(target = "mainDebt", source = "mainDebt")
    @Mapping(target = "totalDebt", source = "totalDebt")
    @Mapping(target = "status", source = "status")
    @Mapping(target = "username", source = "userId.username")
    @Mapping(target = "name", source = "userId.name")
    List<DebtCollectionLateFeeDto> convertDebtToDebtCollectionList(List<Debt> debt);

    /**
     * All Single Mapper
     */
    @Mapping(source = "debtId.mainDebt", target = "mainDebt")
    @Mapping(source = "debtId.totalDebt", target = "totalDebt")
    @Mapping(source = "debtId.status", target = "status")
    @Mapping(source = "debtId.userId.username", target = "username")
    @Mapping(source = "debtId.userId.name", target = "name")
    @Mapping(source = "debtId.expiryDate", target = "expiryDate")
    TwoDatesBetweenDebtCollectionListDto convertDebtCollectionToTwoDatesBetweenDebtCollectionDto(DebtCollection debt);

    @Mapping(source = "debtId.mainDebt", target = "mainDebt")
    @Mapping(source = "debtId.totalDebt", target = "totalDebt")
    @Mapping(source = "debtId.status", target = "status")
    @Mapping(source = "debtId.userId.username", target = "username")
    @Mapping(source = "debtId.userId.name", target = "name")
    @Mapping(source = "debtId.expiryDate", target = "expiryDate")
    DebtCollectionListDto convertDebtCollectionToDebtCollectionListDto(DebtCollection debt);

    @Mapping(target = "mainDebt", source = "mainDebt")
    @Mapping(target = "totalDebt", source = "totalDebt")
    @Mapping(target = "status", source = "status")
    @Mapping(target = "username", source = "userId.username")
    @Mapping(target = "name", source = "userId.name")
    DebtCollectionLateFeeDto convertDebtToDebtCollection(Debt debt);

}
