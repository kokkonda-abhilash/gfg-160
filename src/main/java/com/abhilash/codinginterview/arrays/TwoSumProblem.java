package com.abhilash.codinginterview.arrays;

import java.util.Arrays;
import java.util.HashMap;

/* 
Problem Statement: Given an array of integers arr[] and an integer target.
1st variant: Return YES if there exist two numbers such that their sum is equal to the target. Otherwise, return NO.
2nd variant: Return indices of the two numbers such that their sum is equal to the target. Otherwise, we will return {-1, -1}.
Note: You are not allowed to use the same element twice. Example: If the target is equal to 6 and num[1] = 3, then nums[1] + nums[1] = target is not a solution.
*/

public class TwoSumProblem {

    public static void main(String[] args) {
        int[] array = {2, 6, 5, 8, 11};
        int target = 14;
        new TwoSumProblem().checkIfSumExists4(array, target);
    }

/* Variation 1 START */

/* 1. Brute force
 * Time: O(n * n)
 * Space: O(1)
*/
    public String checkIfSumExists1(int[] inputArray, int target) {
        for(int i = 0; i < inputArray.length -1; i++) {
            for (int j = i + 1; j < inputArray.length; i++) {
                if (inputArray[i] + inputArray[j] == target) return "YES";
            }
        }
        return "NO";
    }

/* 2. Using map
 * Time: O(n)
 * Space: O(n)
*/
    public String checkIfSumExists2(int[] inputArray, int target) {
        HashMap<Integer, Integer> remainingmapper = new HashMap<>();
        for(int i = 0; i < inputArray.length -1; i++) {
            int remaining = target - inputArray[i];
            if (inputArray[i] == remainingmapper.get(remaining)) return "YES";
            remainingmapper.put(remaining, inputArray[i]);
        }
        return "NO";
    }

/* 3. Two pointer approach
 * Time: O(n)
 * Space: O(1)
*/
    public String checkIfSumExists3(int[] inputArray, int target) {
        /* 
         * I UNDERSTOOD YOUR QUESTION - in what fashion we need to increment and decrement the pointers
         * *** the hidden drawback is to first sort the given array ***
         */
        Arrays.sort(inputArray);

        int start = 0;
        int end = inputArray.length - 1;
        while (start < end) {
            int sum = inputArray[start] + inputArray[end];
            if (sum == target) return "YES";
            if (sum < target) start ++;
            else end --;
        }
        return "NO";
    }

    public void checkIfSumExists4(int[] inputArray, int target) {
        int start = 0;
        int end = inputArray.length - 1;
        String result = checkRecursively(inputArray, target, start, end);
        System.out.println(result);
    }

    public String checkRecursively(int[] inputArray, int target, int start, int end) {
        if (start >= end) return "NO";
        else {
            if (inputArray[start] + inputArray[end] == target) return "YES";
            else if (inputArray[start] + inputArray[end] < target) start += 1;
            else end -= 1;
            return checkRecursively(inputArray, target, start, end);
        }
    }
}
