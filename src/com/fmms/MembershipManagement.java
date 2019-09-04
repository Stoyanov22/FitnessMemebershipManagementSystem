package com.fmms;

import java.util.LinkedList;
import java.util.Optional;
import java.util.Scanner;

public class MembershipManagement {

    private Scanner reader = new Scanner(System.in);
    private FileHandler fileHandler = new FileHandler();

    public void initMenu() {
        System.out.println("WELCOME TO OZONE FITNESS CENTER");
        System.out.println("================================");
        System.out.println("1) Add member");
        System.out.println("2) Remove member");
        System.out.println("3) Display member information");
        System.out.println("0) to Exit");
        System.out.println("\nPlease enter value...");
        int userInput = getIntInput(3);
        switch (userInput) {
            case 1:
                addMember();
                break;
            case 2:
                removeMember();
                break;
            case 3:
                displayInfo();
                break;
            default:
                break;
        }
        System.out.println("Press any key to continue...");
        //TODO: if enter is clicked it should continue too.
        reader.next();
        initMenu();
    }

    protected void addMember() {
        String name = getUserName();
        int clubID = getClubOptions();
        int id = getNewMemberID();
        if (clubID == 4) fileHandler.appendMember(new MultiClubMember(id, name));
        else fileHandler.appendMember(new SingleClubMember(id, name, clubID));
        System.out.println("Member successfully added!");
    }

    protected void displayInfo() {
        int userInput = getPrintOptions();
        if(userInput == 1) printMemberInfo();
        else printAllMembers();
    }

    protected void removeMember() {

    }

    //Tries to read the INT value entered. If the user fails to enter an INT, the method keeps prompting the user enter new value;
    private int getIntInput(int maxValue) {
        int choice = -1;
        while (choice < 0 || choice > maxValue) {
            choice = reader.nextInt();
            if (choice == 0) {
                System.out.println("Thanks for using our app");
                break;
            }
            if (choice < 0 || choice > maxValue) {
                System.out.println("Invalid input. Please try again: ");
            }
            reader.nextLine();
        }

        return choice;
    }

    private int getNewMemberID() {
        LinkedList<Member> members = fileHandler.readMembers();
        if (members.size() > 0) {
            return members.getLast().getMemberID() + 1;
        } else return 1;
    }


    private String getUserName() {
        System.out.println("Enter member's name:");
        return reader.nextLine();
    }

    //Shows the user the available club options
    private int getClubOptions() {
        System.out.println("AVAILABLE CLUBS");
        System.out.println("================");
        System.out.println("1) Club Mercury");
        System.out.println("2) Club Neptune");
        System.out.println("3) Club Jupiter");
        System.out.println("4) Multiple Clubs");
        System.out.println("0) to Exit");
        return getIntInput(4);
    }

    private int getPrintOptions(){
        System.out.println("AVAILABLE Options");
        System.out.println("================");
        System.out.println("1) Print single member");
        System.out.println("2) Print all members");
        System.out.println("0) to Exit");
        return getIntInput(2);
    }

    public void printMemberInfo() {
        System.out.println("User ID: ");
        int id = reader.nextInt();
        LinkedList<Member> members = fileHandler.readMembers();
        Optional<Member> member = members.stream().filter(m->m.getMemberID() == id).findFirst();
        if(member.isPresent()) System.out.println(member.get());
        else System.out.println("No user with id " + id);
    }

    public void printAllMembers() {
        LinkedList<Member> members = fileHandler.readMembers();
        for(Member member : members){
            System.out.println(member);
        }
    }
}
