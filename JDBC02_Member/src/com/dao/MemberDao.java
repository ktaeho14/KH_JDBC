package com.dao;

import java.sql.Connection;
import java.util.List;

import com.dto.Member;

public interface MemberDao {
	
	public static final String selectAllSql ="SELECT * FROM TB_MEMBER";
	public static final String selectOneSql = "SELECT * FROM TB_MEMBER WHERE M_NO = ?";
	public static final String insertSql = "INSERT INTO TB_MEMBER VALUES(MEMBERSQ.NEXTVAL,?,?,?,?,?,?,?)";
	public static final String updateSql = "UPDATE TB_MEMBER SET M_AGE=?,M_LOCATION=?,M_JOB=?,M_TEL=? WHERE M_NO=?";
	public static final String deleteSql = "DELETE FROM TB_MEMBER WHERE M_NO=?";
	
	
	public List<Member> getAll(Connection con);
	public Member getOne(Connection con,int n);
	public int insert(Connection con, Member m);
	public int delete(Connection con, int n);
	public int update(Connection con, Member m);
}
