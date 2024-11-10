package com.practice.dsa.lld.parkinglot;

import com.practice.dsa.lld.parkinglot.vehicletype.Vehicle;
import com.practice.dsa.lld.parkinglot.vehicletype.VehicleType;

import java.util.ArrayList;
import java.util.List;

public class Level {
    private int floor;
    private List<ParkingSpot> parkingSpots;

    public Level(int floor, int noOfSpot){
        this.floor = floor;
        parkingSpots = new ArrayList<>();
        //50:40:10
        int carSpot = (int)(0.50*noOfSpot);
        double bikeSpot = (int)(0.40*noOfSpot);
        int count = 1;
        for(;count<=carSpot;count++){
            ParkingSpot parkingSpot = new ParkingSpot(count, VehicleType.CAR);
            parkingSpots.add(parkingSpot);
        }
        for(;count<=carSpot+bikeSpot;count++){
            ParkingSpot parkingSpot = new ParkingSpot(count, VehicleType.BIKE);
            parkingSpots.add(parkingSpot);
        }
        for(;count<=noOfSpot;count++){
            ParkingSpot parkingSpot = new ParkingSpot(count, VehicleType.TRUCK);
            parkingSpots.add(parkingSpot);
        }
    }

    public synchronized ParkingSpot parkVehicle(Vehicle vehicle) {
        for(ParkingSpot parkingSpot:parkingSpots){
            if(parkingSpot.parkVehicle(vehicle)){
                return parkingSpot;
            }
        }
        return null;
    }

    public int getFloor() {
        return floor;
    }

    public synchronized boolean unParkVehicle(Vehicle vehicle) {
        for(ParkingSpot parkingSpot: parkingSpots){
            if(parkingSpot.unParkVehicle(vehicle)){
                return true;
            }
        }
        return false;
    }

    public void getAvailability() {
        System.out.println("Level:"+floor);
        for(ParkingSpot spot : parkingSpots){
            System.out.println("Spot "+spot.getSpotId()+": "+(spot.isAvailable()?"Available for":"Occupied By") + " " + spot.getParkingSpotType());
        }
    }
}
