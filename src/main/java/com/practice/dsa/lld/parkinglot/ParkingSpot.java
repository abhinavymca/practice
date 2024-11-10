package com.practice.dsa.lld.parkinglot;

import com.practice.dsa.lld.parkinglot.vehicletype.Vehicle;
import com.practice.dsa.lld.parkinglot.vehicletype.VehicleType;

public class ParkingSpot {
    private int spotId;
    private VehicleType vehicleType;
    private Vehicle vehicleParked;

    public ParkingSpot(int spotId, VehicleType vehicleType) {
        this.spotId = spotId;
        this.vehicleType = vehicleType;
    }

    public boolean parkVehicle(Vehicle vehicle){
        if(isAvailable() && vehicle.getVehicleType().equals(vehicleType)) {
            vehicleParked = vehicle;
            return true;
        }
        return false;
    }

    public synchronized boolean isAvailable(){
        return vehicleParked==null;
    }

    public VehicleType getParkingSpotType(){
        return vehicleType;
    }

    public int getSpotId(){
        return spotId;
    }

    public Vehicle getVehicleParked() {
        return vehicleParked;
    }

    public synchronized boolean unParkVehicle(Vehicle vehicle) {
        if(!isAvailable() && vehicleParked.equals(vehicle)) {
            vehicleParked = null;
            return true;
        }
        return false;
    }
}
