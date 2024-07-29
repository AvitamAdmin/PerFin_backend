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
@Table(name = "income_categories")
public class UserIncomeCategoryWiseData {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id")
	private int incomeId;
	@Column(name = "category")
	private String category;
	@Column(name = "total")
	private double total;
	@OneToOne
	@JoinColumn(name="income_id",nullable=false)
	private IncomeCategoryData incomeCategoryData;
	@ManyToOne
	@JoinColumn(name="user_id",nullable=false)
	private UserData userData;

	public UserIncomeCategoryWiseData() {
		
	}

	public int getIncomeId() {
		return incomeId;
	}

//	public void setIncomeId(int incomeId) {
//		this.incomeId = incomeId;
//	}

	public UserIncomeCategoryWiseData(String category, double total) {
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
