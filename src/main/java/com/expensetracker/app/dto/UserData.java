package com.expensetracker.app.dto;

import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import jakarta.persistence.CascadeType;

//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "user")
public class UserData  implements UserDetails
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	int id;
	@Column(name = "first_name")
	private String firstName;
	@Column(name = "last_name")
	private String lastName;
	@Column(name = "email")
	private String email;
	@Column(name = "password")
	private String password;
	@Column(name = "role")
	private String roles;
	@ManyToOne
	private CurrencyData currency;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "userData")
	private List<UserTotalExpenseData> userTotalExpenseDatum;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "userData")
	private List<UserExpenseCategoryWiseData> userExpenseCategoryWiseDatum;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "userData")
	private List<UserTotalIncomeData> userTotalIncomeDatum;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "userData")
	private List<UserExpenseCategoryWiseData> userIncomeCategoryWiseDatum;

	public UserData() {

	}

	public UserData(int id, String firstName, String lastName, String email, String password) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
	}

	public int getId() {
		return id;
	}

//	public void setId(int id) {
//		this.id = id;
//	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRoles() {
		return roles;
	}

	public void setRoles(String roles) {
		this.roles = roles;
	}

	public CurrencyData getCurrency() {
		return currency;
	}

	public void setCurrency(CurrencyData currency) {
		this.currency = currency;
	}

	public List<UserTotalExpenseData> getUserTotalExpenseDatum() {
		return userTotalExpenseDatum;
	}

	public void setUserTotalExpenseDatum(List<UserTotalExpenseData> userTotalExpenseDatum) {
		this.userTotalExpenseDatum = userTotalExpenseDatum;
	}

	public List<UserExpenseCategoryWiseData> getUserExpenseCategoryWiseDatum() {
		return userExpenseCategoryWiseDatum;
	}

	public void setUserExpenseCategoryWiseDatum(List<UserExpenseCategoryWiseData> userExpenseCategoryWiseDatum) {
		this.userExpenseCategoryWiseDatum = userExpenseCategoryWiseDatum;
	}

	public List<UserTotalIncomeData> getUserTotalIncomeDatum() {
		return userTotalIncomeDatum;
	}

	public void setUserTotalIncomeDatum(List<UserTotalIncomeData> userTotalIncomeDatum) {
		this.userTotalIncomeDatum = userTotalIncomeDatum;
	}

	public List<UserExpenseCategoryWiseData> getUserIncomeCategoryWiseDatum() {
		return userIncomeCategoryWiseDatum;
	}

	public void setUserIncomeCategoryWiseDatum(List<UserExpenseCategoryWiseData> userIncomeCategoryWiseDatum) {
		this.userIncomeCategoryWiseDatum = userIncomeCategoryWiseDatum;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

}
