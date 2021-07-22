package com.product.controller;

import java.util.List;

import com.product.model.biz.ProductBiz;
import com.product.model.biz.ProductBizImpl;
import com.product.model.dto.Product;

public class ProductController {
	
	
	private ProductBiz biz = new ProductBizImpl();
	
	public List<Product> selectAll(){
		List<Product> res = biz.selectAll();
		return res;
	}
	
	public Product selectOne(String productId) {
		Product p = biz.selectOne(productId);
		return p;
	}
	
	public int insert(Product p) {
		int insert = biz.insert(p);
		return insert;
	}
	
	public int update(Product p) {
		int update = biz.update(p);
		return update;
	}
	
	public int delete(String productId) {
		int delete = biz.delete(productId);
		
		
		return delete;
	}
	
	
	
	
	
	
	
	
	
	
}
