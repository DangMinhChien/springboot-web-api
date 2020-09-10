package com.laptrinhjavaweb.api;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.laptrinhjavaweb.dto.TransactionDTO;
import com.laptrinhjavaweb.emun.Transaction;


@RestController
public class TransactionAPI {
	//Danh loại giao dich
	@GetMapping("/transaction")
	public List<TransactionDTO> getTransaction() {	
		List<TransactionDTO> result = new ArrayList<TransactionDTO>();
		 for (Transaction t : Transaction.values()) {
			 TransactionDTO transactionDTO = new TransactionDTO();
			 transactionDTO.setCode(t.name());
			 transactionDTO.setName(t.getName());
			 result.add(transactionDTO);
	        }
		return result;
	}
}
