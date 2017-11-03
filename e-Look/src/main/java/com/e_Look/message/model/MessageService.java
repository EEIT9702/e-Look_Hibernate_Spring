package com.e_Look.message.model;

import java.util.List;

import com.e_Look.member.model.MemberDAO_interface;
import com.e_Look.member.model.MemberVO;

public class MessageService {
	private MessageDAO_interface dao;    //多型多
	private MemberDAO_interface memberDAO;
	public MessageService() {
		dao = new MessageDAO();
	}

	public void addMessage(String mContent,Integer memberID,Integer courseID, Byte status)
	   {
		MemberVO memberVO = memberDAO.findByPrimaryKey(memberID);
		
		MessageVO messageVO = new MessageVO();
		messageVO.setmContent(mContent);
        //mTime時間由dao產生
		messageVO.setMemberVO(memberVO);
		messageVO.setCourseID(courseID);
		messageVO.setStatus(status);
		dao.insert(messageVO);
	}
	
	public void addResponse(String mContent,Integer messageID_response,Integer memberID,Integer courseID, Byte status)
	   {
		MemberVO memberVO = memberDAO.findByPrimaryKey(memberID);
		MessageVO messageVO = new MessageVO();
		messageVO.setmContent(mContent);
		messageVO.setMessageID_response(messageID_response);
		messageVO.setMemberVO(memberVO);
		messageVO.setCourseID(courseID);
		messageVO.setStatus(status);
		dao.insert(messageVO);
	}
		
	public void updateMessage(Integer messageID,String mContent, String update) {

		MessageVO messageVO = new MessageVO();
		messageVO.setMessageID(messageID);
		messageVO.setmContent(mContent);
		dao.update(messageVO,update);
//		return dao.findByPrimaryKey(messageID);
	}
	public List<MessageVO> findCourseRe(Integer courseID){
		return dao.findMessageByCourseID(courseID);
	} 
	
	public MessageVO getOneMessage(Integer messageID) {
		return dao.findByPrimaryKey(messageID);
	}

	public List<MessageVO> findAllResponse(Integer messageID_response) {
		return dao.findAllResponse(messageID_response);
	}

	

}
