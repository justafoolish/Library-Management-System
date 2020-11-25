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
}
