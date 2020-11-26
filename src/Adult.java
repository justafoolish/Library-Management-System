import java.io.File;
import java.io.FileWriter;

public class Adult extends Membership {
    boolean monthlyPayment;

    public Adult(String username, String name, int age, String address) {
        super(username, name, age, address);
        monthlyPayment = false;
    }

    @Override
    public String printInfo() {
        String checkPayment;
        if(monthlyPayment == true)
            checkPayment = " \nĐã thanh toán định kỳ.";
        else {
            checkPayment = " \nChưa thanh toán định kỳ.";
        }
        String s = "Tài khoản người lớn. tên tài khoản: " + getUsername() + "\thọ tên:  "
                                        + getName() + "\ttuổi: "
                                        + getAge() + "\tđịa chỉ: "
                                        + getAddress();
        return s + checkPayment;
    }

    //Cập nhật trạng thái thanh toán của tài khoản
    public void setMonthlyPayment(boolean monthlyPayment) {
        this.monthlyPayment = monthlyPayment;
    }


    public boolean getMonthlyPayment() {
        return monthlyPayment;
    }

    //Lưu chi tiết thẻ mượn vào file
    public void writeFILE() {
        try {
            String filename = getUsername() + ".adult";
            File f = new File(filename);
            FileWriter fr = new FileWriter(f);

            fr.write(getName() + "\t|\t" +
                    getUsername() + "\t|\t" +
                    getAge() + "\t|\t" + getAddress()
                    + "\t|\t" +
                    getMonthlyPayment() +
                    "\n");
            for(Book book : getBookLending().getBooks()) {
                fr.write(book.getBookID() + "\t|\t" +
                        book.getTitle() + "\t|\t" +
                        book.getAuthor() + "\t|\t" +
                        book.getPrice() + "\n");
            }

            System.out.println("Lưu thành công vào " + filename);
            fr.close();
        } catch (Exception e) {
            System.out.println("FILE ERROR!");
        }
    }


}
