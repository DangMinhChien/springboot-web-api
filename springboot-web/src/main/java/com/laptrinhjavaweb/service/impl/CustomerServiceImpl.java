package com.laptrinhjavaweb.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.laptrinhjavaweb.converter.CustomerConverter;
import com.laptrinhjavaweb.dto.CustomerDTO;
import com.laptrinhjavaweb.dto.input.CustomerDetailInput;
import com.laptrinhjavaweb.dto.output.CustomerDetailOutput;
import com.laptrinhjavaweb.entity.CustomerEntity;
import com.laptrinhjavaweb.entity.StaffEntity;
import com.laptrinhjavaweb.entity.TransactionEntity;
import com.laptrinhjavaweb.repository.impl.AssignmentCustomerRepositoryImpl;
import com.laptrinhjavaweb.repository.impl.CustomerRepositoryImpl;
import com.laptrinhjavaweb.repository.impl.TransactionRepositoryImpl;
import com.laptrinhjavaweb.repository.impl.UserRepositoryImpl;
import com.laptrinhjavaweb.service.ICustomerService;
@Service
public class CustomerServiceImpl implements ICustomerService {
	@Autowired
	private UserRepositoryImpl  userRepository ;
	@Autowired
	private TransactionRepositoryImpl  transactionRepository ;
	@Autowired
	private CustomerRepositoryImpl  customerRepository ;
	@Autowired
	private AssignmentCustomerRepositoryImpl  assignmentCustomerRepository ;
	@Autowired
	private CustomerConverter  customerConverter ;
//	@Autowired
//	private TransactionConverter  transactionConvert ;
	
//	private IUserRepository userRepository = new UserRepositoryImpl();
//	private ITransactionRepository transactionRepository = new TransactionRepositoryImpl();
//	private ICustomerRepository customerRepository = new CustomerRepositoryImpl();
//	private IAssignmentCustomerRepository assignmentCustomerRepository = new AssignmentCustomerRepositoryImpl();
//	private CustomerConverter customerConverter = new CustomerConverter();
//	private TransactionConverter transactionConvert = new TransactionConverter();
	@Transactional
	@Override
	public CustomerDetailOutput getCustomerDetail(CustomerDetailInput customerDetailInput) {
		List<TransactionEntity> listTransactionCSKH = transactionRepository.getTransactionByCustomerIdByCustomerCare(customerDetailInput.getCustomerId());
		List<TransactionEntity> listTransactionGO = transactionRepository.getTransactionByCustomerIdByGoandsee(customerDetailInput.getCustomerId());
		StaffEntity staffEntity = userRepository.findById(customerDetailInput.getCustomerId());
//		List<TransactionDTO> results = transactionEntities.stream().map(item -> transactionConvert.convertToDto(item))
//				.collect(Collectors.toList());
		List<String> noteCareCustomer = listTransactionCSKH.stream().map(item ->{
			return item.getNote();
		}).collect(Collectors.toList());
		
		List<String> noteGotosee = listTransactionGO.stream().map(item ->{
			return item.getNote();
		}).collect(Collectors.toList());
		
		CustomerDetailOutput customerDetailOutput = new CustomerDetailOutput();
		customerDetailOutput.setUserName(staffEntity.getFullName());
		customerDetailOutput.setCareCustomer(noteCareCustomer);
		customerDetailOutput.setGoAndSee(noteGotosee);
		return customerDetailOutput;
	}
	@Override
	public CustomerDTO save(CustomerDTO customerDTO) {
		CustomerEntity customerEntity = customerConverter.convertToEntity(customerDTO);
		Long id = customerRepository.save(customerEntity);
		CustomerDTO dto = customerConverter.convertToDto(customerRepository.findById(id));
		return dto;
	}
	@Override
	public CustomerDTO update(CustomerDTO customerDTO) {
		CustomerEntity updatecustomer = customerConverter.convertToEntity(customerDTO);
		CustomerEntity oldcustomer = customerRepository.findById(customerDTO.getId());
		updatecustomer.setModifiedBy(oldcustomer.getModifiedBy());
		updatecustomer.setModifiedDate(oldcustomer.getModifiedDate());
		customerRepository.update(updatecustomer);
		return customerDTO;
	}
	@Override
	public List<CustomerDTO> findAll() {
		List<CustomerEntity> customerEntities = customerRepository.findAll();
		List<CustomerDTO> results = customerEntities.stream().map(item -> customerConverter.convertToDto(item))
									.collect(Collectors.toList());
		return results;
	}
	@Override
	public void delete(long[] ids) {
		for (long item : ids) {
			String sqlTransaction = "DELTE FROM transaction WHERE customerId = "+ item+"";
			transactionRepository.delete(sqlTransaction);
			String sqlAssignment = "DELTE FROM assignmentcustomer WHERE customerId = "+ item+"";
			assignmentCustomerRepository.delete(sqlAssignment);
			customerRepository.delete(item);
			}
	}
	
	

}
