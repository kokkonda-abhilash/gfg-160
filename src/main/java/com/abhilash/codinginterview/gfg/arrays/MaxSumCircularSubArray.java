package com.abhilash.codinginterview.gfg.arrays;

/* 
 * Given an array of integers arr[] in a circular fashion
 * Find the maximum subarray sum that we can get if we assume the array to be circular
 * 
 * Examples:
 * Input: arr[] = [8, -8, 9, -9, 10, -11, 12]
 * Output: 22
 * Starting from the last element of the array, i.e, 12, and moving in a circular fashion
 * we have max subarray as 12, 8, -8, 9, -9, 10, which gives maximum sum as 22
 * 
 * Input: arr[] = [10, -3, -4, 7, 6, 5, -4, -1]
 * Output: 23
 * Explanation: Maximum sum of the circular subarray is 23. The subarray is [7, 6, 5, -4, -1, 10]
 * 
 * Input: arr[] = [-1, 40, -14, 7, 6, 5, -4, -1]
 * Output: 52
 * Explanation: Circular Subarray [7, 6, 5, -4, -1, -1, 40] has the maximum sum, which is 52
 */
public class MaxSumCircularSubArray {

    public static void main(String[] args) {
        
        int[] arr = { -7, 32, -11, 21, 18, 35, -26, -17, 35, -12, -38, -33, 32, 16, 44, 11, -40, -21, 2, 27, -35, 21, -37, -12, 1 };
        System.out.println(new MaxSumCircularSubArray().getMaxSubArrayFromCircularArray(arr));
    }

    /* 
     * Attempt
     * Approach here is to find the minimum sum sub array and subtract that from the total sum of the array
     */
    public int getMaxSubArrayFromCircularArray(int[] arr) {
        int n = arr.length;
        if (n == 0) return 0;
        if (n == 1) return arr[0];
        int currentsum = 0;
        int minimumsum = Integer.MAX_VALUE;
        int totalsum = 0;

        for (int i = 0; i < n; i ++) {
            if (arr[i] > 0) currentsum = 0;
            else {
                totalsum += arr[i];
                currentsum += arr[i];
                if (currentsum >= 0) currentsum = 0;
            }
            minimumsum = Math.min(minimumsum, currentsum);
        }
        /* All are positive integers */
        if (minimumsum == 0) {
            minimumsum = Integer.MAX_VALUE;
            for (int i = 0; i < n; i ++) {
                minimumsum = Math.min(minimumsum, arr[i]);
            }
        }
        System.out.println("Minimum Sum: " + minimumsum);
        System.out.println("Total Sum: " + totalsum);
        return (totalsum - minimumsum);
    }
}
