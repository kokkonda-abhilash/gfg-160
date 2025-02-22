package com.abhilash.codinginterview.sorting;

/* 
 * COUNTING SORT IS APPLICABLE ONLY IF THE ARRAY HAS POSITIVE INTEGERS -> 0 <= arr[i] <= k where k is the maximum element
 * For elements with negative integers, we have another alogrithm
 * This is NOT a comparison sort like other sorting algorithms
 * This sorting is efficient when range of input values are small when compared to number of elements to be sorted
 * The basic idea is to count the occurrences of the distinct elements in array and place them in correct positions
 */
public class CountSort {

    public static void main(String[] args) {
        int[] arr = { 2, 1, 1, 0, 2, 5, 4, 0, 2, 8, 7, 7, 9, 2, 0, 1, 9 };
    }

}