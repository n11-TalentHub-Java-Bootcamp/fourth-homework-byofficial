package com.burakyildiz.springboothomework4.mapper;

import com.burakyildiz.springboothomework4.dto.user.CreateUserDto;
import com.burakyildiz.springboothomework4.dto.user.LoginDto;
import com.burakyildiz.springboothomework4.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface AuthenticationMapper {
    AuthenticationMapper INSTANCE = Mappers.getMapper(AuthenticationMapper.class);

    //1.a Kullanıcı kaydeden servis yazın
    User convertCreateUserDtoToUser(CreateUserDto userDto);

    //Kullanıcı girişi
    User convertLoginDtoToUser(LoginDto loginDto);
}
