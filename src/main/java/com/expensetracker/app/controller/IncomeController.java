package com.expensetracker.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.expensetracker.app.service.IncomeCalculationService;

@RestController

public class IncomeController {
	@Autowired
	private IncomeCalculationService incomeCalculationService;

	@PostMapping("/income")
	@ResponseBody
	public void income(@RequestParam String category, @RequestParam double amount) {
		incomeCalculationService.calculateTotalIncome(category, amount);
	}
}
