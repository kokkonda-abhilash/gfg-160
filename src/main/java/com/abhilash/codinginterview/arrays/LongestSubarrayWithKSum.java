package com.abhilash.codinginterview.arrays;

public class LongestSubarrayWithKSum {

    /* 
     * Bruteforce
     */
    public static void findLongestSubArray(int[] arr, int k) {
        int n = arr.length;
        int max = 0;
        int start = -1;
        int end = -1;

        for (int i = 0; i < n; i ++) {
            int sum = 0;
            for (int j = i; j < n; j ++) {
                sum += arr[j];
                if (sum == k) {
                    start = i;
                    end = j;
                    max = Math.max(max, j - i + 1);
                }
            }
        }
    }
}
