package com.example.demo.repository;

import java.util.List;

import com.example.demo.entity.Member;

public interface MyRepository {
	
	List<Member> emMemberList();
	
	Member emMemberDetatil(String id);
}
