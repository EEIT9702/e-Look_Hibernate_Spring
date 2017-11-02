package com.e_Look.shoppingCart.model.spring;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.transaction.annotation.Transactional;

import com.e_Look.Course.CourseVO;
@Transactional(readOnly = false)
public class ShoppingCartDAO implements ShoppingCartDAO_interface {
	
	
	private HibernateTemplate hibernateTemplate; 
    public void setHibernateTemplate(HibernateTemplate hibernateTemplate) { 
        this.hibernateTemplate = hibernateTemplate;
    }
	
	
	@Override
	public void insert(ShoppingCartVO shoppingCartVO) {
		hibernateTemplate.saveOrUpdate(shoppingCartVO);
	}

	@Override
	public void update(ShoppingCartVO shoppingCartVO, ShoppingCartVO shoppingCartVO2) {
		hibernateTemplate.update(shoppingCartVO);
	}

	@Override
	public void delete(ShoppingCartVO shoppingCartVO) {
		hibernateTemplate.delete(shoppingCartVO);
	}


	@Override
	public List<CourseVO> findByMemberID(Integer memberID) {
		List<CourseVO> list = null;
//		final String GET_MEMBER_COURSE = "from ShoppingCartVO where memberID ="+memberID;
//		
//		list = (List<CourseVO>) hibernateTemplate.find("from ShoppingCartVO where memberID");
		
		return list;
	}

	@Override
	public List<ShoppingCartVO> getAll() {
		return null;
	}

	
	
	
	public static void main(String[] args){
		ApplicationContext context = new ClassPathXmlApplicationContext("beans-config.xml");
		ShoppingCartDAO_interface dao=(ShoppingCartDAO_interface) context.getBean("shoppingCartDAO");
		ShoppingCartVO vo=new ShoppingCartVO();
		vo.setMemberID(100001);
		vo.setCourseID(200001);
		
		dao.insert(vo);
		dao.delete(vo);
		
	}
	
	
	
	
	
	
}
