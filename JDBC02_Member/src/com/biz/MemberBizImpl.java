package com.biz;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import com.dao.MemberDao;
import com.dao.MemberDaoImpl;
import com.dto.Member;
import static common.JDBCTemplate.*;

public class MemberBizImpl implements MemberBiz {
	
	MemberDao memberdao = new MemberDaoImpl();
	
	@Override
	public List<Member> getAll() {
		Connection con = getConnection();
		
		List<Member> list = memberdao.getAll(con);
		
		close(con);
		
		
		return list;
	}

	@Override
	public Member getOne(int n) {
		Connection con = getConnection();
		Member dto = memberdao.getOne(con, n);
		
		close(con);
		return dto;
	}

	@Override
	public int insert(Member m) {
		Connection con =getConnection();
		int res = memberdao.insert(con, m);
		
		if(res>0) {
			commit(con);
		}else {
			rollback(con);
		}
		
		close(con);
		
		return res;
	}

	@Override
	public int delete(int n) {
		Connection con = getConnection();
		int res = memberdao.delete(con, n);
		
		if(res>0) {
			commit(con);
		}else {
			rollback(con);
		}
		
		close(con);
		
		return res;
	}

	@Override
	public int update(Member m) {
		Connection con = getConnection();
		int res = memberdao.update(con, m);
		
		if(res>0) {
			commit(con);
		}else {
			rollback(con);
		}
		
		close(con);
		
		
		
		
		return res;
	}

}
