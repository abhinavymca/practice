package com.practice.dsa.lld.airlinesystem.flight;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

public class FlightSearch {

    List<Flight> flights;
    public FlightSearch(List<Flight> flights) {
        this.flights = flights;
    }

    public List<Flight> searchFlights(String source, String destination, LocalDate localDate) {
        return flights.stream().filter(flight -> flight.source.equals(source)
                && flight.destination.equals(destination)
                && flight.departureDateTime.toLocalDate().isEqual(localDate))
                .collect(Collectors.toList());

    }
}
