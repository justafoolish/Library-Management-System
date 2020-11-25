import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Librarian implements iBooks{
    private List<Book> librarian;

    public Librarian() {
        this.librarian = new ArrayList<Book>();
    }

    public void addBook(Book book) {
        librarian.add(book);
    }

    public List<Book> getLibrarian() {
        return librarian;
    }

    //HIển thị toàn bộ danh sách sách ra màn hình
    @Override
    public void printList() {
        if(librarian.isEmpty()) System.out.println("Kho sách đang trống.");
        else {
            for (Book book : librarian) {
                System.out.println(book.toString());
                System.out.println("");
            }
        }
    }

    //Tìm kiếm sách trong thư viện
    @Override
    public int searchBook(String Code) {
        int i = 1;
        for(Book book : librarian) {
            if(book.getBookID().equals(Code))
                return i;
            i++;
        }
        return -1;
    }

    //Cập nhật giá tiền sách theo mã
    @Override
    public void updatePrice(String Code) {
        int search = searchBook(Code);
        if(search == -1)
            System.out.println("Không tìm thấy sách.");
        else {
            System.out.print("Nhập giá tiền mới: ");
            Scanner sc = new Scanner(System.in);
            double newPrice = sc.nextDouble();
            librarian.get(search - 1).setPrice(newPrice);

            System.out.println("\nThay đổi thành công.");
        }
        System.out.println("");
    }

    //Xóa sách khỏi thư viện theo mã
    @Override
    public void deleteBook(String Code) {
        int search = searchBook(Code);
        if(search == -1)
            System.out.println("Không tìm thấy sách.");
        else {
            librarian.remove(librarian.get(search - 1));
            System.out.println("Xóa thành công.");
        }
        System.out.println("");
    }

    @Override
    //Quản trị viên nhập sách vào thư viện từ bàn phím
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

            for(int i = 0; i < librarian.size(); i++) {
                if(BookID.equals(librarian.get(i).getBookID())) {
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

            librarian.add(new Book(BookID, Title, Author, Price, Quantity));
        }

    }

    //Quản trị viên lưu toàn bộ sách vào file
    public void outputFILE() throws IOException {
        if(librarian.isEmpty())
            System.out.println("Kho sách đang trống.");
       else {
            try {
                File f = new File("BookList.txt");
                FileWriter fr = new FileWriter(f);
                for (Book books : librarian) {

                    fr.write(books.getBookID() + "|\t" +
                            books.getTitle() + "|\t" +
                            books.getAuthor() + "|\t" +
                            books.getPrice() + "|\t" +
                            books.getQuantity());

                    fr.write("\n");

                }
                System.out.println("Ghi thành công vào BookList.txt");
                fr.close();

            } catch (IOException e) {
                System.out.println("FILE ERROR!");
            }
        }
    }

    //Nhập file danh sách các Sách từ file
    public void readFILE() throws IOException {
        try {
            File f = new File("BookList.txt");
            FileReader fr = new FileReader(f);
            BufferedReader br = new BufferedReader(fr);
            String s;
            String[] array = new String[6];

            String xBookID;
            String xTitle;
            String xAuthor;
            double xPrice;
            int xQuantity;

            while(true) {
                s = br.readLine();
                if(s == null)
                    break;
                array = s.split("\\|");
                xBookID = array[0].trim();
                xTitle = array[1].trim();
                xAuthor = array[2].trim();
                xPrice = Double.parseDouble(array[3].trim());
                xQuantity = Integer.parseInt(array[4].trim());

                addBook(new Book(xBookID, xTitle, xAuthor, xPrice, xQuantity));
            }
            System.out.println("Đọc file thành công!");

            fr.close();
            br.close();
        } catch (Exception e) {
            System.out.println("FILE ERROR!");
        }
    }

}
