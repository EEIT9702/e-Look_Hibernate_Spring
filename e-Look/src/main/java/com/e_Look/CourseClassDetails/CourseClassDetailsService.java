package com.e_Look.CourseClassDetails;

import java.util.LinkedList;
import java.util.List;

public class CourseClassDetailsService {
	private CourseClassDetails_interface dao;
	
	public CourseClassDetailsService() {
		dao = new CourseClassDetailsDAO();
	}
	
	public List<CourseClassDetailsVO> getFreeCourse(Integer courseClassID){
		List<CourseClassDetailsVO> ccdVOs = dao.getBycourseClassID(courseClassID);
		List<CourseClassDetailsVO> freeccdVOs = new LinkedList<CourseClassDetailsVO>();
		
		for(CourseClassDetailsVO ccdVO : ccdVOs){
			if(ccdVO.getCourseVO().getSoldPrice() == 0 && ccdVO.getCourseVO().getStatus() == 2){
				freeccdVOs.add(ccdVO);
			}
		}
		return freeccdVOs;
	}

	public List<CourseClassDetailsVO> getOnlineCourse(Integer courseClassID) {
		List<CourseClassDetailsVO> ccdVOs = dao.getBycourseClassID(courseClassID);
		List<CourseClassDetailsVO> onlineccdVOs = new LinkedList<CourseClassDetailsVO>();
		
		for(CourseClassDetailsVO ccdVO : ccdVOs) {
			if(ccdVO.getCourseVO().getSoldPrice() > 0 && ccdVO.getCourseVO().getStatus() == 2) {
				onlineccdVOs.add(ccdVO);
			}
		}
		return onlineccdVOs;
	}
	
	public List<CourseClassDetailsVO> getFoundRaiseCourse(Integer courseClassID) {
		List<CourseClassDetailsVO> ccdVOs = dao.getBycourseClassID(courseClassID);
		List<CourseClassDetailsVO> foundraiseccdVOs = new LinkedList<CourseClassDetailsVO>();
		
		for(CourseClassDetailsVO ccdVO : ccdVOs) {
			if(ccdVO.getCourseVO().getStatus() == 3) {
				foundraiseccdVOs.add(ccdVO);
			}
		}
		return foundraiseccdVOs;
	}
	
}


