package com.example.springbootbontech.dto.MapperDto;

import com.example.springbootbontech.dto.AddressDto;
import com.example.springbootbontech.entity.Address;
import com.example.springbootbontech.entity.User;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AddressMapper {

    private static  AddressMapper addressMapper;
    private ModelMapper modelMapper;

    public AddressMapper(@Autowired ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }



    public AddressDto getAddressDto(Address address){
        AddressDto addressDto = modelMapper.map(address , AddressDto.class);
        return addressDto;
    }
}
