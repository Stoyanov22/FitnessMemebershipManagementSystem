package com.fmms;

public class MultiClubMember extends Member {

    private int membershipPoints;

    public MultiClubMember(int memberID, String name, char memberType, double fees, int membershipPoints) {
        super(memberID, name, memberType, fees);
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
        return super.toString() + " and " + membershipPoints + " membership points";
    }

    @Override
    public boolean equals(Object obj) {
        MultiClubMember mcm = (MultiClubMember) obj;
        return super.equals(obj) && membershipPoints == mcm.membershipPoints;
    }
}
