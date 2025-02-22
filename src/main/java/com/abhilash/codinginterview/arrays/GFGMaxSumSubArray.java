package com.abhilash.codinginterview.arrays;

public class GFGMaxSumSubArray {

    public static void main(String[] args) {
        int[] arr = { 2, 3, -8, 7, -1, 2, 3 };
        System.out.println(new GFGMaxSumSubArray().getMaximumSumSubArray(arr));
    }

    public int getMaximumSumSubArray(int[] arr) {
        int n = arr.length;
        int start = -1;
        int end = -1;
        int maxsum = 0;
        int sumuntilnow = 0;

        for (int i = 0; i < n; i ++) {
            if (start == -1) start = i;
            sumuntilnow += arr[i];
            maxsum = Math.max(maxsum, sumuntilnow);
            end = i;
            if (sumuntilnow < 0) {
                sumuntilnow = 0;
                start = -1;
                end = -1;
            }
        }
        System.out.println(start + " \t" + end);
        if (maxsum < 0) {
            /* Case when all the elements are negative */
            for (int i = 0; i < n; i ++) {
                maxsum = Integer.MIN_VALUE;
                maxsum = Math.max(maxsum, arr[i]);
            }
        }
        return maxsum;
    }
}

/* 
 * There is one more approach to this problem
 * We check this way:
 *      max = Math.max(currentsum + arr[i], arr[i]);
 * This is like telling the control
 *      Whether you continue with existing sum
 *      or
 *      Start from i
 * This is very intuitive and easy to understand and can be applied to maximum sum circular sub array problem
 */