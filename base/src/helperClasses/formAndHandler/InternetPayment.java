package helperClasses.formAndHandler;

import java.util.Scanner;

public class InternetPayment extends Handler {
    private String number;

    public InternetPayment(double amount) {
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
        System.out.println("Enter the number: ");
        setNumber(input.next());
    }
}
