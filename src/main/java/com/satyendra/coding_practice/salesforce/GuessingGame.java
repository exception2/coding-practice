package com.satyendra.coding_practice.salesforce;

import java.util.*;

public class GuessingGame {

    public static List<Integer> solution(List<Integer> v) {
        int n = v.size();
        List<Integer> d = new ArrayList<>(Collections.nCopies(n + 1, 0));
        TreeMap<Integer, Integer> have = new TreeMap<>();

        // Initialize the map with boundaries
        have.put(0, 0);
        have.put(n + 1, 0);

        for (int x : v) {
            // Get the upper bound
            Map.Entry<Integer, Integer> t = have.higherEntry(x);
            Map.Entry<Integer, Integer> lower = have.lowerEntry(x);

            int be = lower.getKey();
            int org = lower.getValue();
            have.remove(lower.getKey());

            // [be, x - 1] >
            if (be < x) {
                have.put(be, 1);
            }

            // [x, t->first - 1] <
            have.put(x, -1);

            if (org == 1) {
                // ans [x, t.first - 1] all plus one
                d.set(x, d.get(x) + 1);
                d.set(t.getKey(), d.get(t.getKey()) - 1);
            }
        }

        // Accumulate values in d
        for (int i = 1; i < n; i++) {
            d.set(i, d.get(i) + d.get(i - 1));
        }

        // Remove the extra last element
        d.remove(d.size() - 1);
        return d;
    }

    public static void main(String[] args) {
        List<Integer> input = Arrays.asList(5, 1, 2, 4, 3, 6);
        List<Integer> result = solution(input);
        for (int x : result) {
            System.out.println(x);
        }
    }
}



