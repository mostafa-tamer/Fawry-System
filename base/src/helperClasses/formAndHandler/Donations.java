package helperClasses.formAndHandler;

import java.util.Scanner;

public class Donations extends Handler {

    private String dest = "";

    public Donations() {
        setSupportsCash(false);
        fillForm();
    }

    public String getDest() {
        return dest;
    }

    public void setDest(String dest) {
        this.dest = dest;
    }

    @Override
    public void fillForm() {
        var input = new Scanner(System.in);
        System.out.println("Enter amount to be donated: ");
        setAmount(input.nextDouble());

        System.out.println("write desired destination: ");
        input.nextLine();
        setDest(input.nextLine());
    }
}
