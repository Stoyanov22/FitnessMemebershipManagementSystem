package com.fmms;

public class MultiClubMember extends Member {

    private int membershipPoints;

    public MultiClubMember(int memberID, String name, double fees, int membershipPoints) {
        super(memberID, name, 'M', fees);
        this.membershipPoints = membershipPoints;
    }

    public int getMembershipPoints() {
        return membershipPoints;
    }

    public void setMembershipPoints(int membershipPoints) {
        this.membershipPoints = membershipPoints;
    }

    @Override
    public String toString() {
        return super.toString() + "," + membershipPoints;
    }

    @Override
    public boolean equals(Object obj) {
        MultiClubMember mcm = (MultiClubMember) obj;
        return super.equals(obj) && membershipPoints == mcm.membershipPoints;
    }
}
