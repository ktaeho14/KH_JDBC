package com.dao;

import static common.JDBCTemplate.close;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.swing.text.html.HTMLDocument.HTMLReader.PreAction;

import com.dto.Member;

public class MemberDaoImpl implements MemberDao{

	@Override
	public List<Member> getAll(Connection con) {
		Statement stmt = null;
		ResultSet rs = null;
		
		
		List<Member> res = new ArrayList<Member>();
		//실행
		try {
			stmt = con.createStatement();
			rs=stmt.executeQuery(selectAllSql);
			//결과처리
			while(rs.next()) {
				Member tmp = new Member();
				tmp.setM_no(rs.getInt(1));
				tmp.setM_name(rs.getString("M_NAME"));
				tmp.setM_gender(rs.getString(4));
				tmp.setM_age(rs.getInt(3));
				tmp.setM_location(rs.getString(5));
				tmp.setM_job(rs.getString("M_JOB"));
				tmp.setM_tel(rs.getString(7));
				tmp.setM_email(rs.getString(8));
				
				res.add(tmp);
			}
			
		} catch (SQLException e) {			
			e.printStackTrace();
		}finally {
		
		close(rs);
		close(stmt);
		}
		
		return res;
	}

	@Override
	public Member getOne(Connection con, int n) {
		PreparedStatement pstm = null;
		ResultSet rs =null;
		Member res = new Member();
		
		try {
			pstm = con.prepareStatement(selectOneSql);
			pstm.setInt(1, n);
			
		rs = pstm.executeQuery();
			while(rs.next()) {
				res.setM_no(rs.getInt(1));
				res.setM_name(rs.getString(2));
				res.setM_age(rs.getInt(3));
				res.setM_gender(rs.getString(4));
				res.setM_location(rs.getString(5));
				res.setM_job(rs.getString(6));
				res.setM_tel(rs.getString(7));
				res.setM_email(rs.getString(8));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstm);
		}
		
		
		
		
		return res;
	}

	@Override
	public int insert(Connection con, Member m) {
		
		PreparedStatement pstm = null;
		int res = 0;
		
		
		//매개변수로 넘어온 Member객체의 m을 getter & setter를 사용하여 pstm의 ?를 채워준다
		try {
			pstm = con.prepareStatement(insertSql);
			pstm.setString(1,m.getM_name());
			pstm.setInt(2,m.getM_age() );
			pstm.setString(3,m.getM_gender());
			pstm.setString(4,m.getM_location());
			pstm.setString(5, m.getM_job());
			pstm.setString(6, m.getM_tel());
			pstm.setString(7, m.getM_email());
			
			res = pstm.executeUpdate();
			
			
			
		} catch (SQLException e) {
			System.out.println("[error]insert 에러");
			e.printStackTrace();
		}finally {
			
			close(pstm);
		}
		
		
		
		return res;
	}

	@Override
	public int delete(Connection con, int n) {
		PreparedStatement pstm = null;
		int res = 0;
		
		try {
			pstm = con.prepareStatement(deleteSql);
			pstm.setInt(1, n);
			res = pstm.executeUpdate();
			
			
		} catch (SQLException e) {
			System.out.println("[error]delete 에러!!");
			e.printStackTrace();
		}finally {
			close(pstm);
		}
		
		
		return res;
	}

	@Override
	public int update(Connection con, Member m) {
		
		
		PreparedStatement pstm = null;
		int res = 0;
		try {
			pstm = con.prepareStatement(updateSql);
			pstm.setInt(1, m.getM_age());
			pstm.setString(2, m.getM_location());
			pstm.setString(3, m.getM_job());
			pstm.setString(4, m.getM_tel());
			pstm.setInt(5,m.getM_no());
			
			res =pstm.executeUpdate();
			
			
			
			
		} catch (SQLException e) {
			System.out.println("[error]update에러");
			e.printStackTrace();
		}finally {
			close(pstm);
		}
		
		
		
		return res;
	}

}
