package com.e_Look.tool;

import java.sql.Date;
import java.util.List;
import com.e_Look.Course.CourseDAO;
import com.e_Look.Course.CourseVO;
import com.e_Look.CourseClassDetails.CourseClassDetailsDAO;
import com.e_Look.CourseClassDetails.CourseClassDetailsVO;

public class BuyingPrice {

	public static Integer getBuyingPrice(Integer courseID) {
		Double discount = 1.0;
		CourseDAO cdao = new CourseDAO();
		CourseVO courseVO = cdao.findByPrimaryKey(courseID);
		Integer oPrice = courseVO.getSoldPrice();
		Integer price = oPrice;
		if (courseVO.getFundStartDate() != null && courseVO.getFundEndDate() != null) {
			if (courseVO.getFundStartDate().getTime() <= System.currentTimeMillis()
					&& System.currentTimeMillis() <= courseVO.getFundEndDate().getTime() + 1000 * 3600 * 24) {
				discount = 0.7;
			}else{
				CourseClassDetailsDAO ccddao = new CourseClassDetailsDAO();
				List<CourseClassDetailsVO> ccdVOs = ccddao.findBycourseID(courseID);
				for (CourseClassDetailsVO ccdVO : ccdVOs) {
					if (ccdVO.getCourseClassVO().getEventVO() != null) {
						Date startDate = ccdVO.getCourseClassVO().getEventVO().geteStartDate();
						Date endDate = ccdVO.getCourseClassVO().getEventVO().geteEndDate();
						if (startDate.getTime() <= System.currentTimeMillis()
								&& (endDate.getTime() + 3600 * 1000 * 24) >= System.currentTimeMillis()) {
							if (discount > ccdVO.getCourseClassVO().getEventVO().getDiscount()) {
								discount = ccdVO.getCourseClassVO().getEventVO().getDiscount();
							}
						}
					}
				}
			}

			
		} else {
			CourseClassDetailsDAO ccddao = new CourseClassDetailsDAO();
			List<CourseClassDetailsVO> ccdVOs = ccddao.findBycourseID(courseID);
			for (CourseClassDetailsVO ccdVO : ccdVOs) {
				if (ccdVO.getCourseClassVO().getEventVO() != null) {
					Date startDate = ccdVO.getCourseClassVO().getEventVO().geteStartDate();
					Date endDate = ccdVO.getCourseClassVO().getEventVO().geteEndDate();
					if (startDate.getTime() <= System.currentTimeMillis()
							&& (endDate.getTime() + 3600 * 1000 * 24) >= System.currentTimeMillis()) {
						if (discount > ccdVO.getCourseClassVO().getEventVO().getDiscount()) {
							discount = ccdVO.getCourseClassVO().getEventVO().getDiscount();
						}
					}
				}
			}
		}
		price = (int) Math.round(oPrice * discount);
		return price;
	}

}
