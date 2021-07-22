package com.product_01_model.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.product_01_dto.Product_01;
import static Common.JDBCTemplate.*;

public class DaoImpl implements Dao{

	@Override
	public List<Product_01> selectAll(Connection con) {
		Statement stmt = null;
		
		ResultSet rs = null; 
		List<Product_01> list = new ArrayList<Product_01>();
		
		try {
			stmt = con.createStatement();
			rs = stmt.executeQuery(SelctAll);
			Product_01 pd01 = new Product_01();
			while(rs.next()) {
				pd01.setProduct_ID(rs.getString(1));
				pd01.setP_NAME(rs.getNString(2));
				pd01.setPRICE(rs.getInt(3));
				pd01.setDESCRIPTION(rs.getString(4));
				list.add(pd01);
			}
		} catch (SQLException e) {
			System.out.println("selectAll 에러");
			e.printStackTrace();
		}finally {
			close(rs);
			close(stmt);
		}
		 
		return list;
	}

	@Override
	public Product_01 selectOne(Connection con, String PRODUCT_ID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int insert(Connection con, Product_01 p) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(Connection con, Product_01 p) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(Connection con, String PRODUCT_ID) {
		// TODO Auto-generated method stub
		return 0;
	}

}
