package com.example.springbootbontech.service;

import com.example.springbootbontech.dao.AddressDao;
import com.example.springbootbontech.dto.AddressDto;
import com.example.springbootbontech.dto.MapperDto.AddressMapper;
import com.example.springbootbontech.entity.Address;
import lombok.Getter;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AddressService {

    private AddressDao addressDao;
    private AddressMapper addressMapper;
    @Autowired
    public AddressService(AddressDao addressDao, AddressMapper addressMapper) {
        this.addressDao = addressDao;
        this.addressMapper = addressMapper;
    }


    public Page<AddressDto> getAllAddressDto(Pageable pageable){
        return (Page<AddressDto>) addressDao.findAll(pageable).stream().map((Address add) -> {
                    return addressMapper.getAddressDto(add);}).collect(Collectors.toList());
    }
    public AddressDto getAddressDto(Long id){
        Optional<Address> address = addressDao.findById(id);
        //TODO Exception handler
        return addressMapper.getAddressDto(address.get());
    }

    public AddressDao getAddressDao() {
        return addressDao;
    }

    @Transactional
    public AddressDto insertAddress(Address address){
        addressDao.save(address);
        return addressMapper.getAddressDto(address);
    }

}
