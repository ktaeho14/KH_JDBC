package com.product.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.product.model.dto.Product;

import static common.JDBCTemplate.*;
public class ProductDaoImpl implements ProductDao {

	@Override
	public List<Product> selectAll(Connection con) {
		Statement stmt = null;
		ResultSet rs = null;
		
		
		List<Product> list = new ArrayList<Product>();
		
		try {
			stmt = con.createStatement();
			rs = stmt.executeQuery(selectAll);
			while(rs.next()) {
				Product pd = new Product();
				pd.setProductId(rs.getString(1));
				pd.setP_Name(rs.getString(2));
				pd.setPrice(rs.getInt(3));
				pd.setDescription(rs.getString(4));
				
				list.add(pd);
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}finally {
			close(rs);
			close(stmt);
		}
		return list;
	}

	@Override
	public Product selectOne(Connection con, String productId) {
		PreparedStatement pstm = null;
		ResultSet rs = null;
		Product p = new Product();
		try {
			
			pstm = con.prepareStatement(selectOne);
			pstm.setString(1, productId);
			
			rs = pstm.executeQuery();
			while(rs.next()) {
				p.setProductId(rs.getNString(1));
				p.setP_Name(rs.getString(2));
				p.setPrice(rs.getInt(3));
				p.setDescription(rs.getString(4));
			}
		} catch (SQLException e) {
			
			
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstm);
		}
		return p;
	}

	@Override
	public int insert(Connection con, Product p) {
		PreparedStatement pstm = null;
		int rs = 0;
		
		try {
			pstm = con.prepareStatement(insert);
			pstm.setString(1, p.getProductId());
			pstm.setString(2, p.getP_Name());
			pstm.setInt(3, p.getPrice());
			pstm.setString(4, p.getDescription());
			
			rs= pstm.executeUpdate();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}finally {
			close(pstm);
		}
		return rs;
	}

	@Override
	public int update(Connection con, Product p) {
		PreparedStatement pstm = null;
		int res = 0;
		
		try {
			pstm = con.prepareStatement(update);
			pstm.setInt(1,p.getPrice());
			pstm.setString(2, p.getProductId());
			
			res = pstm.executeUpdate();
			
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}finally {
			close(pstm);
		}
		return res;
	}

	@Override
	public int delete(Connection con, String ProductId) {
		PreparedStatement pstm = null;
		int res = 0;
		Product p = new Product();
		
		try {
			pstm = con.prepareStatement(delete);
			pstm.setString(1,ProductId);
			
			res = pstm.executeUpdate();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}finally {
			close(pstm);
		}
		
		return res;
	}

}
