package com.satyendra.coding_practice.salesforce;

public class BeautifulArrangement {
    public static void main(String[] args) {
        BeautifulArrangement beautifulArrangement = new BeautifulArrangement();
        System.out.println(beautifulArrangement.countArrangement(2));
        System.out.println(beautifulArrangement.countArrangement(1));
        System.out.println(beautifulArrangement.countArrangement(4));
    }

    public int countArrangement(int n) {
        return arrangement(1, n, new boolean[n + 1]);
    }

    private int arrangement(int index, int n, boolean[] arr) {
        if(index > n) {
            return 1;
        }
        int count = 0;
        for(int i = 1; i <= n; i++) {
            if(!arr[i] && (i % index == 0 || index % i == 0)) {
                arr[i] = true;
                count += arrangement(index + 1, n, arr);
                arr[i] = false;
            }
        }
        return count;
    }
}
