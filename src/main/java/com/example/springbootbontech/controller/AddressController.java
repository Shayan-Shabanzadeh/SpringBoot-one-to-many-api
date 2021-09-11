package com.example.springbootbontech.controller;

import com.example.springbootbontech.dto.AddressDto;
import com.example.springbootbontech.entity.Address;
import com.example.springbootbontech.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(path = "/addresses")
public class AddressController {

    private AddressService service;
    @Autowired
    public void setService(AddressService service) {
        this.service = service;
    }

    @GetMapping(path = "/")
    public ResponseEntity<Page<AddressDto>> getAllAddress(@RequestParam Pageable pageable){
        return ResponseEntity.ok(service.getAllAddressDto(pageable));
    }
    @GetMapping(path = "/{id}")
    public ResponseEntity<AddressDto> getAddressById(@PathVariable Long id){
        return ResponseEntity.ok(service.getAddressDto(id));
    }
    @PutMapping(path = "/")
    public ResponseEntity<Void> updateAddress(@RequestBody Address address){
        service.getAddressDao().save(address);
        return new ResponseEntity<Void>(HttpStatus.ACCEPTED);
        //TODO validation
    }
    @PostMapping(path = "/")
    public ResponseEntity<AddressDto> insertAddress(@RequestBody Address address){
        return ResponseEntity.ok(service.insertAddress(address));
        //TODO validation
    }
    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> deleteAddress(@PathVariable Long id){
        Optional<Address> address = service.getAddressDao().findById(id);
        service.getAddressDao().delete(address.get());
        return new ResponseEntity<Void>(HttpStatus.ACCEPTED);
    }
}
