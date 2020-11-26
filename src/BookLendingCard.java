import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BookLendingCard {
    private List<Book> books = new ArrayList<>();

    public BookLendingCard() {}

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
