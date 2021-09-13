package ir.maktab.library;

import java.util.Arrays;

public class Member {
    private String name;
    private int birthYear;
    private int id;
    Book[] borrowedBooks = new Book[5];
    private int indexOfBorrowedBooks = 0;
    static int memberCounter = 0;

    public Member() {
    }

    public Member(String name, int birthYear) {
        this.name = name;
        this.birthYear = birthYear;
        this.id = memberCounter;
        memberCounter++;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getBirthYear() {
        return birthYear;
    }

    public void setBirthYear(int birthYear) {
        this.birthYear = birthYear;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Book[] getBorrowedBooks() {
        return borrowedBooks;
    }

    public void setIndexOfBorrowedBooks(int indexOfBorrowedBooks) {
        this.indexOfBorrowedBooks = indexOfBorrowedBooks;
    }

    public int getIndexOfBorrowedBooks() {
        return indexOfBorrowedBooks;
    }

    public void borrowBook(Book book) {
        borrowedBooks[indexOfBorrowedBooks] = book;
            indexOfBorrowedBooks++;
    }

    public int searchBook(int bookId){
        int bookIndex=100;
        for (int i=0; i<indexOfBorrowedBooks;i++){
            if(borrowedBooks[i].getId() == bookId){
                bookIndex=i;
            }
        }
        return bookIndex;
    }

    public void shiftBookList(int bookIndex){
        for (int i=0; i<indexOfBorrowedBooks;i++){
            if(i==bookIndex){
                for(int j=i;j<indexOfBorrowedBooks-1;j++){
                    borrowedBooks[j]=borrowedBooks[j+1];
                }
            }
        }
    }
}
