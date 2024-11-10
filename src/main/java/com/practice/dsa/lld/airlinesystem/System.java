package com.practice.dsa.lld.airlinesystem;

import com.practice.dsa.lld.airlinesystem.booking.Booking;
import com.practice.dsa.lld.airlinesystem.booking.BookingManager;
import com.practice.dsa.lld.airlinesystem.entities.*;
import com.practice.dsa.lld.airlinesystem.entities.Aircraft;
import com.practice.dsa.lld.airlinesystem.entities.Passenger;
import com.practice.dsa.lld.airlinesystem.entities.PaymentProcessor;
import com.practice.dsa.lld.airlinesystem.entities.Seat;
import com.practice.dsa.lld.airlinesystem.flight.Flight;
import com.practice.dsa.lld.airlinesystem.flight.FlightSearch;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class System {

    List<Flight> flights;
    List<Aircraft> aircrafts;
    FlightSearch flightSearch;
    BookingManager bookingManager;

    PaymentProcessor paymentProcessor;

    public System(){
        this.flights = new ArrayList<>();
        this.aircrafts = new ArrayList<>();
        this.flightSearch = new FlightSearch(flights);
        this.bookingManager = BookingManager.getInstance();
        this.paymentProcessor = PaymentProcessor.getInstance();
    }

    public void addFlight(Flight flight){
        flights.add(flight);
    }
    public void addAircraft(Aircraft aircraft){
        aircrafts.add(aircraft);
    }

    public List<Flight> searchFlights(String source, String destination, LocalDate localDate){
        return flightSearch.searchFlights(source, destination, localDate);
    }

    public Booking bookFlight(Flight flight, Passenger passenger, Seat seat, double price){
        return bookingManager.createBooking(flight, passenger, seat, price);
    }
}
