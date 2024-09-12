package wayfair;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class SecurityJump {
    public static void main(String[] args) {

        // Get test cases
        List<List<Integer>> testCases = getTests();
        // Iterate through test cases
        for (List<Integer> testCase : testCases) {
            int n = testCase.size(), k = testCase.get(n - 1);
            List<Integer> inp = testCase.subList(0, n - 1);

            // Calculate results using both approaches
            int optimal = gainMaxValue1(inp, k);
            int bruteForce = gainMaxValue2(inp, k);

            // Check if both approaches produce the same result
            System.out.println(optimal == bruteForce
                    ? "Answer: " + optimal
                    : "Expected: " + bruteForce);
        }
    }

    // Optimized approach: O(n)
    public static int gainMaxValue1(List<Integer> securityVal, int k) {
        int n = securityVal.size();
        int[] dp = new int[n];
        int result = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            dp[i] = securityVal.get(i);
            if (i - k >= 0) dp[i] = Math.max(securityVal.get(i) + dp[i - k], securityVal.get(i));
            if (i + k > n - 1) result = Math.max(result, dp[i]);
        }
        return result;
    }

    // Brute force approach: O(n^2)
    public static int gainMaxValue2(List<Integer> securityVal, int k) {
        int n = securityVal.size();
        int result = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            int currSum = securityVal.get(i);
            for (int j = i + k; j < n; j = j + k) {
                currSum += securityVal.get(j);
            }
            result = Math.max(currSum, result);
        }
        return result;
    }

    public static List<List<Integer>> getTests() {
        List<List<Integer>> tests = new ArrayList<>();

        // Adding original test cases
        tests.add(Arrays.asList(2, -3, 4, 6, 1, 2)); // answer 7
        tests.add(Arrays.asList(1, 1)); // answer 1
        tests.add(Arrays.asList(-3, -5, -1, -8, -4, -5, 3)); // answer -4
        tests.add(Arrays.asList(0, 0, 0, 0, 0, 3)); // answer 0
        tests.add(Arrays.asList(2, -3, 4, 6, 1, 1)); // answer 11
        tests.add(Arrays.asList(-5, 2, 100, 7, -100, 2)); // answer 9
        tests.add(Arrays.asList(-5, 2, 100, 7, -100, 3)); // answer 100
        tests.add(Arrays.asList(1, 2, 3, 4, 5, 1)); // 15
        tests.add(Arrays.asList(-1, -2, -3, -4, -5, 3)); // -3
        tests.add(Arrays.asList(0, 0, 0, 0, 0, 2)); // 0

        // Adding additional random test cases
        Random random = new Random();
        for (int i = 0; i < 50; i++) {
            int size = random.nextInt(1000000) + 1;  // Random size between 1 and 10^6
            int k = random.nextInt(size) + 1;  // Random k between 1 and size
            List<Integer> testCase = new ArrayList<>();
            for (int j = 0; j < size; j++) {
                int value = random.nextInt(2001) - 1000;  // Random value between -1000 and 1000
                testCase.add(value);
            }
            testCase.add(k);
            tests.add(testCase);
        }

        return tests;
    }
}