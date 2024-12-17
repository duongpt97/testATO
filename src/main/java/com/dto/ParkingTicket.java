package com.dto;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class ParkingTicket {

    private Vehicle vehicle;
    private LocalDateTime timeIn;
    private LocalDateTime timeOut;
    private String space;

    public ParkingTicket(Vehicle vehicle, LocalDateTime timeIn, LocalDateTime timeOut, String space) {
        this.vehicle = vehicle;
        this.timeIn = timeIn;
        this.timeOut = timeOut;
        this.space = space;
    }

    public long getTotalDays() {
        long days = ChronoUnit.DAYS.between(timeIn, timeOut);
        return (days < 1) ? 1 : (days + 1);
    }

    public double getTotalParkingFee() {
        return vehicle.calculateParkingFee(timeIn, timeOut);
    }
}
