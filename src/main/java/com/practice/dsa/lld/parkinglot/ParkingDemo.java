package com.practice.dsa.lld.parkinglot;

import com.practice.dsa.lld.parkinglot.vehicletype.Bike;
import com.practice.dsa.lld.parkinglot.vehicletype.Car;
import com.practice.dsa.lld.parkinglot.vehicletype.Truck;

/**
 * The parking lot should have multiple levels, each level with a certain number of parking spots.
 * The parking lot should support different types of vehicles, such as cars, motorcycles, and trucks.
 * Each parking spot should be able to accommodate a specific type of vehicle.
 * The system should assign a parking spot to a vehicle upon entry and release it when the vehicle exits.
 * The system should track the availability of parking spots and provide real-time information to customers.
 * The system should handle multiple entry and exit points and support concurrent access.
 */
public class ParkingDemo {

    public static void main(String[] args) {
        ParkingLot parkingLot = ParkingLot.getParkingLot();
        parkingLot.addLevel(new Level(1, 10));
        parkingLot.addLevel(new Level(2, 12));
        System.out.println("==============================");
        parkingLot.getAvailability();

        parkingLot.parkVehicle(new Car("Car123"));
        parkingLot.parkVehicle(new Bike("Bike123"));
        parkingLot.parkVehicle(new Truck("Truck123"));

        System.out.println("==============================");
        parkingLot.getAvailability();

        parkingLot.unParkVehicle(new Car("Car123"));
        System.out.println("==============================");
        parkingLot.getAvailability();


    }
}
