package com.satyendra.coding_practice.rateLimiter;

public abstract class RateLimiter {
    int limitPerSecond;
    int capacity;

    public RateLimiter(int limitPerSecond, int capacity) {
        this.limitPerSecond = limitPerSecond;
        this.capacity = capacity;
    }

    public abstract boolean allowRequest();
}
