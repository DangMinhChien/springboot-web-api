package com.laptrinhjavaweb.repository;

import java.util.List;

import com.laptrinhjavaweb.entity.TransactionEntity;

public interface ITransactionRepository {

	List<TransactionEntity> getTransactionByCustomerIdByCustomerCare(Long customerId);
	
	List<TransactionEntity> getTransactionByCustomerIdByGoandsee(Long customerId);
}
