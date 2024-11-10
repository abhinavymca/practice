package com.practice.dsa.lld.airlinesystem.booking;

import com.practice.dsa.lld.airlinesystem.entities.Passenger;
import com.practice.dsa.lld.airlinesystem.entities.Seat;
import com.practice.dsa.lld.airlinesystem.flight.Flight;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class BookingManager {

    private static BookingManager bookingManager;
    private final Object lock = new Object();

    Map<String, Booking> bookings;

    private final AtomicInteger bookingCounter = new AtomicInteger(0);

    private BookingManager(){
        bookings = new HashMap<>();
    }
    public static synchronized BookingManager getInstance() {
        if(bookingManager==null){
            bookingManager = new BookingManager();
        }
        return bookingManager;
    }

    public Booking createBooking(Flight flight, Passenger passenger, Seat seat, double price) {
        String bookingNumber = getBookingNumber();
        Booking booking = new Booking(bookingNumber, flight, passenger, seat, price);
        synchronized (lock){
            bookings.put(bookingNumber, booking);
        }
        return booking;

    }

    private String getBookingNumber() {
        int counter = bookingCounter.incrementAndGet();
        String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMddHHmmss"));
        return "AIR"+timestamp+String.format("%06d", counter);
    }
}
