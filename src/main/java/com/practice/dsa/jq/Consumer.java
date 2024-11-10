package com.practice.dsa.jq;

public class Consumer implements Runnable{

    private DataQueue dataQueue;
    private volatile boolean runFlag;
    public Consumer(DataQueue dataQueue){
        this.dataQueue = dataQueue;
        this.runFlag = true;
    }

    @Override
    public void run() {
        try {
            consume();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void consume() throws InterruptedException {
        System.out.println("Consumer start:"+Thread.currentThread().getName());
        while (runFlag) {
            System.out.println("consume data size "+dataQueue.getMsgQueue().size());
            if(dataQueue.getMsgQueue().isEmpty())
                dataQueue.waitOnEmptyConsumer();
            if (!runFlag)
                break;
            System.out.println("consume data size after wait "+dataQueue.getMsgQueue().size());
            Message message=dataQueue.removeMessage();
            System.out.println("consume data size after removal "+dataQueue.getMsgQueue().size());
            dataQueue.notifyProducer();
            System.out.println("Consumer end:"+Thread.currentThread().getName());
        }
    }

    public void stop() {
        runFlag = false;
        dataQueue.notifyProducer();
    }
}
