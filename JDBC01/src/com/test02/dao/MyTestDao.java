package com.test02.dao;

import static common.JDBCTemplate.close;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.test02.dto.MyTestDto;
public class MyTestDao {
	
	//select
	public List<MyTestDto> getAll(Connection con) {
		
		Statement stmt = null;
		ResultSet rs = null;
		
		List<MyTestDto> list = new ArrayList<MyTestDto>();
		String sql = "SELECT * FROM MYTEST";
		
		//실행 및 리턴
		
		try {
			stmt = con.createStatement();
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				MyTestDto tmp = new MyTestDto(rs.getInt(1),rs.getNString(2),rs.getNString(3));
				
				list.add(tmp);
				
				
				
			}
			
		} catch (SQLException e) {
			System.out.println("[error]select 에러");
			e.printStackTrace();
		}
		
		close(rs);
		close(stmt);
		
		
		
		return list;
	}
	
	
	
	public int getInsert(Connection con2, MyTestDto dto) {
		//준비
		PreparedStatement pstm = null;
		String sql = "INSERT INTO MYTEST VALUES(?,?,?)";
		
		int res = 0;
		
		try {
			pstm = con2.prepareStatement(sql);
			pstm.setInt(1, dto.getMno());
			pstm.setString(2, dto.getMname());
			pstm.setString(3, dto.getNickname());
			
			res = pstm.executeUpdate();
			
			
			
		} catch (SQLException e) {
			System.out.println("[error]insert 에러");
			e.printStackTrace();
		}finally {
			close(pstm);
		}
		
		
		
		
		
		
		
		
		
		return res;
	}
	
	
	public  int getUpdate(Connection con3, MyTestDto dto) {
		PreparedStatement pstm = null;
		String sql = "UPDATE MYTEST SET MNAME=?, NICKNAME=? WHERE MNO=?";
		int res = 0;
		
		try {
			pstm = con3.prepareStatement(sql);
			pstm.setString(1, dto.getMname());
			pstm.setString(2, dto.getNickname());
			pstm.setInt(3, dto.getMno());
			
			res = pstm.executeUpdate();
		} catch (SQLException e) {
			System.out.println("[error]update 에러");
			e.printStackTrace();
		}finally {
			close(pstm);
		}
		
		
		
		
		return res;
	}
	
	public int getDelete(Connection con4,int no) {
		PreparedStatement pstm = null;
		String sql = "DELETE FROM MYTEST WHERE MNO=?";
		
		int res =0;
		try {
			pstm=con4.prepareStatement(sql);
			pstm.setInt(1, no);
			
			res = pstm.executeUpdate();
		} catch (SQLException e) {
			System.out.println("[error]delete 에러!!");
			e.printStackTrace();
		}finally {
				close(pstm);
		}
		return res;
	}
	
	
	
}
