package com.product_01_dto;

public class Product_01 {
	private String Product_ID;
	private String P_NAME;
	private int PRICE;
	private String DESCRIPTION;
	
	
	//기본생성자
	public Product_01() {
		super();
		// TODO Auto-generated constructor stub
	}

	//매개변수 생성자
	public Product_01(String product_ID, String p_NAME, int pRICE, String dESCRIPTION) {
		super();
		Product_ID = product_ID;
		P_NAME = p_NAME;
		PRICE = pRICE;
		DESCRIPTION = dESCRIPTION;
	}

	
	
	//getter & setter
	public String getProduct_ID() {
		return Product_ID;
	}

	public void setProduct_ID(String product_ID) {
		Product_ID = product_ID;
	}

	public String getP_NAME() {
		return P_NAME;
	}

	public void setP_NAME(String p_NAME) {
		P_NAME = p_NAME;
	}

	public int getPRICE() {
		return PRICE;
	}

	public void setPRICE(int pRICE) {
		PRICE = pRICE;
	}

	public String getDESCRIPTION() {
		return DESCRIPTION;
	}

	public void setDESCRIPTION(String dESCRIPTION) {
		DESCRIPTION = dESCRIPTION;
	}

	
	
	
	//to_String 메소드
	@Override
	public String toString() {
		return "Product_01 [Product_ID=" + Product_ID + ", P_NAME=" + P_NAME + ", PRICE=" + PRICE + ", DESCRIPTION="
				+ DESCRIPTION + "]";
	}
	
	
	
	
	
	
	
	
}
