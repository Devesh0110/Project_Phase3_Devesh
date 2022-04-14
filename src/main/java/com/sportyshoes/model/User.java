package com.sportyshoes.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "user")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int userId;

	@Column(name = "name")
	private String userName;

	@Column(name = "email")
	private String userEmail;

	@Column(name = "password")
	private String userPassword;

	@ManyToMany(fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	@JoinTable(name = "USER_PRODUCT", joinColumns = @JoinColumn(name = "USER_ID"), inverseJoinColumns = @JoinColumn(name = "PRODUCT_ID"))
	private List<Product> products = new ArrayList<Product>();

	public User(String userName, String userEmail) {
		this.userEmail = userEmail;
		this.userName = userName;
	}

	public void addProduct(Product product) {
		this.products.add(product);
	}
	
	@Override
	public String toString() {
		return "Custom ToString -> User [userId=" + userId + ", userName=" + userName + ", userEmail=" + userEmail + ", userPassword="
				+ userPassword + ", products=" + products + "]";
	}

	public String getUserName() {
		// TODO Auto-generated method stub
		return userName;
	}

	public String getUserEmail() {
		// TODO Auto-generated method stub
		return userEmail;
	}

	public void setUserPassword(String s) {
		// TODO Auto-generated method stub
		userPassword=s;
	}

	public void setUserName(String n) {
		// TODO Auto-generated method stub
		userName=n;
	}

	

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public User(int userId, String userName, String userEmail, String userPassword, List<Product> products) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.userEmail = userEmail;
		this.userPassword = userPassword;
		this.products = products;
	}

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

}
