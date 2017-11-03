package com.e_Look.reportMessage.model;

import java.util.List;

import com.e_Look.member.model.MemberService;
import com.e_Look.message.model.MessageDAO;
import com.e_Look.message.model.MessageVO;

public class ReportMessageService {
	private ReportMessageDAO_interface dao;
	public ReportMessageService() {
		dao = new ReportMessageDAO();
	}
	public void insertReportMessage(Integer messageID, Integer reportMemberID,
			String reportContent) {
		
		ReportMessageVO reportMessageVO = new ReportMessageVO();
		MessageVO messageVO = new MessageVO();
		
		messageVO.setMessageID(messageID);
		reportMessageVO.setMessageVO(messageVO);
		reportMessageVO.setReportMemberID(reportMemberID);
		reportMessageVO.setReportContent(reportContent);
		dao.insert(reportMessageVO);
		
	}
	
	public String getJSON(Integer status) {
		return dao.getJSON(status);
	}
	
	public void hideMessage(Integer reportID,int status) {
		//使用Message欄位
		MessageDAO mdao = new MessageDAO(); 
		//用reportID及ReportMessageDAO去拿出rmVO物件
		ReportMessageVO rmVO = dao.findByReportId(reportID);
		//將ReportMessage的狀態設為1,審核結果為遮蔽留言
		rmVO.setStatus((byte) 1);
		dao.update(rmVO);
		
		Integer memberID = rmVO.getMessageVO().getMemberVO().getMemberID();
		
		MessageVO mVO = rmVO.getMessageVO();		
		//將傳進來的status訊息狀態設定進去Message裡
		mVO.setStatus((byte)status);
		//DAO裡有判斷式,使用符合status的update
		mdao.update(mVO, "status");
		
		MemberService mbServ = new MemberService();
		mbServ.updateMemberCount(memberID);
	}
	
	public void jugeMessage(Integer reportID,int status) {
		//用reportID及ReportMessageDAO去拿出rmVO物件
		ReportMessageVO rmVO = dao.findByReportId(reportID);
		//將ReportMessage的狀態設為2,審核結果為不處理
		rmVO.setStatus((byte) 2);
		dao.update(rmVO);
	}
	
	public List<ReportMessageVO>findNotHandle() {
		return dao.getNotHandle();
	}

	public void updateReportMessageStatus(Integer reportId, Byte status) {
		
		ReportMessageVO reportMessageVO = new ReportMessageVO();
		reportMessageVO.setReportId(reportId);
		reportMessageVO.setStatus(status);
		dao.update(reportMessageVO);
		
	}
	
	//寫著,但應該用不到
	public void deleteReportMessage(Integer reportId) {
		
		ReportMessageVO reportMessageVO = new ReportMessageVO();
		reportMessageVO.setReportId(reportId);
		dao.update(reportMessageVO);
		
	}
}
