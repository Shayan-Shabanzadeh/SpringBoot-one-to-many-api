package com.example.springbootbontech.dto;

import com.example.springbootbontech.dao.AddressDao;
import com.example.springbootbontech.entity.Address;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;
@Getter @Setter @ToString
public class UserDto {

    private String username;
    private String country;
    private List<Address> addresses;

}
