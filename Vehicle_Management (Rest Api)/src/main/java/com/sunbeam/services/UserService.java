package com.sunbeam.services;

import com.sunbeam.DTO.ApiResponse;
import com.sunbeam.entities.User;

public interface UserService {
	ApiResponse addUser(User user);
}
