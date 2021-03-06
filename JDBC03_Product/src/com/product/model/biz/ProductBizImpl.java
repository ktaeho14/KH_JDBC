package com.product.model.biz;


import static common.JDBCTemplate.close;
import static common.JDBCTemplate.commit;
import static common.JDBCTemplate.getConnection;
import static common.JDBCTemplate.rollback;

import java.sql.Connection;
import java.util.List;

import com.product.model.dao.ProductDao;
import com.product.model.dao.ProductDaoImpl;
import com.product.model.dto.Product;
public class ProductBizImpl implements ProductBiz {

	@Override
	public List<Product> selectAll() {
		Connection con = getConnection();
		ProductDao pd = new ProductDaoImpl();
		
		List<Product> list = pd.selectAll(con);
		
		close(con);
		return list;
	}

	@Override
	public Product selectOne(String productId) {
		Connection con = getConnection();
		ProductDao pd = new ProductDaoImpl();
		Product p = pd.selectOne(con, productId);
		
		close(con);
		return p;
	}

	@Override
	public int insert(Product p) {
		Connection con = getConnection();
		ProductDao pd = new ProductDaoImpl();
		int res = pd.insert(con, p);
		
		if(res>0) {
			commit(con);
		}else {
			rollback(con);
		}
		
		
		close(con);
		return res;
	}

	@Override
	public int update(Product p) {
		Connection con = getConnection();
		ProductDao pd = new ProductDaoImpl();
		int res = pd.update(con, p);
		
		if(res>0) {
			commit(con);
		}else {
			rollback(con);
		}
		
		close(con);
		
		return res;
	}

	@Override
	public int delete(String productId) {
		Connection con = getConnection();
		ProductDao pd = new ProductDaoImpl();
		int res = 0;
		
		res = pd.delete(con, productId);
		
		close(con);
		return res;
	}
}
