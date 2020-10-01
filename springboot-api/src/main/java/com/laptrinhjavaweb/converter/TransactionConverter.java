package com.laptrinhjavaweb.converter;

import org.modelmapper.ModelMapper;

import com.laptrinhjavaweb.dto.TransactionDTO;
import com.laptrinhjavaweb.entity.TransactionEntity;

public class TransactionConverter {
	ModelMapper modelMapper = new ModelMapper();

	public TransactionDTO convertToDto(TransactionEntity entity) {
		TransactionDTO dto = modelMapper.map(entity, TransactionDTO.class);
		return dto;
	}

	public TransactionEntity convertToEntity(TransactionDTO dto) {
		TransactionEntity entity = modelMapper.map(dto, TransactionEntity.class);
		return entity;
	}
}
