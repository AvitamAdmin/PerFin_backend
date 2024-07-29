package com.expensetracker.app.service;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import java.text.ParseException;
import java.time.LocalDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.expensetracker.app.dao.ModifyTotalExpenseDataRepository;
import com.expensetracker.app.dto.UserTotalExpenseData;

@Component
public class RecordSearchService {
	@Autowired
	ModifyTotalExpenseDataRepository modifyTotalExpenseDataRepository;
	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

	public ArrayList<UserTotalExpenseData> searchCurrentDayExpenses(String date) throws ParseException {
		LocalDate dateOfTheDay = LocalDate.parse(date, formatter);
		return modifyTotalExpenseDataRepository.findByDate(dateOfTheDay);
	}

	public ArrayList<UserTotalExpenseData> searchExpensesForThePeriod(String startDate, String endDate) {
		LocalDate fromDate = LocalDate.parse(startDate);
		LocalDate toDate = LocalDate.parse(endDate);
		return modifyTotalExpenseDataRepository.findByDate(fromDate, toDate);
	}
}
