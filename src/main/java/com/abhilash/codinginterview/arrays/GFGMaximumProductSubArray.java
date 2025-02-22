package com.abhilash.codinginterview.arrays;

public class GFGMaximumProductSubArray {

    public static void main(String[] args) {
        int[] arr = { -2, 6, -3, -10, 0, 2 };
        System.out.println(new GFGMaximumProductSubArray().getMaximumProductSubArray_optimized(arr));
    }

    public int getMaximumProductSubArray_bruteforce(int[] arr) {
        int n = arr.length;

        if (n == 0) return 0;
        if (n == 1) return arr[0];

        int maxproduct = 1;
        int currentproduct = 1;
        int start = -1;
        int end = -1;
        
        for (int i = 0; i < n; i ++) {
            currentproduct = 1;
            start = i;
            for (int j = i; j < n; j ++) {
                currentproduct *= arr[j];
                maxproduct = Math.max(currentproduct, maxproduct);
                end = j;
            }
        }
        return maxproduct;
    }

    /* 
     * In case of negative numbers, we need to check for two way combination
     */
    public int getMaximumProductSubArray_optimized(int[] arr) {
        int n = arr.length;
        int maxproduct = Integer.MIN_VALUE;

        if (n == 0) return 0;
        if (n == 1) return arr[0];
        int suffix = 1;
        int prefix = 1;
        
        for (int i = 0; i < n; i ++) {
            if (arr[i] == 0) {
                suffix = 1;
            } else {
                suffix *= arr[i];
                maxproduct = Math.max(maxproduct, suffix);
            }
            if (arr[n - i - 1] == 0) {
                prefix = 1;
            } else {
                prefix *= arr[n - i - 1];
                maxproduct = Math.max(maxproduct, prefix);
            }
        }
        if (maxproduct < 0) {
            /* In case we have negative numbers and zeroes */
            for (int i = 0; i < n; i ++) {
                maxproduct = Math.max(maxproduct, arr[i]);
            }
        }
        return maxproduct;
    }
}
