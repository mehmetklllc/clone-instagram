package com.instagram.mapper;

import com.instagram.dto.UserCreateRequestDto;
import com.instagram.entities.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserMapper {
    UserMapper INSTANCE = Mappers.getMapper( UserMapper.class );

    @Mapping(target="username", source="username")
    User userDtoToUser(UserCreateRequestDto userDto);
}
