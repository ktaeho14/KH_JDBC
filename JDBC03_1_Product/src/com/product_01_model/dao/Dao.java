package com.product_01_model.dao;

import java.sql.Connection;
import java.util.List;

import com.product_01_dto.Product_01;

public interface Dao {
	
	public static final String SelctAll = "SELECT * FROM PRODUCT_01";
	
	
	public List<Product_01> selectAll(Connection con);
	public Product_01 selectOne(Connection con,String PRODUCT_ID);
	public int insert(Connection con,Product_01 p);
	public int update(Connection con,Product_01 p);
	public int delete(Connection con,String PRODUCT_ID);
}
