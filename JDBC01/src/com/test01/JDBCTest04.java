package com.test01;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

import static common.JDBCTemplate.*;

public class JDBCTest04 {

	public static void main(String[] args) throws SQLException {
		
		//준비
		Connection con = null;
		PreparedStatement pstm = null;

		Scanner sc = new Scanner(System.in);
				
		System.out.println("No: ");
		int no =sc.nextInt();
		System.out.println("Name: ");
		String name = sc.next();
		System.out.println("NickName: ");
		String nickName =sc.next();
		
		String sql = "INSERT INTO MYTEST VALUES(?,?,?)";
		
		con =getConnection();
		
		
		pstm = con.prepareStatement(sql);
		pstm.setInt(1, no);
		pstm.setString(2, name);
		pstm.setString(3, nickName);
		
		int res = pstm.executeUpdate();
		
		if(res>0) {
			System.out.println("insert 성공");
		}else {
			System.out.println("insert 실패");
		}
		
		close(pstm);
		close(con);
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
