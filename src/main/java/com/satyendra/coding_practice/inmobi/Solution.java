package com.satyendra.coding_practice.inmobi;

public class Solution {
    /*
    You are tasked with finding the highest possible sum from a non-empty contiguous sequence of integers within an array,
    with the option to remove one element. Essentially, you need to select a subarray and may choose to delete a single element,
    ensuring that at least one element is left, in order to maximize the sum of what remains.
    Keep in mind that the selected sequence must not be empty after the removal.

    arr = [1,-2,0,3] -> -1
    ans = [1, -2 ,0,3] = 2 , 4

    left : 1, -1, -1, 2
    right: 2, 1, 3, 3

    leftMin: 1, -2, -2, -2
    rightMin: -2, -2, 0, 3

    subSum = (1, 3)

            [0, 3]
       [0, 1]   [2, 3]
   [0,0] [1,1]  [2,2]  [3,3]

   maxSum
   minElement

   1, -2, 0
   -2
   left
   right


    ans = max(ans , max(subSum , (subSum - minElement)))

    [1, -2, -2, 3]
    (0, 1), (0, 2)
    [-2, 3] = 3

    left : 1, -1, -3, 0
    right: 0, -1,  1, 3
    find a choose sub array
    at least 2 elements
    maximum sum


    Sol1 :
    brute force
    TC - O(N^2)
    SC - O(1)

    sol2
    TC - O(N)
    SC - O(N)

    sol3
    TC - O(N * log(N))
    SC - O(N)

    * */

    /*
    Alisha loves to eat bananas. There are n piles of bananas, the ith pile has piles[i] bananas. The Arun have gone and will come back in h hours.
    Alisha can decide her bananas-per-hour eating speed of k. Each hour, she chooses some pile of bananas and eats k bananas from that pile.
    If the pile has less than k bananas, she eats all of them instead and will not eat any more bananas during this hour.
    Alisha likes to eat slowly but still wants to finish eating all the bananas before the Arun return.
    Return the minimum integer k such that she can eat all the bananas within h hours.

    piles = [3,6,7,11], h = 8
    k [1, max]
    speed of eating - k ?
    k = 4
    c(3/k), c(6/k), c(7/k), c(11/k) = h
    k = 3
    h = 0, 0
    h = 1, 4 - 3 = 1
    h = 2, 1 - 0 = 0

    [3,6,7,11] , 8
    min = 1, max = 11
    mid = 6
    hour = 6

    min = 1, max = 6
    mid = 3
    hour = 10

    min = 4, max = 6
    mid = 3
    hour = 10

    int findYourSpeed(piles, h) {
        min = 1, max = max(piles)
        while(min < max) {
            find mid
            hour = findHours(piles, mid)
            if(hour < h)
                max = mid;
            else
                min = mid+1
        }
        return max;
    }
    int findHours(arr, k) {
        traverse array
        sum of all ceil value of array element after division by k
        return sum
    }

    * */

}
