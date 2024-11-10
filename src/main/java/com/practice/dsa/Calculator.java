package com.practice.dsa;

import java.util.concurrent.*;

public class Calculator implements Callable<Double> {

    private double num1;
    private double num2;
    private String operation;

    public Calculator(double num1, int num2, String operation) {
        this.num1 = num1;
        this.num2 = num2;
        this.operation = operation;
    }

    @Override
    public Double call() throws Exception {
        switch (operation) {
            case "add":
                return num1 + num2;
            case "subtract":
                return num1 - num2;
            case "multiply":
                return num1 * num2;
            case "divide":
                if (num2 != 0){
                    return num1/num2;
                } else{
                    throw new ArithmeticException("Not divisible by 0");
                }
            default:
                throw new UnsupportedOperationException("Operation not supported");
        }
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(4);
        Calculator task1 = new Calculator(10, 5, "add");
        Calculator task2 = new Calculator(10, 5, "subtract");
        Calculator task3 = new Calculator(10, 5, "multiply");
        Calculator task4 = new Calculator(10, 5, "divide");

        Future<Double> f1 = executorService.submit(task1);
        Future<Double> f2 = executorService.submit(task2);
        Future<Double> f3 = executorService.submit(task3);
        Future<Double> f4 = executorService.submit(task4);

        System.out.println(f1.get()+f2.get()+f3.get()+f4.get());
    }
}
