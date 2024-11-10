package com.practice.dsa.lld.airlinesystem.booking;

import com.practice.dsa.lld.airlinesystem.entities.Passenger;
import com.practice.dsa.lld.airlinesystem.entities.Seat;
import com.practice.dsa.lld.airlinesystem.flight.Flight;

public class Booking {

    String bookingNumber;
    Flight flight;
    Passenger passenger;
    Seat seat;
    double price;

    BookingStatus status;

    public Booking(String bookingNumber, Flight flight, Passenger passenger, Seat seat, double price) {
        this.bookingNumber = bookingNumber;
        this.flight = flight;
        this.passenger = passenger;
        this.seat = seat;
        this.price = price;
        status=BookingStatus.CONFIRMED;
    }
}
