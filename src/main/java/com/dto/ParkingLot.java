package com.dto;

public class ParkingLot {

    private static final int MAX_SPACES = 80;
    private static int parkedVehicles = 0;
    private static final String SPACE_A = "A";
    private static final String SPACE_B = "B";

    public String acceptVehicle(Vehicle vehicle) {
        if (parkedVehicles >= MAX_SPACES) {
            return "Parking lot is full. Vehicle rejected.";
        }
        return parkVehicle(vehicle);
    }

    private String parkVehicle(Vehicle vehicle) {
        parkedVehicles++;
        String space = (vehicle.width >= 2) ? SPACE_A : SPACE_B;
        return "Vehicle parked at Space " + space;
    }

    public static void vehicleLeaves() {
        parkedVehicles--;
    }
}
