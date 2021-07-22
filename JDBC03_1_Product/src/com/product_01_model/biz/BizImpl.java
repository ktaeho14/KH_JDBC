package com.product_01_model.biz;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import com.product_01_dto.Product_01;
import com.product_01_model.dao.DaoImpl;

import static Common.JDBCTemplate.*;
public class BizImpl implements Biz {
	DaoImpl dao = new DaoImpl();
	@Override
	public List<Product_01> selectAll() {
		Connection con = getConnection();
		List<Product_01> list = new ArrayList<Product_01>();
		list = dao.selectAll(con);
		close(con);
		return list;
	}

	@Override
	public int selectOne( String PRODUCT_ID) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insert( Product_01 p) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update( Product_01 p) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete( String PRODUCT_ID) {
		// TODO Auto-generated method stub
		return 0;
	}

}
