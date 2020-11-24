import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BookList {
    private List<Book> bookList;

    public BookList() {
        this.bookList = new ArrayList<Book>();
    }

    public void addBook(Book book) {
        bookList.add(book);
    }

    public void printList() {
        if(bookList.isEmpty()) System.out.println("Kho sách đang trống.");
        else {
            for (Book book : bookList) {
                System.out.println(book.toString());
                System.out.println("");
            }
        }
    }

    public int searchBook(String Code) {
        int i = 1;
        for(Book book : bookList) {
            if(book.getBookID().equals(Code))
                return i;
            i++;
        }
        return -1;
    }

    public void updatePrice(String Code) {
        int search = searchBook(Code);
        if(search == -1)
            System.out.println("Không tìm thấy sách.");
        else {
            System.out.print("Nhập giá tiền mới: ");
            Scanner sc = new Scanner(System.in);
            double newPrice = sc.nextDouble();
            bookList.get(search - 1).setPrice(newPrice);

            System.out.println("\nThay đổi thành công.");
        }
        System.out.println("");
    }

    public void deleteBook(String Code) {
        int search = searchBook(Code);
        if(search == -1)
            System.out.println("Không tìm thấy sách.");
        else {
            bookList.remove(bookList.get(search - 1));
            System.out.println("Xóa thành công.");
        }
        System.out.println("");
    }

    public void createBookList() throws IOException {
        Scanner sc = new Scanner(System.in);
        String BookID;
        String Title;
        String Author;
        double Price;
        int Quantity;

        A:
        while (true) {
            System.out.print("Nhập mã sách (0 = Thoát): ");
            BookID = sc.nextLine();

            if(BookID.equals("0"))
                break;

            for(int i = 0; i < bookList.size(); i++) {
                if(BookID.equals(bookList.get(i).getBookID())) {
                    System.out.println("Sách đã tồn tại");
                    continue A;
                }
            }

            System.out.print("Tựa đề sách: ");
            Title = sc.nextLine();
            System.out.print("Tác giả: ");
            Author = sc.nextLine();
            System.out.print("Giá bìa: ");
            Price = sc.nextDouble();
            sc.nextLine();
            System.out.print("Số lượng nhập: ");
            Quantity = sc.nextInt();
            sc.nextLine();

            //Book book = new Book(BookID, Title, Author, Price, Quantity);
            //bookList.add(book);
            bookList.add(new Book(BookID, Title, Author, Price, Quantity));
        }

    }

}
