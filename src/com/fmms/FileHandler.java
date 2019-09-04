package com.fmms;

import java.io.*;
import java.util.LinkedList;

public class FileHandler {

    //Adds a member to the CSV list of members
    public void appendMember(Member member) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("members.csv", true))) {
            writer.write(member + "\n");
        } catch (IOException e) {
            System.out.println("Writing in the file failed for some reason. Please try again or contact support");
        }
    }

    //Reads a file and returns a LinkedList of Members
    public LinkedList<Member> readMembers() {
        LinkedList<Member> members = new LinkedList<>();
        String lineRead;
        String[] splitLine;
        Member member;

        try (BufferedReader reader = new BufferedReader(new FileReader("members.csv"))) {

            while ((lineRead = reader.readLine()) != null) {
                //22,Iliyan,M,1200,100
                splitLine = lineRead.split(",");
                if (splitLine[2].equals("S")) {
                    member = new SingleClubMember(Integer.parseInt(splitLine[0]), splitLine[1], Integer.parseInt(splitLine[4]));
                } else {
                    member = new MultiClubMember(Integer.parseInt(splitLine[0]), splitLine[1]);
                }

                members.add(member);
            }
        } catch (FileNotFoundException e) {
            System.out.println("The file was not found. Please try again or contact support");
        } catch (IOException e) {
            System.out.println("The file could not be read. Please try again or contact support");
        } catch (NumberFormatException e) {
            System.out.println("Some of the rows in the file was incorrect");
        }

        return members;
    }

    //It is called when we want to remove a member from a club
    public void overwriteMembers(LinkedList<Member> members) {
        for (Member member : members) {
            try (BufferedWriter writer = new BufferedWriter(new FileWriter("temp.csv", true))) {
                writer.write(member.toString() + "\n");
            } catch (IOException e) {
                System.out.println("Writing in the file failed. Please try again or contact support");
            }
        }

        try {
            File oldMembersFile = new File("members.csv");
            File newMembersFile = new File("temp.csv");
            oldMembersFile.delete();
            newMembersFile.renameTo(oldMembersFile);
        } catch (Exception e) {
            System.out.println("The file failed to update. Please try again or contact support");
        }
    }
}