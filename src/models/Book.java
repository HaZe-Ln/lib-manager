package models;

public class Book {
    private long id;
    private String title;
    private String author;
    private String category;
    private int quantity;

    public Book(long id, String title, String author, String category, int quanlity) {
        this.id = id;
        this.title = title;
        this.author = this.author;
        this.category = this.category;
        this.quantity = quantity;
    }



    // Getters và Setters
    public long getid() { return id; }
    public void setid(long id) { this.id = id; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getAuthor() { return author; }
    public void setAuthor(String author) { this.author = author; }

    public String getCategory() { return category; }
    public void setCategory(String category) { this.category = category; }

    public int getQuantity() { return quantity; }
    public void setQuantity(int quantity) { this.quantity = quantity; }

    public static String toStringHeader() {
        return String.format(
            "ID\tName\tTitle\tAuthor\tCategory\tQuanlity"
        );
    }

    @Override
    public String toString() {
        return String.format(
            id + "\t" + title + "\t" + author + "\t" + category + "\t" + quantity
        );
    }
}
