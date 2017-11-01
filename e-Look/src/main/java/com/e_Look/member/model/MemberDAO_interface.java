package com.e_Look.member.model;

import java.util.List;

public interface MemberDAO_interface {
	 public void insert(MemberVO memberVO);
     public void update(MemberVO memberVO,String update);
     public void updataimage(MemberVO memberVO);
     public void delete(Integer memberID);
     public MemberVO  findByPrimaryKey(Integer memberID);
     public MemberVO  findByPrimaryKey(String email);
     public List<MemberVO> getAll();
}
