package com.test01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import static common.JDBCTemplate.*;

public class JDBCTest02 {

	public static void main(String[] args) throws SQLException {
		//준비
		Connection con  = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		String sql = "SELECT * FROM DEPT";
		//연결
		con = getConnection();
		stmt = con.createStatement();
		
		
		//실행 및 결과 처리
		rs = stmt.executeQuery(sql);
		
		
		
		
		while(rs.next()) {
			System.out.println(rs.getInt(1)+" " + rs.getString(2)+ " " + rs.getString("LOC"));
		}
		
		//연결해제
		close(rs);
		close(stmt);
		close(con);
		
		
		
		
		
		
		
		
		
		
		
	

	}

}
