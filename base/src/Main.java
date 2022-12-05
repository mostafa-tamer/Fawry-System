import boundaries.BoundaryProducer;
import customException.CustomException;

public class Main {
    public static void main(String[] args) {

        System.out.println("Program Starts...");

        try {
            new BoundaryProducer();
        } catch (CustomException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println("Unexpected Error: " + e.getMessage());
        }
    }
}