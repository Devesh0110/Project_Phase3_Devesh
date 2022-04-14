package com.sportyshoes.entity;

public class Product {
int ProductPrice;
String ProductCategory;
String ProductName;
@Override
public String toString() {
	return "Product [ProductPrice=" + ProductPrice + ", ProductCategory=" + ProductCategory + ", ProductName="
			+ ProductName + "]";
}
public Product(int productPrice, String productCategory, String productName) {
	super();
	ProductPrice = productPrice;
	ProductCategory = productCategory;
	ProductName = productName;
}
public int getProductPrice() {
	return ProductPrice;
}
public void setProductPrice(int productPrice) {
	ProductPrice = productPrice;
}
public String getProductCategory() {
	return ProductCategory;
}
public void setProductCategory(String productCategory) {
	ProductCategory = productCategory;
}
public String getProductName() {
	return ProductName;
}
public void setProductName(String productName) {
	ProductName = productName;
}
public Product() {
	super();
	// TODO Auto-generated constructor stub
}

}
