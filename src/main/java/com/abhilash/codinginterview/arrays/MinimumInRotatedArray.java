package com.abhilash.codinginterview.arrays;

/* 
 * Minimum in Rotated Sorted Array
 * Problem Statement: Given an integer array arr of size N, sorted in ascending order (with distinct values). Now the array is rotated between 1 to N times which is unknown. Find the minimum element in the array.
 * Example 1:
 * Input Format:
 * arr = [4,5,6,7,0,1,2,3]
 * Result:
 * 0
 * Explanation:
 * Here, the element 0 is the minimum element in the array.
 * Example 2:
 * Input Format:
 * arr = [3,4,5,1,2]
 * Result:
 * 1
 * Explanation:
 * Here, the element 1 is the minimum element in the array.
 */
public class MinimumInRotatedArray {

    /* 
     * Naive Approach (Brute force):
     * Linar search algorithm
     * Time: O(n)
     * Space: O(1)
     */
    public int getMinimumValue(int[] inputArray) {
        int min = Integer.MIN_VALUE;
        final int n = inputArray.length;
        for (int i = 0; i < n; i ++) min = Math.min(n, inputArray[i]);
        return min;
    }

    /* 
     * Binary Search
     * As per the question the rotated array is sorted. So we can go for binary search algorithm
     * VERY IMPORTANT OBSERVATION: For every index in the rotated array, on of the two halves will always be sorted
     * We will declare the ‘ans’ variable and initialize it with the largest value possible. With that, as usual, we will declare 2 pointers i.e. low and high.
     * Place the 2 pointers i.e. low and high: Initially, we will place the pointers like this: low will point to the first index and high will point to the last index.
     * Calculate the ‘mid’: Now, inside a loop, we will calculate the value of ‘mid’ using the following formula:
     *   mid = (low+high) // 2 ( ‘//’ refers to integer division)
     * Identify the sorted half, and after picking the leftmost element, eliminate that half.
     *   If arr[low] <= arr[mid]: This condition ensures that the left part is sorted. So, we will pick the leftmost element i.e. arr[low]. Now, we will compare it with 'ans' and update 'ans' with the smaller value (i.e., min(ans, arr[low])). Now, we will eliminate this left half(i.e. low = mid+1).
     *   Otherwise, if the right half is sorted:  This condition ensures that the right half is sorted. So, we will pick the leftmost element i.e. arr[mid]. Now, we will compare it with 'ans' and update 'ans' with the smaller value (i.e., min(ans, arr[mid])). Now, we will eliminate this right half(i.e. high = mid-1).
     * This process will be inside a loop and the loop will continue until low crosses high. Finally, we will return the ‘ans’ variable that stores the minimum element.
     */
    public int getMinimumValue2(int[] inputArray) {
        int left = 0;
        int right = inputArray.length - 1;
        int min = Integer.MIN_VALUE;

        while (left <= right) {
            int mid = (left + right)/2;
            if (inputArray[left] < inputArray[mid]) {
                /* Left array is sorted */
                min = inputArray[left];
                /* Discard left half */
                left = mid + 1;
            } else {
                /* Right half is sorted */
                min = inputArray[mid];
                /* Discard right half */
                right = mid - 1;
            }
        }
        return min;
    }
}
