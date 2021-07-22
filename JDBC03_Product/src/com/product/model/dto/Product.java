package com.product.model.dto;

public class Product {
/*
필드만들기
CREATE TABLE PRODUCT (
					  PRODUCT_ID VARCHAR2(20) PRIMARY KEY
					  ,P_NAME VARCHAR2(30) NOT NULL
					  ,PRICE NUMBER NOT NULL
					  ,DESCRIPTION VARCHAR2(20)
					  );
*/
   private String productId;
   private String pName;
   private int price;
   private String description;
   public Product() {

   }
   public Product(String productId, String pName, int price, String description) {

      this.productId = productId;
      this.pName = pName;
      this.price = price;
      this.description = description;
   }
   
   public String getProductId() {
      return productId;
   }
   
   public void setProductId(String productId) {
      this.productId = productId;
   }
   
   public String getpName() {
      return pName;
   }
   
   public void setpName(String pName) {
      this.pName = pName;
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
      return "Product [productId=" + productId + ", pName=" + pName + ", price=" + price + ", description="
            + description + "]";
   }
   
   
}