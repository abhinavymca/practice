package com.practice.dsa.circuitbreaker;
import java.net.URI;
import java.time.Instant;
import java.time.Duration;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.ReentrantLock;

public class CircuitBreaker implements WebClient {
    private final Map<URI, Deque<Instant>> uriMap = new ConcurrentHashMap<>();
    private final ReentrantLock lock = new ReentrantLock();
    private static final int FAILURE_THRESHOLD = 3;    // Max failures before opening circuit
    private static final Duration TIME_WINDOW = Duration.ofMinutes(5);  // 5 minutes window

    public static void main(String[] args) {


    }
    @Override
    public Response execute(Request request) {
        URI uri = request.uri;
        Instant now = Instant.now();

        // Check if the circuit is open for the given URI
        if (isCircuitOpen(uri, now)) {
            return new Response();  // Circuit is open, return empty Response
        }

        // Proceed with the actual request
        Response response = request.call();

        // Handle success or failure based on response status
        if (response.status / 100 != 5) {  // Not a 5xx status code, consider this a success
            clearFailures(uri);
        } else {  // Failure scenario
            recordFailure(uri, now);
        }

        return response;
    }

    /**
     * Checks if the circuit is open for a given URI based on the recorded failure times.
     */
    private boolean isCircuitOpen(URI uri, Instant now) {
        // Thread-safe read from the map
        Deque<Instant> failureTimestamps = uriMap.get(uri);

        if (failureTimestamps == null || failureTimestamps.isEmpty()) {
            return false;  // Circuit is closed
        }

        // Remove timestamps older than the TIME_WINDOW (5 minutes)
        synchronized (failureTimestamps) {
            while (!failureTimestamps.isEmpty() && now.minus(TIME_WINDOW).isAfter(failureTimestamps.peekFirst())) {
                failureTimestamps.pollFirst();  // Remove expired failure timestamps
            }
        }

        // If we still have 3 failures within the 5-minute window, the circuit is open
        return failureTimestamps.size() >= FAILURE_THRESHOLD;
    }

    /**
     * Records a failure for the given URI and current time.
     */
    private void recordFailure(URI uri, Instant now) {
        // Use a lock to safely update the failure list for the URI
        lock.lock();
        try {
            uriMap.computeIfAbsent(uri, k -> new LinkedList<>());
            Deque<Instant> failureTimestamps = uriMap.get(uri);
            synchronized (failureTimestamps) {
                if (failureTimestamps.size() >= FAILURE_THRESHOLD) {
                    failureTimestamps.pollFirst();  // Maintain size by removing the oldest failure
                }
                failureTimestamps.addLast(now);  // Record the new failure
            }
        } finally {
            lock.unlock();
        }
    }

    /**
     * Clears any recorded failures for the given URI, typically on a successful response.
     */
    private void clearFailures(URI uri) {
        // Use a lock to safely clear the failure list for the URI
        lock.lock();
        try {
            uriMap.remove(uri);  // Remove all failure records for this URI
        } finally {
            lock.unlock();
        }
    }
}

