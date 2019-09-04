package com.fmms;

import com.sun.xml.internal.bind.v2.runtime.unmarshaller.XsiNilLoader;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;

import static org.junit.Assert.*;

public class FileHandlerTest {
    FileHandler fh = new FileHandler();
    SingleClubMember member = new SingleClubMember(1, "Ivaka", 1);
    MultiClubMember member2 = new MultiClubMember(2, "Velina");

    @Test
    public void testAppendFile() {
        fh.appendMember(member.toString());
        File f = new File("members.csv");
        assertTrue(f.exists());
        String lineRead;
        String lastLine = null;

        try (BufferedReader reader = new BufferedReader(new FileReader("members.csv"))) {
            while ((lineRead = reader.readLine()) != null) {
                lastLine = lineRead;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        assertEquals(member.toString(), lastLine);
    }

    @Test
    public void testReadFile() {
        LinkedList<Member> members = fh.readMembers();
        compareFileToLinkedList(members);
    }

    @Test
    public void testOverwriteFile() {
        LinkedList<Member> members = new LinkedList<>();
        members.add(member);
        members.add(member2);
        fh.overwriteMembers(members);
        compareFileToLinkedList(members);
    }

    protected void compareFileToLinkedList(LinkedList<Member> members){
        try (BufferedReader reader = new BufferedReader(new FileReader("members.csv"))) {
            String lineRead = reader.readLine();
            for (int i = 0; lineRead != null; i++, lineRead = reader.readLine()) {
                String[] splitLine = lineRead.split(",");
                if (splitLine[2].equals("S")) {
                    assertEquals(members.get(i).toString(), new SingleClubMember(Integer.parseInt(splitLine[0]), splitLine[1], Integer.parseInt(splitLine[4])).toString());
                } else {
                    assertEquals(members.get(i).toString(), new MultiClubMember(Integer.parseInt(splitLine[0]), splitLine[1]).toString());
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}