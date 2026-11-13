import java.util.ArrayList;
import java.util.Scanner;

public class UserInterface {
    private Dealership dealership;
    static Scanner scanner = new Scanner(System.in);

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
    }

    public void processRemoveVehicleRequest() {
    }
    }
