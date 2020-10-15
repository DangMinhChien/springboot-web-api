package com.laptrinhjavaweb.api;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.laptrinhjavaweb.dto.CustomerDTO;
import com.laptrinhjavaweb.dto.input.AssignmentCustomerInput;
import com.laptrinhjavaweb.dto.input.CustomerDetailInput;
import com.laptrinhjavaweb.dto.output.CustomerDetailOutput;
import com.laptrinhjavaweb.service.IAssignmentCustomerService;
import com.laptrinhjavaweb.service.ICustomerService;
import com.laptrinhjavaweb.service.impl.AssignmentCustomerServiceImpl;
import com.laptrinhjavaweb.service.impl.CustomerServiceImpl;

@RestController
public class CustomerAPI {
	private ICustomerService customerService = new CustomerServiceImpl();
	private IAssignmentCustomerService assignmentCustomerService = new AssignmentCustomerServiceImpl();

	// Giao khách hàng cho nhân viên 
		@PostMapping("/customer/assignment")
		public Boolean assignmentCustomer(@RequestBody AssignmentCustomerInput assignmentCustomerInput) {
			return assignmentCustomerService.assignmentCustomer(assignmentCustomerInput);
		}
		
	//Chi tiết khách hàng
		@PostMapping("/customer/detail")
		public CustomerDetailOutput getCustomerDetail(@RequestBody CustomerDetailInput customerDetailInput) {
			return customerService.getCustomerDetail(customerDetailInput);
		}
		
		// Thêm khách hàng
		@PostMapping("/customer")
		public CustomerDTO addCustomer(@RequestBody CustomerDTO customerDTO) {
			return customerService.save(customerDTO);
		}

		// Sửa thông tin khách hàng
		@PutMapping("/customers/")
		public CustomerDTO updateCustomer(@RequestBody CustomerDTO customerDTO) {
			return customerService.update(customerDTO);
		}

		// Delete xóa khách hàng
		@DeleteMapping(value = "/customers")
		public void deleteNew(@RequestBody long[] ids) {
			customerService.delete(ids);
		}
		
}
