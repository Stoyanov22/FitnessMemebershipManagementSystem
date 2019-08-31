package com.fmms;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;

import static org.junit.Assert.*;

public class FileHandlerTest {
    FileHandler fh = new FileHandler();
    SingleClubMember member = new SingleClubMember(1, "Ivaka", 900, 1);
    MultiClubMember member2 = new MultiClubMember(2, "Velina", 1100, 1000);

    @Test
    public void testAppendFile() {
        fh.appendFile(member.toString());
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
        LinkedList<Member> members = fh.readFile();
        compareFileLinesToLinkedList(members);
    }

    @Test
    public void testOverwriteFile() {
        LinkedList<Member> members = new LinkedList<>();
        members.add(member);
        members.add(member2);
        fh.overwriteFile(members);
        compareFileLinesToLinkedList(members);
    }

    private void compareFileLinesToLinkedList(LinkedList<Member> members){
        try (BufferedReader reader = new BufferedReader(new FileReader("members.csv"))) {
            String lineRead = reader.readLine();
            for (int i = 0; lineRead != null; i++, lineRead = reader.readLine()) {
                assertEquals(members.get(i).toString(), lineRead);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}