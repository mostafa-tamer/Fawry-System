package helperClasses.formAndHandler;

import java.util.Scanner;

public class Landline extends Handler {
    private String landlineNumber;

    public Landline(double amount) {
        setSupportsCash(true);
        setAmount(amount);
        fillForm();
    }

    public String getLandlineNumber() {
        return landlineNumber;
    }

    public void setLandlineNumber(String landlineNumber) {
        this.landlineNumber = landlineNumber;
    }

    @Override
    public void fillForm() {
        var input = new Scanner(System.in);
        System.out.println("Enter number: ");
        setLandlineNumber(input.next());
    }
}
