import java.io.IOException;

public interface iBooks {

    public void createBookList() throws IOException;

    public void updatePrice(String Code);

    public void deleteBook(String Code);

    public void printList();

    public int searchBook(String Code);

}
