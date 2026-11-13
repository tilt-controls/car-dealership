import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Scanner;

public class UserInterface {
    private Dealership dealership;
    static Scanner scanner = new Scanner(System.in);
    private DealershipFileManager fileManager = new DealershipFileManager();

    public UserInterface() {
    }

    private void init() {
        DealershipFileManager fileManager = new DealershipFileManager();
        this.dealership = fileManager.getDealership();
    }
    private void displayVehicles(ArrayList<Vehicle> inventory) {
        for (Vehicle vehicle : inventory) {
            System.out.println("\n------------------------------");
            System.out.println(vehicle.getYear() + " " + vehicle.getMake() + " " + vehicle.getModel());
            System.out.println("Price: $" + vehicle.getPrice());
            System.out.println("Color: " + vehicle.getColor());
            System.out.println("Mileage: " + vehicle.getOdometer());
            System.out.println("VIN: " + vehicle.getVin());
            System.out.println("------------------------------");
        }
    }

    public void display() {
        init();
        String command;
        do {
            System.out.println();
            System.out.println("=== Home ===");
            System.out.println("P) Search by Price");
            System.out.println("M) Search by Make/Model");
            System.out.println("Y) Search by Year");
            System.out.println("C) Search by Color");
            System.out.println("O) Search by Mileage");
            System.out.println("T) Search by Vehicle Type");
            System.out.println("A) Display All Vehicles");
            System.out.println("N) Add a Vehicle");
            System.out.println("R) Remove a Vehicle");
            System.out.println("X) Exit");
            System.out.print("Enter a command: ");
            command = scanner.nextLine().trim().toUpperCase();

            switch (command) {
                case "P" -> processGetByPriceRequest();

                case "M" -> processGetByMakeModelRequest();

                case "Y" -> processGetByYearRequest();

                case "C" -> processGetByColorRequest();

                case "O" -> processGetByMileageRequest();

                case "T" -> processGetByVehicleTypeRequest();

                case "A" -> processGetAllVehiclesRequest();

                case "N" -> processAddVehicleRequest();

                case "R" -> processRemoveVehicleRequest();

                case "X" -> System.out.println("Good Bye!");

                default -> System.out.println("Unknown Command! Try again.");
            }
        } while(!command.equals("X"));
    }

    public void processGetByPriceRequest() {

        }

    public void processGetByMakeModelRequest() {
    }

    public void processGetByYearRequest() {
    }

    public void processGetByColorRequest() {
    }

    public void processGetByMileageRequest() {
    }

    public void processGetByVehicleTypeRequest() {
    }

    public void processGetAllVehiclesRequest() {
        displayVehicles(dealership.getAllVehicles());
    }

    public void processAddVehicleRequest() {
        int vin = promptForInt("Enter VIN: ");
        int year = promptForInt("Enter year: ");
        String make = promptForString("Enter make: ");
        String model = promptForString("Enter model: ");
        String vehicleType = promptForString("Enter vehicle type: ");
        String color = promptForString("Enter color: ");
        int odometer = promptForInt("Enter odometer: ");
        BigDecimal price = promptForBigDecimal("Enter price: ");
        Vehicle vehicle = new Vehicle(vin, year, make, model, vehicleType, color, odometer, price);
        dealership.addVehicle(vehicle);
        fileManager.saveDealership(dealership);
    }

    public void processRemoveVehicleRequest() {
        int vin = promptForInt("Enter VIN to remove vehicle: ");
        for (Vehicle vehicle : dealership.getAllVehicles()) {
            if (vehicle.getVin() == vin) {
                dealership.removeVehicle(vehicle);
                break;
            }
        }
        fileManager.saveDealership(dealership);
    }

    public static void pressEnterToContinue() {
        System.out.println();
        System.out.print("Press Enter to go back to the menu...");
        scanner.nextLine();
    }
    public static BigDecimal promptForBigDecimal(String prompt) {
        while (true) {
            System.out.print(prompt);
            try {
                return new BigDecimal(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Please enter a number.");
            }
        }
    }
    public static int promptForInt(String prompt) {
        while (true) {
            System.out.print(prompt);
            try {
                return Integer.parseInt(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Please enter a number.");
            }
        }
    }
    public static String promptForString(String prompt) {
        while (true) {
            System.out.print(prompt);
            String input = scanner.nextLine().trim();
            if (input.isEmpty()) {
                System.out.println("This can't be blank.");
            } else if (input.contains("|")) {
                System.out.println("Please don't use the | character.");
            } else {
                return input;
            }
        }
    }
    }
