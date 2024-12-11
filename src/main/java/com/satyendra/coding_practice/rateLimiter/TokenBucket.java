package com.satyendra.coding_practice.rateLimiter;

public class TokenBucket extends RateLimiter {

    private long lastRefillTime;
    private int tokenAvailable;

    public TokenBucket(int capacity, int limitPerSecond) {
        super(limitPerSecond, capacity);
        this.capacity = capacity;
        this.limitPerSecond = limitPerSecond;
        this.lastRefillTime = System.currentTimeMillis();
        this.tokenAvailable = capacity;
    }

    @Override
    public boolean allowRequest() {
        refill();
        if(tokenAvailable > 0) {
            tokenAvailable--;
            return true;
        }
        return false;
    }

    // @Scheduled(fixedRate = 1000)
    private synchronized void refill() {
        long newAvailableTokens = ((System.currentTimeMillis() - lastRefillTime)/1000) * limitPerSecond;
        tokenAvailable += (int)newAvailableTokens;
        // System.out.println("Refill started!");
    }

    public static void main(String[] args) throws InterruptedException {
        TokenBucket tokenBucket = new TokenBucket(10, 5);

        for(int i = 0 ; i < 30 ; i++) {
            if (tokenBucket.allowRequest()) {
                System.out.println("Request allowed : " + i);
            } else {
                System.out.println("Request denied : " + i);
            }
            Thread.sleep(50);
        }
    }
}
