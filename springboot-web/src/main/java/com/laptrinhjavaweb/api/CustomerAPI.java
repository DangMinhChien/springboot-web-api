package com.laptrinhjavaweb.api;

import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.laptrinhjavaweb.buider.CustomerSearchBuilder;
import com.laptrinhjavaweb.dto.CustomerDTO;
import com.laptrinhjavaweb.dto.input.AssignmentCustomerInput;
import com.laptrinhjavaweb.dto.input.CustomerDetailInput;
import com.laptrinhjavaweb.dto.output.CustomerDetailOutput;
import com.laptrinhjavaweb.service.ICustomerService;

@RestController
public class CustomerAPI {
	@Autowired
	ICustomerService customerService;


	// Giao khách hàng cho nhân viên
	@PostMapping("/customer/assignment")
	public void assignmentCustomer(@RequestBody AssignmentCustomerInput assignmentCustomerInput) {
		customerService.assignmentCustomer(assignmentCustomerInput);
	}

	// Giao dịch nhân viên và khách hàng
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

	// Tìm kiếm
	@GetMapping("/customers")
	public List<CustomerDTO> getCustomer(@RequestParam Map<String, String> requestParams,
			@RequestParam String[] types) {
		CustomerSearchBuilder builder = convertMapToBuilder(requestParams, types);
		return customerService.getCustomers(builder);
	}

	private CustomerSearchBuilder convertMapToBuilder(Map<String, String> requestParams, String[] types) {
		Long staffId = requestParams.containsKey("staffId")
				? (StringUtils.isNotBlank(requestParams.get("staffId")) ? Long.parseLong(requestParams.get("staffId"))
						: null)
				: null;

		CustomerSearchBuilder buider = CustomerSearchBuilder.builder()
				.name(requestParams.containsKey("name") ? requestParams.get("name") : null)
				.email(requestParams.containsKey("email") ? requestParams.get("email") : null)
				.phone(requestParams.containsKey("phone") ? requestParams.get("phone") : null).staffId(staffId).build();
		return buider;
	}

}
