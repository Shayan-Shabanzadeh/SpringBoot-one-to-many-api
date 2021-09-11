package com.example.springbootbontech.dao;


import com.example.springbootbontech.entity.Address;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


@Repository
public interface AddressDao extends JpaRepository<Address , Long> {
//    Page<Address> findAll(Pageable pageable);

    @Transactional
    Address getById(Long id);
}
