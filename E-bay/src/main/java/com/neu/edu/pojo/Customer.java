package com.neu.edu.pojo;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
public class Customer {

	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int customerID;
	
	@Column
	@NotEmpty
	private String fname;
	@Column
	private String lname;
	
	@Column
	private Long phoneNumber;
	
	@Column(unique = true)
	@NotEmpty
	private String userName;
	
	@Column
	@NotEmpty
	@Size(min=8)
	private String password;
	
	private String role;
	
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	List<Orders> orders;
	
	public List<Orders> getOrder() {
		return orders;
	}
	public void setOrder(List<Orders> orders) {
		this.orders = orders;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public void setCustomerID(int customerID) {
		this.customerID = customerID;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	public void setPhoneNumber(Long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public int getCustomerID() {
		return customerID;
	}
	public String getFname() {
		return fname;
	}
	public String getLname() {
		return lname;
	}
	public Long getPhoneNumber() {
		return phoneNumber;
	}
	
	
	
}
