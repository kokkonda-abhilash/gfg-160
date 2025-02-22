package com.abhilash.codinginterview.arrays;

/* 
 * Problem Statement: Given an integer array arr of size N, sorted in ascending order (with distinct values). Now the array is rotated between 1 to N times which is unknown. Find the minimum element in the array. 
 * How does the rotation occur in a sorted array?
 * Let's consider a sorted array: {1, 2, 3, 4, 5}. If we rotate this array at index 3, it will become: {4, 5, 1, 2, 3}. In essence, we moved the element at the last index to the front, while shifting the remaining elements to the right. We performed this process twice.
 */

public class MinimumInRotatedSortedArray {

    public static void main(String[] args) {
        int[] arr = {4, 5, 6, 0, 1, 2, 3};
        int ans = new MinimumInRotatedSortedArray().findMinimumOwnSolution(arr);
        System.out.println("The minimum element is: " + ans );
    }

    /* 
     * Brute Force
     * Time: O(n)
     * Space: O(n)
     */
    public int findMinimum1(int[] inputArray) {
        int n = inputArray.length;
        int min = inputArray[0];
    
        for (int i = 0; i < n; i ++) {
            if (min < inputArray[i]) min = inputArray[i];
        }
        return min;
    }

    /* 
     * Binary Search (Self analysis)
     * As the given array is sorted, we can think of binary search
     * { 10, 1, 2, 3, 4, 5, 6, 7, 8, 9 }
     * { 9, 10, 1, 2, 3, 4, 5, 6, 7, 8 }
     * { 7, 8, 9, 10, 1, 2, 3, 4, 5, 6 }
     * { 6, 7, 8, 9, 10, 1, 2, 3, 4, 5 }
     * { 6, 7, 8, 9, 1, 2, 3, 4, 5 }
     * Crucial observation in roated sorted array - at any index, either of the left or right part of the array is sorted
     * 1. get the mid point of the array - If right and left part of the array is sorted, then mid is the minimum element
     * 2. The minimum always lies in the unsorted part of the array
     */
    public int findMinimumOwnSolution(int[] inputArray) {
        int n = inputArray.length;
        int start = 0;
        int end = n - 1;
        int mid = 0;
        int ans = inputArray[0];
        if (inputArray[start] < inputArray[end]) return inputArray[start];
        /* Check if array is rotated to exactly mid point */
        mid = (start + end) / 2;
        while (start < end) {
            mid = (start + end) / 2;
            if (inputArray[mid] < inputArray[end]) {
                /* right half of the array is sorted */
                end = mid - 1;/* Discard right hald */
                ans = Math.min(ans, inputArray[mid]);
            } else {
                /* Left half the array is sorted */
                start = mid + 1;/* Discard the left half */
                ans = Math.min(ans, inputArray[start]);
            }
        }
        return ans;
    }
}
