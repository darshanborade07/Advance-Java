package com.sunbeam.services;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sunbeam.DAO.UserDao;
import com.sunbeam.DTO.ApiResponse;
import com.sunbeam.entities.User;

@Service
@Transactional
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;
	
	@Override
	public ApiResponse addUser(User user) {
		userDao.save(user);
		return new ApiResponse("New User Added!!!s");
	}

	

}
