package helperClasses.formAndHandler;

import java.util.Scanner;

public class MobileRecharge extends Handler {

    private String number;

    public MobileRecharge(double amount) {
        setSupportsCash(true);
        setAmount(amount);
        fillForm();
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    @Override
    public void fillForm() {
        var input = new Scanner(System.in);
        System.out.println("Enter phone number: ");
        setNumber(input.next());
    }
}
