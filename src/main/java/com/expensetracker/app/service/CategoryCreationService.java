package com.expensetracker.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import com.expensetracker.app.dto.ExpenseCategoryData;
import com.expensetracker.app.dto.IncomeCategoryData;
import org.springframework.stereotype.Component;

import com.expensetracker.app.dao.ExpenseCategoryRepository;
import com.expensetracker.app.dao.IncomeCategoryRepository;
import com.expensetracker.app.dto.UserExpenseCategoryWiseData;
import com.expensetracker.app.dto.UserIncomeCategoryWiseData;

@Component
public class CategoryCreationService {
	@Autowired
	ExpenseCategoryRepository expenseCategoryDao;
	@Autowired
	IncomeCategoryRepository incomeCategoryDao;
	ExpenseCategoryData expenseCategoryData = new ExpenseCategoryData();
	IncomeCategoryData incomeCategoryData = new IncomeCategoryData();

	public void createCategory(String type, String category) {
		if (type.equals("expense")) {
			expenseCategoryData.setExpenseCategory(category);
			expenseCategoryDao.save(expenseCategoryData);
		} else {
			incomeCategoryData.setIncomeCategory(category);
			incomeCategoryDao.save(incomeCategoryData);
		}
	}
}
