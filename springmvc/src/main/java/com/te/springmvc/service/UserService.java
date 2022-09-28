package com.te.springmvc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.te.springmvc.User;
import com.te.springmvc.repository.UserRepo;

@Service
public class UserService {
	@Autowired
	UserRepo repo;

	public boolean check(User user) {
		if (user.getPassword().equals(user.getRetype_password())) {
          repo.saveUser(user);
          return true;
		}
		return false;
	}
}
