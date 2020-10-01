package com.laptrinhjavaweb.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import com.laptrinhjavaweb.dto.input.CustomerDetailInput;
import com.laptrinhjavaweb.dto.output.CustomerDetailOutput;
import com.laptrinhjavaweb.entity.TransactionEntity;
import com.laptrinhjavaweb.entity.UserEntity;
import com.laptrinhjavaweb.repository.ITransactionRepository;
import com.laptrinhjavaweb.repository.IUserRepository;
import com.laptrinhjavaweb.repository.impl.TransactionRepositoryImpl;
import com.laptrinhjavaweb.repository.impl.UserRepositoryImpl;
import com.laptrinhjavaweb.service.ICustomerService;

public class CustomerServiceImpl implements ICustomerService {
	private IUserRepository userRepository = new UserRepositoryImpl();
	private ITransactionRepository transactionRepository = new TransactionRepositoryImpl();
//	private TransactionConverter transactionConvert = new TransactionConverter();
	@Override
	public CustomerDetailOutput getCustomerDetail(CustomerDetailInput customerDetailInput) {
		List<TransactionEntity> listTransactionCSKH = transactionRepository.getTransactionByCustomerIdByCustomerCare(customerDetailInput.getCustomerId());
		List<TransactionEntity> listTransactionGO = transactionRepository.getTransactionByCustomerIdByGoandsee(customerDetailInput.getCustomerId());
		UserEntity userEntity = userRepository.findById(customerDetailInput.getCustomerId());
//		List<TransactionDTO> results = transactionEntities.stream().map(item -> transactionConvert.convertToDto(item))
//				.collect(Collectors.toList());
		List<String> noteCareCustomer = listTransactionCSKH.stream().map(item ->{
			return item.getNote();
		}).collect(Collectors.toList());
		
		List<String> noteGotosee = listTransactionGO.stream().map(item ->{
			return item.getNote();
		}).collect(Collectors.toList());
		
		CustomerDetailOutput customerDetailOutput = new CustomerDetailOutput();
		customerDetailOutput.setUserName(userEntity.getFullName());
		customerDetailOutput.setCareCustomer(noteCareCustomer);
		customerDetailOutput.setGoAndSee(noteGotosee);
		return customerDetailOutput;
	}

}
