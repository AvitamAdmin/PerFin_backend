package com.expensetracker.app.service;

import com.expensetracker.app.dao.UserRepository;
import com.expensetracker.app.dto.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class UserInfoUserDetailsService implements UserDetailsService {

	@Autowired
	private UserRepository repository;

	@Override
	public UserData loadUserByUsername(String username) throws UsernameNotFoundException {
		UserData userInfo = repository.findByEmail(username);
		return (userInfo == null) ? null : userInfo;

	}
}