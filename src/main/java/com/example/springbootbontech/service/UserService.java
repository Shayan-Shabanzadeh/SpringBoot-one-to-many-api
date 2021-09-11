package com.example.springbootbontech.service;


import com.example.springbootbontech.dao.UserDao;
import com.example.springbootbontech.dto.AddressDto;
import com.example.springbootbontech.dto.MapperDto.UserMapper;
import com.example.springbootbontech.dto.UserDto;
import com.example.springbootbontech.entity.Address;
import com.example.springbootbontech.entity.User;
import lombok.Getter;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.stream.Collectors;

@Service
public class UserService {

    private UserDao userDao;
    private UserMapper userMapper;

    @Autowired
    public void setUserMapper(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @Autowired
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    public Page<UserDto> getAllUserDto(Pageable pageable){
        return (Page<UserDto>) userDao.findAll(pageable).stream().map((User user) -> {
            return userMapper.getUserDto(user);}).collect(Collectors.toList());
    }
    public UserDto getUserDto(Long id){
        User user = userDao.getById(id);
        //TODO Exception handler
        return  userMapper.getUserDto(user);
    }

    public UserDao getUserDao() {
        return userDao;
    }

    @Transactional
    public UserDto insertUser(User user){
        userDao.save(user);
        return userMapper.getUserDto(user);
    }
}
