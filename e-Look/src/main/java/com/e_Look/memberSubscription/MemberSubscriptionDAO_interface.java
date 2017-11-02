package com.e_Look.memberSubscription;

import java.util.List;

public interface MemberSubscriptionDAO_interface {
	
	public void insert(MemberSubscriptionVO memberSubscriptionVO);
	public void update(MemberSubscriptionVO memberSubscriptionVO);
	public void delete(Integer memberID, Integer memberTrackID);
	public List<MemberSubscriptionVO> findByMemberID(Integer memberID);
	public List<MemberSubscriptionVO> getAll();

}
