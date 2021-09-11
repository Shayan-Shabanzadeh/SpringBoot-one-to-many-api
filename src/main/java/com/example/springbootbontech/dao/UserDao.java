package com.example.springbootbontech.dao;

import com.example.springbootbontech.entity.Address;
import com.example.springbootbontech.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface UserDao extends JpaRepository<User, Long> {
//    public Page<User> findAll(Pageable pageable);

    @Transactional
    User getById(Long aLong);
}
