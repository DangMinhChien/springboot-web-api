  
package com.laptrinhjavaweb.service;

import java.util.Map;

import com.laptrinhjavaweb.dto.UserDTO;

public interface IUserService {
    UserDTO findOneByUserNameAndStatus(String name, int status);
    Map<Long, String> getStaffMaps();
}