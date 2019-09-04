package com.fmms;

public class SingleClubMember extends Member {

    private int clubID;

    public SingleClubMember(int memberID, String name, int clubID) {
        super(memberID, name);
        super.setMemberType('S');
        switch (clubID) {
            case 1:
                super.setFees(900);
                break;
            case 2:
                super.setFees(950);
                break;
            case 3:
                super.setFees(1000);
                break;
            default:
                throw new IllegalStateException("Illegal club selected for user " + name);
        }
        this.clubID = clubID;
    }

    public int getClubID() {
        return clubID;
    }

    public void setClubID(int clubID) {
        this.clubID = clubID;
    }

    @Override
    public String toString() {
        return super.toString() + "," + clubID;
    }

    @Override
    public boolean equals(Object obj) {
        SingleClubMember scm = (SingleClubMember) obj;
        return super.equals(obj) && clubID == scm.clubID;
    }
}
