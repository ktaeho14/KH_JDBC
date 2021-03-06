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
		Product pd = new Product();
		Statement stmt = null;
		ResultSet rs = null;
		
		List<Product> list = new ArrayList<Product>();
		
		try {
			stmt = con.createStatement();
			rs = stmt.executeQuery(selectAll);
		while(rs.next()) {
			pd.setProductId(rs.getString(1));
			pd.setpName(rs.getString(2));
			pd.setPrice(rs.getInt(3));
			pd.setDescription(rs.getString(4));
			list.add(pd);
			}
			
			
		} catch (SQLException e) {
			System.out.println("selectAll error");
			e.printStackTrace();
		}finally{ 
			close(rs);
			close(stmt);		
		}
		
		return list;
	}

	@Override
	public Product selectOne(Connection con, String productId) {
		Product p = new Product();
		PreparedStatement pstm = null;
		ResultSet rs = null;
		
		try {
			pstm = con.prepareStatement(selectOne);
			pstm.setString(1, p.getProductId());
			rs = pstm.executeQuery();
		} catch (SQLException e) {
			System.out.println("selectOne error");
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
		int res = 0;
		
		try {
			pstm = con.prepareStatement(Insert);
			pstm.setString(1, p.getProductId());
			pstm.setString(2, p.getpName());
			pstm.setInt(3, p.getPrice());
			pstm.setString(4, p.getDescription());
			
			res = pstm.executeUpdate();
			
			if(res>0) {
				System.out.println("insert 성공!!");
			}else {
				System.out.println("insert 실패!!");
			}
			
		} catch (SQLException e) {
			System.out.println("Insert error");
			e.printStackTrace();
		}finally {
			close(pstm);
		}
		
		
		
		return res;
	}

	@Override
	public int update(Connection con, Product p) {
		PreparedStatement pstm = null;
		int res = 0;
		
		
		
		try {
			pstm = con.prepareStatement(Update);
			pstm.setInt(1, p.getPrice());
			pstm.setString(2, p.getProductId());
			
			res = pstm.executeUpdate();
			
			if(res>0) {
				System.out.println("Update 성공");
			}else {
				System.out.println("Update 실패");
			}
		} catch (SQLException e) {
			System.out.println("Update error");
			e.printStackTrace();
		}finally {
			close(pstm);
		}
		
		return res;
	}

	@Override
	public int delete(Connection con, String productId) {
		PreparedStatement pstm = null;
		int res = 0;
		
		try {
			pstm = con.prepareStatement(Delete);
			pstm.setString(1, productId);
			
			res = pstm.executeUpdate();
			
			if(res)
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}finally {
			close(pstm);
		}
		return 0;
	}

	@Override
	public int hashCode() {
		return super.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		return super.equals(obj);
	}

	@Override
	protected Object clone() throws CloneNotSupportedException {
		return super.clone();
	}

	@Override
	public String toString() {
		return super.toString();
	}

	@Override
	protected void finalize() throws Throwable {
		super.finalize();
	}

}
