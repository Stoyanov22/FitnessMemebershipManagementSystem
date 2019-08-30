package com.fmms;

public class SingleClubMember extends Member {

    private int clubID;

    public SingleClubMember(int memberID, String name,  double fees, int clubID) {
        super(memberID, name, 'S', fees);
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
