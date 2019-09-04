package com.fmms;

import org.junit.Test;

import static junit.framework.TestCase.*;
import static org.junit.Assert.assertNotNull;

public class MultiClubMemberTest {

    MultiClubMember member = new MultiClubMember(22, "Iliyan");

    @Test
    public void testSingleClubMember() {
        assertNotNull(member.getMemberID());
        assertNotNull(member.getName());
        assertNotNull(member.getMemberType());
        assertNotNull(member.getFees());
        assertNotNull(member.getMembershipPoints());
        assertEquals('M', member.getMemberType());
        assertEquals(100, member.getMembershipPoints());
    }

    @Test
    public void testToString() {
        assertEquals("22,Iliyan,M,1200.0,100", member.toString());
    }

    @Test
    public void testEquals() {
        assertTrue(member.equals(new MultiClubMember(22, "Iliyan")));
        assertFalse(member.equals(new MultiClubMember(22, "Atanas")));
    }
}