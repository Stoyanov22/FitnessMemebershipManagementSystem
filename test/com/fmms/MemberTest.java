package com.fmms;

import org.junit.Test;

import static junit.framework.TestCase.*;

public class MemberTest {

    Member member = new Member(22, "Iliyan", 'M', 1000);

    @Test
    public void testMember() {
        assertNotNull(member.getMemberID());
        assertNotNull(member.getName());
        assertNotNull(member.getMemberType());
        assertNotNull(member.getFees());
    }

    @Test
    public void testToString() {
        assertEquals("22,Iliyan,M,1000.0", member.toString());
    }

    @Test
    public void testEquals() {
        assertEquals(new Member(22, "Iliyan", 'M', 1000), member);
        assertTrue(member.equals(new Member(22, "Iliyan", 'M', 1000)));
        assertNotSame(new Member(22, "Iliyan", 'S', 1000), member);
    }

    @Test
    public void testHashCode() {
        assertEquals(22, member.hashCode());
        assertNotSame(member.hashCode(), new Member(1, "Iliyan", 'M', 1000).hashCode());
    }
}