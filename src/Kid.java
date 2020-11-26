import java.io.File;
import java.io.FileWriter;

public class Kid extends Membership {
    int computerUsingcounttime;

    public Kid(String username, String name, int age, String address) {
        super(username, name, age, address);
        computerUsingcounttime = 100;
    }

    public Kid() {}

    public int getComputerUsingcounttime() {
        return computerUsingcounttime;
    }

    //Người dùng có 1h sử dụng máy tính mỗi lần
    public void setComputerUsingcounttime() {
        this.computerUsingcounttime -= 1;
    }

    public String printInfo() {
        String s = "Tài khoản trẻ em. tên tài khoản: " + getUsername() + "\thọ tên: "
                    + getName() + "\ttuổi: "
                    + getAge() + "\tđịa chỉ: "
                    + getAddress()
                    + "\nThời gian sử dụng máy tính còn lại: "
                    +getComputerUsingcounttime();
        return s;
    }
    //Lưu chi tiết thẻ mượn vào file
    public void writeFILE() {
        try {
            String filname = getUsername()+".kid";
            File f = new File(filname);
            FileWriter fr = new FileWriter(f);

            fr.write(getName() + "\t|\t" +
                    getUsername() + "\t|\t" +
                    getAge() + "\t|\t" +
                    getAddress() + "\t|\t" +
                    getComputerUsingcounttime() + "\n");


            for(Book book : getBookLending().getBooks()) {
                fr.write(book.getBookID() + "\t|\t" +
                        book.getTitle() + "\t|\t" +
                        book.getAuthor() + "\t|\t" +
                        book.getPrice() + "\n");
            }

            System.out.println("Lưu thành công vào " + filname);
            fr.close();

        } catch (Exception e) {
            System.out.println("FILE ERROR!");
        }
    }
}
