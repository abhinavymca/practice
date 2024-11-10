package com.practice.dsa;

import java.io.FileWriter;
import java.io.IOException;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Logger {
    private static Logger logger;
    private FileWriter fileWriter;
    private static Lock lock = new ReentrantLock();

    private Logger(FileWriter fileWriter) {
        this.fileWriter = fileWriter;
    }

    public static Logger getInstance(FileWriter fileWriter) {
        if (logger == null) {
            lock.lock();
            if (logger == null) {
                logger = new Logger(fileWriter);
            }
            lock.unlock();
        }

        return logger;
    }

    public void log(String message) {
        lock.lock();
        try {
            logger.fileWriter.write(message);
            logger.fileWriter.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) throws IOException, InterruptedException {
        Logger loggerInstance = Logger.getInstance(new FileWriter("log.txt", true));
        Runnable task = () -> {
            for (int i = 0; i < 10; i++) {
                loggerInstance.log("Thread:" + Thread.currentThread().getName() + " ,count:" + i + "\n");
            }
        };
        CompletableFuture<Void> task1 = CompletableFuture.runAsync(() -> {
            for (int i = 0; i < 10; i++) {
                loggerInstance.log("Thread:" + Thread.currentThread().getName() + " ,count:" + i + "\n");
            }
        });
        CompletableFuture<Void> task2 = CompletableFuture.runAsync(() -> {
            for (int i = 0; i < 10; i++) {
                loggerInstance.log("Thread:" + Thread.currentThread().getName() + " ,count:" + i + "\n");
            }
        });


        Thread t = new Thread(task);
        Thread t1 = new Thread(task);
        t.start();
        t1.start();
        CompletableFuture<Void> future = CompletableFuture.allOf(task1, task2);
        future.join();
        t.join();
        t1.join();
    }

}
