package com.abhilash.codinginterview.arrays;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.TreeSet;

/* 
 * You are given an array of integer arr[] where each number represents a vote to a candidate
 * Return the candidates that have votes greater than one-third of the total votes, If there's not a majority vote, return an empty array
 * Note: The answer should be returned in an increasing format.
 * 
 * Examples:
 * Input: arr[] = [2, 1, 5, 5, 5, 5, 6, 6, 6, 6, 6]
 * Output: [5, 6]
 * Explanation: 5 and 6 occur more n/3 times
 * 
 * Input: arr[] = [1, 2, 3, 4, 5]
 * Output: []
 * Explanation: no candidate occur more than n/3 times
 * 
 * >>>> ** IMP: While adding the candidate to the result, make sure that the candidate you are adding is not the same candidate added as before ** <<<<
 */
public class MajorityElement {

    public static void main(String[] args) {
        int[] arr = { 2, 1, 5, 5, 5, 5, 6, 6, 6, 6, 6 };
        MajorityElement majorityElement = new MajorityElement();
        System.out.println(majorityElement.collectMojorityElements2(arr));
    }

    /* Better approach: Hashing */
    public TreeSet<Integer> collectMojorityElements(int[] arr) {
        int n = arr.length;
        int leastRequired = n/3;
        HashMap<Integer, Integer> majorities = new HashMap<>();
        TreeSet<Integer> result = new TreeSet<>();

        for (int i = 0; i < n; i ++) {
            if (majorities.containsKey(arr[i])) {
                majorities.put(arr[i], majorities.get(arr[i]) + 1);
            } else majorities.put(arr[i], 1);
        }
        for (int element: majorities.keySet()) {
            if (majorities.get(element) >= leastRequired) {
                result.add(element);
            }
        }
        return result;
    }

    /* 
     * Optimal approach - Moore's algorithm
     */
    public ArrayList<Integer> collectMojorityElements2(int[] nums) {
        int n = nums.length;
        int candidate1 = nums[0];
        int candidate2 = -1;
        int count1 = 1;
        int count2 = 0;
        ArrayList<Integer> result = new ArrayList<>();

        for (int i = 1; i < n; i ++) {
            /* candidate2 != nums[i]  --> IMP */
            if (count1 == 0 && candidate2 != nums[i]) {
                candidate1 = nums[i];
                count1 = 1;
            /* candidate1 != nums[i]  --> IMP */
            } else if (count2 == 0 && candidate1 != nums[i]) {
                candidate2 = nums[i];
                count2 = 1;
            } else if (candidate1 == nums[i]) count1 += 1;
            else if (candidate2 == nums[i]) count2 += 1; 
            else {
                count1 -= 1;
                count2 -= 1;
                if (count1 == 0) candidate1 = -1;
                if (count2 == 0) candidate2 = -1;
            }
        }
        /* 
         * Iterate over the array again for candidate1 and candidate2 to check if they are majority elements
         */
        count1 = 0;
        count2 = 0;
        for (int i = 0; i < n; i ++) {
            if (nums[i] == candidate1) {
                count1 += 1;
            } else if (nums[i] == candidate2) {
                count2 += 1;
            }
        }
        if (count1 > (n/3)) result.add(candidate1);
        if (count2 > (n/3)) {
            if (candidate1 < candidate2) result.add(candidate2);
            else result.add(0, candidate2); /* Don't forget the else case!!!!! */
        }
        return result;
    }
}
