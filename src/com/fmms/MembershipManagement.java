package com.fmms;

import java.util.Scanner;

public class MembershipManagement {

    private Scanner reader = new Scanner(System.in);

    //Tries to read the INT value entered. If the user fails to enter an INT, the method keeps prompting the user enter new value;
    private int getIntInput() {
        int choice = 0;
        while (choice == 0) {
            choice = reader.nextInt();
            if (choice == 0) {
                System.out.println("Invalid input. Please try again: ");
            }
            reader.nextLine();
        }

        return choice;
    }

    //Shows the user the available club options
    private void printClubOptions() {
        System.out.println("AVAILABLE CLUBS");
        System.out.println("================");
        System.out.println("1) Club Mercury");
        System.out.println("2) Club Neptune");
        System.out.println("3) Club Jupiter");
        System.out.println("4) Multiple Clubs");
    }

    public int getStartOperation() {
        System.out.println("WELCOME TO OZONE FITNESS CENTER");
        System.out.println("================================");
        System.out.println("1) Add member");
        System.out.println("2) Remove member");
        System.out.println("3) Display member information");
        System.out.println("\nPlease enter value...");
        return getIntInput();
    }

    public void addMember() {

    }

    public void removeMember() {

    }

    public void printMemberInfo() {

    }

    public void printAllMembers() {

    }
}
