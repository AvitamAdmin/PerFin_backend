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
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "expense_categories")
public class ExpenseCategoryData {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private int expenseCategoryId;
	@Column(name = "expense_category")
	private String expenseCategory;
	@OneToOne(cascade = CascadeType.ALL, mappedBy = "expenseCategoryData")
	private UserExpenseCategoryWiseData userExpenseCategoryWiseData;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "expenseCategoryData")
	private List<UserTotalExpenseData> userTotalExpenseDatum;

	public int getExpenseCategoryId() {
		return expenseCategoryId;
	}

//	public void setExpenseCategoryId(int expenseCategoryId) {
//		this.expenseCategoryId = expenseCategoryId;
//	}

	public String getExpenseCategory() {
		return expenseCategory;
	}

	public void setExpenseCategory(String expenseCategory) {
		this.expenseCategory = expenseCategory;
	}

	

	public UserExpenseCategoryWiseData getUserExpenseCategoryWiseData() {
		return userExpenseCategoryWiseData;
	}

	public void setUserExpenseCategoryWiseData(UserExpenseCategoryWiseData userExpenseCategoryWiseData) {
		this.userExpenseCategoryWiseData = userExpenseCategoryWiseData;
	}

	public List<UserTotalExpenseData> getUserTotalExpenseDatum() {
		return userTotalExpenseDatum;
	}

	public void setUserTotalExpenseDatum(List<UserTotalExpenseData> userTotalExpenseDatum) {
		this.userTotalExpenseDatum = userTotalExpenseDatum;
	}
}