package com.fmms;

public class MultiClubMember extends Member {

    private int membershipPoints;

    public MultiClubMember(int memberID, String name) {
        super(memberID, name);
        super.setMemberType('M');
        super.setFees(1200.0);
        this.membershipPoints = 100;
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
