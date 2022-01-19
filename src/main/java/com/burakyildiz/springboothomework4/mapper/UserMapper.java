package com.burakyildiz.springboothomework4.mapper;

import com.burakyildiz.springboothomework4.dto.user.UpdateUserDto;
import com.burakyildiz.springboothomework4.dto.user.UserDto;
import com.burakyildiz.springboothomework4.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface UserMapper {
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    List<UserDto> convertAllListUserToUserDto(List<User> user);

    UserDto convertUserToUserDto(User user);

    User convertUpdateUserDtoToUser(UpdateUserDto updateUserDto);
}
