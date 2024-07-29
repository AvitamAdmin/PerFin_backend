package com.expensetracker.app.dto;

import java.time.LocalDate;
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "user_expense")
public class UserTotalExpenseData {
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
	@JoinColumn(name="expense_id",nullable=false)
	private ExpenseCategoryData expenseCategoryData;
	@ManyToOne
	@JoinColumn(name="user_id",nullable=false)
	private UserData userData;

	public UserTotalExpenseData() {

	}

	public UserTotalExpenseData(String category, double amount, LocalDate now) {
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

	public ExpenseCategoryData getExpenseCategoryData() {
		return expenseCategoryData;
	}

	public void setExpenseCategoryData(ExpenseCategoryData expenseCategoryData) {
		this.expenseCategoryData = expenseCategoryData;
	}

	public UserData getUserData() {
		return userData;
	}

	public void setUserData(UserData userData) {
		this.userData = userData;
	}
}
