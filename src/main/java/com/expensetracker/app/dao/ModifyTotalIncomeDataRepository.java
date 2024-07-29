package com.expensetracker.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.expensetracker.app.dto.UserTotalIncomeData;

@Repository
public interface ModifyTotalIncomeDataRepository extends JpaRepository<UserTotalIncomeData, Integer> {

}
