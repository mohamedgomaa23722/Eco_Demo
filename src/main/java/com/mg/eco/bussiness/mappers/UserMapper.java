package com.mg.eco.bussiness.mappers;

import com.mg.eco.bussiness.dtos.UserDto;
import com.mg.eco.persistence.entity.User;
import com.mg.eco.presentation.dtos.InsertUserDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "default")
public interface UserMapper extends BaseMapper<User, UserDto>{
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);
    UserDto fromInsertObject(InsertUserDto insertUserDto);

}
