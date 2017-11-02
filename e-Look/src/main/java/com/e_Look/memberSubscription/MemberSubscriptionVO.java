package com.e_Look.memberSubscription;

import java.io.Serializable;

public class MemberSubscriptionVO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Integer memberID;
	private Integer memberTrackID;
	public MemberSubscriptionVO() {};
	
	public MemberSubscriptionVO(Integer memberID, Integer memberTrackID) {
		this.memberID = memberID;
		this.memberTrackID = memberTrackID;
	}
	public Integer getMemberID() {
		return memberID;
	}
	public void setMemberID(Integer memberID) {
		this.memberID = memberID;
	}
	public Integer getMemberTrackID() {
		return memberTrackID;
	}
	public void setMemberTrackID(Integer memberTrackID) {
		this.memberTrackID = memberTrackID;
	}
}
