import java.math.BigDecimal;
import java.util.Scanner;

public class Program {
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        UserInterface ui = new UserInterface();
        ui.display();

    }
    public static void pressEnterToContinue() {
        System.out.println();
        System.out.print("Press Enter to go back to the menu...");
        scanner.nextLine();
    }
    public static BigDecimal promptForBigDeciaml(String prompt) {
        while (true) {
            System.out.print(prompt);
            try {
                return new BigDecimal(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Please enter a number.");
            }
        }
    }
}
