public class Book {
    private String bookID;
    private String title;
    private String author;
    private double price;
    private int quantity;

    public Book() {}

    public Book(String bookID, String title, String author, double price, int quantity) {
        this.bookID = bookID;
        this.title = title;
        this.author = author;
        this.price = price;
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
    }
    public int getQuantity() {
        return quantity;
    }
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    public String getAuthor() {
        return author;
    }
    public String getTitle() {
        return title;
    }
    public String getBookID() {
        return bookID;
    }

    @Override
    public String toString() {
        String s = bookID + "|\t" + title + "|\t" + author + "|\t" + price + "|\t" + quantity;
        return s;
    }
}
