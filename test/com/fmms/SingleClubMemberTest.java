package com.fmms;

import org.junit.Test;

import static junit.framework.TestCase.*;
import static org.junit.Assert.assertNotNull;

public class SingleClubMemberTest {

    SingleClubMember member = new SingleClubMember(22, "Iliyan", 2);

    @Test
    public void testSingleClubMember() {
        assertNotNull(member.getMemberID());
        assertNotNull(member.getName());
        assertNotNull(member.getMemberType());
        assertNotNull(member.getFees());
        assertNotNull(member.getClubID());
        assertEquals('S', member.getMemberType());
        assertTrue(member.getClubID() > 0 && member.getClubID() < 4);
        assertEquals(950.0, member.getFees());
        SingleClubMember testMember = new SingleClubMember(1, "Pepi", 1);
        assertEquals(900.0, testMember.getFees());
        testMember = new SingleClubMember(2, "Toti", 3);
        assertEquals(1000.0, testMember.getFees());
    }

    @Test
    public void testToString() {
        assertEquals("22,Iliyan,S,950.0,2", member.toString());
    }

    @Test
    public void testEquals() {
        assertTrue(member.equals(new SingleClubMember(22, "Iliyan", 2)));
        assertFalse(member.equals(new SingleClubMember(22, "Iliyan", 3)));
    }
}