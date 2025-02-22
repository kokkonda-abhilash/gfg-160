package com.abhilash.codinginterview.arrays;

/* 
 * Problem Statement: Given an integer array arr of size N, sorted in ascending order (with distinct values) and a target value k. Now the array is rotated at some pivot point unknown to you. Find the index at which k is present and if k is not present return -1.
 * Example 1:
 * Input Format: arr = [4,5,6,7,0,1,2,3], k = 0
 * Result: 4
 * Explanation: Here, the target is 0. We can see that 0 is present in the given rotated sorted array, nums. Thus, we get output as 4, which is the index at which 0 is present in the array.
 * Example 2:
 * Input Format: arr = [4,5,6,7,0,1,2], k = 3
 * Result: -1
 * Explanation: Here, the target is 3. Since 3 is not present in the given rotated sorted array. Thus, we get the output as -1.
 * 
 * 
 * How does the rotation occur in a sorted array?
 * Let's consider a sorted array: {1, 2, 3, 4, 5}. If we rotate this array at index 3, it will become: {4, 5, 1, 2, 3}. In essence, we moved the element at the last index to the front, while shifting the remaining elements to the right. We performed this process twice.
 */
public class SearchInRotatedArray {
    
    /* 
     * Brute Force
     * Time: O(n)
     * Space: O(1)
     * Iterate through the array and return the value if found
     */
    public int searchTheElement1(int[] inputArray, int test) {
        int n = inputArray.length;
        
        for (int i = 0; i < n; i ++) {
            if (inputArray[i] == test) return 1;
        }
        return -1;
    }

    /* 
     * Optimalapproach
     * Employ binary search as the given is a sorted array
     * Key Observation: At any index, one of the two portions is always sorted
     * So, to efficiently search for a target value using this observation, we will follow a simple two-step process. 
     * First, we identify the sorted half of the array. 
     * Once found, we determine if the target is located within this sorted half.
     * If not, we eliminate that half from further consideration.
     * Conversely, if the target does exist in the sorted half, we eliminate the other half.
     */
    public int searchTheElement2(int[] inputArray, int test) {
        int start = 0;
        int end = inputArray.length - 1;
        int mid = 0;

        while (start < end) {
            mid = (start + mid)/2;
            if (inputArray[mid] == test) return 1;
            else {
                if (inputArray[0] < inputArray[mid]) {
                    /* left half is sorted */
                    if (test < inputArray[mid]) {
                        end = mid - 1;
                    } else {
                        start = mid + 1;
                    }
                } else {
                    /* right half is sorted */
                    if (test < inputArray[end]) {
                        start = mid + 1;
                    } else {
                        end = mid - 1;
                    }
                }
            }
        }
        return -1;
    }
}
