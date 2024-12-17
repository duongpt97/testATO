import com.dto.Bike;
import com.dto.Car;
import com.dto.Vehicle;
import org.junit.Test;

import java.time.LocalDateTime;

import static org.junit.Assert.assertEquals;


public class ParkingLotTest {

    @Test
    public void testCarParkingFee() {
        Vehicle car = new Car();
        LocalDateTime timeIn = LocalDateTime.of(2024, 12, 17, 9, 0, 0, 0);
        LocalDateTime timeOut = LocalDateTime.of(2024, 12, 18, 9, 0, 0, 0); // 1 day
        double fee = car.calculateParkingFee(timeIn, timeOut);
        assertEquals(10.0, fee, 0.0001); // delta = 0.0001
    }

    @Test
    public void testBikeParkingFee() {
        Vehicle bike = new Bike();
        LocalDateTime timeIn = LocalDateTime.of(2024, 12, 17, 9, 0, 0, 0);
        LocalDateTime timeOut = LocalDateTime.of(2024, 12, 18, 9, 0, 0, 0); // 1 day
        double fee = bike.calculateParkingFee(timeIn, timeOut);
        assertEquals(10.0, fee, 0.0001); // delta = 0.0001
    }

    @Test
    public void testCarPartialDayFee() {
        Vehicle car = new Car();
        LocalDateTime timeIn = LocalDateTime.of(2024, 12, 17, 9, 0, 0, 0);
        LocalDateTime timeOut = LocalDateTime.of(2024, 12, 17, 12, 0, 0, 0); // less than 1 day
        double fee = car.calculateParkingFee(timeIn, timeOut);
        assertEquals(10.0, fee, 0.0001); // delta = 0.0001
    }

    @Test
    public void testBikePartialDayFee() {
        Vehicle bike = new Bike();
        LocalDateTime timeIn = LocalDateTime.of(2024, 12, 17, 9, 0, 0, 0);
        LocalDateTime timeOut = LocalDateTime.of(2024, 12, 17, 12, 0, 0, 0); // less than 1 day
        double fee = bike.calculateParkingFee(timeIn, timeOut);
        assertEquals(10.0, fee, 0.0001); // delta = 0.0001
    }
}
