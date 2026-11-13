import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class DealershipTest {
    static DealershipFileManager fileManager = new DealershipFileManager();
    static Dealership dealership = fileManager.getDealership();

    @Test
    public void getVehiclesByPrice_should_findVehiclesWithinRange() {
        // arrange
        BigDecimal min = new BigDecimal("1000");
        BigDecimal max = new BigDecimal("2000");

        // act
        ArrayList<Vehicle> matchedVehicles = dealership.getVehiclesByPrice(min,max);

        // assert
        assertFalse(matchedVehicles.isEmpty());
        for (Vehicle vehicle : matchedVehicles) {
            assertTrue(vehicle.getPrice().compareTo(min)>=0 && vehicle.getPrice().compareTo(max)<=0);
        }
    }

    @Test
    public void getVehiclesByMakeModel_should_findVehiclesFromMakeModel() {
        // arrange
        String make = "Honda";
        String model = "Civic";

        // act
        ArrayList<Vehicle>  matchedVehicles = dealership.getVehiclesByMakeModel(make,model);

        // assert
        assertFalse(matchedVehicles.isEmpty());
        for (Vehicle vehicle : matchedVehicles) {
            assertTrue(vehicle.getMake().equals(make) && vehicle.getModel().equals(model));
        }
    }

    @Test
    public void getVehiclesByYear_should_findVehiclesWithinYearRange() {
        int min = 2001;
        int max = 2011;

        // act
        ArrayList<Vehicle> matchedVehicles = dealership.getVehiclesByYear(min,max);

        // assert
        assertFalse(matchedVehicles.isEmpty());
        for (Vehicle vehicle : matchedVehicles) {
            assertTrue(vehicle.getYear() >= min && vehicle.getYear() <= max);
        }
    }
    @Test
    public void getVehiclesByColor_should_findVehiclesByColor() {
        // arrange
        String color = "Red";

        // act
        ArrayList<Vehicle> matchedVehicles = dealership.getVehiclesByColor(color);

        // assert
        assertFalse(matchedVehicles.isEmpty());
        for (Vehicle vehicle : matchedVehicles) {
            assertTrue(vehicle.getColor().equals(color));
        }
    }
    @Test
    public void getVehiclesByMileage_should_findVehiclesWithinMileageRange() {
        // arrange
        int min = 0;
        int max = 70000;

        // act
        ArrayList<Vehicle> matchedVehicles = dealership.getVehiclesByMileage(min,max);

        // assert
        assertFalse(matchedVehicles.isEmpty());
        for (Vehicle vehicle : matchedVehicles) {
            assertTrue(vehicle.getOdometer() >= min && vehicle.getOdometer() <= max);
        }
    }
    @Test
    public void getVehiclesByCarType_should_findVehiclesByCarType() {
        // arrange
        String carType = "SUV";

        // act
        ArrayList<Vehicle> matchedVehicles = dealership.getVehiclesByType(carType);

        // assert
        assertFalse(matchedVehicles.isEmpty());
        for (Vehicle vehicle : matchedVehicles) {
            assertTrue(vehicle.getVehicleType().equals(carType));
        }
    }
}