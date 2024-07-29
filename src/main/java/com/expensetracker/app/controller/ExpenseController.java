package com.expensetracker.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.expensetracker.app.dao.ExpenseCategoryRepository;
import com.expensetracker.app.service.ExpenseCalculationService;

@RestController

public class ExpenseController {
	@Autowired
	private ExpenseCalculationService expenseCalculationService;
	@Autowired
	private ExpenseCategoryRepository expenseCategoryRepository;

	@PostMapping("/expense")
	@ResponseBody
	public void expense(@RequestParam String category,@RequestParam Double amount) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		Object user = auth.getPrincipal();
		System.out.println(user);
		expenseCalculationService.calculateTotalExpense(category,amount);
	}
	
	
	

}
