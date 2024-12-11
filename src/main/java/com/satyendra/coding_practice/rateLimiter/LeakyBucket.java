package com.satyendra.coding_practice.rateLimiter;

import org.springframework.scheduling.annotation.Async;

import java.util.LinkedList;
import java.util.Queue;

public class LeakyBucket extends RateLimiter {

    Queue<Long> queue;
    public LeakyBucket(int limitPerSecond, int capacity) {
        super(limitPerSecond, capacity);
        this.queue = new LinkedList<>();
    }

    @Override
    public boolean allowRequest() {
        leak();
        if(queue.size() < capacity) {
            queue.add(System.currentTimeMillis());
            return true;
        }
        return false;
    }

    @Async
    private void leak() {
        while(!queue.isEmpty() && (System.currentTimeMillis() - queue.peek())/1000 > 0) {
            
        }
    }
}
