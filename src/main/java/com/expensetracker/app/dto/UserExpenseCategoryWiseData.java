package com.expensetracker.app.dto;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "user_expense_categories")
public class UserExpenseCategoryWiseData {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id")
	private int expenseId;
	@Column(name = "category")
	private String category;
	@Column(name = "total")
	private double total;
	@OneToOne
	@JoinColumn(name="expense_id",nullable=false)
	private ExpenseCategoryData expenseCategoryData;
	@ManyToOne
	@JoinColumn(name="user_id",nullable=false)
	private UserData userData;

	public int getExpenseId() {
		return expenseId;
	}

//	public void setExpenseId(int expenseId) {
//		this.expenseId = expenseId;
//	}

	public UserExpenseCategoryWiseData() {

	}

	public UserExpenseCategoryWiseData(String category, double total) {
		super();
		this.category = category;
		this.total = total;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
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
