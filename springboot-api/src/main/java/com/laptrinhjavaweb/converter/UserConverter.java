package com.laptrinhjavaweb.converter;

import org.modelmapper.ModelMapper;

import com.laptrinhjavaweb.dto.output.UserOutput;
import com.laptrinhjavaweb.entity.UserEntity;

public class UserConverter {
	ModelMapper modelMapper = new ModelMapper();

	public UserOutput convertToDto(UserEntity entity) {
		UserOutput dto = modelMapper.map(entity, UserOutput.class);
		return dto;
	}

	public UserEntity convertToEntity(UserOutput dto) {
		UserEntity entity = modelMapper.map(dto, UserEntity.class);
		return entity;
	}
}
