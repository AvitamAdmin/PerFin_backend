package com.expensetracker.app.dto;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "income_categories")
public class IncomeCategoryData {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private int incomeCategoryId;
	@Column(name = "income_category")
	private String incomeCategory;
	@OneToOne(cascade = CascadeType.ALL, mappedBy = "incomeCategoryData")
	private UserIncomeCategoryWiseData userIncomeCategoryWiseData;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "incomeCategoryData")
	private List<UserTotalIncomeData> userTotalIncomeDatum;

	public int getIncomeCategoryId() {
		return incomeCategoryId;
	}

//	public void setIncomeCategoryId(int incomeCategoryId) {
//		this.incomeCategoryId = incomeCategoryId;
//	}

	public String getIncomeCategory() {
		return incomeCategory;
	}

	public void setIncomeCategory(String incomeCategory) {
		this.incomeCategory = incomeCategory;
	}

	

	public UserIncomeCategoryWiseData getUserIncomeCategoryWiseData() {
		return userIncomeCategoryWiseData;
	}

	public void setUserIncomeCategoryWiseData(UserIncomeCategoryWiseData userIncomeCategoryWiseData) {
		this.userIncomeCategoryWiseData = userIncomeCategoryWiseData;
	}

	public List<UserTotalIncomeData> getUserTotalIncomeDatum() {
		return userTotalIncomeDatum;
	}

	public void setUserTotalIncomeDatum(List<UserTotalIncomeData> userTotalIncomeDatum) {
		this.userTotalIncomeDatum = userTotalIncomeDatum;
	}
}
