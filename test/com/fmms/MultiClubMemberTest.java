package com.fmms;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNotSame;
import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.*;

public class MultiClubMemberTest {

    MultiClubMember member = new MultiClubMember(22, "Iliyan", 2000, 1000);

    @Test
    public void testSingleClubMember() {
        assertNotNull(member.getMemberID());
        assertNotNull(member.getName());
        assertNotNull(member.getMemberType());
        assertNotNull(member.getFees());
        assertNotNull(member.getMembershipPoints());
        assertEquals('M', member.getMemberType());
        assertEquals(1000, member.getMembershipPoints());
    }

    @Test
    public void testToString() {
        assertEquals("22,Iliyan,M,2000.0,1000", member.toString());
    }

    @Test
    public void testEquals() {
        assertEquals(new MultiClubMember(22, "Iliyan", 2000, 1000), member);
        assertTrue(member.equals(new MultiClubMember(22, "Iliyan", 2000, 1000)));
        assertNotSame(new MultiClubMember(22, "Iliyan", 2000, 1000), member);
    }
}