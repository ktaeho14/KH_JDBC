package com.product.model.dto;

public class Product {
	private String productId;
	private String p_Name;
	private int price;
	private String description;
	public Product() {
	}
	public Product(String productId, String p_Name, int price, String description) {
		super();
		this.productId = productId;
		this.p_Name = p_Name;
		this.price = price;
		this.description = description;
	}
	public String getProductId() {
		return productId;
	}
	public void setProductId(String productId) {
		this.productId = productId;
	}
	public String getP_Name() {
		return p_Name;
	}
	public void setP_Name(String p_Name) {
		this.p_Name = p_Name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	@Override
	public String toString() {
		return "[" + productId + "," + p_Name + "," + price + ","+ description + "]";
	}
	
	
}


