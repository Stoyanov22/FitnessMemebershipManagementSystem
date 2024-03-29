package com.fmms;

public class Member {
    private int memberID;
    private String name;
    private char memberType;
    private double fees;

    public Member(int memberID, String name) {
        this.memberID = memberID;
        this.name = name;
    }

    public int getMemberID() {
        return memberID;
    }

    public void setMemberID(int memberID) {
        this.memberID = memberID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public char getMemberType() {
        return memberType;
    }

    public void setMemberType(char memberType) {
        this.memberType = memberType;
    }

    public double getFees() {
        return fees;
    }

    public void setFees(double fees) {
        this.fees = fees;
    }

    @Override
    public String toString() {
        return memberID + "," + name + "," + memberType + "," + fees;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Member member = (Member) obj;
        return memberID == member.memberID && name.equals(member.name) && memberType == memberType && fees == member.fees;
    }

    @Override
    public int hashCode() {
        return memberID;
    }
}
