package com.laptrinhjavaweb.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.laptrinhjavaweb.entity.TransactionEntity;

public interface ITransactionRepository 
//extends JpaRepository<TransactionEntity>
extends JpaRepository<TransactionEntity, Long> {
	List<TransactionEntity> findByCustomer_Id(Long customerId);
	
	List<TransactionEntity> findByCodeAndCustomer_Id(String code , Long id);
	
}
