package com.product.model.dao;

import java.sql.Connection;
import java.util.List;

import com.product.model.dto.Product;

public interface ProductDao {
	String selectAll = "SELECT * FROM PRODUCT";
	String selectOne = "SELECT * FROM PRODUCT  WHERE PRODUCT_ID = ?";
	String insert = "INSERT INTO PRODUCT VALUES(?,?,?,?)";
	String update = "UPDATE PRODUCT SET PRICE =? WHERE PRODUCT_ID = ?";
	String delete = "DELETE FROM PRODUCT WHERE Product_Id = ?";
	
	public List<Product> selectAll(Connection con);
	public Product selectOne(Connection con, String productId);
	public int insert(Connection con,Product p);
	public int update(Connection con,Product p);
	public int delete(Connection con,String ProductId);
	
	
}
