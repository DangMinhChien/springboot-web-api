package com.laptrinhjavaweb.converter;

import org.modelmapper.ModelMapper;

import com.laptrinhjavaweb.dto.CustomerDTO;
import com.laptrinhjavaweb.entity.CustomerEntity;

public class CustomerConverter {
	ModelMapper modelMapper = new ModelMapper();

	public CustomerDTO convertToDto(CustomerEntity entity) {
		CustomerDTO dto = modelMapper.map(entity, CustomerDTO.class);
		return dto;
	}

	public CustomerEntity convertToEntity(CustomerDTO dto) {
		CustomerEntity entity = modelMapper.map(dto, CustomerEntity.class);
		return entity;
	}
}
