package com.dto;

import java.time.Duration;
import java.time.LocalDateTime;

public class Car extends Vehicle {
    public Car() {
        super("Car", 2.0, 10.0);
    }

    @Override
    public double calculateParkingFee(LocalDateTime timeIn, LocalDateTime timeOut) {
        long hours = Duration.between(timeIn, timeOut).toHours();
        if (hours == 0) {
            hours = 1; // Nếu dưới 1 giờ, tính là 1 giờ
        }
        double pricePerHour = pricePerDay / 24.0; // Giá mỗi giờ
        return Math.ceil(hours / 24.0) * pricePerDay; // Tính tròn theo ngày
    }
}
