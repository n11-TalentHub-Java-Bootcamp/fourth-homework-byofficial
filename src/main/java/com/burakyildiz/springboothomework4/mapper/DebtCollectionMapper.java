package com.burakyildiz.springboothomework4.mapper;

import com.burakyildiz.springboothomework4.dto.deptCollect.CreateDeptCollectionDto;
import com.burakyildiz.springboothomework4.model.DebtCollection;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE,componentModel = "spring")
public interface DebtCollectionMapper {
    DebtCollectionMapper INSTANCE = Mappers.getMapper(DebtCollectionMapper.class);

    @Mapping(source = "debtId", target = "debtId.id")
    DebtCollection convertCreateDebtCollectionDtoToDebtCollection(CreateDeptCollectionDto deptCollectionDto);

}
