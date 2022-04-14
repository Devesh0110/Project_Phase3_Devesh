package com.sportyshoes.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "purchasereport2")
public class PurchaseReport {


	public PurchaseReport() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	

	@Column(name = "product_name")
	private String productName;
	
	@Column(name = "category_of_product")
	private String categoryOfProduct;
	

	@Column(name = "price_of_the_product")
	private int priceOfTheProduct;

	@Column(name = "user_who_bought_the_product")
	private String userWhoBoughtTheProduct;
	
	@Column(name = "user_email_who_bought_the_product")
	private String userEmailBoughtTheProduct;

	@Temporal(TemporalType.DATE)
	private Date dateOfProductPurchase;

	public PurchaseReport(String productName, String categoryOfProduct, int priceOfTheProduct, String userWhoBoughtTheProduct, String userEmailBoughtTheProduct, Date dateOfProductPurchase) {
		this.productName = productName;
		this.categoryOfProduct = categoryOfProduct;
		this.priceOfTheProduct = priceOfTheProduct;
		this.userWhoBoughtTheProduct = userWhoBoughtTheProduct;
		this.dateOfProductPurchase = dateOfProductPurchase;
		this.userEmailBoughtTheProduct = userEmailBoughtTheProduct;
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getCategoryOfProduct() {
		return categoryOfProduct;
	}

	public void setCategoryOfProduct(String categoryOfProduct) {
		this.categoryOfProduct = categoryOfProduct;
	}

	public int getPriceOfTheProduct() {
		return priceOfTheProduct;
	}

	public void setPriceOfTheProduct(int priceOfTheProduct) {
		this.priceOfTheProduct = priceOfTheProduct;
	}

	public String getUserWhoBoughtTheProduct() {
		return userWhoBoughtTheProduct;
	}

	public void setUserWhoBoughtTheProduct(String userWhoBoughtTheProduct) {
		this.userWhoBoughtTheProduct = userWhoBoughtTheProduct;
	}

	public String getUserEmailBoughtTheProduct() {
		return userEmailBoughtTheProduct;
	}

	public void setUserEmailBoughtTheProduct(String userEmailBoughtTheProduct) {
		this.userEmailBoughtTheProduct = userEmailBoughtTheProduct;
	}

	public Date getDateOfProductPurchase() {
		return dateOfProductPurchase;
	}

	public void setDateOfProductPurchase(Date dateOfProductPurchase) {
		this.dateOfProductPurchase = dateOfProductPurchase;
	}

	@Override
	public String toString() {
		return "PurchaseReport [id=" + id + ", productName=" + productName + ", category=" + categoryOfProduct
				+ ", Product Price=" + priceOfTheProduct + ", User Name =" + userWhoBoughtTheProduct
				+ ", User Email=" + userEmailBoughtTheProduct + ", Purchase Date="
				+ dateOfProductPurchase + "]";
	}

	
	

}
