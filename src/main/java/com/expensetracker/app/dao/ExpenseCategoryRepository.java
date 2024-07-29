package com.expensetracker.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.expensetracker.app.dto.ExpenseCategoryData;
import com.expensetracker.app.dto.UserExpenseCategoryWiseData;

public interface ExpenseCategoryRepository extends JpaRepository<ExpenseCategoryData, Integer> {
	ExpenseCategoryData findByExpenseCategory(String category);
}
