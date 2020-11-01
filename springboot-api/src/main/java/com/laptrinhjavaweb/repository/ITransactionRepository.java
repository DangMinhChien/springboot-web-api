package com.laptrinhjavaweb.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.laptrinhjavaweb.entity.TransactionEntity;

public interface ITransactionRepository 
//extends JpaRepository<TransactionEntity>
extends JpaRepository<TransactionEntity, Long> {

//	List<TransactionEntity> getTransactionByCustomerIdByCustomerCare(Long customerId);
//	
//	List<TransactionEntity> getTransactionByCustomerIdByGoandsee(Long customerId);
}
