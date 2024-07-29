package com.expensetracker.app.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.expensetracker.app.dto.UserData;

public interface UserRepository extends JpaRepository<UserData, Integer> {
	UserData findByEmail(String email);

	Optional<UserData> findByFirstName(String username);

}
