package com.laptrinhjavaweb.service;

import java.util.List;

import com.laptrinhjavaweb.dto.output.UserOutput;

public interface IUserService {
	List<UserOutput> findAllUser(Long buildingId , String staff);
}
