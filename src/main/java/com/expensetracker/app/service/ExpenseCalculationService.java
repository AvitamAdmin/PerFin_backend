package com.expensetracker.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import com.expensetracker.app.dto.*;
import com.expensetracker.app.dao.ExpenseCategoryRepository;
import com.expensetracker.app.dao.ModifyTotalExpenseDataRepository;
import com.expensetracker.app.dao.UserRepository;

import java.time.format.DateTimeFormatter;
import java.time.LocalDate;

@Component
public class ExpenseCalculationService {
	@Autowired
	ModifyTotalExpenseDataRepository modifyTotalExpenseDataRepository;
	@Autowired
	ExpenseCategoryRepository expenseCategoryRepository;
	@Autowired
	UserRepository userRepository;
	UserTotalExpenseData userTotalExpenseData;

	public void calculateTotalExpense(String category, double amount, String email) {
		userTotalExpenseData = new UserTotalExpenseData();
		this.userTotalExpenseData.setCategory(category);
		this.userTotalExpenseData.setAmount(amount);
		this.userTotalExpenseData.setDate(LocalDate.now());
		this.userTotalExpenseData.setExpenseCategoryData(expenseCategoryRepository.findByExpenseCategory(category));
		this.userTotalExpenseData.setUserData(userRepository.findByEmail(email));
		// this.userTotalExpenseData.setUserData(userRepository.findByEmail(user.getEmail()));
		modifyTotalExpenseDataRepository.save(userTotalExpenseData);
	}

}
