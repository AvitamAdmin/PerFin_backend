package com.expensetracker.app.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.expensetracker.app.dto.UserData;
import com.expensetracker.app.dto.UserInfoUserDetails;

@RestController
public class TestController {
	@GetMapping(value = "/")
	public String test() {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		UserInfoUserDetails user =  (UserInfoUserDetails) auth.getPrincipal();
		System.out.println(user.getEmail());
		return "testHome-committest";
	}
}
