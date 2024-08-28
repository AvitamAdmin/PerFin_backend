package com.expensetracker.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.expensetracker.app.dto.JwtRequest;
import com.expensetracker.app.dto.JwtResponse;
import com.expensetracker.app.dto.UserData;
import com.expensetracker.app.dto.UserInfoUserDetails;
import com.expensetracker.app.service.UserInfoUserDetailsService;
import com.expensetracker.app.utility.JWTUtility;

@RestController
public class TestController {
	@Autowired
	private JWTUtility jwtUtility;

	@Autowired
	private AuthenticationProvider authenticationManager;

	@Autowired
	private UserInfoUserDetailsService userInfoUserDetailsService;

	@GetMapping(value = "/")
	public String test() {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		UserInfoUserDetails user = (UserInfoUserDetails) auth.getPrincipal();
		System.out.println(user.getEmail());
		return "testHome-vignesh-commit";
	}
//	@GetMapping("/token")
//	public JwtResponse getToken() {
//		final UserData userDetails = (UserData) userInfoUserDetailsService.loadUserByUsername(jwtRequest.getUsername());
//		final String token = jwtUtility.generateToken(userDetails);
//		return new JwtResponse(token);
//	}

	@PostMapping("/authenticate")
	public JwtResponse authenticate(@RequestBody JwtRequest jwtRequest) throws Exception {

		try {
			authenticationManager.authenticate(
					new UsernamePasswordAuthenticationToken(jwtRequest.getEmail(), jwtRequest.getPassword()));
		} catch (BadCredentialsException e) {
			throw new Exception("INVALID_CREDENTIALS", e);
		}

		final UserData userDetails = userInfoUserDetailsService.loadUserByUsername(jwtRequest.getEmail());

		final String token = jwtUtility.generateToken(userDetails);

		return new JwtResponse(token);
	}
}
