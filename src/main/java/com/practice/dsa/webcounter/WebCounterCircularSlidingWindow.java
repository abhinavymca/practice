package com.practice.dsa.webcounter;

import java.time.Instant;
import java.util.*;
import java.util.concurrent.locks.ReentrantLock;

public class WebCounterCircularSlidingWindow {
    int windowSize = 300;
    String prefix = "visitCount:";
    Bucket[] bucket = new Bucket[300];
    Map<Integer, ReentrantLock> lockMap = new HashMap<>();

    public WebCounterCircularSlidingWindow() {
        for (int i = 0; i < 300; i++) {
            this.bucket[i] = new Bucket();
            bucket[i].userId = new HashSet<>();
            lockMap.put(i, new ReentrantLock());
        }
    }

    public void recordVisit(String userId) {
        long currentTime = Instant.now().getEpochSecond();
        int currentTimeIndex = (int) (currentTime / 300);
        ReentrantLock lock = lockMap.get(currentTimeIndex);
        lock.lock();
        try {
            if (bucket[currentTimeIndex].time != currentTime) {
                bucket[currentTimeIndex].time = currentTime;
                bucket[currentTimeIndex].userId.clear();
            }
            bucket[currentTimeIndex].userId.add(userId);
        } finally {
            lock.unlock();
        }

    }

    public int count() {
        long currentTime = Instant.now().getEpochSecond();
        int totalVisit = 0;
        for (int i = 0; i < 300; i++) {
            ReentrantLock lock = lockMap.get(i);
            lock.lock();
            try {
                if (currentTime - bucket[i].time < 300) {
                    totalVisit += bucket[i].userId.size();
                }
            } finally {
                lock.unlock();
            }
        }

        return totalVisit;
    }

    class Bucket {
        long time;
        Set<String> userId;
    }

    public static void main(String[] args) {

    }
}
