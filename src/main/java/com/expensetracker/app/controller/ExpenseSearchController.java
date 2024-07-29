package com.expensetracker.app.controller;

import java.text.ParseException;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.expensetracker.app.dto.UserTotalExpenseData;
import com.expensetracker.app.service.RecordSearchService;

@RestController
@RequestMapping(value = "/searchExpenses", method = RequestMethod.POST)
public class ExpenseSearchController {
	@Autowired
	RecordSearchService recordSearchService;

	@GetMapping("/{startDate}")
	@ResponseBody
	public ArrayList<UserTotalExpenseData> searchCurrentDayRecords(@PathVariable String startDate) throws ParseException {
		return recordSearchService.searchCurrentDayExpenses(startDate);

	}
	
	@GetMapping("/{startDate}/{endDate}")
	@ResponseBody
	public ArrayList<UserTotalExpenseData> searchRecordsForTheInterval(@PathVariable String startDate,@PathVariable String endDate){
		return recordSearchService.searchExpensesForThePeriod(startDate, endDate);
	}
}
