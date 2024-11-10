package com.practice.dsa.circuitbreaker;

public interface WebClient {
    Response execute(Request request);
}
