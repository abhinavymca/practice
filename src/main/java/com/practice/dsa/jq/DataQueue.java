package com.practice.dsa.jq;

import java.util.LinkedList;
import java.util.Queue;

public class DataQueue {
    private Queue<Message> msgQueue = new LinkedList<>();
    private int maxSize;
    private Object FULL_QUEUE = new Object();
    private Object EMPTY_QUEUE = new Object();

    public DataQueue(int maxSize){
        this.maxSize = maxSize;
    }

    public Queue<Message> getMsgQueue() {
        return msgQueue;
    }

    public void addMessage(Message message){
        synchronized (msgQueue){
            msgQueue.add(message);
        }
    }

    public Message removeMessage(){
        synchronized (msgQueue){
            return msgQueue.poll();
        }
    }

    public void notifyProducer(){
        synchronized (FULL_QUEUE){
            System.out.println("FULL_QUEUE notifyAll:"+Thread.currentThread().getName());
            FULL_QUEUE.notifyAll();
        }
    }

    public void waitOnFullProducer() throws InterruptedException {
        synchronized (FULL_QUEUE){
            System.out.println("FULL_QUEUE wait:"+Thread.currentThread().getName());
            FULL_QUEUE.wait();
        }
    }

    public void waitOnEmptyConsumer() throws InterruptedException {
        synchronized (EMPTY_QUEUE){
            System.out.println("EMPTY_QUEUE wait:"+Thread.currentThread().getName());
            EMPTY_QUEUE.wait();
        }
    }
    public void notifyConsumer(){
        synchronized (EMPTY_QUEUE){
            System.out.println("EMPTY_QUEUE notify:"+Thread.currentThread().getName());
            EMPTY_QUEUE.notify();
        }
    }

    public boolean isFull() {
       return this.msgQueue.size()==this.maxSize;
    }

    public static void main(String[] args) {
        DataQueue dataQueue = new DataQueue(10);
        Consumer consumer = new Consumer(dataQueue);
        Producer producer = new Producer(dataQueue);
        //for(int i=0;i<15;i++){
            Thread threadProduce = new Thread(producer);
          //  threadProduce.setName("producer-"+i);
            threadProduce.start();
        //}

        //for(int i=0;i<15;i++){
            Thread threadConsume = new Thread(consumer);
          //  threadConsume.setName("consumer-"+i);
            threadConsume.start();
        //}

//        producer.stop();
//        consumer.stop();



    }
}
