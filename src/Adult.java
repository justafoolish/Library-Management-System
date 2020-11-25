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


}
