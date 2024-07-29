package com.expensetracker.app.service;

import javax.management.relation.Role;
import java.util.List;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.expensetracker.app.dao.UserRepository;
import com.expensetracker.app.dto.UserData;

@Component
public class UserService {
	@Autowired
	UserRepository userDao;
	@Autowired
	PasswordEncoder passwordEncoder;

	public void registerUser(UserData userData) {
		userData.setPassword(passwordEncoder.encode(userData.getPassword()));
		userDao.save(userData);
	}

}
