package com.e_Look.buyCourse.model;

import java.util.List;

public class BuyCourseService {
	private BuyCourseDAO_interface dao;

	public BuyCourseService() {
		dao = new BuyCourseDAO();
	}
	public List<BuyCourseVO> getBuyCourse(Integer memberID){
		
		return dao.findByMemberID(memberID);
		
	}
	public void updateScore(Integer scoreStar,Integer memberID,Integer courseID){
		BuyCourseVO buyCourseVO=new BuyCourseVO();
		buyCourseVO.setScore(scoreStar);
		buyCourseVO.setMemberID(memberID);
		buyCourseVO.setCourseID(courseID);
		dao.update(buyCourseVO);
		
	}
	public Double avgScore(Integer courseID){
		return dao.getAvgScore(courseID);
	
	}
	public List<BuyCourseVO> findCourseID(Integer memberID){
		return dao.findByMemberID(memberID);
	
	}
	public Integer getBuyCourseNumber(Integer courseID) {
		List<BuyCourseVO> bcVO = dao.getByCourseID(courseID);
		Integer bsize = bcVO.size();
		//System.out.println("bsize = " + bsize);
		return bsize;
	}
}
