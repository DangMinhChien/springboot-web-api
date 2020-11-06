package com.laptrinhjavaweb.service.impl;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

//
//import java.util.List;
//import java.util.stream.Collectors;
//
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.laptrinhjavaweb.buider.CustomerSearchBuilder;
import com.laptrinhjavaweb.converter.CustomerConverter;
import com.laptrinhjavaweb.dto.CustomerDTO;
import com.laptrinhjavaweb.dto.input.AssignmentCustomerInput;
import com.laptrinhjavaweb.dto.input.CustomerDetailInput;
import com.laptrinhjavaweb.dto.output.CustomerDetailOutput;
import com.laptrinhjavaweb.entity.CustomerEntity;
import com.laptrinhjavaweb.entity.TransactionEntity;
import com.laptrinhjavaweb.entity.UserEntity;
import com.laptrinhjavaweb.repository.ICustomerRepository;
import com.laptrinhjavaweb.repository.ITransactionRepository;
import com.laptrinhjavaweb.repository.UserRepository;
import com.laptrinhjavaweb.service.ICustomerService;
@Service
public class CustomerServiceImpl implements ICustomerService {
	
	@Autowired
	private UserRepository  userRepository ;
	
	@Autowired
	private ITransactionRepository  transactionRepository ;
	
	@Autowired
	private CustomerConverter  customerConverter ;
	
	@Autowired
	private ICustomerRepository  customerRepository ;
	
	@Override
	public List<CustomerDTO> getCustomers(CustomerSearchBuilder customerSearchBuilder) {
		List<CustomerEntity> customerEntities = customerRepository.getCustomers(customerSearchBuilder);
		List<CustomerDTO> results = customerEntities.stream().map(item -> customerConverter.convertToDto(item))
				.collect(Collectors.toList());
		return results;
	}

	@Transactional
	@Override
	public CustomerDetailOutput getCustomerDetail(CustomerDetailInput customerDetailInput) {
		List<TransactionEntity> listTransactionCSKH = transactionRepository.findByCodeAndCustomer_Id("QUA_TRINH_CSKH", customerDetailInput.getCustomerId());
		List<TransactionEntity> listTransactionGO = transactionRepository.findByCodeAndCustomer_Id("DAN_DI_XEM", customerDetailInput.getCustomerId());
		UserEntity userEntity = userRepository.findOne(customerDetailInput.getCustomerId());
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
	@Override
	public CustomerDTO save(CustomerDTO customerDTO) {
		CustomerEntity customerEntity = customerConverter.convertToEntity(customerDTO);
		customerEntity = customerRepository.save(customerEntity);
		CustomerDTO dto = customerConverter.convertToDto(customerEntity);
		return dto;
	}
	@Override
	public CustomerDTO update(CustomerDTO customerDTO) {
		CustomerEntity updatecustomer = customerConverter.convertToEntity(customerDTO);
		CustomerEntity oldcustomer = customerRepository.findOne(customerDTO.getId());
		updatecustomer.setModifiedBy(oldcustomer.getModifiedBy());
		updatecustomer.setModifiedDate(oldcustomer.getModifiedDate());
		customerRepository.save(updatecustomer);
		return customerDTO;
	}
	
	@Override
	public void delete(long[] ids) {
		for (long id : ids) {
			List<TransactionEntity> transactionEntities = transactionRepository.findByCustomer_Id(id);
			for (TransactionEntity transactionEntity : transactionEntities) {
				transactionRepository.delete(transactionEntity);
			}
			customerRepository.deleteAssignmentCustomerByIdNative(id);
			customerRepository.delete(id);
			}
	}

	@Transactional
	@Override
	public void assignmentCustomer(AssignmentCustomerInput assignmentCustomerInput	) {
		List<UserEntity> userEntities = userRepository
				.findByUsersCustomer_IdAndRole_Id(assignmentCustomerInput.getCustomerId(), "staff");
		List<Long> oldUsers = new ArrayList<>();
		for (UserEntity userEntity : userEntities) {
			oldUsers.add(userEntity.getId());
		}
		List<Long> newUsers = new ArrayList<>();
		Long[] ids = assignmentCustomerInput.getStaff();
		for (int i = 0; i < ids.length; i++) {
			newUsers.add(ids[i]);
		}
		List<Long> checkedUsers = getIsCheckedUsers(oldUsers, newUsers);
		List<Long> uncheckedUsers = getIsUncheckedUsers(oldUsers, newUsers);
		if (!uncheckedUsers.isEmpty()) {
			for (Long staffId : uncheckedUsers) {
				customerRepository.deleteAssignmentByCustomerIdAndStaffIdNative(assignmentCustomerInput.getCustomerId(), staffId);
			}
		}
		if (!checkedUsers.isEmpty()) {
			for (Long staffId : checkedUsers) {
				customerRepository.insertAssignment(assignmentCustomerInput.getCustomerId(), staffId);
			}
		}
	}

	private List<Long> getIsCheckedUsers(List<Long> oldUsers, List<Long> newUsers) {
		List<Long> result = new ArrayList<>();
		for (Long newobj : newUsers) {
			if (!oldUsers.contains(newobj)) {
				result.add(newobj);
			}
		}
		return result;
	}

	private List<Long> getIsUncheckedUsers(List<Long> oldUsers, List<Long> newUsers) {
		List<Long> result = new ArrayList<>();
		for (Long oldobj : oldUsers) {
			if (!newUsers.contains(oldobj)) {
				result.add(oldobj);
			}
		}
		return result;
	}
	
	

}
