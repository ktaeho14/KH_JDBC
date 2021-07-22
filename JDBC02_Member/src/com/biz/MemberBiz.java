package com.biz;

import java.util.List;

import com.dto.Member;

public interface MemberBiz {

	public List<Member> getAll();
	public Member getOne(int n);
	public int insert(Member m);
	public int delete(int n);
	public int update(Member m);
}
