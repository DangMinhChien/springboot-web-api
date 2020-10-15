package com.laptrinhjavaweb.converter;

import org.modelmapper.ModelMapper;

import com.laptrinhjavaweb.dto.output.UserOutput;
import com.laptrinhjavaweb.entity.StaffEntity;

public class UsersConverter {
	ModelMapper modelMapper = new ModelMapper();

	public UserOutput convertToDto(StaffEntity entity) {
		UserOutput dto = modelMapper.map(entity, UserOutput.class);
		return dto;
	}

	public StaffEntity convertToEntity(UserOutput dto) {
		StaffEntity entity = modelMapper.map(dto, StaffEntity.class);
		return entity;
	}
}
