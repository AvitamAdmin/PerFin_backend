package com.expensetracker.app.dto;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "user_income")
public class UserTotalIncomeData {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id")
	int id;
	@Column(name = "category")
	private String category;
	@Column(name = "amount")
	private double amount;
	@Column(name = "date")
	private LocalDate date;
	@ManyToOne
	@JoinColumn(name="income_id",nullable=false)
	private IncomeCategoryData incomeCategoryData;
	@ManyToOne
	@JoinColumn(name="user_id",nullable=false)
	private UserData userData;

	public UserTotalIncomeData(String category, double amount, LocalDate now) {
		super();
		this.category = category;
		this.amount = amount;
		this.date = now;
	}

	public int getId() {
		return id;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public IncomeCategoryData getIncomeCategoryData() {
		return incomeCategoryData;
	}

	public void setIncomeCategoryData(IncomeCategoryData incomeCategoryData) {
		this.incomeCategoryData = incomeCategoryData;
	}

	public UserData getUserData() {
		return userData;
	}

	public void setUserData(UserData userData) {
		this.userData = userData;
	}
}
