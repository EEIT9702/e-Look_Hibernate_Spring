package com.e_Look.memberBookmarks.model;

import java.util.List;
import com.e_Look.Course.CourseVO;
import com.e_Look.member.model.MemberVO;

public interface MemberBookmarksDAO_interface {
	
	public void insert(Integer memberID,Integer courseID);
	public void update(MemberBookmarksVO MemberBookmarksVO);	
	public void delete(Integer memberID, Integer courseID);
	public List<MemberBookmarksVO> findByMemberID(Integer memberID);
	public List<MemberBookmarksVO> getAll();

}
