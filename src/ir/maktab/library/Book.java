package ir.maktab.library;

public class Book {
    private String name;
    private int id;
    private int count;
    static int bookCounter =0;

    public Book() {
    }

    public Book(String name, int count) {
        this.name = name;
        this.count = count;
        this.id= bookCounter;
        bookCounter++;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
