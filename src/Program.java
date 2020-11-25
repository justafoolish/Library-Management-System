import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Program {
    private static Librarian librarian = new Librarian();
    private static List<Kid> kidMember = new ArrayList<>();
    private static List<Adult> adultMember = new ArrayList<>();

    public static void main(String[] args) {
        boolean running = true;
        while (running) {
            System.out.println("--------------------------\n" +
                    "| Chào mừng đến thư viện |\n" +
                    "|          Menu          |\n" +
                    "|1. Quản lý thư viện.    |\n" +
                    "|2. Đăng nhập.           |\n" +
                    "|3. Đăng ký thành viên   |\n" +
                    "|0. Thoát.               |\n" +
                    "--------------------------\n");

            System.out.print("Nhập lựa chọn: ");
            try {
                int choice = new Scanner(System.in).nextInt();
                switch (choice) {
                    case 0:
                        running = false;
                        break;
                    case 1:
                        admin_menu();
                        break;
                    case 2:
                        user_login();
                        break;
                    case 3:
                        register_menu();
                    default:
                        System.out.println("Lựa chọn không hợp lệ.");
                        break;
                    }
                } catch(Exception e) {
                        System.out.println("Lựa chọn không hợp lệ.");
                }
            }
    }


    /*--------------------------Menu chính -------------------------------*/

    //Đăng ký
    public static void register_menu() {
        Scanner sc = new Scanner(System.in);
        boolean running = true;
        while (running) {
            System.out.println("--------------------------\n" +
                    "|         Menu           |\n" +
                    "|1. Người lớn.           |\n" +
                    "|2. Trẻ em.              |\n" +
                    "|0. Exit                 |\n" +
                    "--------------------------\n");
            System.out.println("Nhập lựa chọn: ");
            try {
                int choice = sc.nextInt();
                sc.nextLine();
                if(choice == 0) {
                    running = false;
                    break;
                }
                String name;
                String username;
                String address;
                int age;

                System.out.print("Họ và tên: ");
                name = sc.nextLine();
                System.out.print("Tên tài khoản thư viện: ");
                username = sc.nextLine();;
                System.out.print("Tuổi: ");
                age = sc.nextInt();
                sc.nextLine();
                System.out.print("Địa chỉ: ");
                address = sc.nextLine();

                switch (choice) {
                    case 0:
                        running = false;
                        break;
                    case 1:
                        //Tạo tài khoản người lớn

                        Adult adult = new Adult(username,name,age,address);
                        adultMember.add(adult);
                        System.out.println("Đăng ký thành công!");

                        break;

                    case 2:
                        //Tạo tài khoản cho trẻ em

                        Kid kid = new Kid(username,name,age,address);
                        kidMember.add(kid);
                        System.out.println("Đăng ký thành công!");

                        break;
                    default:
                        System.out.println("Lựa chọn không hợp lệ");
                        break;

                }
            } catch (Exception e) {
                System.out.println("Lựa chọn không hợp lệ");
                running = false;
                break;
            }
        }
    }

    //Menu quản trị
    public static void admin_menu() {

        Scanner sc = new Scanner(System.in);
        boolean running = true;
        while (running) {
            System.out.println("-------------------------------\n" +
                    "|          Menu               |\n" +
                    "|1. Hiện thị toàn bộ Sách     |\n" +
                    "|2. Thêm sách mới vào thư viện|\n" +
                    "|3. Tìm kiếm sách theo mã     |\n" +
                    "|4. Cập nhật giá tiền sách    |\n" +
                    "|5. Xóa sách                  |\n" +
                    "|6. Lưu kho sách vào file     |\n" +
                    "|7. Đọc kho sách từ file      |\n" +
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
                    case 1: librarian.printList();
                        break;
                    case 2: librarian.createBookList();
                        break;
                    case 3:
                        System.out.print("Nhập mã sách cần tìm: ");
                        keySearch = sc.nextLine();
                        int search = librarian.searchBook(keySearch);
                        if(search == -1)
                            System.out.println("Không tìm thấy sách");
                        else {
                            System.out.println("Tìm thấy sách ở vị trí: " +search);
                        }
                        break;
                    case 4:
                        System.out.print("Nhập mã sách: ");
                        keySearch = sc.nextLine();
                        librarian.updatePrice(keySearch);
                        break;
                    case 5:
                        System.out.print("Nhập mã sách: ");
                        keySearch = sc.nextLine();
                        librarian.deleteBook(keySearch);
                        break;
                    case 6:
                        librarian.outputFILE();
                        break;
                    case 7:
                        librarian.readFILE();
                        break;
                    default:
                        System.out.println("Lựa chọn không hợp lệ.");
                }

            } catch (Exception e) {
                System.out.println("Lựa chọn không hợp lệ.");
            }

        }
    }

    //Menu Đăng nhập
    public static void user_login() {
        Scanner sc = new Scanner(System.in);
        boolean running = true;
        while (running) {
            System.out.println("--------------------------\n" +
                    "|         Menu           |\n" +
                    "|1. Người lớn.           |\n" +
                    "|2. Trẻ em.              |\n" +
                    "|0. Exit                 |\n" +
                    "--------------------------\n");
            String account;
            System.out.print("Nhập lựa chọn: ");
            try {
                int choice = sc.nextInt();
                sc.nextLine();

                if(choice == 0) {
                    running = false;
                    break;
                }

                System.out.print("User ID: ");
                account = sc.nextLine();

                switch (choice) {
                    case 1:
                        boolean flag1 = false;
                        for(Adult member : adultMember) {
                            if(member.getUsername().equals(account)) {
                                //do somthing
                                adultMenu(member);
                                System.out.println(member.printInfo());
                                flag1 = true;
                                break;
                            }
                        }
                        if(flag1 == false)
                            System.out.println("Không tìm thấy tài khoản.");
                        break;
                    case 2:
                        boolean flag2 = false;
                        for (Kid member : kidMember) {
                            if(member.getUsername().equals(account)) {
                                kidMenu(member);

                                flag2 = true;
                                break;
                            }
                        }
                        if(flag2 == false)
                            System.out.println("Không tìm thấy tài khoản.");
                        break;
                    default:
                        System.out.println("Lựa chọn không hợp lệ.");
                        break;
                }
            } catch (Exception e) {
                System.out.println("Lựa chọn không hợp lệ.");
                running = false;
                break;

            }

        }
    }


    /* -----------------------Menu con---------------------- */

    //Menu dành cho Adult User:
    public static void adultMenu(Adult adultMember) {
        Scanner sc = new Scanner(System.in);
        boolean running = true;
        while(running) {
            System.out.println("---------------------------------------\n" +
                    "|          Menu                       |\n" +
                    "|1. Thêm sách vào thẻ mượn cá nhân    |\n" +
                    "|2. Trả sách đã mượn                  |\n" +
                    "|3. Thanh toán phí duy trì tài khoản  |\n" +
                    "|4. Hiển thị thông tin tài khoản      |\n" +
                    "|0. Thoát                             |\n" +
                    "---------------------------------------\n");
            int choice;
            try {
                choice = sc.nextInt();
                if(choice == 0)
                    break;
                switch (choice) {
                    case 1:
                        if(adultMember.getMonthlyPayment())
                            adultMember.addBook(librarian.getLibrarian());
                        else
                            System.out.println("Vui lòng thanh toán phí duy trì.");
                        break;

                    case 2:
                        System.out.println("Nhập mã sách cần trả: ");
                        String bookID = sc.nextLine();
                        adultMember.returnBook(bookID);
                        for(Book b : librarian.getLibrarian()) {
                            if(bookID.equals(b.getBookID()))
                                b.setQuantity(b.getQuantity()+1);
                        }
                        break;

                    case 3:
                        System.out.print("Tiến hành nạp phí duy trì tài khoản (50.0000): ");
                        int pay = sc.nextInt();
                        if(pay == 50000) {
                            adultMember.setMonthlyPayment(true);
                            System.out.println("Thanh toán thành công.");
                        }
                        else
                            System.out.println("Thất bại.");
                        break;

                    case 4:

                        System.out.println(adultMember.printInfo());
                        adultMember.printListBook();
                        break;
                    default:
                        System.out.println("Lựa chọn không hợp lệ.");
                        break;
                }
            } catch (Exception e) {
                System.out.println("Lựa chọn không hợp lệ.");
            }
        }
    }

    //Menu dành cho Kid User
    public static void kidMenu(Kid kidMember) {
        Scanner sc = new Scanner(System.in);
        boolean running = true;
        while(running) {
            System.out.println("---------------------------------------\n" +
                               "|          Menu                       |\n" +
                               "|1. Thêm sách vào thẻ mượn cá nhân    |\n" +
                               "|2. Trả sách đã mượn                  |\n" +
                               "|3. Sử dụng máy tính                  |\n" +
                               "|4. Hiển thị thông tin mượn sách      |\n" +
                               "|0. Thoát                             |\n" +
                               "---------------------------------------\n");
            int choice;
            try {
                choice = sc.nextInt();
                if(choice == 0) {
                    running = false;
                    break;
                }
                switch (choice) {
                    case 1:
                        kidMember.addBook(librarian.getLibrarian());
                        break;
                    case 2:
                        System.out.println("Nhập mã sách cần trả: ");
                        String bookID = sc.nextLine();
                        kidMember.returnBook(bookID);
                        for(Book b : librarian.getLibrarian()) {
                            if(bookID.equals(b.getBookID()))
                                b.setQuantity(b.getQuantity()+1);
                        }
                        break;
                    case 3:
                        System.out.println("Bạn có 1 giờ sử dụng phòng máy");
                        kidMember.setComputerUsingcounttime();
                        break;
                    case 4:
                        System.out.println(kidMember.printInfo());
                        kidMember.printListBook();
                        break;
                    default:
                        System.out.println("Lựa chọn không hợp lệ.");
                        break;
            }
        } catch (Exception e) {
                System.out.println("Lựa chọn không hợp lệ.");
            }
        }
    }
}
