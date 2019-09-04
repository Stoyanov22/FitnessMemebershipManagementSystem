package com.fmms;

import org.junit.Test;

import static junit.framework.TestCase.*;

public class MemberTest {

    Member member = new Member(22, "Iliyan");

    @Test
    public void testMember() {
        assertNotNull(member.getMemberID());
        assertNotNull(member.getName());
        assertNotNull(member.getMemberType());
        assertNotNull(member.getFees());
    }

    @Test
    public void testToString() {
        Member testMember = member;
        testMember.setMemberType('S');
        testMember.setFees(100);
        assertEquals("22,Iliyan,S,100.0", member.toString());
    }

    @Test
    public void testEquals() {
        assertTrue(member.equals(new Member(22, "Iliyan")));
        assertFalse(member.equals(new Member(22, "Atanas")));
    }

    @Test
    public void testHashCode() {
        assertEquals(22, member.hashCode());
        assertNotSame(member.hashCode(), new Member(1, "Iliyan").hashCode());
    }
}