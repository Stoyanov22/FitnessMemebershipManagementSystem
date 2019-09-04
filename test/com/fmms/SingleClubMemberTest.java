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
        //TODO: Write cases for different clubIDs
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