package com.laptrinhjavaweb.api;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.laptrinhjavaweb.dto.output.Enum;
import com.laptrinhjavaweb.emun.Transaction;


@RestController
public class TransactionAPI {
	//Danh loại giao dich
	@GetMapping("/transaction")
	public List<Enum> getTransaction() {	
		List<Enum> result = new ArrayList<Enum>();
		 for (Transaction t : Transaction.values()) {
			 Enum enum1 = new Enum();
			 enum1.setCode(t.name());
			 enum1.setName(t.getName());
			 result.add(enum1);
	        }
		return result;
	}
}
