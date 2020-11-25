import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BookLendingCart {
    private List<Book> books = new ArrayList<>();

    public BookLendingCart() {}

    public List<Book> getBooks() {
        return books;
    }

    public void listbook(Book b) {
        books.add(b);
    }

    public void deleteBook(Book b) {
        books.remove(b);
    }

}
