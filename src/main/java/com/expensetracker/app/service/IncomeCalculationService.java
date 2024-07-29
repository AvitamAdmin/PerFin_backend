package com.expensetracker.app.service;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import com.expensetracker.app.dao.IncomeCategoryRepository;
import com.expensetracker.app.dao.ModifyTotalIncomeDataRepository;
import com.expensetracker.app.dao.UserRepository;
import com.expensetracker.app.dto.UserIncomeCategoryWiseData;
import com.expensetracker.app.dto.UserInfoUserDetails;
import com.expensetracker.app.dto.UserTotalIncomeData;

@Component
public class IncomeCalculationService {
	@Autowired
	ModifyTotalIncomeDataRepository modifyTotalIncomeDataRepository;
	@Autowired
	IncomeCategoryRepository incomeCategoryRepository;
	@Autowired
	UserRepository userRepository;
	UserTotalIncomeData userTotalIncomeData;
	UserIncomeCategoryWiseData userIncomeCategoryWiseData;

	public void calculateTotalIncome(String category, double amount) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		UserInfoUserDetails user = (UserInfoUserDetails) auth.getPrincipal();
		this.userTotalIncomeData.setCategory(category);
		this.userTotalIncomeData.setAmount(amount);
		this.userTotalIncomeData.setDate(LocalDate.now());
		this.userTotalIncomeData.setIncomeCategoryData(incomeCategoryRepository.findByIncomeCategory(category));
		this.userTotalIncomeData.setUserData(userRepository.findByEmail("hari@avitam.in"));
		// this.userTotalIncomeData.setUserData(userRepository.findByEmail(user.getEmail()));
		modifyTotalIncomeDataRepository.save(userTotalIncomeData);

	}

}
