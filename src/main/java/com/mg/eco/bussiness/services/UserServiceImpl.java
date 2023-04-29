package com.mg.eco.bussiness.services;

import com.mg.eco.logging.Log;
import com.mg.eco.bussiness.dtos.Message;
import com.mg.eco.bussiness.dtos.UserDto;
import com.mg.eco.bussiness.mappers.UserMapper;
import com.mg.eco.persistence.entity.User;
import com.mg.eco.persistence.repository.UserRepository;
import com.mg.eco.presentation.dtos.LoginDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends BaseService<User, UserDto> implements UserService {
    @Autowired
    UserRepository repository;

    @Autowired
    public UserServiceImpl(UserRepository repository) {
        super(repository, UserMapper.INSTANCE);
    }

    @Log
    @Override
    public Message insert(UserDto object) {
        return super.insert(object);
    }

    @Override
    public boolean login(LoginDto loginDto) {
        return repository.login(loginDto.getEmail(), loginDto.getPassword());
    }
}
