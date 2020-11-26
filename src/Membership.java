import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public abstract class Membership {
    private String username;
    private String name;
    private int age;
    private String address;
    private BookLendingCard bookLending;

    public Membership() {
        this.bookLending  = new BookLendingCard();
    }

    public Membership(String username, String name, int age, String address) {
        this.username = username;
        this.name = name;
        this.age = age;
        this.address = address;
        this.bookLending  = new BookLendingCard();
    }

    public BookLendingCard getBookLending() {
        return bookLending;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }


    //Truyền vào danh sách sách trong thư viện
    public void addBook(List<Book> books) throws IOException {
        Scanner sc = new Scanner(System.in);
        String bookID;

        System.out.print("Nhập mã sách: ");
        bookID = sc.nextLine();

        boolean flag = false;
        for(Book b : books) {
            if(bookID.equals(b.getBookID()) && b.getQuantity() > 0) {
                bookLending.listbook(b);
                flag = true;
                System.out.println("Thêm sách thành công.");
                b.setQuantity(b.getQuantity()-1);
                break;
            }
            if(b.getQuantity() == 0) {
                System.out.println("Sách hiện đã hết.");
                flag = true;
                break;
            }
        }
        if(flag == false)
            System.out.println("Sách không tồn tại");

    }

    //Hiển thị các sách đang mượn được lưu trong tài khoản
    public void printListBook() {
        if(!(bookLending.getBooks().isEmpty())) {
            System.out.println("Danh sách các sách đang mượn: ");
            for (Book book : bookLending.getBooks()) {
                System.out.println("Tên sách: " + book.getTitle() + "\tMã sách: " + book.getBookID() + "\tTác giả: " + book.getAuthor());
            }
        }
    }

    //Xóa sách khỏi thẻ mượn trong tài khoản:
    public void returnBook(String code) {
        boolean flag = false;
        for(Book b : bookLending.getBooks()) {
            if(b.getBookID().equals(code)) {
                bookLending.deleteBook(b);
                System.out.println("Trả sách thành công.");
                flag = true;
            }
        }

        if(flag == false)
            System.out.println("Không tìm thấy sách");
    }


    //Hiển thị thông tin tài khoản
    public abstract String printInfo();


    //In phiếu mượn
    public abstract void writeFILE();

}
