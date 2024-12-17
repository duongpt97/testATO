package com.dto;

import java.time.Duration;
import java.time.LocalDateTime;

public class Bike extends Vehicle {
    public Bike() {
        super("Bike", 0.8, 2.0);
    }

    @Override
    public double calculateParkingFee(LocalDateTime timeIn, LocalDateTime timeOut) {
        // Tính số giờ đỗ xe
        long hours = Duration.between(timeIn, timeOut).toHours();
        if (hours == 0) {
            hours = 1; // Nếu thời gian đỗ dưới 1 giờ, mặc định là 1 giờ
        }
        // Tính phí đỗ xe (tròn ngày)
        return Math.ceil(hours / 24.0) * pricePerDay; // Math.ceil để làm tròn ngày
    }
}
