package com.test01;

import static common.JDBCTemplate.getConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;
import static common.JDBCTemplate.*;
public class JDBCTest05 {
	
	//삭제할 이름은?
	//홍길동
	//삭제되었습니다.
	public static void main(String[] args) throws SQLException {
		
		//준비
		Connection  con = null;
		PreparedStatement pstm = null;
		
		String name = null;
		String sql = "DELETE FROM MYTEST WHERE MNAME = ?";

		Scanner sc = new Scanner(System.in);
		
		
		System.out.println("삭제할 이름: ");
		name = sc.next();
		
		
		
		
		con = getConnection();
		
		pstm = con.prepareStatement(sql);
		pstm.setString(1,name);
		
		int res = pstm.executeUpdate();
		
		if(res>0) {
			System.out.println("삭제되었습니다");
		}else {
			System.out.println("삭제에 실패하였습니다");
		}
		
		pstm.close();
		con.close();
		
	}

}
