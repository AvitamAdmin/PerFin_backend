package com.expensetracker.app.dao;

import java.time.LocalDate;
import java.util.ArrayList;

import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.expensetracker.app.dto.UserTotalExpenseData;

@Repository
public interface ModifyTotalExpenseDataRepository extends JpaRepository<UserTotalExpenseData, Integer> {
	ArrayList<UserTotalExpenseData> findByDate(LocalDate entryDate);
	@Modifying
	@Query(value="SELECT * FROM user_expense WHERE date>= :startDate AND date< :endDate",nativeQuery=true)
	ArrayList<UserTotalExpenseData> findByDate(@Param("startDate")LocalDate startDate,@Param("endDate")LocalDate endDate);
}
