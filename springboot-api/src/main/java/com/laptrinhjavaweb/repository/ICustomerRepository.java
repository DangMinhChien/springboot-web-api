package com.laptrinhjavaweb.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.laptrinhjavaweb.entity.CustomerEntity;

public interface ICustomerRepository 
//extends JpaRepository<CustomerEntity>
extends JpaRepository<CustomerEntity, Long> {
}
