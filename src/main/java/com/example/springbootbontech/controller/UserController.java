package com.example.springbootbontech.controller;

import com.example.springbootbontech.dto.UserDto;
import com.example.springbootbontech.entity.User;
import com.example.springbootbontech.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(path = "/users")
public class UserController {
    private UserService service;
    @Autowired
    public void setService(UserService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<Page<UserDto>> getAllUsers(@RequestParam Pageable pageable){
        return ResponseEntity.ok(service.getAllUserDto(pageable));
    }
    @GetMapping(path = "/{id}")
    public ResponseEntity<UserDto> getUser(@PathVariable Long id){
        return ResponseEntity.ok(service.getUserDto(id));
    }
    @PutMapping
    public ResponseEntity<Void> updateUser(@RequestBody User user){
        service.getUserDao().save(user);
        return new ResponseEntity<Void>(HttpStatus.ACCEPTED);
        //TODO validation
    }
    @PostMapping
    public ResponseEntity<UserDto> insertUser(@RequestBody User user){
        return ResponseEntity.ok(service.insertUser(user));
        //TODO validation
    }
    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id){
        Optional<User> user = service.getUserDao().findById(id);
        service.getUserDao().delete(user.get());
        return new ResponseEntity<Void>(HttpStatus.ACCEPTED);
    }

}
