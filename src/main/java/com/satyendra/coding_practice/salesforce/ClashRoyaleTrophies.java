package com.satyendra.coding_practice.salesforce;

public class ClashRoyaleTrophies {

    public static void main(String[] args) {
        System.out.println(findFirstTrophyCount(7));
    }

    private static int findFirstTrophyCount(int n) {
        int result = n;
        for(int x = n - 1; x > 0 ; x--) {
            result &= x;
            if(result == 0) {
                return n-x;
            }
        }
        return -1;
    }
}
