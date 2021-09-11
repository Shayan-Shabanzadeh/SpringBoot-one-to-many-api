package com.example.springbootbontech.dto.MapperDto;

import com.example.springbootbontech.dto.UserDto;
import com.example.springbootbontech.entity.Address;
import com.example.springbootbontech.entity.User;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import java.util.List;

@Component
public class UserMapper {

    private static UserMapper userMapper;
    private ModelMapper modelMapper;

    public UserMapper(@Autowired ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }



    public UserDto getUserDto(User user){
       UserDto userDto = modelMapper.map(user, UserDto.class);
       return userDto;
    }

}
