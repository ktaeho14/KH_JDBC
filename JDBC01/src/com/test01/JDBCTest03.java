package com.test01;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import common.JDBCTemplate;

public class JDBCTest03 extends JDBCTemplate {

	public static void main(String[] args) throws SQLException {
		
		//준비
		Connection con = null;
		Statement stmt = null;
		
		//입력
		Scanner sc = new Scanner(System.in);
	
		System.out.println("no: ");
		int no  = sc.nextInt();
		System.out.println("name: ");
		String name = sc.next();
		System.out.println("nickname: ");
		String nickName = sc.next();
		
		
		//INSERT INTO MYTEST VALUES(no,'name','nickName')
		String sql = "INSERT INTO MYTEST VALUES("+no+",'"+name+"','"+nickName+"')";
		System.out.println(sql);
		
		con = getConnection();
		
		stmt = con.createStatement();
	
		int res = stmt.executeUpdate(sql);
		
		if(res>0) {
			System.out.println("insert 성공");
		}else {
			System.out.println("insert 실패");
		}
		
		close(stmt);
		close(con);
	}

}
