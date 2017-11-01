package com.e_Look.message.model;

import java.util.List;



public interface MessageDAO_interface {
	public void insert(MessageVO messageVO);
	public void insert_re(MessageVO messageVO);
	public void update(MessageVO messageVO,String update);
    public void delete(Integer messageID);
    public MessageVO findByPrimaryKey(Integer messageID);
    public List<MessageVO>  findByPrimaryKeyM(Integer courseID);
    public List<MessageVO> getAll();
}
