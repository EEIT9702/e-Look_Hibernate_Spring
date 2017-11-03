package com.e_Look.message.model;

import java.util.List;
public interface MessageDAO_interface {
	public Integer insert(MessageVO messageVO);
	public void insert_re(MessageVO messageVO);
	public void update(MessageVO messageVO,String update);
    public void delete(Integer messageID);
    public MessageVO findByPrimaryKey(Integer messageID);
    public List<MessageVO> findAllResponse(Integer messageID_response);
    public List<MessageVO> findMessageByCourseID(Integer courseID);
    public List<MessageVO> getAll();
}
