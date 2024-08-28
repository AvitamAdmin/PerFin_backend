package com.expensetracker.app.controller;

import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.expensetracker.app.dto.UserData;
import com.expensetracker.app.service.UserService;

@RestController
public class RegistrationController {
	@Autowired
	UserService userService;

	@PostMapping(value = "/register")
	public String registerUser(@ModelAttribute UserData user) {
		userService.registerUser(user);
		return "registration successful";
	}
}
