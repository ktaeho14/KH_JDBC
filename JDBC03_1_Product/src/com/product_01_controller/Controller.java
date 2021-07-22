package com.product_01_controller;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import com.product_01_dto.Product_01;
import com.product_01_model.biz.BizImpl;

public class Controller {
	public List<Product_01> selectAll(){
		BizImpl bi = new BizImpl();
		List<Product_01> list = bi.selectAll();
		
		return list;
	}
	
	public Product_01 selectOne(Connection con, String PRODUCT_ID) {
		return null;
	}
	
	public int insert(Connection con,Product_01 p) {
		return 0;
	}
	
	public int update(Connection con,Product_01 p) {
		
		return 0;
	}
	
	public int delete(Connection con,String PRODUCT_ID) {
		
		return 0;
	}
	
	
	
}
