package common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

// db연결, 연결해제, 저장, 취소
// new 연산자 사용하지 않고 static으로 만든다
public class JDBCTemplate {

	//1. 연결
	public static Connection getConnection() {
		
		// 드라이버 등록
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String id = "KH";
		String pw = "KH";
		
		Connection con = null;
		
		try {
			con = DriverManager.getConnection(url, id, pw);
			con.setAutoCommit(false);
			
		} catch (Exception e) {
			System.out.println("[error]db 연결 실패");
			e.printStackTrace();
		}	
		return con;
	}
	
	//2. 해제
	   public static void close(Connection conn)
	   {
	      try {
	         conn.close();
	      } catch (SQLException e) {
	         System.out.println("[err]Connection close error is induced");
	         e.printStackTrace();
	      }
	   }
	   
	   public static void close(Statement stat)
	   {
	      try {
	         stat.close();
	      } catch (SQLException e) {
	         System.out.println("[err]Statement object close error");
	         e.printStackTrace();
	      }
	   }

	   public static void close(ResultSet rs)
	   {
	      try {
	         rs.close();
	      } catch (SQLException e) {
	         System.out.println("[err]ResultSet close error");
	         e.printStackTrace();
	      }
	   }
	  
	   //3. 저장(commit)
	   public static void commit(Connection con) {
		  
		   try {
   			    con.commit();
			
		   } catch (SQLException e) {
			   System.out.println("[error]commit 에러");
			   e.printStackTrace();
		   }
	   }
	   
	   //4. 취소(rollback)
	   public static void rollback(Connection con) {
		 
		   try {
  			    con.rollback();
			
		   } catch (SQLException e) {
			   System.out.println("[error]rollback 에러");
			   e.printStackTrace();
		   }
	   }
	   
}