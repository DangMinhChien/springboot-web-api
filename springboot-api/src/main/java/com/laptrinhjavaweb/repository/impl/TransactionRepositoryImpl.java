//package com.laptrinhjavaweb.repository.impl;
//
//import java.util.List;
//
//import com.laptrinhjavaweb.entity.TransactionEntity;
//import com.laptrinhjavaweb.repository.ITransactionRepository;
//
//public class TransactionRepositoryImpl extends SimpleJpaRepository<TransactionEntity> implements ITransactionRepository{
//	
//	@Override
//	public List<TransactionEntity> getTransactionByCustomerIdByCustomerCare(Long customerId) {
//		String sql = "SELECT * FROM transaction t where customerid = "+customerId+" and code = QUA_TRINH_CSKH";
//		return this.findAll(sql);
//	}
//
//	@Override
//	public List<TransactionEntity> getTransactionByCustomerIdByGoandsee(Long customerId) {
//		String sql = "SELECT * FROM transaction t where customerid = "+customerId+" and code = DAN_DI_XEM";
//		return this.findAll(sql);
//	}
//
//}
