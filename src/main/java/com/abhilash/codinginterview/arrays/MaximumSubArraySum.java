package com.abhilash.codinginterview.arrays;

/* 
 * Kadane's Algorithm : Maximum Subarray Sum in an Array
 * Problem Statement: Given an integer array arr, find the contiguous subarray (containing at least one number) which
has the largest sum and returns its sum and prints the subarray.
 */
public class MaximumSubArraySum {

    /* 
    * Approach 1: Brute force
    * Time: O(n * n * n)
    * Space: O(1)
    */
    public int getMaximumSum1(int[] inputArray) {
        int maxSum = Integer.MIN_VALUE;
        for (int i = 0; i < inputArray.length; i++) {
            for (int j = i; j < inputArray.length; j++) {
                int sum = 0;
                for (int k = i; k <= j; k++) {
                    sum += inputArray[k];
                }
                maxSum = Math.max(maxSum, sum);
            }
        }
        return maxSum;
    }

    /* 
     * As per analysis we see loop k not necessary
     * Time: O(n * n)
     * Space: O(1)
     */
    public int getMaximumSum2(int[] inputArray) {
        int maxSum = Integer.MIN_VALUE;
        for (int i = 0; i < inputArray.length; i++) {
            int sum = 0;
            for (int j = i; j < inputArray.length; j++) sum += inputArray[j];
            maxSum = Math.max(maxSum, sum);
        }
        return maxSum;
    }

    /* 
     * Kadane's Algorithm
     * Time: O(n)
     * Space: O(1)
     * Note: This algorithm will not work if all the elements are negative
     * In that case, we will return the maximum element from the array
     * Approach is:
     * 1. Initialize maxSum and currentSum to 0
     * 2. Iterate over the array
     * 3. For each element, add it to currentSum
     * 4. If currentSum is less than 0, then reset it to 0
     * 5. If currentSum is greater than maxSum, then update maxSum
     * 6. Return maxSum
     */
    public int getMaximumSum3(int[] inputArray) {
        int maxSum = Integer.MIN_VALUE;
        int currentSum = 0;
        for (int i = 0; i < inputArray.length; i++) {
            currentSum += inputArray[i];
            if (currentSum < 0) currentSum = 0;
            maxSum = Math.max(maxSum, currentSum);
        }
        // Below code if all elements are negative
        if (maxSum == 0) {
            maxSum = Integer.MIN_VALUE;
            for (int i = 0; i < inputArray.length; i++) {
                maxSum = Math.max(maxSum, inputArray[i]);
            }
        }
        return maxSum;
    }
}