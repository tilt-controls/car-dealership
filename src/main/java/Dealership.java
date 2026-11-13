import java.util.*;
import java.math.*;

public class Dealership {

    private String name;
    private String address;
    private String phone;
    private ArrayList<Vehicle> inventory;

    public Dealership(String name, String address, String phone) {
        inventory = new ArrayList<Vehicle>();
        this.name = name;
        this.address = address;
        this.phone = phone;
    }

    public List<Vehicle> getVehiclesByPrice(BigDecimal min, BigDecimal max) {
        List<Vehicle> matchedVehicles = new ArrayList<>();
        for (Vehicle vehicle : getAllVehicles()) {
            if (vehicle.getPrice().compareTo(min) >= 0 && vehicle.getPrice().compareTo(max) <= 0) {
                matchedVehicles.add(vehicle);
            }
        }
        if (matchedVehicles.isEmpty()) {
            System.out.println("No matching vehicles found.");
        }
        return matchedVehicles;
    }

    public List<Vehicle> getVehiclesByMakeModel(String make, String model) {
        List<Vehicle> matchedVehicles = new ArrayList<>();
        for (Vehicle vehicle : getAllVehicles()) {
            if (vehicle.getMake().equalsIgnoreCase(make) && vehicle.getModel().equalsIgnoreCase(model)) {
                matchedVehicles.add(vehicle);
            }
        }
        if (matchedVehicles.isEmpty()) {
            System.out.println("No matching vehicles found.");
        }
        return matchedVehicles;
    }

    public List <Vehicle> getVehiclesByYear(int min, int max) {
        List<Vehicle> matchedVehicles = new ArrayList<>();
        for (Vehicle vehicle : getAllVehicles()) {
            if (vehicle.getYear() > min && vehicle.getYear() <= max) {
                matchedVehicles.add(vehicle);
            }
        }
        if (matchedVehicles.isEmpty()) {
            System.out.println("No matching vehicles found.");
        }
        return matchedVehicles;
    }

    public List <Vehicle> getVehiclesByColor(String color) {
        List<Vehicle> matchedVehicles = new ArrayList<>();
        for (Vehicle vehicle : getAllVehicles()) {
            if (vehicle.getColor().equalsIgnoreCase(color)) {
                matchedVehicles.add(vehicle);
            }
        }
        if (matchedVehicles.isEmpty()) {
            System.out.println("No matching vehicles found.");
        }
        return matchedVehicles;
    }

    public List <Vehicle> getVehiclesByMileage(int min, int max) {
        List<Vehicle> matchedVehicles = new ArrayList<>();
        for (Vehicle vehicle : getAllVehicles()) {
            if (vehicle.getOdometer() >= min && vehicle.getOdometer() <= max ) {
                matchedVehicles.add(vehicle);
            }
        }
        if (matchedVehicles.isEmpty()) {
            System.out.println("No matching vehicles found.");
        }
        return matchedVehicles;
    }

    public List <Vehicle> getVehiclesByType(String vehicleType) {
        return null;
    }

    public ArrayList <Vehicle> getAllVehicles() {
        return inventory;
    }

    public void addVehicle(Vehicle vehicle) {
        inventory.add(vehicle);
    }
    public void removeVehicle(Vehicle vehicle) {
        inventory.remove(vehicle);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
