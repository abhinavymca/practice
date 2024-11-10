package com.practice.dsa.lld.parkinglot;

import com.practice.dsa.lld.parkinglot.vehicletype.Vehicle;

import java.util.ArrayList;
import java.util.List;

public class ParkingLot {
    List<Level> levels;
    int id;
    private static ParkingLot parkingLot;

    private ParkingLot(){
        levels = new ArrayList<>();
    }
    public static synchronized ParkingLot getParkingLot(){
        if(parkingLot==null){
            parkingLot = new ParkingLot();
        }
        return parkingLot;
    }

    public void addLevel(Level level){
        levels.add(level);
    }

    public synchronized VehicleReceipt parkVehicle(Vehicle vehicle){
        for(Level level : levels){
            ParkingSpot parkingSpot = level.parkVehicle(vehicle);
            if(parkingSpot!=null){
                return new VehicleReceipt(level.getFloor(), parkingSpot.getSpotId(), vehicle.getRegNo());
            }
        }
        return null;
    }


    public boolean unParkVehicle(Vehicle vehicle){
        for(Level level : levels){
            if(level.unParkVehicle(vehicle)){
                return true;
            }
        }
        return false;
    }

    public void getAvailability(){
        for(Level level : levels){
            level.getAvailability();
        }
    }
}
