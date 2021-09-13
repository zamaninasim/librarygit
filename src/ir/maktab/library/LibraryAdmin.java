package ir.maktab.library;

public class LibraryAdmin {
    static String adminUsername = "admin";
    static String adminPassword = "admin";
    static int indexOfBook = 0;
    static int indexOfMember = 0;
    Book[] books = new Book[50];
    Member[] members = new Member[50];

    public LibraryAdmin() {
        for (int i = 0; i < 50; i++) {
            books[i] = new Book();
            members[i] = new Member();
        }
    }


    public boolean addBook(String name, int count) {
        boolean checkAddBook = false;
        boolean checkBookExist = false;
        if (indexOfBook < 51) {
            for (int i = 0; i < indexOfBook; i++) {
                if (books[i].getName().equals(name)) {
                    books[i].setCount(books[i].getCount() + count);
                    checkBookExist = true;
                    checkAddBook = true;
                }
            }
            if (!checkBookExist) {
                Book book = new Book(name, count);
                books[indexOfBook] = book;
                indexOfBook++;
                checkAddBook = true;
            }
        }
        return checkAddBook;
    }

    public boolean addMember(String name, int birthYear) {
        boolean checkAddMember = false;
        if (indexOfMember < 51) {
            Member member = new Member(name, birthYear);
            members[indexOfMember] = member;
            indexOfMember++;
            checkAddMember = true;
        }
        return checkAddMember;
    }

    public boolean getBook(int memberID, int bookID) {
        boolean checkBookExist = false;
        Book book = new Book();
        int bookIndex=100;
        for (int i = 0; i < indexOfBook; i++) {
            if (books[i].getId() == bookID) {
                if (books[i].getCount() > 0) {
                    checkBookExist = true;
                    book = books[i];
                    bookIndex=i;
                } else {
                    System.out.println("Count of book not enough!");
                    return false;
                }
            }
        }
        if (!checkBookExist) {
            System.out.println("BookId not exist!");
            return false;
        }

        boolean checkMemberExist = false;
        for (int i = 0; i < indexOfMember; i++) {
            if (members[i].getId() == memberID) {
                if (members[i].getIndexOfBorrowedBooks() < 5) {
                    Book[] borrowedBooks = members[i].getBorrowedBooks();
                    for(int j=0; j<members[i].getIndexOfBorrowedBooks();j++){
                        if(borrowedBooks[j].getName().equals(book.getName())){
                            System.out.println("This book has already been borrowed by this member.");
                            return false;
                        }
                    }
                    checkMemberExist = true;
                    members[i].borrowBook(book);
                    books[bookIndex].setCount(books[bookIndex].getCount()-1);
                } else {
                    System.out.println("MaxReached");
                    return false;
                }
            }
        }
        if (!checkMemberExist) {
            System.out.println("MemberId not exist!");
            return false;
        }
        return true;
    }

    public boolean returnBook(int memberID, int bookID) {
        boolean checkBookExist = false;
        Book book = new Book();
        int bookIndex=100;
        for (int i = 0; i < indexOfBook; i++) {
            if (books[i].getId() == bookID) {
                checkBookExist = true;
                book = books[i];
                bookIndex = i;
            }
        }
        if (!checkBookExist) {
            System.out.println("BookId not exist!");
            return false;
        }
        boolean checkMemberExist = false;
        for (int i = 0; i < indexOfMember; i++) {
            if (members[i].getId() == memberID) {
                checkMemberExist = true;
                int borrowedBookIndex = members[i].searchBook(book.getId());
                if (members[i].getIndexOfBorrowedBooks() > 0 && borrowedBookIndex < 5) {
                    members[i].shiftBookList(borrowedBookIndex);
                }
                if (borrowedBookIndex > 5) {
                    System.out.println("This member does not borrow this book!");
                    return false;
                } else {
                    members[i].setIndexOfBorrowedBooks(members[i].getIndexOfBorrowedBooks() - 1);
                    books[bookIndex].setCount(books[bookIndex].getCount()+1);
                }
            }
        }
        if (!checkMemberExist) {
            System.out.println("MemberId not exist!");
            return false;
        }
        return true;
    }

    public void bookState() {
        for (int i = 0; i < indexOfBook; i++) {
            System.out.println("Book name: " + books[i].getName() +
                    " | Book Id: " + books[i].getId() +
                    " | Book Count: " + books[i].getCount());
        }
    }

    public void memberState() {
        for (int i = 0; i < indexOfMember; i++) {
            System.out.print("Member name: " + members[i].getName() +
                    " | Member Id: " + members[i].getId() +
                    " | Borrowed Books: ");
            Book[] borrowedBooks = members[i].getBorrowedBooks();
            for (int j = 0; j < members[i].getIndexOfBorrowedBooks(); j++) {
                System.out.print("[name: " + borrowedBooks[j].getName() +
                        " ,id: " + borrowedBooks[j].getId() + "] ");
            }
            System.out.println("\n");
        }
    }
}
