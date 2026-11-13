import java.io.*;
import java.math.BigDecimal;

public class DealershipFileManager {

    public Dealership getDealership() {
            Dealership dealership = new Dealership("D & B Used Cars", "111 Old Benbrook Rd", "817-555-5555");
            try {
                BufferedReader bufferedReader = new BufferedReader(new FileReader("inventory.csv"));
                String line;
                line = bufferedReader.readLine();

                while ((line = bufferedReader.readLine()) != null) {
                    String[] tokens = line.split("\\|");
                    int vin = Integer.parseInt(tokens[0]);
                    int year = Integer.parseInt(tokens[1]);
                    String make = tokens[2];
                    String model = tokens[3];
                    String vehicleType = tokens[4];
                    String color = tokens[5];
                    int odometer = Integer.parseInt(tokens[6]);
                    BigDecimal price = new BigDecimal(tokens[7]);
                    Vehicle vehicle = new Vehicle(vin, year, make, model, vehicleType, color, odometer, price);
                    dealership.addVehicle(vehicle);
                }
            } catch (IOException e) {
                System.out.println("Error reading file!");
            }
            return dealership;
        }

    public void saveDealership(Dealership dealership) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("inventory.csv"));
            writer.write(dealership.getName() + "|" + dealership.getAddress() + "|" + dealership.getPhone() + "\n");
            for (Vehicle vehicle : dealership.getAllVehicles()) {
                writer.write(vehicle.getVin() + "|" + vehicle.getYear() + "|" + vehicle.getMake() + "|" + vehicle.getModel() + "|" + vehicle.getVehicleType()
                        + "|" + vehicle.getColor() + "|" + vehicle.getOdometer() + "|" + vehicle.getPrice() + "\n");
            }
            writer.close();
        } catch (IOException e) {
            System.out.println("Error! Inventory could not be saved.");
        }
    }
}
