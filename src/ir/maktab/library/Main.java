package ir.maktab.library;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        LibraryAdmin admin = new LibraryAdmin();
        String username;
        String password;
        boolean checkUsername;
        boolean checkPassword;
        do {
            System.out.println("*********Library*********");
            System.out.println("Enter username and password:");
            username = input.next();
            password = input.next();
            checkUsername=admin.adminUsername.equals(username);
            checkPassword = admin.adminPassword.equals(password);
            if(!checkUsername || ! checkPassword){
                System.out.println("Username or Password is incorrect!");
            }
        } while (!checkUsername && !checkPassword);
        do {
            int choice;
            do {
                System.out.println("Enter number of Choice:");
                System.out.println("****Menu****");
                System.out.println("1.Add Book\n2.Add Member\n3-Get Book\n4.Return Book\n" +
                        "5.Book State\n6.Member State");
                while (!input.hasNextInt()) {
                    System.out.printf("Your choice was \"%s\". Please enter a number:%n", input.next());
                }
                choice = input.nextInt();
                switch (choice) {
                    case 1:
                        System.out.println("Enter name and count of BOOK:");
                        boolean checkAddBook = admin.addBook(input.next(), input.nextInt());
                        if (checkAddBook) {
                            System.out.println("This book add to library successfully!\n");
                        } else {
                            System.out.println("NOT ADD!\n");
                        }
                        break;
                    case 2:
                        System.out.println("Enter name and birth year of MEMBER:");
                        boolean checkAddMember = admin.addMember(input.next(), input.nextInt());
                        if (checkAddMember) {
                            System.out.println("This member add to library successfully!\n");
                        } else {
                            System.out.println("NOT ADD!\n");
                        }
                        break;
                    case 3:
                        System.out.println("Enter MemberID and BookID:");
                        boolean checkGetBook = admin.getBook(input.nextInt(), input.nextInt());
                        if (checkGetBook) {
                            System.out.println("Get Successfully!\n");
                        }
                        break;
                    case 4:
                        System.out.println("Enter MemberID and BookID:");
                        boolean checkReturnBook = admin.returnBook(input.nextInt(), input.nextInt());
                        if (checkReturnBook) {
                            System.out.println("Return Successfully!\n");
                        }
                        break;
                    case 5:
                        System.out.println("*****Book State*****");
                        admin.bookState();
                        break;
                    case 6:
                        System.out.println("*****Member State*****");
                        admin.memberState();
                        break;
                    default:
                        System.out.println("Choice is invalid!");
                }
            } while (choice < 1 || choice > 6);
        }while (true);
    }
}
