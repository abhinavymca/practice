package com.practice.dsa.blockingqueue;

import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class BlockingQueueTest {

    public static void main(String[] args) {
        BlockingQueue<Integer> blockingQueue = new ArrayBlockingQueue<>(10);
        Thread t1 = new Thread(new Producer(blockingQueue));
        Thread t2 = new Thread(new Consumer(blockingQueue));
        t1.start();
        t2.start();
    }

}

class Producer implements Runnable {

    BlockingQueue<Integer> blockingQueue;

    Producer(BlockingQueue<Integer> blockingQueue) {
        this.blockingQueue = blockingQueue;
    }

    @Override
    public void run() {
        while (true) {
            try {
                blockingQueue.put(produce());
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    private Integer produce() {
        Random random = new Random();
        int num = random.nextInt(1000);
        System.out.println("produced:" + num);
        return num;
    }
}

class Consumer implements Runnable {

    BlockingQueue<Integer> blockingQueue;

    Consumer(BlockingQueue<Integer> blockingQueue) {
        this.blockingQueue = blockingQueue;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Integer num = blockingQueue.take();
                System.out.println("consumed:" + num);
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    private Integer produce() {
        Random random = new Random();
        return random.nextInt(1000);
    }
}