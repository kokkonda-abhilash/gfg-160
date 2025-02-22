package com.abhilash.codinginterview.arrays;
/* 
 * Given a positive integer k and an array arr[] denoting heights of towers
 * you have to modify the height of each tower either by increasing or decreasing them by k only once
 * Find out what could be the possible minimum difference of the height of shortest and longest towers
 * after you have modified each tower
 * 
 * Examples:
 * Input: k = 2, arr[] = [1, 5, 8, 10]
 * Output: 5
 * Explanation: The array can be modified as [3, 3, 6, 8]. The difference between the largest and the smallest is 8 - 3 = 5
 * 
 * Input: k = 3, arr[] = [3, 9, 12, 16, 20]
 * Output: 11
 * Explanation: The array can be modified as [6, 12, 9, 13, 17]
 * The difference between the largest and the smallest is 17 - 6 = 11
 */
public class MinimizeHeightDifferenceII {

    public static void main(String[] args) {
        int[] arr = { 3, 9, 12, 16, 20 };
        int k = 3;
        System.out.println(new MinimizeHeightDifferenceII().getMinimalHeightDifference(k, arr));
    }

    /* 
     * Here, the tricky part is to find the minimum element and maximum element after transformation
     * As the array is sorted, what we can do is
     *  Grab the minimum element by adding k to first element and subtracting 2 for the other elements
     *  Grab the maximum element by subtracting k from last element and adding k to all elements
     */
    public int getMinimalHeightDifference(int k, int[] arr) {
        int n = arr.length;
        int max = arr[n - 1] - k;
        int min = arr[0] + k;

        for (int i = 1; i < n - 1; i ++) {
            min = Math.min(arr[0] + k, arr[i] - k);
            max = Math.max(arr[n - 1] - k, arr[i] + k);
        }
        min = Math.min(arr[0] + k, arr[n - 1] - k);
        max = Math.max(arr[n - 1] - k, arr[0] + k);
        return Math.abs(min - max);
    }
}

/* 
 * 80
 * -70 -59 83 16 61 19
 * Your Code's output is:   71
 * It's Correct output is:  85
 */