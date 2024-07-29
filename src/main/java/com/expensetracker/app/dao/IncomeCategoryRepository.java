package com.expensetracker.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.expensetracker.app.dto.IncomeCategoryData;
import com.expensetracker.app.dto.UserIncomeCategoryWiseData;

public interface IncomeCategoryRepository extends JpaRepository<IncomeCategoryData, Integer> {
	IncomeCategoryData findByIncomeCategory(String category);
}
