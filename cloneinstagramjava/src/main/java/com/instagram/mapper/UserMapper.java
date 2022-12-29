package com.instagram.mapper;

import com.instagram.dto.UserCreateRequestDto;
import com.instagram.entities.User;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserMapper {
    UserMapper USER_INSTANCE = Mappers.getMapper( UserMapper.class );

    User userDtoToUser(UserCreateRequestDto userDto);
}
