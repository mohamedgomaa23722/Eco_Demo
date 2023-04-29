package com.mg.eco.bussiness.services;

import com.mg.eco.bussiness.dtos.UserDto;
import com.mg.eco.persistence.entity.User;
import com.mg.eco.presentation.dtos.LoginDto;

public interface UserService extends Service<User, UserDto>{
    boolean login(LoginDto loginDto);
}
