import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class DealershipTest {

    @Test
    public void getVehiclesByPrice_should_findVehiclesWithinRange() {
        // arrange
        Dealership dealership = new Dealership("D & B Used Cars", "111 Old Benbrook Rd", "817-555-5555");
        BigDecimal min = new BigDecimal("1000");
        BigDecimal max = new BigDecimal("2000");

        // act
        ArrayList<Vehicle> matchedVehicles = dealership.getVehiclesByPrice(min,max);

        // assert
        for (Vehicle vehicle : matchedVehicles) {
            assertTrue(vehicle.getPrice().compareTo(min)>=0 && vehicle.getPrice().compareTo(max)<=0);
        }
    }

}