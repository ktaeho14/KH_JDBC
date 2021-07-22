package com.test01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCTest01 {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
	//1. 드라이버 등록
	Class.forName("oracle.jdbc.driver.OracleDriver");
	//2. db연결
	Connection con =
			DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","KH","KH");
	//127.0.0.1 -내컴퓨터 ip
	
	
	//3.쿼리 실행 준비
	String sql = "SELECT * FROM EMP";
	Statement stmt = con.createStatement();
	
	
	//4.실행 및 결과 리턴
	ResultSet rs = stmt.executeQuery(sql);
	while(rs.next()) {
		System.out.println(rs.getInt(1)+" " +rs.getString("ENAME")+ " " + rs.getInt("SAL"));
	}
	
	
	//5.db 종료
	rs.close();
	stmt.close();
	con.close();
	
	
	/*
	 * 0.드라이버 등록
	 * Class.forName("oracle.jdbc.driver.OracleDriver");
	 * 
	 * 1.커넥션 객체만들기(db연결)
	 * Connection con = DriverManager.Connection("url", "계정명", "비밀번호");
	
	   2.//쿼리 실행준비
	   String sql = "SELECT * FROM EMPLYOEE";
	   Statement st = con.createStatement();
	   //Statement 객체 db연결
	   
	   3.//실행
	   ResultSet rs = st.executeQuery(sql);
	   
	   5.//db종료
	   rs.close()
	   st.close()
	   con.close()
	   
	*/
	
	
	
	
	
	
	
	}

}
