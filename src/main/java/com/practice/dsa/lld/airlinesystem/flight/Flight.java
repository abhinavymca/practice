package com.practice.dsa.lld.airlinesystem.flight;

import com.practice.dsa.lld.airlinesystem.entities.Seat;

import java.time.LocalDateTime;
import java.util.List;

public class Flight {
    String flightNumber;
    String source;
    String destination;

    LocalDateTime departureDateTime;
    LocalDateTime arrivalDateTime;
    List<Seat> seats;

    public Flight(String flightNumber, String source, String destination, LocalDateTime departureDateTime, LocalDateTime arrivalDateTime, List<Seat> seats) {
        this.flightNumber = flightNumber;
        this.source = source;
        this.destination = destination;
        this.departureDateTime = departureDateTime;
        this.arrivalDateTime = arrivalDateTime;
        this.seats = seats;
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public String getSource() {
        return source;
    }

    public String getDestination() {
        return destination;
    }

    public LocalDateTime getDepartureDateTime() {
        return departureDateTime;
    }

    public LocalDateTime getArrivalDateTime() {
        return arrivalDateTime;
    }

    public List<Seat> getSeats() {
        return seats;
    }
}
