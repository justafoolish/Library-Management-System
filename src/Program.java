import java.util.Scanner;

public class Program {


    public static void main(String[] args) {
        BookList books = new BookList();
        boolean running = true;
        while (running) {
            System.out.println("--------------------------\n" +
                    "| Chào mừng đến thư viện |\n" +
                    "| Bạn là:                |\n" +
                    "|1. Quản lý thư viện.    |\n" +
                    "|2. Độc giả.             |\n" +
                    "|0. Thoát.               |\n" +
                    "--------------------------\n");

            System.out.print("Nhập lựa chọn: ");
            try {
                int choice = new Scanner(System.in).nextInt();
                switch (choice) {
                    case 0:
                        running = false;
                        break;
                    case 2:
                        borrower_menu();
                        break;
                    case 1:
                        admin_menu(books);
                        break;
                    default:
                        System.out.println("Lựa chọn không hợp lệ.");
                        break;
                        }
                } catch(Exception e) {
                        System.out.println("Lựa chọn không hợp lệ.");
                    }

        }
    }

    public static void borrower_menu() {
        Scanner sc = new Scanner(System.in);
        boolean running = true;
        while (running) {
            System.out.println("--------------------------\n" +
                    "|1. Login                |\n" +
                    "|2. Register             |\n" +
                    "|0. Exit                 |\n" +
                    "--------------------------\n");
            String account;
            System.out.print("Nhập lựa chọn: ");
            try {
                int choice = sc.nextInt();
                switch (choice) {
                    case 0:
                      running = false;
                      break;
                    case 2:
                        System.out.print("User: ");
                        account = sc.nextLine();
                    case 1:
                        System.out.print("Create User: ");
                        account = sc.nextLine();
                    default:
                        System.out.println("Lựa chọn không hợp lệ.");
                }
            } catch (Exception e) {
                System.out.println("Lựa chọn không hợp lệ.");
            }

        }
    }

    public static void admin_menu(BookList books) {
        Scanner sc = new Scanner(System.in);
        boolean running = true;
        while (running) {
            System.out.println("-------------------------------\n" +
                    "|1. Hiện thị toàn bộ Sách     |\n" +
                    "|2. Thêm sách mới vào thư viện|\n" +
                    "|3. Tìm kiếm sách theo mã     |\n" +
                    "|4. Cập nhật giá tiền sách    |\n" +
                    "|5. Xóa sách                  |\n" +
                    "|0. Thoát                     |\n" +
                    "-------------------------------\n");
            String keySearch;
            int choice;
            try {
                System.out.print("Lựa chọn: ");
                choice = sc.nextInt();
                sc.nextLine();
                switch (choice) {
                    case 0:
                        running = false;
                        break;
                    case 1: books.printList();
                            break;
                    case 2: books.createBookList();
                            break;
                    case 3:
                        System.out.print("Nhập mã sách cần tìm: ");
                        keySearch = sc.nextLine();
                        int search = books.searchBook(keySearch);
                        if(search == -1)
                            System.out.println("Không tìm thấy sách");
                        else {
                            System.out.println("Tìm thấy sách ở vị trí: " +search);
                        }
                        break;
                    case 4:
                        System.out.print("Nhập mã sách: ");
                        keySearch = sc.nextLine();
                        books.updatePrice(keySearch);
                        break;
                    case 5:
                        System.out.print("Nhập mã sách: ");
                        keySearch = sc.nextLine();
                        books.deleteBook(keySearch);
                        break;
                    default:
                        System.out.println("Lựa chọn không hợp lệ.");
                }

            } catch (Exception e) {
                System.out.println("Lựa chọn không hợp lệ.");
            }

        }
    }
}
