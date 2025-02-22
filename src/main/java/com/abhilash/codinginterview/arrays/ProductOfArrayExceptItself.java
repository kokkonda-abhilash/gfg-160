package com.abhilash.codinginterview.arrays;

/* 
 * Given an array, return an array such that the element at index i is the product of all the elements in the array except itself.
 * Example 1:
 * Input: [1, 2, 3, 4]
 * Output: [24, 12, 8, 6]
 * Explanation: The product of all the elements except 1 is 24, except 2 is 12, except 3 is 8, except 4 is 6.
 */
public class ProductOfArrayExceptItself {

    /* 
     * Brute Force
     * Time: O(n)
     * Space: O(1) as output array is not considered
     * 
     * Problem with this approach - division with zero if input array contains 0
     */
    public int[] getProductOfArrayExceptItself(int[] inputArray) {
        int n = inputArray.length;
        int[] outputArray = new int[n];
        int product = 1;

        for (int i = 0; i < n; i ++) product = product * inputArray[i];

        for (int i = 0; i < n; i ++) outputArray[i] = product / inputArray[i];

        return outputArray;
    }

    /* 
     * Optimal approach
     * 
     * Approach 1: Using prefix and suffix arrays
     * prefix array is the subarray from o to i
     * suffix array is the subarray from i + 1 to n
     * Time: O(n)
     * Space: O(n) as we are using two arrays of length n
     */
    public int[] getProductOfArrayExceptItself2(int[] inputArray) {
        int n = inputArray.length;
        int[] prefix = new int[n];
        int[] suffix = new int[n];
        int[] outputArray = new int[n];

        /* Prepare prefix array */
        int product = 1;
        for (int i = 0; i < n; i ++) {
            product *= inputArray[i];
            prefix[i] = product;
        }
        /* Prepare suffix array */
        product = 1;
        for (int i = (n - 1); i >= 0; i --) {
            product *= inputArray[i];
            suffix[i] = product;
        }
        /* Prepare output array */
        outputArray[0] = suffix[1];
        outputArray[n - 1] = prefix[n - 2];
        for (int i = 1; i <= (n - 2); i ++) outputArray[i] = prefix[i - 1] * suffix[i + 1];

        return outputArray;
    }

    /* 
     * Optimizing the optimal approach to make Space complexity O(1)
     * Here the trick is to utilize the input and output arrays to store the prefix and suffix arrays
     * [ 2, 3, 7, 9, 2, 6 ]
     * Prefix = [ 2, 6,  ]
     * Sufix = [  ]
     */
    public int[] getProductOfArrayExceptItself3(int[] inputArray) {
        final int n = inputArray.length;
        final int outputArray[] = new int[n];
        
        /* Populate input array with prefixes */
        int product = 1;
        for (int i = 0; i < n; i ++) {
            product *= inputArray[i];
            inputArray[i] = product;
        }
        /* Prepare output array with suffixes */
        product = 1;
        for (int i = n - 1; i >= 0; i --) {
            product *= outputArray[i];
            outputArray[i] = product;
        }
        /* Prepare output array for result */
        for (int i = 1; i <= n - 2; i ++) {
            outputArray[i] = inputArray[i - 1] * outputArray[i + 1];
        }
        outputArray[0] = outputArray[1];
        outputArray[n - 1] = inputArray[n - 2];
        return outputArray;
    }
}
/* 
 * 
 * Best video for this explanation: https://www.youtube.com/watch?v=gREVHiZjXeQ
 * 
 */