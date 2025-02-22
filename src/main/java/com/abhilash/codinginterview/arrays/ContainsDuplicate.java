package com.abhilash.codinginterview.arrays;

import java.util.Arrays;

/* 
 * Problem Statement: Given an integer array nums, return true if any value appears at least twice in the array, and return false if every element is distinct.
 */
public class ContainsDuplicate {

    /* Approach 1: Brute force - 2 loops
    * Time: O(n * n)
    * Space: O(1)
    */
    public String checkForDuplicate1(int[] inputArray) {
        for (int i = 0; i < inputArray.length - 1; i ++) {
            for (int j = i + 1; j < inputArray.length; j ++) {
                if (inputArray[i] == inputArray[j]) return "YES";
            }
        }
        return "NO";
    }

    /* 
     * Approach 2: Sorting approach
     * Sort and check if adjacent elements are same
     */
    public String checkForDuplicate2(int[] inputArray) {
        Arrays.sort(inputArray);
        for (int i = 0; i < inputArray.length - 1; i ++) {
            if (inputArray[i] == inputArray[i + 1]) return "YES";
        }
        return "NO";
    }
}
