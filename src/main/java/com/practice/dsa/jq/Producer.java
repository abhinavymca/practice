package com.practice.dsa.jq;

public class Producer implements Runnable{
    private DataQueue dataQueue;
    private volatile boolean runFlag;

    public Producer(DataQueue dataQueue){
        this.dataQueue = dataQueue;
        runFlag = true;
    }

    @Override
    public void run() {
        try {
            produce();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void produce() throws InterruptedException {
        System.out.println("Producer start:"+Thread.currentThread().getName());
        Message message = new Message((int)Math.random(),"message"+Math.random());
        while(runFlag) {
            while (dataQueue.isFull()) {
                dataQueue.waitOnFullProducer();
            }
            if (!runFlag)
                break;
            dataQueue.addMessage(message);
            System.out.println("Producer data size"+dataQueue.getMsgQueue().size());
            dataQueue.notifyConsumer();
            System.out.println("Producer end:"+Thread.currentThread().getName());
        }
    }

    public void stop() {
        runFlag = false;
        dataQueue.notifyConsumer();
    }

}
