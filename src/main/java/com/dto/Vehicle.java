package com.dto;

import java.time.LocalDateTime;

public abstract class Vehicle {
    protected String vehicleType; // Loai xe
    protected double width; // Chieu rong
    protected double pricePerDay; // Phi do xe theo gio

    public Vehicle(String vehicleType, double width, double pricePerDay) {
        this.vehicleType = vehicleType;
        this.width = width;
        this.pricePerDay = pricePerDay;
    }

    public abstract double calculateParkingFee(LocalDateTime timeIn, LocalDateTime timeOut);
}

