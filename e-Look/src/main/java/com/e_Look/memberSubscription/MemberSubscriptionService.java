package com.e_Look.memberSubscription;

import java.util.List;

public class MemberSubscriptionService {
	private MemberSubscriptionDAO_interface dao;

	public MemberSubscriptionService() {
		dao = new MemberSubscriptionDAO();
	}

	public void insertMemberSubscription(Integer memberID,Integer memberTrackID) {
		MemberSubscriptionVO memberSubscriptionVO =new MemberSubscriptionVO();
		memberSubscriptionVO.setMemberID(memberID);
		memberSubscriptionVO.setMemberTrackID(memberTrackID);
		dao.insert(memberSubscriptionVO);
		
	}

	public void deleteMemberSubscription(Integer memberID, Integer memberTrackID) {
		dao.delete(memberID, memberTrackID);
		
	}
	public List<MemberSubscriptionVO> findPrimaryMemberBookmarks(Integer memberID) {
		return dao.findByMemberID(memberID);
	}
	
}	