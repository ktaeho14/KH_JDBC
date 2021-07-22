package com.product.controller;

import java.util.List;

import com.product.model.biz.ProductBiz;
import com.product.model.biz.ProductBizImpl;
import com.product.model.dto.Product;

public class ProductController {
	
	private ProductBiz biz = new ProductBizImpl();

	public List<Product> selectAll() {
		
		List<Product> res = biz.selectAll();
		return res;
	}

	public Product selectOne(String productId) {
		Product p = biz.selectOne(productId);
		
		return p;
	}

	public int insert(Product p) {
		int res =biz.insert(p);
		return res;
	}

	public int update(Product p) {
		int res = biz.update(p);
		return res;
	}

	public int delete(String productId) {
		int res = biz.delete(productId);
		return 0;
	}
}
