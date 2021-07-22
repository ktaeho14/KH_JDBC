package com.product_01_model.biz;

import java.sql.Connection;
import java.util.List;

import com.product_01_dto.Product_01;

public interface Biz {
	public List<Product_01> selectAll();
	public int selectOne(String PRODUCT_ID);
	public int insert(Product_01 p);
	public int update(Product_01 p);
	public int delete(String PRODUCT_ID);
}
