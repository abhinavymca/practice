package com.practice.dsa.lld.airlinesystem.entities;

public class PaymentProcessor {
    private static PaymentProcessor paymentProcessor;
    public static synchronized PaymentProcessor getInstance() {
        if(paymentProcessor==null){
            paymentProcessor = new PaymentProcessor();
        }
        return paymentProcessor;
    }
}
