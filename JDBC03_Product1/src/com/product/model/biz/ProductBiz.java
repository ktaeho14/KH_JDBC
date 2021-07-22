package com.product.model.biz;

import java.sql.Connection;
import java.util.List;

import com.product.model.dto.Product;

public interface ProductBiz {
	
	public List<Product> selectAll();
	public Product selectOne(String productId);
	public int insert(Product p);
	public int update(Product p);
	public int delete(String productId);
	
	
	
	
	
	
}
