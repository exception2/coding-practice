package general;

public class MaxSumSubArray {

    public static void main(String[] args) {
        // Example usage
        int[] arr = {-3, 4, 3, -2, 2, 5};
        int K = 4; // Maximum length of the subarray

        int result = maxSubarrayWithMaxLength(arr, K);
        System.out.println("Maximum subarray sum with a maximum length of " + K + ": " + result);

        int[] arr1 = {70, 21, -78, 69, 31};
        int K1 = 3;  // Maximum subarray length

        int result1 = maxSubarrayWithMaxLength(arr1, K1);
        System.out.println("Maximum subarray sum with a maximum length of " + K1 + ": " + result1);
    }

    public static int maxSubarrayWithMaxLength(int[] arr, int K) {
        int n = arr.length;
        int maxSum = 0;
        int currentSum = 0;
        int start = 0;

        for (int i = 0; i < n; i++) {
            currentSum += arr[i];
            if(currentSum < 0) {
                currentSum = 0;
                start = i + 1;
            } else {
                if(i - start + 1 == K) {
                    maxSum = Math.max(maxSum, currentSum);
                    currentSum -= arr[start];
                    start++;
                }
                while(currentSum <= 0 && start <= i) {
                    maxSum = Math.max(maxSum, currentSum);
                    currentSum -= arr[start];
                    start++;
                }
            }
        }

        return maxSum;
    }

}
