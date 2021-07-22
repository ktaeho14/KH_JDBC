package com.product.model.biz;

import static common.JDBCTemplate.*;
import static common.JDBCTemplate.close;
import static common.JDBCTemplate.commit;
import static common.JDBCTemplate.getConnection;

import java.sql.Connection;
import java.util.List;

import com.product.model.dao.ProductDao;
import com.product.model.dao.ProductDaoImpl;
import com.product.model.dto.Product;

public class ProductBizImpl implements ProductBiz {
private ProductDao pd = new ProductDaoImpl();


	@Override
	public List<Product> selectAll() {
		Connection con = getConnection();
		
		List<Product> list = pd.selectAll(con);
		
		close(con);
		return list;
	}

	@Override
	public Product selectOne(String productId) {
		Connection con = getConnection();
		
		Product p = pd.selectOne(con, productId);
		close(con);
		return p;
	}

	@Override
	public int insert(Product p) {
		Connection con = getConnection();
		
		int insert = pd.insert(con, p);
		
		if(insert>0) {
			commit(con);
		}else {
			rollback(con);
		}
			
		close(con);
		return insert;
	}

	@Override
	public int update(Product p) {
		Connection con = getConnection();
		int update = pd.update(con, p);
		
		if(update>0) {
			commit(con);
		}else {
			rollback(con);
		}
		
		close(con);
		return update;
	}

	@Override
	public int delete(String productId) {
		Connection con = getConnection();
		int delete = pd.delete(con, productId);
		
		
		System.out.println(delete);
		if(delete>0) {
			commit(con);
		}else {
			rollback(con);
		}
		
		close(con);
		return delete;
	}

}
